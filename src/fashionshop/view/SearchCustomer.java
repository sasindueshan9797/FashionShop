/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fashionshop.view;
import fashionshop.controller.OrderController;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author sasin
 */
public class SearchCustomer extends javax.swing.JFrame {
    
    private JButton backButton;
    private JButton searchButton;

    private JLabel customerIdLabel;
    private JLabel toalLabel;
    private JLabel toalTextLabel;

    private JTextField customerIdText;

    private JTable customerDetailsTable;
    private DefaultTableModel dtm;
    /**
     * Creates new form SearchCustomer
     */
    public SearchCustomer() {
        initComponents();
        
        setSize(500, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Search Customer");
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
                SearchCustomer.this.dispose();
                new MainForm().setVisible(true);
            }
        });

        customerIdLabel = new JLabel("Enter Customer ID : ");
        customerIdLabel.setFont(new Font("", 1, 13));
        customerIdText = new JTextField(20);
        customerIdText.setPreferredSize(new Dimension(200, 30));
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


        searchButton = new JButton("Search");
        searchButton.setPreferredSize(new Dimension(100, 30));
        searchButton.setBackground(new Color(26, 188, 156));
        searchButton.setForeground(Color.white);
        searchButton.setFont(new Font("Segoe UI", 1, 15));
        searchButton.setOpaque(true);
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String id = customerIdText.getText();
                double total = 0;

                if(OrderController.isValidNumber(id) && OrderController.isExistingCustomer(id)){

                    for (int i = 0; i < OrderController.getNumberOfOrders(); i++) {

                        if (id.equals(OrderController.getOrder(i).getCustomerId())) {

                            double amount = OrderController.getPrice(OrderController.getOrder(i).getSize(), OrderController.getOrder(i).getQty());
                            
                            Object[] row = {OrderController.getOrder(i).getSize(), OrderController.getOrder(i).getQty(), amount};
                            dtm.addRow(row);

                            total += amount;
                        }
                    }

                    toalTextLabel.setText(String.valueOf(total));

                } else{
                    JOptionPane.showMessageDialog(null, "Invalid Customer", "Input Error",JOptionPane.ERROR_MESSAGE);
                    customerIdText.setText("");
                }
            }
        });

        JPanel northJPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        northJPanel.add(backButton);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(searchButton);

        JPanel searchPanel = new JPanel(new GridLayout(1, 3));
        searchPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 5, 20));
        searchPanel.add(customerIdLabel);
        searchPanel.add(customerIdText);
        searchPanel.add(buttonPanel);

        JPanel topPanel = new JPanel(new BorderLayout());
	topPanel.add(northJPanel, BorderLayout.NORTH);
	topPanel.add(searchPanel, BorderLayout.CENTER);

        String columnName[]={"Size", "Qty", "Amount"};
	dtm=new DefaultTableModel(columnName,0);
	customerDetailsTable=new JTable(dtm);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        
        
        for (int i = 0; i < customerDetailsTable.getColumnCount(); i++) {
            customerDetailsTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

	customerDetailsTable.getColumnModel().getColumn(0).setPreferredWidth(20);  
        customerDetailsTable.getColumnModel().getColumn(0).setMinWidth(100);
        customerDetailsTable.getColumnModel().getColumn(0).setMaxWidth(100); 

        customerDetailsTable.getColumnModel().getColumn(1).setPreferredWidth(50);  
        customerDetailsTable.getColumnModel().getColumn(1).setMinWidth(50);
        customerDetailsTable.getColumnModel().getColumn(1).setMaxWidth(100); 

        customerDetailsTable.getColumnModel().getColumn(2).setPreferredWidth(70);  
        customerDetailsTable.getColumnModel().getColumn(2).setMinWidth(50);
        customerDetailsTable.getColumnModel().getColumn(2).setMaxWidth(200); 

        
        customerDetailsTable.setRowHeight(40);

        JScrollPane tablePane=new JScrollPane(customerDetailsTable);

        JPanel resultPanel = new JPanel(new BorderLayout());
	resultPanel.setBorder(BorderFactory.createEmptyBorder(10, 50, 20, 50));
        resultPanel.add(tablePane);

        toalLabel = new JLabel("Total: ");
        toalLabel.setFont(new Font("", 1, 13));
        JPanel totalLabelPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        totalLabelPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 5, 120));
        totalLabelPanel.add(toalLabel);

        toalTextLabel = new JLabel("");
        toalTextLabel.setFont(new Font("", 1, 13));
        JPanel totalTextPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        totalTextPanel.setBorder(BorderFactory.createEmptyBorder(10, 110, 5, 50));
        totalTextPanel.add(toalTextLabel);

        JPanel bottomPanel = new JPanel();
        bottomPanel.add(totalLabelPanel);
        bottomPanel.add(totalTextPanel);

		add("Center",resultPanel);
        add("North",topPanel);
        add("South",bottomPanel);
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
