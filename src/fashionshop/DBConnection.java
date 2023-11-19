/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fashionshop;

import fashionshop.controller.OrderList;
import fashionshop.controller.OrderListImpl;

/**
 *
 * @author sasin
 */
public class DBConnection {
    private OrderList orderList;
    private static DBConnection dBConnection;
    
    private DBConnection(){
        orderList=new OrderListImpl();
    }
    
    public static DBConnection getInstance(){
        if(dBConnection==null){
            dBConnection=new DBConnection();
        }
        return dBConnection;
    }
    
    public OrderList getOrderList(){
       return orderList;
    }
}
