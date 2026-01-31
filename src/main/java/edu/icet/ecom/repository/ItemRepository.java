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
    public void addItems(String id, String description, String packSize, double unitPrice, int qty) {

    }

    @Override
    public void updateItems(String description, String packSize, double unitPrice, int qty, String id) {

    }

    @Override
    public void deleteItems(String id) {

    }
}
