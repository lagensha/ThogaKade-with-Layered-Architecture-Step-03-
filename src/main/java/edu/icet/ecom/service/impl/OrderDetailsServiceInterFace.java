package edu.icet.ecom.service.impl;

import edu.icet.ecom.dto.OrderDTO;
import edu.icet.ecom.dto.OrderDetailsDTO;
import javafx.collections.ObservableList;

public interface OrderDetailsServiceInterFace {
    ObservableList<OrderDetailsDTO> viewOrderDetails();
    void addOrderDetails(String orderId,String itemCode, int qty,int discount);
    void updateOrderDetails(String itemCode, int qty,int discount,String orderId);
    void deleteOrderDetails(String orderId);
}
