package edu.icet.ecom.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface OrderRepositoryInterFace {
    ResultSet viewOrders() throws SQLException;
    void addOrders(String orderId,String orderDate,String customerId);
    void updateOrders(String orderDate,String customerId,String orderId);
    void deleteOrders(String orderId);
}
