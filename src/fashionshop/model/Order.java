/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fashionshop.model;

/**
 *
 * @author sasin
 */
public class Order {
    private String orderId;
    private String customerId;
    private String size;
    private int qty;
    private String orderStatus;

    public Order() {
    }

    public Order(String orderId, String customerId, String size, int qty, String orderStatus) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.size = size;
        this.qty = qty;
        this.orderStatus = orderStatus;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getSize() {
        return size;
    }

    public int getQty() {
        return qty;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

}