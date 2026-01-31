package edu.icet.ecom.service.impl;

import edu.icet.ecom.dto.ItemDTO;
import edu.icet.ecom.repository.ItemRepository;
import edu.icet.ecom.service.ItemServiceInterFace;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemService implements ItemServiceInterFace {
    @Override
    public ObservableList<ItemDTO> viewItems() {
        ObservableList<ItemDTO>itemDTOS= FXCollections.observableArrayList();

        try {
            ItemRepository itemRepository = new ItemRepository();
           ResultSet resultSet= itemRepository.viewItems();
            while (resultSet.next()){
                itemDTOS.add(new ItemDTO(
                resultSet.getString("ItemCode"),
                        resultSet.getString("Description"),
                        resultSet.getString("PackSize"),
                        resultSet.getDouble("UnitPrice"),
                        resultSet.getInt("QtyOnHand")
                        ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return itemDTOS;
    }

    @Override
    public void addItems(String id, String description, String packSize, double unitPrice, int qty) {

        try {
            ItemRepository itemRepository = new ItemRepository();
            itemRepository.addItems(id,description,packSize,unitPrice,qty);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateItems(String description, String packSize, double unitPrice, int qty, String id) {

    }

    @Override
    public void deleteItems(String id) {

    }
}
