package edu.icet.ecom.service;

import edu.icet.ecom.dto.OrderDTO;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface OrderServiceInterFace {
    ObservableList<OrderDTO> viewOrders();
    void addOrders(String orderId,String orderDate,String customerId) throws SQLException;
    void updateOrders(String orderDate,String customerId,String orderId);
    void deleteOrders(String orderId);
}
