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
public class SearchOrder extends javax.swing.JFrame {
    
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
    /**
     * Creates new form SearchOrder
     */
    public SearchOrder() {
        initComponents();
        
        setSize(500, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Search Order");
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
                SearchOrder.this.dispose();
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

                if(index >= 0){

                    Order order = OrderController.getOrder(index);
                    double amount = OrderController.getPrice(order.getSize(), order.getQty());

                    custIdTextLabel.setText(order.getCustomerId());
                    sizeTextLabel.setText(order.getSize());
                    qtyTextLabel.setText(String.valueOf(order.getQty()));
                    amountTextLabel.setText(String.valueOf(amount));
                    statusTextLabel.setText(order.getOrderStatus());

                } else{
                    JOptionPane.showMessageDialog(null, "Invalid Order", "Input Error",JOptionPane.ERROR_MESSAGE);
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
        custIdLabel.setFont(new Font("",1,13));
        sizeLabel = new JLabel("Size : ");
        sizeLabel.setFont(new Font("",1,13));
        qtyLabel = new JLabel("Qty : ");
        qtyLabel.setFont(new Font("",1,13));
        amountLabel = new JLabel("Amount : ");
        amountLabel.setFont(new Font("",1,13));
        statusLabel = new JLabel("Status : ");
        statusLabel.setFont(new Font("",1,13));

        custIdTextLabel=new JLabel();
		custIdTextLabel.setFont(new Font("",1,13));
        sizeTextLabel=new JLabel();
		sizeTextLabel.setFont(new Font("",1,13));
        qtyTextLabel=new JLabel();
		qtyTextLabel.setFont(new Font("",1,13));
        amountTextLabel=new JLabel();
		amountTextLabel.setFont(new Font("",1,13));
        statusTextLabel=new JLabel();
		statusTextLabel.setFont(new Font("",1,13));

        JPanel leftJPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel middJPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        JPanel labelPanel = new JPanel(new GridLayout(5,1,0,20));
        labelPanel.setBorder(BorderFactory.createEmptyBorder(40,20,10,0));
        labelPanel.add(custIdLabel);
        labelPanel.add(sizeLabel);
        labelPanel.add(qtyLabel);
        labelPanel.add(amountLabel);
        labelPanel.add(statusLabel);

        JPanel textPanel = new JPanel(new GridLayout(5,1,0,20));
        textPanel.setBorder(BorderFactory.createEmptyBorder(40,0,10,150));
        textPanel.add(custIdTextLabel);
        textPanel.add(sizeTextLabel);
        textPanel.add(qtyTextLabel);
        textPanel.add(amountTextLabel);
        textPanel.add(statusTextLabel);

        leftJPanel.add(labelPanel);
        middJPanel.add(textPanel);

        add("West",leftJPanel);
        add("Center",middJPanel);
        add("North",topPanel);
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
