package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.dto.OrderRequest;
import com.tencent.wxcloudrun.model.Order;
import com.tencent.wxcloudrun.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * counter控制器
 */
@RestController

public class OrderController {

  final OrderService orderService;
  final Logger logger;

  public OrderController(@Autowired OrderService orderService) {
    this.orderService = orderService;
    this.logger = LoggerFactory.getLogger(OrderController.class);
  }

  @GetMapping(value = "/api/getOrder")
  ApiResponse getOrder(@RequestParam Integer id) {
    logger.info("/api/getOrder id = " + id);
    Optional<Order> order = orderService.getOrder(id);
    if (order.isPresent()) return ApiResponse.ok(order);
    return ApiResponse.error("order is not exist!");
  }

  @GetMapping(value = "/api/getValidOrders")
  ApiResponse getValidOrders() {
    logger.info("/api/getValidOrders");
    List<Order> validOrders = orderService.getValidOrders();
    if (validOrders != null && !validOrders.isEmpty()) {
      return ApiResponse.ok(validOrders);
    }
    return ApiResponse.error("valid order is not exist!");
  }

  @PostMapping(value = "/api/insertOrUpsertOrder")
  ApiResponse insertOrUpsertOrder(@RequestBody OrderRequest request) {
    String action = request.getId() == 0 ? "insert" : "update";
    logger.info("/api/insertOrUpsertOrder, action = " + action + ", order = " + request);
    Order order = new Order();
    order.setId(request.getId());
    order.setCustomerID(request.getCustomerID());
    order.setCustomerName(request.getCustomerName());
    order.setOrderCount(request.getOrderCount());
    order.setOrderType(request.getOrderType());
    order.setTransportType(request.getTransportType());
    order.setAddress(request.getAddress());
    order.setPhone(request.getPhone());
    order.setIsValid(request.getIsValid());
    orderService.insertOrUpsertOrder(order);
    int result = order.getId() == 0 ? 1 : 2; // 1: 下单成功 2：修改成功
    return ApiResponse.ok(result);
  }
}