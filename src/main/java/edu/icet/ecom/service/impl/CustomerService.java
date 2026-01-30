package edu.icet.ecom.service.impl;



import edu.icet.ecom.dto.CustomerDTO;
import edu.icet.ecom.repository.CustomerRepository;
import edu.icet.ecom.service.CustomerServiceInterFace;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;


public class CustomerService implements CustomerServiceInterFace {


    @Override
    public ObservableList<CustomerDTO> viewCustomers() {
        ObservableList<CustomerDTO>customerDTOS= FXCollections.observableArrayList();

        try {
            CustomerRepository customerRepository=new CustomerRepository();
           ResultSet resultSet= customerRepository.viewCustomers();
            while (resultSet.next()){
                customerDTOS.add(new CustomerDTO(
                        resultSet.getString("CustID"),
                        resultSet.getString("CustTitle"),
                        resultSet.getString("CustName"),
                        resultSet.getString("DOB"),
                        resultSet.getDouble("salary"),
                        resultSet.getString("CustAddress"),
                        resultSet.getString("City"),
                        resultSet.getString("Province"),
                        resultSet.getInt("PostalCode")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
            return customerDTOS;
    }

    @Override
    public void addCustomers(String id, String title, String name, String dob, double salary, String address, String city, String province, int postalCode) {
        CustomerRepository customerRepository = new CustomerRepository();
        try {
            customerRepository.addCustomers(id, title, name, dob, salary, address, city, province, postalCode);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateCustomers(String title,String name, String dob,double salary,String address,String city, String province,int postalCode,String id) {
     CustomerRepository customerRepository = new CustomerRepository();
     customerRepository.updateCustomers(title,name,dob,salary,address,city,province,postalCode,id);
    }

    @Override
    public void deleteCustomers(String id) {

        try {
            CustomerRepository customerRepository = new CustomerRepository();
            customerRepository.deleteCustomers(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
