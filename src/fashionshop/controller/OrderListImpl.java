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
public class OrderListImpl implements OrderList {

    Node first;

    private boolean isEmpty() {
        return first == null;
    }

    public boolean add(Order order) {
        Node n1 = new Node(order);

        if (isEmpty()) {
            first = n1;
        } else {
            Node lastNode = first;

            while (lastNode.next != null) {
                lastNode = lastNode.next;
            }

            lastNode.next = n1;
        }
        
        return true;
    }

    public int getSize() {
        Node temp = first;
        int count = 0;

        while (temp != null) {
            temp = temp.next;
            count++;
        }

        return count;
    }

    public Order getLastElement() {
        Node temp = first;

        while (temp.next != null) {
            temp = temp.next;
        }

        return temp.order;
    }

    public boolean isExistingCustomer(String value) {
        Node temp = first;

        while (temp != null) {

            if (value.equals(temp.order.getCustomerId())) {
                return true;
            }

            temp = temp.next;
        }

        return false;
    }

    public int isExistingOrder(String value) {
        Node temp = first;
        int count = 0;

        while (temp != null) {

            if (value.equals(temp.order.getOrderId())) {
                return count;
            }

            temp = temp.next;
            count++;
        }

        return -1;
    }

    private boolean isInvalidIndex(int index) {
        return isEmpty() && getSize() < index;
    }

    public Order getOrder(int index) {
        Node temp = first;
        int count = 0;

        if (!isInvalidIndex(index)) {

            while (temp != null) {

                if (count == index) {
                    return temp.order;
                }

                temp = temp.next;
                count++;
            }
        }

        return null;
    }

    public double getPrice(String size, int quantity) {
        double amount = 1;

        switch (size) {
            case "XS":
                amount *= 600 * quantity;
                break;
            case "S":
                amount *= 800 * quantity;
                break;
            case "M":
                amount *= 900 * quantity;
                break;
            case "L":
                amount *= 1000 * quantity;
                break;
            case "XL":
                amount *= 1100 * quantity;
                break;
            case "XXL":
                amount *= 1200 * quantity;
                break;
            default:
                System.out.println("Invalid Input...");
        }

        return amount;
    }

    public void printOrderDetails(int index) {
        Node temp = first;
        int count = 0;

        while (temp != null) {

            if (count == index) {
                double amount = getPrice(temp.order.getSize(), temp.order.getQty());

                System.out.println("\nPhone Number : " + temp.order.getCustomerId());
                System.out.println("Size         : " + temp.order.getSize());
                System.out.println("Qty          : " + temp.order.getQty());
                System.out.println("Amount       : " + amount);
                System.out.println("Status       : " + temp.order.getOrderStatus());
            }

            temp = temp.next;
            count++;
        }
    }

    public void removeItems(int index) {

        if (index == 0) {
            first = first.next;

        } else {
            Node temp = first;

            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }

            temp.next = temp.next.next;
        }
    }

    private boolean search(Order[] ar, Order order) {

        for (int i = 0; i < ar.length; i++) {
            if (ar[i].getCustomerId().equals(order.getCustomerId())) {
                return true;
            }
        }

        return false;
    }

    public Order[] removeDuplicates() {
        Node tempNode = first;
        Order[] br = new Order[0];
        Order[] tempArray = new Order[getSize()];
        int index = 0;

        while (tempNode != null) {
            tempArray[index++] = tempNode.order;
            tempNode = tempNode.next;
        }

        for (int i = 0; i < tempArray.length; i++) {

            if (!search(br, tempArray[i])) {

                Order[] temp = new Order[br.length + 1];

                for (int j = 0; j < br.length; j++) {
                    temp[j] = br[j];
                }

                temp[br.length] = tempArray[i];
                br = temp;
            }
        }

        return br;
    }

    public Order[] copyArray() {
        Node tempNode = first;
        Order[] tempArray = new Order[getSize()];
        int index = 0;

        while (tempNode != null) {
            tempArray[index++] = tempNode.order;
            tempNode = tempNode.next;
        }

        return tempArray;
    }

    public int getIndex(String key) {
        Node temp = first;
        int count = 0;

        if (isExistingOrder(key) != -1) {

            while (temp != null) {

                if (key.equals(temp.order.getOrderId())) {
                    return count;
                }

                temp = temp.next;
                count++;
            }
        }

        return -1;
    }

    
    class Node {

        Order order;
        Node next;

        public Node(Order order) {
            this.order = order;
        }
    }
}
