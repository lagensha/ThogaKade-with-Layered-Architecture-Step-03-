package edu.icet.ecom.service;

import edu.icet.ecom.dto.ItemDTO;
import javafx.collections.ObservableList;

import java.sql.ResultSet;

public interface ItemServiceInterFace {
    ObservableList<ItemDTO> viewItems();
    void addItems(String id,String description ,String packSize,double unitPrice,int qty);
    void updateItems(String description ,String packSize,double unitPrice,int qty,String id);
    void deleteItems(String id);
}
