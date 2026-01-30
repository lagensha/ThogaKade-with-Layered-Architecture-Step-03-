package edu.icet.ecom.service;

import edu.icet.ecom.dto.CustomerDTO;
import javafx.collections.ObservableList;

public interface CustomerServiceInterFace {
        ObservableList<CustomerDTO>viewCustomers();
        void addCustomers(String id, String title, String name, String dob, double salary, String address, String city, String province, int postalCode);
        void updateCustomers(String title,String name, String dob,double salary,String address,String city, String province,int postalCode,String id);
        void deleteCustomers(String id);
}
