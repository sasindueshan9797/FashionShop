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
import javax.swing.table.*;

/**
 *
 * @author sasin
 */
public class ViewReports extends javax.swing.JFrame {

    private JButton backButton;

    private JButton viewCustomerButton;
    private JButton bestCustomerButton;
    private JButton allCustomerButton;

    private JButton itemsByQtyButton;
    private JButton itemsByAmountButton;

    private JButton ordersByAmountButton;
    private JButton allOrdersButton;

    /**
     * Creates new form ViewReports
     */
    public ViewReports() {
        initComponents();

        setSize(650, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("View Reports");
        setResizable(false);
        setLayout(new BorderLayout());

        JPanel northPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        backButton = new JButton("Back");
        backButton.setPreferredSize(new Dimension(100, 40));
        backButton.setBackground(new Color(231, 76, 60));
        backButton.setFont(new Font("Segoe UI", 1, 15));
        backButton.setForeground(Color.white);
        backButton.setOpaque(true);
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ViewReports.this.dispose();
            }
        });

        northPanel.add(backButton);

        JPanel centPanel = new JPanel(new GridLayout(0, 3));
        JPanel leftGridPanel = new JPanel(new GridLayout(3, 0, 0, 30));
        JPanel centerGridPanel = new JPanel(new GridLayout(3, 3, 0, 30));
        JPanel rightGridPanel = new JPanel(new GridLayout(3, 3, 0, 30));

        JPanel leftButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        leftButtonPanel.setBorder(BorderFactory.createEmptyBorder(40, 5, 0, 5));

        viewCustomerButton = new JButton("View Customers");
        viewCustomerButton.setPreferredSize(new Dimension(170, 25));
        viewCustomerButton.setBackground(new Color(0, 148, 50));
        viewCustomerButton.setForeground(Color.white);
        viewCustomerButton.setFont(new Font("Segoe UI", 1, 15));
        viewCustomerButton.setOpaque(true);
        viewCustomerButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                new ViewCustomers().setVisible(true);
            }
        });

        bestCustomerButton = new JButton("Best In Customers");
        bestCustomerButton.setPreferredSize(new Dimension(170, 25));
        bestCustomerButton.setBackground(new Color(0, 148, 50));
        bestCustomerButton.setForeground(Color.white);
        bestCustomerButton.setFont(new Font("Segoe UI", 1, 15));
        bestCustomerButton.setOpaque(true);
        bestCustomerButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                new BestCustomers().setVisible(true);
            }
        });

        allCustomerButton = new JButton("All Customers");
        allCustomerButton.setPreferredSize(new Dimension(170, 25));
        allCustomerButton.setBackground(new Color(0, 148, 50));
        allCustomerButton.setForeground(Color.white);
        allCustomerButton.setFont(new Font("Segoe UI", 1, 15));
        allCustomerButton.setOpaque(true);
        allCustomerButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                new AllCustomers().setVisible(true);
            }
        });

        leftGridPanel.add(viewCustomerButton);
        leftGridPanel.add(bestCustomerButton);
        leftGridPanel.add(allCustomerButton);

        leftButtonPanel.add(leftGridPanel);

        JPanel centerButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        centerButtonPanel.setBorder(BorderFactory.createEmptyBorder(60, 5, 0, 5));

        itemsByQtyButton = new JButton("Categorized By Qty");
        itemsByQtyButton.setPreferredSize(new Dimension(220, 25));
        itemsByQtyButton.setBackground(new Color(27, 20, 100));
        itemsByQtyButton.setForeground(Color.white);
        itemsByQtyButton.setFont(new Font("Segoe UI", 1, 15));
        itemsByQtyButton.setOpaque(true);
        itemsByQtyButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                new ItemsByQty().setVisible(true);
            }
        });

        itemsByAmountButton = new JButton("Categorized By Amount");
        itemsByAmountButton.setPreferredSize(new Dimension(220, 25));
        itemsByAmountButton.setBackground(new Color(27, 20, 100));
        itemsByAmountButton.setForeground(Color.white);
        itemsByAmountButton.setFont(new Font("Segoe UI", 1, 15));
        itemsByAmountButton.setOpaque(true);
        itemsByAmountButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                new ItemsByAmount().setVisible(true);
            }
        });

        centerGridPanel.add(itemsByQtyButton);
        centerGridPanel.add(itemsByAmountButton);

        centerButtonPanel.add(centerGridPanel);

        JPanel rightButtonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        rightButtonPanel.setBorder(BorderFactory.createEmptyBorder(60, 5, 0, 5));

        ordersByAmountButton = new JButton("Orders By Amount");
        ordersByAmountButton.setPreferredSize(new Dimension(170, 25));
        ordersByAmountButton.setBackground(new Color(87, 96, 111));
        ordersByAmountButton.setForeground(Color.white);
        ordersByAmountButton.setFont(new Font("Segoe UI", 1, 15));
        ordersByAmountButton.setOpaque(true);
        ordersByAmountButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                new OrdersByAmount().setVisible(true);
            }
        });

        allOrdersButton = new JButton("All Orders");
        allOrdersButton.setPreferredSize(new Dimension(170, 25));
        allOrdersButton.setBackground(new Color(87, 96, 111));
        allOrdersButton.setForeground(Color.white);
        allOrdersButton.setFont(new Font("Segoe UI", 1, 15));
        allOrdersButton.setOpaque(true);
        allOrdersButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                new AllOrders().setVisible(true);
            }
        });

        rightGridPanel.add(ordersByAmountButton);
        rightGridPanel.add(allOrdersButton);

        rightButtonPanel.add(rightGridPanel);

        centPanel.add(leftButtonPanel);
        centPanel.add(centerButtonPanel);
        centPanel.add(rightButtonPanel);
        add("North", northPanel);
        add("Center", centPanel);
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

    private class OrdersByAmount extends JFrame {

        private JButton backButton;

        private JTable itemByAmountTable;
        private DefaultTableModel dtm;

        public OrdersByAmount() {
            setSize(800, 450);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            setTitle("Orders By Amount");
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
                    OrdersByAmount.this.dispose();
                    new MainForm().setVisible(true);
                }
            });

            JPanel northJPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            northJPanel.add(backButton);

            String columnName[] = {"Order ID", "Customer ID", "Size", "Qty", "Amount", "Status"};
            dtm = new DefaultTableModel(columnName, 0);
            itemByAmountTable = new JTable(dtm);

            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

            for (int i = 0; i < itemByAmountTable.getColumnCount(); i++) {
                itemByAmountTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
            }

            itemByAmountTable.getColumnModel().getColumn(0).setPreferredWidth(70);
            itemByAmountTable.getColumnModel().getColumn(0).setMaxWidth(200);

            itemByAmountTable.getColumnModel().getColumn(1).setPreferredWidth(70);
            itemByAmountTable.getColumnModel().getColumn(1).setMaxWidth(200);

            itemByAmountTable.getColumnModel().getColumn(2).setPreferredWidth(20);
            itemByAmountTable.getColumnModel().getColumn(2).setMaxWidth(200);

            itemByAmountTable.getColumnModel().getColumn(3).setPreferredWidth(20);
            itemByAmountTable.getColumnModel().getColumn(3).setMaxWidth(200);

            itemByAmountTable.getColumnModel().getColumn(4).setPreferredWidth(70);
            itemByAmountTable.getColumnModel().getColumn(4).setMaxWidth(200);

            itemByAmountTable.getColumnModel().getColumn(5).setPreferredWidth(70);
            itemByAmountTable.getColumnModel().getColumn(5).setMaxWidth(200);

            itemByAmountTable.setRowHeight(40);

            JScrollPane tablePane = new JScrollPane(itemByAmountTable);

            JPanel resultPanel = new JPanel(new BorderLayout());
            resultPanel.setBorder(BorderFactory.createEmptyBorder(10, 40, 20, 40));
            resultPanel.add(tablePane);

            add("Center", resultPanel);
            add("North", northJPanel);

            printOrders();
        }

        private void printOrders() {

            Order[] temp_order = OrderController.copyArray();

            // sorting temporary order id array
            for (int i = 1; i < temp_order.length; i++) {

                for (int j = 1; j < temp_order.length; j++) {

                    if (OrderController.getPrice(temp_order[j - 1].getSize(), temp_order[j - 1].getQty()) < OrderController.getPrice(
                            temp_order[j].getSize(), temp_order[j].getQty())) {

                        Order order = temp_order[j - 1];
                        temp_order[j - 1] = temp_order[j];
                        temp_order[j] = order;
                    }
                }
            }

            for (int i = 0; i < temp_order.length; i++) {

                double total = OrderController.getPrice(temp_order[i].getSize(), temp_order[i].getQty());

                Object[] row = {temp_order[i].getOrderId(), temp_order[i].getCustomerId(), temp_order[i].getSize(),
                    temp_order[i].getQty(), total, temp_order[i].getOrderStatus()};
                dtm.addRow(row);
            }
        }
    }

    private class AllOrders extends JFrame {

        private JButton backButton;
        private JTable allOrdersTable;
        private DefaultTableModel dtm;

        public AllOrders() {
            setSize(800, 450);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            setTitle("All Orders");
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
                    AllOrders.this.dispose();
                    new MainForm().setVisible(true);
                }
            });

            JPanel northJPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            northJPanel.add(backButton);

            String columnName[] = {"Order ID", "Customer ID", "Size", "Qty", "Amount", "Status"};
            dtm = new DefaultTableModel(columnName, 0);
            allOrdersTable = new JTable(dtm);

            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

            for (int i = 0; i < allOrdersTable.getColumnCount(); i++) {
                allOrdersTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
            }

            allOrdersTable.getColumnModel().getColumn(0).setPreferredWidth(70);
            allOrdersTable.getColumnModel().getColumn(0).setMaxWidth(200);

            allOrdersTable.getColumnModel().getColumn(1).setPreferredWidth(70);
            allOrdersTable.getColumnModel().getColumn(1).setMaxWidth(200);

            allOrdersTable.getColumnModel().getColumn(2).setPreferredWidth(20);
            allOrdersTable.getColumnModel().getColumn(2).setMaxWidth(200);

            allOrdersTable.getColumnModel().getColumn(3).setPreferredWidth(20);
            allOrdersTable.getColumnModel().getColumn(3).setMaxWidth(200);

            allOrdersTable.getColumnModel().getColumn(4).setPreferredWidth(70);
            allOrdersTable.getColumnModel().getColumn(4).setMaxWidth(200);

            allOrdersTable.getColumnModel().getColumn(5).setPreferredWidth(70);
            allOrdersTable.getColumnModel().getColumn(5).setMaxWidth(200);

            allOrdersTable.setRowHeight(40);

            JScrollPane tablePane = new JScrollPane(allOrdersTable);

            JPanel resultPanel = new JPanel(new BorderLayout());
            resultPanel.setBorder(BorderFactory.createEmptyBorder(10, 40, 20, 40));
            resultPanel.add(tablePane);

            add("Center", resultPanel);
            add("North", northJPanel);

            printOrders();
        }

        private void printOrders() {

            Order[] temp_order = OrderController.copyArray();

            // sorting temporary order id array
            for (int i = 1; i < temp_order.length; i++) {

                for (int j = 1; j < temp_order.length; j++) {

                    if (Integer.parseInt(temp_order[j - 1].getOrderId().split("[#]")[1]) < Integer
                            .parseInt(temp_order[j].getOrderId().split("[#]")[1])) {

                        Order order = temp_order[j - 1];
                        temp_order[j - 1] = temp_order[j];
                        temp_order[j] = order;

                    }
                }
            }

            for (int i = 0; i < temp_order.length; i++) {

                double total = OrderController.getPrice(temp_order[i].getSize(), temp_order[i].getQty());

                Object[] row = {temp_order[i].getOrderId(), temp_order[i].getCustomerId(), temp_order[i].getSize(),
                    temp_order[i].getQty(), total, temp_order[i].getOrderStatus()};
                dtm.addRow(row);
            }
        }
    }

    private class ItemsByQty extends JFrame {

        private JButton backButton;
        private JTable itemByQtyTable;
        private DefaultTableModel dtm;

        public ItemsByQty() {
            setSize(500, 450);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            setTitle("Items By Qty");
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
                    ItemsByQty.this.dispose();
                    new MainForm().setVisible(true);
                }
            });

            JPanel northJPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            northJPanel.add(backButton);

            String columnName[] = {"Size", "Qty", "Amount"};
            dtm = new DefaultTableModel(columnName, 0);
            itemByQtyTable = new JTable(dtm);

            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

            for (int i = 0; i < itemByQtyTable.getColumnCount(); i++) {
                itemByQtyTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
            }

            itemByQtyTable.getColumnModel().getColumn(0).setPreferredWidth(20);
            itemByQtyTable.getColumnModel().getColumn(0).setMinWidth(100);
            itemByQtyTable.getColumnModel().getColumn(0).setMaxWidth(100);

            itemByQtyTable.getColumnModel().getColumn(1).setPreferredWidth(50);
            itemByQtyTable.getColumnModel().getColumn(1).setMinWidth(50);
            itemByQtyTable.getColumnModel().getColumn(1).setMaxWidth(100);

            itemByQtyTable.getColumnModel().getColumn(2).setPreferredWidth(70);
            itemByQtyTable.getColumnModel().getColumn(2).setMinWidth(50);
            itemByQtyTable.getColumnModel().getColumn(2).setMaxWidth(200);

            itemByQtyTable.setRowHeight(40);

            JScrollPane tablePane = new JScrollPane(itemByQtyTable);

            JPanel resultPanel = new JPanel(new BorderLayout());
            resultPanel.setBorder(BorderFactory.createEmptyBorder(10, 40, 20, 40));
            resultPanel.add(tablePane);

            add("Center", resultPanel);
            add("North", northJPanel);

            printItems();
        }

        private void printItems() {

            String[] size = {"XS", "S", "M", "L", "XL", "XXL"};
            double[] totalAmount = new double[size.length];
            int[] totalQtys = new int[size.length];

            for (int i = 0; i < size.length; i++) {

                for (int j = 0; j < OrderController.getNumberOfOrders(); j++) {

                    if (size[i].equals(OrderController.getOrder(j).getSize())) {

                        double amount = OrderController.getPrice(OrderController.getOrder(j).getSize(), OrderController.getOrder(j).getQty());

                        totalAmount[i] += amount;
                        totalQtys[i] += OrderController.getOrder(j).getQty();
                    }
                }
            }

            // sorting according to the Qty
            for (int i = 1; i < totalQtys.length; i++) {
                for (int j = 1; j < totalQtys.length; j++) {

                    if (totalQtys[j - 1] < totalQtys[j]) {

                        double t = totalAmount[j - 1];
                        totalAmount[j - 1] = totalAmount[j];
                        totalAmount[j] = t;

                        int q = totalQtys[j - 1];
                        totalQtys[j - 1] = totalQtys[j];
                        totalQtys[j] = q;

                        String s = size[j - 1];
                        size[j - 1] = size[j];
                        size[j] = s;
                    }
                }
            }

            // printing data to the table
            for (int i = 0; i < size.length; i++) {
                Object[] row = {size[i], totalQtys[i], totalAmount[i]};
                dtm.addRow(row);

            }
        }
    }

    private class ItemsByAmount extends JFrame {

        private JButton backButton;
        private JTable itemByAmountTable;
        private DefaultTableModel dtm;

        public ItemsByAmount() {
            setSize(500, 450);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            setTitle("Items By Amount");
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
                    ItemsByAmount.this.dispose();
                    new MainForm().setVisible(true);
                }
            });

            JPanel northJPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            northJPanel.add(backButton);

            String columnName[] = {"Size", "Qty", "Amount"};
            dtm = new DefaultTableModel(columnName, 0);
            itemByAmountTable = new JTable(dtm);

            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

            for (int i = 0; i < itemByAmountTable.getColumnCount(); i++) {
                itemByAmountTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
            }

            itemByAmountTable.getColumnModel().getColumn(0).setPreferredWidth(20);
            itemByAmountTable.getColumnModel().getColumn(0).setMinWidth(100);
            itemByAmountTable.getColumnModel().getColumn(0).setMaxWidth(100);

            itemByAmountTable.getColumnModel().getColumn(1).setPreferredWidth(50);
            itemByAmountTable.getColumnModel().getColumn(1).setMinWidth(50);
            itemByAmountTable.getColumnModel().getColumn(1).setMaxWidth(100);

            itemByAmountTable.getColumnModel().getColumn(2).setPreferredWidth(70);
            itemByAmountTable.getColumnModel().getColumn(2).setMinWidth(50);
            itemByAmountTable.getColumnModel().getColumn(2).setMaxWidth(200);

            itemByAmountTable.setRowHeight(40);

            JScrollPane tablePane = new JScrollPane(itemByAmountTable);

            JPanel resultPanel = new JPanel(new BorderLayout());
            resultPanel.setBorder(BorderFactory.createEmptyBorder(10, 40, 20, 40));
            resultPanel.add(tablePane);

            add("Center", resultPanel);
            add("North", northJPanel);

            printItems();
        }

        private void printItems() {

            String[] size = {"XS", "S", "M", "L", "XL", "XXL"};
            double[] totalAmount = new double[size.length];
            int[] totalQtys = new int[size.length];

            for (int i = 0; i < size.length; i++) {

                for (int j = 0; j < OrderController.getNumberOfOrders(); j++) {

                    if (size[i].equals(OrderController.getOrder(j).getSize())) {

                        double amount = OrderController.getPrice(OrderController.getOrder(j).getSize(), OrderController.getOrder(j).getQty());

                        totalAmount[i] += amount;
                        totalQtys[i] += OrderController.getOrder(j).getQty();
                    }
                }
            }

            // sorting according to the Total Amount
            for (int i = 1; i < totalQtys.length; i++) {
                for (int j = 1; j < totalQtys.length; j++) {

                    if (totalAmount[j - 1] < totalAmount[j]) {

                        double t = totalAmount[j - 1];
                        totalAmount[j - 1] = totalAmount[j];
                        totalAmount[j] = t;

                        int q = totalQtys[j - 1];
                        totalQtys[j - 1] = totalQtys[j];
                        totalQtys[j] = q;

                        String s = size[j - 1];
                        size[j - 1] = size[j];
                        size[j] = s;
                    }
                }
            }

            // printing data to the table
            for (int i = 0; i < size.length; i++) {
                Object[] row = {size[i], totalQtys[i], totalAmount[i]};
                dtm.addRow(row);

            }
        }
    }

    private class BestCustomers extends JFrame {

        private JButton backButton;
        private JTable bestCustomersTable;
        private DefaultTableModel dtm;

        public BestCustomers() {
            setSize(500, 450);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            setTitle("Best In Customers");
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
                    BestCustomers.this.dispose();
                }
            });

            JPanel northJPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            northJPanel.add(backButton);

            String columnName[] = {"Customer ID", "Qty", "Amount"};
            dtm = new DefaultTableModel(columnName, 0);
            bestCustomersTable = new JTable(dtm);

            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

            for (int i = 0; i < bestCustomersTable.getColumnCount(); i++) {
                bestCustomersTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
            }

            bestCustomersTable.getColumnModel().getColumn(0).setPreferredWidth(70);
            bestCustomersTable.getColumnModel().getColumn(0).setMaxWidth(200);

            bestCustomersTable.getColumnModel().getColumn(1).setPreferredWidth(50);
            bestCustomersTable.getColumnModel().getColumn(1).setMaxWidth(100);

            bestCustomersTable.getColumnModel().getColumn(2).setPreferredWidth(70);
            bestCustomersTable.getColumnModel().getColumn(2).setMaxWidth(200);

            bestCustomersTable.setRowHeight(40);

            JScrollPane tablePane = new JScrollPane(bestCustomersTable);

            JPanel resultPanel = new JPanel(new BorderLayout());
            resultPanel.setBorder(BorderFactory.createEmptyBorder(10, 40, 20, 40));
            resultPanel.add(tablePane);

            add("Center", resultPanel);
            add("North", northJPanel);

            printBestCustomers();
        }

        private void printBestCustomers() {

            Order[] orders = OrderController.removeDuplicates();
            double[] totalAmount = new double[orders.length];
            int[] totalQtys = new int[orders.length];

            // Adding values to local arrays according to unique customer Array
            for (int i = 0; i < orders.length; i++) {

                for (int j = 0; j < OrderController.getNumberOfOrders(); j++) {

                    if (orders[i].getCustomerId().equals(OrderController.getOrder(j).getCustomerId())) {

                        double amount = OrderController.getPrice(OrderController.getOrder(j).getSize(),
                                OrderController.getOrder(j).getQty());

                        totalAmount[i] += amount;
                        totalQtys[i] += OrderController.getOrder(j).getQty();
                    }
                }
            }

            // sorting according to the Total Amount
            for (int i = 1; i < totalAmount.length; i++) {
                for (int j = 1; j < totalAmount.length; j++) {

                    if (totalAmount[j - 1] < totalAmount[j]) {

                        double t = totalAmount[j - 1];
                        totalAmount[j - 1] = totalAmount[j];
                        totalAmount[j] = t;

                        int q = totalQtys[j - 1];
                        totalQtys[j - 1] = totalQtys[j];
                        totalQtys[j] = q;

                        Order d = orders[j - 1];
                        orders[j - 1] = orders[j];
                        orders[j] = d;
                    }
                }
            }

            // printing data to the table
            for (int i = 0; i < orders.length; i++) {
                Object[] row = {orders[i].getCustomerId(), totalQtys[i], totalAmount[i]};
                dtm.addRow(row);

            }
        }
    }

    private class AllCustomers extends JFrame {

        private JButton backButton;
        private JTable allCustomersTable;
        private DefaultTableModel dtm;

        public AllCustomers() {
            setSize(800, 450);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            setTitle("All Customers");
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
                    AllCustomers.this.dispose();
                }
            });

            JPanel northJPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            northJPanel.add(backButton);

            String columnName[] = {"Customer ID", "XS", "S", "M", "L", "XL", "XXL", "Amount"};
            dtm = new DefaultTableModel(columnName, 0);
            allCustomersTable = new JTable(dtm);

            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

            for (int i = 0; i < allCustomersTable.getColumnCount(); i++) {
                allCustomersTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
            }

            allCustomersTable.getColumnModel().getColumn(0).setPreferredWidth(70);
            allCustomersTable.getColumnModel().getColumn(0).setMaxWidth(200);

            allCustomersTable.getColumnModel().getColumn(1).setPreferredWidth(50);
            allCustomersTable.getColumnModel().getColumn(1).setMaxWidth(100);

            allCustomersTable.getColumnModel().getColumn(2).setPreferredWidth(50);
            allCustomersTable.getColumnModel().getColumn(2).setMaxWidth(100);

            allCustomersTable.getColumnModel().getColumn(3).setPreferredWidth(50);
            allCustomersTable.getColumnModel().getColumn(3).setMaxWidth(100);

            allCustomersTable.getColumnModel().getColumn(4).setPreferredWidth(50);
            allCustomersTable.getColumnModel().getColumn(4).setMaxWidth(100);

            allCustomersTable.getColumnModel().getColumn(5).setPreferredWidth(50);
            allCustomersTable.getColumnModel().getColumn(5).setMaxWidth(100);

            allCustomersTable.getColumnModel().getColumn(6).setPreferredWidth(50);
            allCustomersTable.getColumnModel().getColumn(6).setMaxWidth(100);

            allCustomersTable.getColumnModel().getColumn(7).setPreferredWidth(70);
            allCustomersTable.getColumnModel().getColumn(7).setMaxWidth(200);

            allCustomersTable.setRowHeight(40);

            JScrollPane tablePane = new JScrollPane(allCustomersTable);

            JPanel resultPanel = new JPanel(new BorderLayout());
            resultPanel.setBorder(BorderFactory.createEmptyBorder(10, 40, 20, 40));
            resultPanel.add(tablePane);

            add("Center", resultPanel);
            add("North", northJPanel);

            printAllCustomers();
        }

        private void printAllCustomers() {

            Order[] orders = OrderController.removeDuplicates();

            // Adding values to local arrays accordi to unique customer Array
            for (int i = 0; i < orders.length; i++) {

                int[] tempSizes = new int[6];
                String[] size = {"XS", "S", "M", "L", "XL", "XXL"};

                for (int j = 0; j < OrderController.getNumberOfOrders(); j++) {

                    if (orders[i].getCustomerId().equals(OrderController.getOrder(j).getCustomerId())) {

                        switch (OrderController.getOrder(j).getSize()) {
                            case "XS":
                                tempSizes[0] += OrderController.getOrder(j).getQty();
                                break;
                            case "S":
                                tempSizes[1] += OrderController.getOrder(j).getQty();
                                break;
                            case "M":
                                tempSizes[2] += OrderController.getOrder(j).getQty();
                                break;
                            case "L":
                                tempSizes[3] += OrderController.getOrder(j).getQty();
                                break;
                            case "XL":
                                tempSizes[4] += OrderController.getOrder(j).getQty();
                                break;
                            case "XXL":
                                tempSizes[5] += OrderController.getOrder(j).getQty();
                                break;
                        }

                    }
                }

                double total = 0;

                for (int j = 0; j < tempSizes.length; j++) {
                    total += (size[j].equals("XS") ? OrderController.getPrice("XS", tempSizes[j])
                            : size[j].equals("S") ? OrderController.getPrice("S", tempSizes[j])
                            : size[j].equals("M") ? OrderController.getPrice("M", tempSizes[j])
                            : size[j].equals("L") ? OrderController.getPrice("L", tempSizes[j])
                            : size[j].equals("XL")
                            ? OrderController.getPrice("XL", tempSizes[j])
                            : OrderController.getPrice("XXL", tempSizes[j]));
                }

                Object[] row = {orders[i].getCustomerId(), tempSizes[0], tempSizes[1], tempSizes[2], tempSizes[3], tempSizes[4], tempSizes[5], total};
                dtm.addRow(row);

            }
        }
    }

    private class ViewCustomers extends JFrame {

        private JButton backButton;
        private JTable viewCustomerTable;
        private DefaultTableModel dtm;

        ViewCustomers() {
            setSize(500, 450);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            setTitle("View Customers");
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
                    ViewCustomers.this.dispose();
                }
            });

            JPanel northJPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            northJPanel.add(backButton);

            String columnName[] = {"Customer ID", "Qty", "Amount"};
            dtm = new DefaultTableModel(columnName, 0);
            viewCustomerTable = new JTable(dtm);

            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

            for (int i = 0; i < viewCustomerTable.getColumnCount(); i++) {
                viewCustomerTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
            }

            viewCustomerTable.getColumnModel().getColumn(0).setPreferredWidth(70);
            viewCustomerTable.getColumnModel().getColumn(0).setMaxWidth(200);

            viewCustomerTable.getColumnModel().getColumn(1).setPreferredWidth(50);
            viewCustomerTable.getColumnModel().getColumn(1).setMaxWidth(100);

            viewCustomerTable.getColumnModel().getColumn(2).setPreferredWidth(70);
            viewCustomerTable.getColumnModel().getColumn(2).setMaxWidth(200);

            viewCustomerTable.setRowHeight(40);

            JScrollPane tablePane = new JScrollPane(viewCustomerTable);

            JPanel resultPanel = new JPanel(new BorderLayout());
            resultPanel.setBorder(BorderFactory.createEmptyBorder(10, 40, 20, 40));
            resultPanel.add(tablePane);

            add("Center", resultPanel);
            add("North", northJPanel);

            printCustomers();
        }

        private void printCustomers() {

            Order[] orders = OrderController.removeDuplicates();
            double[] totalAmount = new double[orders.length];
            int[] totalQtys = new int[orders.length];

            // Adding values to local arrays according to unique customer Array
            for (int i = 0; i < orders.length; i++) {

                for (int j = 0; j < OrderController.getNumberOfOrders(); j++) {

                    if (orders[i].getCustomerId().equals(OrderController.getOrder(j).getCustomerId())) {

                        double amount = OrderController.getPrice(OrderController.getOrder(j).getSize(),
                                OrderController.getOrder(j).getQty());

                        totalAmount[i] += amount;
                        totalQtys[i] += OrderController.getOrder(j).getQty();
                    }
                }
            }

            // printing data to the table
            for (int i = 0; i < orders.length; i++) {
                Object[] row = {orders[i].getCustomerId(), totalQtys[i], totalAmount[i]};
                dtm.addRow(row);

            }
        }
    }
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
