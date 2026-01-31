package edu.icet.ecom.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface OrderDetailsRepositoryInterFace {
    ResultSet viewOrderDetails() throws SQLException;
    void addOrderDetails(String orderId,String itemCode, int qty,int discount) throws SQLException;
    void updateOrderDetails(String itemCode, int qty,int discount,String orderId) throws SQLException;
    void deleteOrderDetails(String orderId) throws SQLException;
}
