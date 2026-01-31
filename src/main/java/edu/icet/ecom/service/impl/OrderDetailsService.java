package edu.icet.ecom.service.impl;

import edu.icet.ecom.dto.OrderDetailsDTO;
import edu.icet.ecom.repository.OrderDetailsRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderDetailsService implements OrderDetailsServiceInterFace{
    @Override
    public ObservableList<OrderDetailsDTO> viewOrderDetails() {
        ObservableList<OrderDetailsDTO>orderDetailsDTOS= FXCollections.observableArrayList();
        try {
            OrderDetailsRepository orderDetailsRepository = new OrderDetailsRepository();
            ResultSet resultSet =orderDetailsRepository.viewOrderDetails();
            while (resultSet.next()){
                orderDetailsDTOS.add(new OrderDetailsDTO(
                resultSet.getString("OrderID"),
                resultSet.getString("ItemCode"),
                resultSet.getInt("OrderQTY"),
                resultSet.getInt("Discount")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return orderDetailsDTOS;
    }

    @Override
    public void addOrderDetails(String orderId, String itemCode, int qty, int discount) {

    }

    @Override
    public void updateOrderDetails(String itemCode, int qty, int discount, String orderId) {

    }

    @Override
    public void deleteOrderDetails(String orderId) {

    }
}
