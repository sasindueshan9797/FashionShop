/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fashionshop.controller;
import fashionshop.model.Order;

/**
 *
 * @author sasin
 */
public interface OrderList {


    public boolean add(Order order);

    public int getSize();

    public Order getLastElement();

    public boolean isExistingCustomer(String value);

    public int isExistingOrder(String value);

    public Order getOrder(int index);

    public double getPrice(String size, int quantity);

    public void printOrderDetails(int index);

    public void removeItems(int index);

    public Order[] removeDuplicates();

    public Order[] copyArray();

    public int getIndex(String key);
}

