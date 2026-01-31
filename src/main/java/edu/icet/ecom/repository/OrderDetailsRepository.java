package edu.icet.ecom.repository;

import edu.icet.ecom.db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderDetailsRepository implements OrderDetailsRepositoryInterFace{

    @Override
    public ResultSet viewOrderDetails() throws SQLException {
        Connection connection= DBConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM orderdetail");
        ResultSet resultSet = preparedStatement.executeQuery();

        return resultSet;
    }

    @Override
    public void addOrderDetails(String orderId, String itemCode, int qty, int discount) throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO orderdetail VALUES(?,?,?,?)");
        preparedStatement.setObject(1,orderId);
        preparedStatement.setObject(2,itemCode);
        preparedStatement.setObject(3,qty);
        preparedStatement.setObject(4,discount);

        preparedStatement.executeUpdate();
    }

    @Override
    public void updateOrderDetails(String itemCode, int qty, int discount, String orderId) throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE orderdetail SET ItemCode=?, OrderQTY=?,Discount=? WHERE OrderID=?");
        preparedStatement.setObject(1,itemCode);
        preparedStatement.setObject(2,qty);
        preparedStatement.setObject(3,discount);
        preparedStatement.setObject(4,orderId);
        preparedStatement.executeUpdate();
    }

    @Override
    public void deleteOrderDetails(String orderId) {

    }
}
