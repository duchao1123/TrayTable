package com.tencent.wxcloudrun.dto;

import lombok.Data;

@Data
public class OrderRequest {

  /**
   * 订单id
   */
  private int id;

  /**
   * 顾客微信id，修改订单唯一标识
   */
  private String customerID;

  /**
   * '顾客微信名称'
   */
  private String customerName;

  /**
   * '订餐份数'
   */
  private short orderCount;

  /**
   * '1: 午餐 2: 晚餐'
   */
  private short orderType;

  /**
   * '1: 送餐 2:自取'
   */
  private short transportType;

  /**
   * '送货地址'
   */
  private String address;

  /**
   * '联系电话'
   */
  private String phone;

  /**
   * '1有效订单， 0已取消'
   */
  private short isValid = 1;

}
