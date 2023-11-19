/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fashionshop.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author sasin
 */
public class MainForm extends javax.swing.JFrame {

    private JLabel imageLabel;
    private JLabel titleLabel;
    private JLabel bottomLabel;
    private JButton search_button;
    private JButton status_button;
    private JButton reports_button;
    private JButton delete_button;
    private JButton placeOrder_button;
    /**
     * Creates new form MainForm
     */
    public MainForm() {
        initComponents();
        
        setSize(500, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Fashion Shop");
        setResizable(false);
        setLayout(new BorderLayout());

        titleLabel = new JLabel("Fashion Shop");
        titleLabel.setFont(new Font("", 1, 35));
        titleLabel.setForeground(Color.white);
        titleLabel.setBackground(new Color(55, 120, 255));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setOpaque(true);

        bottomLabel = new JLabel("Copyright© iCET 2023");
        bottomLabel.setFont(new Font("", 1, 12));
        bottomLabel.setHorizontalAlignment(JLabel.CENTER);

        imageLabel = new JLabel();
        imageLabel.setSize(350, 350);

        ImageIcon image = new ImageIcon("C:/Users/sasin/Desktop/A8/New folder (2)/FashionShop/lib/sample.png");
        Image img = image.getImage();
        Image imgScale = img.getScaledInstance(imageLabel.getWidth(), imageLabel.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        imageLabel.setIcon(scaledIcon);

        JPanel buttonPanel = new JPanel();
        JPanel buttonAlignPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        Dimension buttonSize1 = new Dimension(150, 40);
        Dimension buttonSize2 = new Dimension(150, 60); 

        JPanel imagPanel = new JPanel();
        imagPanel.add(imageLabel);

        buttonPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        search_button = new JButton("Search");
        search_button.setAlignmentX(Component.CENTER_ALIGNMENT);
        search_button.setPreferredSize(buttonSize1); 
        search_button.setMaximumSize(buttonSize1); 
        search_button.setFont(new Font("", 1,13));
        search_button.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                int choice = JOptionPane.showOptionDialog(
                        MainForm.this,
                        "Select an option:",
                        "Search an option",
                        JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        new String[]{"Search Customer", "Search Order", "Cancel"},
                        "Option 1");

                if (choice == JOptionPane.YES_OPTION) {

                    MainForm.this.dispose();
                    new SearchCustomer().setVisible(true);

                } else if (choice == JOptionPane.NO_OPTION) {

                    MainForm.this.dispose();
                    new SearchOrder().setVisible(true);

                } else if (choice == JOptionPane.CANCEL_OPTION) {
                    
                }
            }

            
        });
        buttonPanel.add(search_button);

        buttonPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        reports_button = new JButton("Reports");
        reports_button.setAlignmentX(Component.CENTER_ALIGNMENT);
        reports_button.setPreferredSize(buttonSize1); 
        reports_button.setMaximumSize(buttonSize1);
        reports_button.setFont(new Font("", 1,13));
        reports_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ViewReports().setVisible(true);
            }
        }); 
        buttonPanel.add(reports_button);

        buttonPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        status_button = new JButton("Status");
        status_button.setAlignmentX(Component.CENTER_ALIGNMENT);
        status_button.setPreferredSize(buttonSize1); 
        status_button.setMaximumSize(buttonSize1);
        status_button.setFont(new Font("", 1,13));
        status_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ChangeStatus().setVisible(true);
            }
        }); 
        buttonPanel.add(status_button);

        buttonPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        delete_button = new JButton("Delete");
        delete_button.setAlignmentX(Component.CENTER_ALIGNMENT);
        delete_button.setPreferredSize(buttonSize1); 
        delete_button.setMaximumSize(buttonSize1);
        delete_button.setFont(new Font("", 1,13));
        delete_button.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                new DeleteOrder().setVisible(true);
            }
        });

        buttonPanel.add(delete_button);

        buttonPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        placeOrder_button = new JButton("Place Order");
        placeOrder_button.setAlignmentX(Component.CENTER_ALIGNMENT);
        placeOrder_button.setPreferredSize(buttonSize2); 
        placeOrder_button.setMaximumSize(buttonSize2);
        placeOrder_button.setBackground(new Color(26, 188, 156));
        placeOrder_button.setFont(new Font("", 1, 18));
        placeOrder_button.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        placeOrder_button.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                new PlaceOrder().setVisible(true);
            }
        });

        buttonPanel.add(placeOrder_button);
        
        buttonAlignPanel.add(buttonPanel);
        add("North", titleLabel);
        add("West", buttonAlignPanel);
        add("East", imagPanel);
        add("South", bottomLabel);
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
   
    
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

