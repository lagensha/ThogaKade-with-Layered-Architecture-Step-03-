package edu.icet.ecom.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ItemRepositoryInterFace {
    ResultSet viewItems() throws SQLException;
    void addItems(String id,String description ,String packSize,double unitPrice,int qty);
    void updateItems(String description ,String packSize,double unitPrice,int qty,String id);
    void deleteItems(String id);
}
