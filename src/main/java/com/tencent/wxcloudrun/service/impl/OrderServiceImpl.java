package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.dao.OrderMapper;
import com.tencent.wxcloudrun.model.Order;
import com.tencent.wxcloudrun.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

  final OrderMapper orderMapper;

  public OrderServiceImpl(@Autowired OrderMapper orderMapper) {
    this.orderMapper = orderMapper;
  }

  @Override
  public void insertOrUpsertOrder(Order order) {
    orderMapper.insertOrUpsertOrder(order);
  }

  @Override
  public Optional<Order> getOrder(Integer id) {
    return Optional.ofNullable(orderMapper.getOrder(id));
  }

  @Override
  public List<Order> getValidOrders() {
    return orderMapper.getValidOrders();
  }

  @Override
  public void deleteOrder(Integer id) {
    orderMapper.deleteOrder(id);
  }
}
