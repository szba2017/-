package com.jiahua.utlis;

import java.io.Serializable;
import java.util.List;

import com.jiahua.entity.Order;
import com.jiahua.entity.OrderDetail;


public class OrderVo implements Serializable {
    private Order order;
    private List<OrderDetail> orderDetailList;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public List<OrderDetail> getOrderDetailList() {
        return orderDetailList;
    }

    public void setOrderDetailList(List<OrderDetail> orderDetailList) {
        this.orderDetailList = orderDetailList;
    }
}
