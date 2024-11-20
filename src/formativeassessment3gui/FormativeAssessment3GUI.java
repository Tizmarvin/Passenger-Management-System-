/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

//@author tiyanimabasa

package formativeassessment3gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class FormativeAssessment3GUI extends JFrame implements ActionListener {
    
    JLabel labelhead, labelName, labelSname, labelDest, labelPhone;
    
    JTextField textName, textSname, textPhone;
    
    JComboBox<String> comboDest; // Dropdown for destination

    JButton buttonInsert, buttonExit, buttonView;
    
    JTable table;
    
    JScrollPane scrollPane;
    
    DefaultTableModel tableModel;
    
    boolean isTableVisible = true;
    
    FormativeAssessment3GUI() {
        super("TIYANI BUS SERVICES");

        // Heading
        labelhead = new JLabel("Boarded Passenger List");
        labelhead.setForeground(Color.BLACK);
        labelhead.setFont(new Font("SansSerif", Font.BOLD, 23));
        labelhead.setBounds(280, 100, 450, 40);
        add(labelhead);

        // Name 
        labelName = new JLabel("Name(s): ");
        labelName.setForeground(Color.BLACK);
        labelName.setFont(new Font("AvantGarde", Font.BOLD, 16));
        labelName.setBounds(20, 170, 450, 40);
        add(labelName);

        textName = new JTextField();
        textName.setForeground(Color.BLACK);
        textName.setFont(new Font("AvantGarde", Font.PLAIN, 16));
        textName.setBounds(120, 175, 280, 30);
        add(textName);

        // Surname 
        labelSname = new JLabel("Surname: ");
        labelSname.setForeground(Color.BLACK);
        labelSname.setFont(new Font("AvantGarde", Font.BOLD, 16));
        labelSname.setBounds(410, 170, 450, 40);
        add(labelSname);

        textSname = new JTextField();
        textSname.setForeground(Color.BLACK);
        textSname.setFont(new Font("AvantGarde", Font.PLAIN, 16));
        textSname.setBounds(485, 175, 280, 30);
        add(textSname);

        // Destination
        labelDest = new JLabel("Destination: ");
        labelDest.setForeground(Color.BLACK);
        labelDest.setFont(new Font("AvantGarde", Font.BOLD, 16));
        labelDest.setBounds(20, 230, 450, 40);
        add(labelDest);

        String[] destinations = {"", "Cape Town", "Durban", "East London", "Gqeberha","Giyani", "Polokwane", "Tshwane"};
        comboDest = new JComboBox<>(destinations);
        comboDest.setForeground(Color.BLACK);
        comboDest.setFont(new Font("AvantGarde", Font.PLAIN, 16));
        comboDest.setBounds(120, 235, 280, 30);
        add(comboDest);

        // Phone
        labelPhone = new JLabel("Phone: ");
        labelPhone.setForeground(Color.BLACK);
        labelPhone.setFont(new Font("AvantGarde", Font.BOLD, 16));
        labelPhone.setBounds(410, 230, 450, 40);
        add(labelPhone);

        textPhone = new JTextField();
        textPhone.setForeground(Color.BLACK);
        textPhone.setFont(new Font("AvantGarde", Font.PLAIN, 16));
        textPhone.setBounds(485, 235, 280, 30);
        add(textPhone);
        
        // Table setup
        String[] columnNames = {"First Name", "Last Name", "Destination", "Phone"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);
        table.setBackground(new Color(200, 240, 226));
        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(50, 300, 700, 150);
        add(scrollPane);
        scrollPane.setVisible(true);

        // Insert button
        buttonInsert = new JButton("INSERT");
        buttonInsert.setForeground(Color.BLACK);
        buttonInsert.setFont(new Font("AvantGarde", Font.BOLD, 15));
        buttonInsert.setBounds(210, 500, 120, 40);
        buttonInsert.setBackground(Color.DARK_GRAY);
        buttonInsert.addActionListener(this);
        add(buttonInsert);

        // View button
        buttonView = new JButton("VIEW");
        buttonView.setForeground(Color.BLACK);
        buttonView.setFont(new Font("AvantGarde", Font.BOLD, 15));
        buttonView.setBounds(490, 500, 120, 40);
        buttonView.setBackground(Color.DARK_GRAY);
        buttonView.addActionListener(this);
        add(buttonView);

        // Exit button
        buttonExit = new JButton("EXIT");
        buttonExit.setForeground(Color.BLACK);
        buttonExit.setFont(new Font("AvantGarde", Font.BOLD, 15));
        buttonExit.setBounds(350, 560, 120, 40);
        buttonExit.setBackground(Color.DARK_GRAY);
        buttonExit.addActionListener(this);
        add(buttonExit);

        // Logo
        ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("icons/buslogo.png"));
        Image img2 = img1.getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT);
        ImageIcon img3 = new ImageIcon(img2);
        JLabel image = new JLabel(img3);
        image.setBounds(350, 5, 120, 120);
        add(image);

        // Background
        ImageIcon imgg1 = new ImageIcon(ClassLoader.getSystemResource("icons/background.jpg"));
        Image imgg2 = imgg1.getImage().getScaledInstance(850, 700, Image.SCALE_DEFAULT);
        ImageIcon imgg3 = new ImageIcon(imgg2);
        JLabel background = new JLabel(imgg3);
        background.setBounds(0, 0, 850, 700);
        add(background);

        setLayout(null);
        setSize(800, 660);
        setLocation(380, 60);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == buttonInsert) {
            String name = textName.getText();
            String sName = textSname.getText();
            String destination = comboDest.getSelectedItem().toString();
            String phone = textPhone.getText();

            try {
                if (name.isEmpty() || sName.isEmpty() || destination.isEmpty() || phone.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill in all fields");
                } else {
                    Conn conn1 = new Conn();
                    String q = "INSERT INTO passenger_details (Fname, Lname, Dest, Phone) VALUES ('" + name + "', '" + sName + "', '" + destination + "', '" + phone + "')";
                    conn1.statement.executeUpdate(q);
                    JOptionPane.showMessageDialog(null, "Data Inserted Successfully");
                    loadTableData();
                    clearFields();
                }
            } catch (Exception E) {
                E.printStackTrace();
            }
        }

        if (e.getSource() == buttonView) {
            
            if (!isTableVisible) {
                loadTableData();  
                scrollPane.setVisible(true);
                buttonView.setText("HIDE");
            } else {
                scrollPane.setVisible(false);
                buttonView.setText("VIEW");
            }
            isTableVisible = !isTableVisible;
        }

        if (e.getSource() == buttonExit) {
            System.exit(0);
        }
    }

    public void loadTableData() {
        
        try {
            Conn conn1 = new Conn();
            String q = "SELECT Fname, Lname, Dest, Phone FROM passenger_details";
            ResultSet result = conn1.statement.executeQuery(q);

            tableModel.setRowCount(0);

            while (result.next()) {
                String firstName = result.getString("Fname");
                String lastName = result.getString("Lname");
                String destination = result.getString("Dest");
                String phone = result.getString("Phone");
                Object[] row = {firstName, lastName, destination, phone};
                tableModel.addRow(row);
            }
        } catch (Exception E) {
            E.printStackTrace();
        }
    }

    public void clearFields() {
        
        textName.setText("");
        textSname.setText("");
        comboDest.setSelectedIndex(0);
        textPhone.setText("");
    }

    public static void main(String[] args) {
        new FormativeAssessment3GUI();
    }
}
