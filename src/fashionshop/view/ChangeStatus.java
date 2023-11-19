/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fashionshop.view;

import fashionshop.controller.OrderController;
import fashionshop.model.Order;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author sasin
 */
public class ChangeStatus extends javax.swing.JFrame {

    private JLabel orderIdLabel;
    private JLabel custIdLabel;
    private JLabel sizeLabel;
    private JLabel qtyLabel;
    private JLabel amountLabel;
    private JLabel statusLabel;

    private JLabel custIdTextLabel;
    private JLabel sizeTextLabel;
    private JLabel qtyTextLabel;
    private JLabel amountTextLabel;
    private JLabel statusTextLabel;

    private JTextField orderIdText;

    private JButton searchButton;
    private JButton backButton;
    private JButton changeButton;

    final int PROCESSING = 0;
    final int DELIVERING = 1;
    final int DELIVERED = 2;

    /**
     * Creates new form ChangeStatus
     */
    public ChangeStatus() {
        initComponents();

        setSize(500, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Status Form");
        setResizable(false);
        setLayout(new BorderLayout());

        backButton = new JButton("Back");
        backButton.setPreferredSize(new Dimension(100, 40));
        backButton.setBackground(new Color(231, 76, 60));
        backButton.setFont(new Font("Segoe UI", 1, 15));
        backButton.setForeground(Color.white);
        backButton.setOpaque(true);
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ChangeStatus.this.dispose();
                new MainForm().setVisible(true);
            }
        });

        searchButton = new JButton("Search");
        searchButton.setPreferredSize(new Dimension(100, 30));
        searchButton.setBackground(new Color(26, 188, 156));
        searchButton.setForeground(Color.white);
        searchButton.setFont(new Font("Segoe UI", 1, 15));
        searchButton.setOpaque(true);
        searchButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                String id = orderIdText.getText();
                int index = OrderController.isExistingOrder(id);

                if (index >= 0) {
                    changeButton.setEnabled(true);
                    Order order = OrderController.getOrder(index);
                    double amount = OrderController.getPrice(order.getSize(), order.getQty());

                    custIdTextLabel.setText(order.getCustomerId());
                    sizeTextLabel.setText(order.getSize());
                    qtyTextLabel.setText(String.valueOf(order.getQty()));
                    amountTextLabel.setText(String.valueOf(amount));
                    statusTextLabel.setText(order.getOrderStatus());

                } else {
                    changeButton.setEnabled(false);
                    JOptionPane.showMessageDialog(null, "Invalid Order", "Input Error", JOptionPane.ERROR_MESSAGE);
                    orderIdText.setText("");
                }
            }
        });

        orderIdLabel = new JLabel("Enter Order ID : ");
        orderIdLabel.setFont(new Font("", 1, 13));
        orderIdText = new JTextField(20);
        orderIdText.setPreferredSize(new Dimension(200, 30));
        orderIdText.setFont(new Font("", 1, 13));

        JPanel northJPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        northJPanel.add(backButton);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(searchButton);

        JPanel searchPanel = new JPanel(new GridLayout(1, 3));
        searchPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 5, 20));
        searchPanel.add(orderIdLabel);
        searchPanel.add(orderIdText);
        searchPanel.add(buttonPanel);

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(northJPanel, BorderLayout.NORTH);
        topPanel.add(searchPanel, BorderLayout.CENTER);

        custIdLabel = new JLabel("Customer ID : ");
        custIdLabel.setFont(new Font("", 1, 13));
        sizeLabel = new JLabel("Size : ");
        sizeLabel.setFont(new Font("", 1, 13));
        qtyLabel = new JLabel("Qty : ");
        qtyLabel.setFont(new Font("", 1, 13));
        amountLabel = new JLabel("Amount : ");
        amountLabel.setFont(new Font("", 1, 13));
        statusLabel = new JLabel("Status : ");
        statusLabel.setFont(new Font("", 1, 13));

        custIdTextLabel = new JLabel();
        custIdTextLabel.setFont(new Font("", 1, 13));
        sizeTextLabel = new JLabel();
        sizeTextLabel.setFont(new Font("", 1, 13));
        qtyTextLabel = new JLabel();
        qtyTextLabel.setFont(new Font("", 1, 13));
        amountTextLabel = new JLabel();
        amountTextLabel.setFont(new Font("", 1, 13));
        statusTextLabel = new JLabel();
        statusTextLabel.setFont(new Font("", 1, 13));

        JPanel leftJPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel middJPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        JPanel labelPanel = new JPanel(new GridLayout(5, 1, 0, 20));
        labelPanel.setBorder(BorderFactory.createEmptyBorder(40, 20, 10, 0));
        labelPanel.add(custIdLabel);
        labelPanel.add(sizeLabel);
        labelPanel.add(qtyLabel);
        labelPanel.add(amountLabel);
        labelPanel.add(statusLabel);

        JPanel textPanel = new JPanel(new GridLayout(5, 1, 0, 20));
        textPanel.setBorder(BorderFactory.createEmptyBorder(40, 0, 10, 150));
        textPanel.add(custIdTextLabel);
        textPanel.add(sizeTextLabel);
        textPanel.add(qtyTextLabel);
        textPanel.add(amountTextLabel);
        textPanel.add(statusTextLabel);

        leftJPanel.add(labelPanel);
        middJPanel.add(textPanel);

        changeButton = new JButton("Change");
        changeButton.setPreferredSize(new Dimension(100, 30));
        changeButton.setBackground(new Color(116, 185, 255));
        changeButton.setForeground(Color.white);
        changeButton.setFont(new Font("Segoe UI", 1, 15));
        changeButton.setOpaque(true);
        changeButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String id = orderIdText.getText();
                int index = OrderController.getIndex(id);

                if (index >= 0) {
                    String current_status = OrderController.getOrder(index).getOrderStatus().toUpperCase();

                    switch (current_status) {
                        case "PROCESSING":

                            int choice = JOptionPane.showOptionDialog(
                                    ChangeStatus.this,
                                    "Select an option:",
                                    "Search an option",
                                    JOptionPane.YES_NO_CANCEL_OPTION,
                                    JOptionPane.QUESTION_MESSAGE,
                                    null,
                                    new String[]{"Delivering", "Delivered"},
                                    "Option 1");

                            if (choice == JOptionPane.YES_OPTION) {

                                OrderController.getOrder(index)
                                        .setOrderStatus(OrderController.orderStatusSelector(DELIVERING));

                                JOptionPane.showMessageDialog(null, "Order Status Changed Successfully", "Change",
                                        JOptionPane.INFORMATION_MESSAGE);
                                orderIdText.setText("");
                                custIdTextLabel.setText("");
                                sizeTextLabel.setText("");
                                qtyTextLabel.setText("");
                                amountTextLabel.setText("");
                                statusTextLabel.setText("");

                            } else if (choice == JOptionPane.NO_OPTION) {

                                OrderController.getOrder(index)
                                        .setOrderStatus(OrderController.orderStatusSelector(DELIVERED));

                                JOptionPane.showMessageDialog(null, "Order Status Changed Successfully", "Change",
                                        JOptionPane.INFORMATION_MESSAGE);
                                orderIdText.setText("");
                                custIdTextLabel.setText("");
                                sizeTextLabel.setText("");
                                qtyTextLabel.setText("");
                                amountTextLabel.setText("");
                                statusTextLabel.setText("");
                            }
                            break;

                        case "DELIVERING":
                            int choice_1 = JOptionPane.showOptionDialog(
                                    ChangeStatus.this,
                                    "Select an option:",
                                    "Search an option",
                                    JOptionPane.YES_NO_CANCEL_OPTION,
                                    JOptionPane.QUESTION_MESSAGE,
                                    null,
                                    new String[]{"Delivered"},
                                    "Option 1");

                            if (choice_1 == JOptionPane.YES_OPTION) {

                                OrderController.getOrder(index)
                                        .setOrderStatus(OrderController.orderStatusSelector(DELIVERED));

                                JOptionPane.showMessageDialog(null, "Order Status Changed Successfully", "Change",
                                        JOptionPane.INFORMATION_MESSAGE);
                                orderIdText.setText("");
                                custIdTextLabel.setText("");
                                sizeTextLabel.setText("");
                                qtyTextLabel.setText("");
                                amountTextLabel.setText("");
                                statusTextLabel.setText("");

                            } else if (choice_1 == JOptionPane.NO_OPTION) {

                            }
                            break;

                        default:
                            JOptionPane.showMessageDialog(null, "Order Already in its final stage", "final stage",
                                    JOptionPane.INFORMATION_MESSAGE);
                            orderIdText.setText("");
                    }
                }
            }
        });

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 20));
        bottomPanel.add(changeButton);

        add("West", leftJPanel);
        add("Center", middJPanel);
        add("North", topPanel);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
