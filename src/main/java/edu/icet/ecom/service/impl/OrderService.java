package edu.icet.ecom.service.impl;

import edu.icet.ecom.db.DBConnection;
import edu.icet.ecom.dto.OrderDTO;
import edu.icet.ecom.repository.OrderRepository;
import edu.icet.ecom.service.OrderServiceInterFace;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderService implements OrderServiceInterFace {
    @Override
    public ObservableList<OrderDTO> viewOrders() {
        ObservableList<OrderDTO>orderDTOS= FXCollections.observableArrayList();

        try {
            OrderRepository orderRepository = new OrderRepository();
           ResultSet resultSet = orderRepository.viewOrders();
           while (resultSet.next()){
               orderDTOS.add(new OrderDTO(
               resultSet.getString("OrderID"),
               resultSet.getString("OrderDate"),
               resultSet.getString("CustID")
               ));
           }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return orderDTOS;
    }

    @Override
    public void addOrders(String orderId, String orderDate, String customerId) {

    }

    @Override
    public void updateOrders(String orderDate, String customerId, String orderId) {

    }

    @Override
    public void deleteOrders(String orderId) {

    }
}
