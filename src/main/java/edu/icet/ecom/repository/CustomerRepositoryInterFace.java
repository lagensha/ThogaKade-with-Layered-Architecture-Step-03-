package edu.icet.ecom.repository;

import edu.icet.ecom.dto.CustomerDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface CustomerRepositoryInterFace {
    ResultSet viewCustomers() throws SQLException;
    void addCustomers(String id,String title,String name, String dob,double salary,String address,String city, String province,int postalCode) throws SQLException;
    void updateCustomers(String title,String name, String dob,double salary,String address,String city, String province,int postalCode,String id);
    void deleteCustomers(String id) throws SQLException;
}
