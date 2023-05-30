package com.tencent.wxcloudrun.service;

import com.tencent.wxcloudrun.model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {

  void insertOrUpsertOrder(Order order);

  Optional<Order> getOrder(Integer id);

  List<Order> getValidOrders();

  void deleteOrder(Integer id);
}
