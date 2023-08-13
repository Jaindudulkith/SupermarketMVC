/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supermarket.mvc.controller;

import supermarketmvc.model.CustomerModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import supermarketmvc.db.DBConnection;

/**
 *
 * @author Jaindu
 */
public class CustomerController {
    
    public String saveCustomer(CustomerModel customerModel) throws SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        
        String query = "INSERT INTO Customer VALUES(?,?,?,?,?,?,?,?,?)";
        
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, customerModel.getCusID());
        statement.setString(2, customerModel.getCustTittle());
        statement.setString(3, customerModel.getCustName());
        statement.setString(4, customerModel.getDOB());
        statement.setDouble(5, customerModel.getSalary());
        statement.setString(6, customerModel.getCustAddress());
        statement.setString(7, customerModel.getCity());
        statement.setString(8, customerModel.getProvince());
        statement.setString(9, customerModel.getPostalCode());
        
        if(statement.executeUpdate() > 0){
            return "Success";
        } else{
            return "Fail";
        }
        
    }
    
}