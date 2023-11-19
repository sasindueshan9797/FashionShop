/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fashionshop.view;

import fashionshop.controller.OrderController;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author sasin
 */
public class PlaceOrder extends javax.swing.JFrame {
    private JButton backButton;
    private JButton placeButton;

    private JLabel orderIdLabel;
    private JLabel customerIdLabel;
    private JLabel sizeLabel;
    private JLabel qtyLabel;
    private JLabel amountLabel;

    private JLabel orderIdTextLabel;
    private JLabel amountTextLabel;
    private JLabel sizeListLabel;

    private JTextField customerIdText;
    private JTextField sizeText;
    private JTextField qtyText;
    /**
     * Creates new form PlaceOrder
     */
    public PlaceOrder() {
        initComponents();
        
        setSize(500, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Place Order");
        setResizable(false);
        setLayout(new BorderLayout());

        JPanel northJPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel southJPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        backButton = new JButton("Back");
        backButton.setPreferredSize(new Dimension(100, 40));
        backButton.setBackground(new Color(231, 76, 60));
        backButton.setFont(new Font("Segoe UI", 1, 15));
        backButton.setForeground(Color.white);
        backButton.setOpaque(true);
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PlaceOrder.this.dispose();
            }
        });

        orderIdLabel = new JLabel("Order ID : ");
        orderIdLabel.setFont(new Font("", 1, 13));
        customerIdLabel = new JLabel("Customer ID : ");
        customerIdLabel.setFont(new Font("", 1, 13));
        sizeLabel = new JLabel("Size : ");
        sizeLabel.setFont(new Font("", 1, 13));
        qtyLabel = new JLabel("Qty : ");
        qtyLabel.setFont(new Font("", 1, 13));
        amountLabel = new JLabel("Amount : ");
        amountLabel.setFont(new Font("", 1, 13));

        orderIdTextLabel = new JLabel();
        orderIdTextLabel.setFont(new Font("", 1, 13));
        orderIdTextLabel.setText(OrderController.idGenerator());

        amountTextLabel = new JLabel();
        amountTextLabel.setFont(new Font("", 1, 13));

        customerIdText = new JTextField(15);
        customerIdText.setFont(new Font("", 1, 13));
        customerIdText.addKeyListener(new KeyListener() {
            public void keyReleased(KeyEvent evt) {
                char c = evt.getKeyChar();

                if ((c >= '0' && c <= '9') || evt.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    customerIdText.setEditable(true);
                } else {
                    customerIdText.setEditable(false);
                    JOptionPane.showMessageDialog(null, "* Enter only Number", "Input Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }

            public void keyTyped(KeyEvent e) {
                String text = customerIdText.getText();

                if (text.length() >= 10) {
                    e.consume();
                }
            }

            public void keyPressed(KeyEvent e) {

            }
        });

        sizeText = new JTextField(15);
        sizeText.setFont(new Font("", 1, 13));
        sizeText.addKeyListener(new KeyListener() {

            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                String text = sizeText.getText();
                String validSizes = "XS S M L XL XXL \b xs s m l xl xxl";

                if (!validSizes.contains(text + c)) {
                    sizeText.setEditable(false);
                    JOptionPane.showMessageDialog(null, "Invalid Size Input", "Input Error",
                            JOptionPane.ERROR_MESSAGE);
                    sizeText.setText("");
                } else {
                    sizeText.setEditable(true);
                }
            }

            public void keyPressed(KeyEvent e) {
            }

            public void keyReleased(KeyEvent e) {
            }
        });

        qtyText = new JTextField(15);
        qtyText.setFont(new Font("", 1, 13));
        qtyText.addKeyListener(new KeyListener() {

            public void keyTyped(KeyEvent e) {
            }

            public void keyPressed(KeyEvent e) {
                char c = e.getKeyChar();

                if ((c >= '0' && c <= '9') | e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    qtyText.setEditable(true);

                } else {
                    qtyText.setEditable(false);
                    JOptionPane.showMessageDialog(null, "* Enter only Number", "Input Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }

            public void keyReleased(KeyEvent e) {
                
                double amount = OrderController.getPrice(sizeText.getText(), Integer.parseInt(qtyText.getText()));
                amountTextLabel.setText(String.valueOf(amount));

            }
        });

        sizeListLabel = new JLabel("(XS/S/M/L/XL/XXL)");
        sizeListLabel.setFont(new Font("", 1, 13));

        placeButton = new JButton("Place");
        placeButton.setPreferredSize(new Dimension(100, 40));
        placeButton.setBackground(new Color(26, 188, 156));
        placeButton.setForeground(Color.white);
        placeButton.setFont(new Font("Segoe UI", 1, 15));
        placeButton.setOpaque(true);

        placeButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                String customerID = customerIdText.getText();
                String selectedSize = sizeText.getText().toUpperCase();
                int tempQty = Integer.parseInt(qtyText.getText());

                if (customerIdText.getText().isEmpty() || !OrderController.isValidNumber(customerID)) {

                    JOptionPane.showMessageDialog(null,
                            "Invalid Customer ID. Please enter a valid 10-digit phone number starting with 0.");

                } else if (sizeText.getText().isEmpty() || !OrderController.isValidSize(selectedSize)) {

                    JOptionPane.showMessageDialog(null, "Invalid Size. Please select a valid size.");

                } else if (qtyText.getText().isEmpty()
                        || !OrderController.isValidQty(Integer.parseInt(qtyText.getText()))) {

                    JOptionPane.showMessageDialog(null, "Invalid Quantity. Please enter a valid quantity.");

                } else {

                    OrderController.placeOrder(orderIdTextLabel.getText(), customerID, selectedSize, tempQty);
                    JOptionPane.showMessageDialog(null, "Order placed successfully!");
                    orderIdTextLabel.setText(OrderController.idGenerator());
                    customerIdText.setText("");
                    sizeText.setText("");
                    qtyText.setText("");
                    amountTextLabel.setText("");
                }
            }
        });

        northJPanel.add(backButton);
        southJPanel.add(placeButton);

        JPanel leftJPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel middJPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel rightJPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        JPanel labelPanel = new JPanel(new GridLayout(5, 1, 0, 40));
        labelPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 0));
        labelPanel.add(orderIdLabel);
        labelPanel.add(customerIdLabel);
        labelPanel.add(sizeLabel);
        labelPanel.add(qtyLabel);
        labelPanel.add(amountLabel);

        JPanel textPanel = new JPanel(new GridLayout(5, 1, 0, 35));
        textPanel.setBorder(BorderFactory.createEmptyBorder(10, 5, 10, 0));
        textPanel.add(orderIdTextLabel);
        textPanel.add(customerIdText);
        textPanel.add(sizeText);
        textPanel.add(qtyText);
        textPanel.add(amountTextLabel);

        JPanel singPanel = new JPanel();
        singPanel.setBorder(BorderFactory.createEmptyBorder(120, 0, 0, 0));
        singPanel.add(sizeListLabel);

        leftJPanel.add(labelPanel);
        middJPanel.add(textPanel);
        rightJPanel.add(singPanel);

        add("North", northJPanel);
        add("South", southJPanel);
        add("East", rightJPanel);
        add("West", leftJPanel);
        add("Center", middJPanel);
        
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
