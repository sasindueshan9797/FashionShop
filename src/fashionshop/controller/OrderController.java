/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fashionshop.controller;

import fashionshop.DBConnection;
import fashionshop.model.Order;

/**
 *
 * @author sasin
 */
public class OrderController {
    
    public static final int PROCESSING = 0;
    public static OrderList orderList = DBConnection.getInstance().getOrderList();
    
    public static String idGenerator() {
        if (orderList.getSize() > 0) {
            int id = Integer.parseInt(orderList.getLastElement().getOrderId().split("[#]")[1]);
            id++;

            return String.format("ODR#%05d", id);
        }

        return "ODR#00001";
    }
    
    public static boolean isValidSize(String size) {
        
        if ((size.equals("XS") || size.equals("S") || size.equals("M") || size.equals("L")
                || size.equals("XL") || size.equals("XXL"))) {
            return true;
        }

        return false;
    }
    
    public static boolean isValidNumber(String num) {

        if (num.length() == 10) {
            if (num.startsWith("07") || num.startsWith("011")) {
                return true;
            }

            return false;
        }
        return false;
    }
    
    public static boolean isValidQty(int qty) {

        if (qty > 0) {
            return true;
        }

        return false;
    }
    
    public static String orderStatusSelector(int num) {

        switch (num) {
            case 0:
                return "PROCESSING";

            case 1:
                return "DELIVERING";

            case 2:
                return "DELIVERED";

            default:
                return null;
        }

    }
    
    public static boolean placeOrder(String orderID, String number, String size, int qty) {

        String order_status = orderStatusSelector(PROCESSING);
        return orderList.add(new Order(orderID, number, size, qty, order_status));
    }
    
    public static double getPrice(String size, int qty){
        return orderList.getPrice(size, qty);
    }

    public static boolean isExistingCustomer(String id){
        return orderList.isExistingCustomer(id);
    }
    
    public static int getNumberOfOrders(){
        return orderList.getSize();
    }
    
    public static Order getOrder(int index){
        return orderList.getOrder(index);
    }
    
    public static int isExistingOrder(String id){
        return orderList.isExistingOrder(id);
    }
    
    public static void removeItems(int index){
        orderList.removeItems(index);
    }
    
    public static Order[] removeDuplicates(){ 
        return orderList.removeDuplicates();
    }
    
    public static Order[] copyArray(){
        return orderList.copyArray();
    }

    public static int getIndex(String id){
        return orderList.getIndex(id);
    }
}
