package edu.icet.ecom.repository;

import edu.icet.ecom.db.DBConnection;
import edu.icet.ecom.dto.CustomerDTO;

import java.sql.*;

public class CustomerRepository implements CustomerRepositoryInterFace {
    @Override
    public ResultSet viewCustomers() throws SQLException {

        Connection connection= DBConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM customer");
        ResultSet resultSet = preparedStatement.executeQuery();

        return resultSet;
    }

    @Override
    public void addCustomers(String id,String title,String name, String dob,double salary,String address,String city, String province,int postalCode) throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO customer VALUES(?,?,?,?,?,?,?,?,?)");

        preparedStatement.setObject(1,id);
        preparedStatement.setObject(2,title);
        preparedStatement.setObject(3,name);
        preparedStatement.setObject(4,dob);
        preparedStatement.setObject(5,salary);
        preparedStatement.setObject(6,address);
        preparedStatement.setObject(7,city);
        preparedStatement.setObject(8,province);
        preparedStatement.setObject(9,postalCode);

        preparedStatement.executeUpdate();
    }

    @Override
    public void updateCustomers(String title,String name, String dob,double salary,String address,String city, String province,int postalCode,String id) {

        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE customer SET  CustTitle=?,CustName=?,DOB=?,salary=?,CustAddress=?,City=?, Province=?, PostalCode=? WHERE CustID=?");

            preparedStatement.setObject(1,title);
            preparedStatement.setObject(2,name);
            preparedStatement.setObject(3,dob);
            preparedStatement.setObject(4,salary);
            preparedStatement.setObject(5,address);
            preparedStatement.setObject(6,city);
            preparedStatement.setObject(7,province);
            preparedStatement.setObject(8,postalCode);
            preparedStatement.setObject(9,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void deleteCustomers(String id) throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM customer WHERE CustID=?");
        preparedStatement.setObject(1,id);
        preparedStatement.executeUpdate();

    }
}
