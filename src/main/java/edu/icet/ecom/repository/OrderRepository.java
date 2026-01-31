package edu.icet.ecom.repository;

import edu.icet.ecom.db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderRepository implements OrderRepositoryInterFace{
    @Override
    public ResultSet viewOrders() throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM orders");
        ResultSet resultSet = preparedStatement.executeQuery();

        return resultSet;
    }

    @Override
    public void addOrders(String orderId, String orderDate, String customerId) throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement preparedStatement =connection.prepareStatement("INSERT INTO orders VALUES(?,?,?)");
        preparedStatement.setObject(1,orderId);
        preparedStatement.setObject(2,orderDate);
        preparedStatement.setObject(3,customerId);

        preparedStatement.executeUpdate();
    }

    @Override
    public void updateOrders(String orderDate, String customerId, String orderId) throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE orders SET  OrderDate=?, CustID=? WHERE OrderID=?");
        preparedStatement.setObject(1,orderDate);
        preparedStatement.setObject(2,customerId);
        preparedStatement.setObject(3,orderId);
        preparedStatement.executeUpdate();

    }

    @Override
    public void deleteOrders(String orderId) throws SQLException {
        Connection connection=DBConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM orders WHERE OrderID=?");
        preparedStatement.setObject(1,orderId);
        preparedStatement.executeUpdate();

    }
}
