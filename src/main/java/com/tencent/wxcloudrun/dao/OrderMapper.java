package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.model.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderMapper {

  /**
   * 新增订单 或 更新订单
   */
  void insertOrUpsertOrder(Order order);

  /**
   * 获取单个订单
   */
  Order getOrder(@Param("id") Integer id);

  /**
   * 获取有效的订单
   * 暂时不添加offset、limit
   */
  List<Order> getValidOrders();

  /**
   * 删除订单
   */
  void deleteOrder(@Param("id") Integer id);
}