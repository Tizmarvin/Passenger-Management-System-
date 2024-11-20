/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package formativeassessment3gui;

//@author tiyanimabasa
 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conn {
    
    Connection connection;
    Statement statement;

    public Conn() {
        try {

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/fa3_assessment", "root", "SWDeveloper2024!");
            statement = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
