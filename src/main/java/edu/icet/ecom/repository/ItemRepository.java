package edu.icet.ecom.repository;

import edu.icet.ecom.db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemRepository implements ItemRepositoryInterFace{
    @Override
    public ResultSet viewItems() throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM item");
        ResultSet resultSet = preparedStatement.executeQuery();

        return resultSet;
    }

    @Override
    public void addItems(String id, String description, String packSize, double unitPrice, int qty) throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO item VALUES(?,?,?,?,?)");
        preparedStatement.setObject(1,id);
        preparedStatement.setObject(2,description);
        preparedStatement.setObject(3,packSize);
        preparedStatement.setObject(4,unitPrice);
        preparedStatement.setObject(5,qty);

        preparedStatement.executeUpdate();

    }

    @Override
    public void updateItems(String description, String packSize, double unitPrice, int qty, String id) throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE item SET Description=?,PackSize=?,UnitPrice=?,QtyOnHand=? WHERE ItemCode=?");
        preparedStatement.setObject(1, description);
        preparedStatement.setObject(2, packSize);
        preparedStatement.setObject(3, unitPrice);
        preparedStatement.setObject(4, qty);
        preparedStatement.setObject(5, id);

        preparedStatement.executeUpdate();

    }
    @Override
    public void deleteItems(String id) throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM item WHERE ItemCode=?");
        preparedStatement.setObject(1,id);
        preparedStatement.executeUpdate();
    }
}
