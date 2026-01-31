package edu.icet.ecom.controller;

import edu.icet.ecom.dto.OrderDTO;
import edu.icet.ecom.service.impl.OrderService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class OrderController implements Initializable {
    OrderService orderService = new OrderService();
    @FXML
    private TableColumn<?, ?> colCustomerId;

    @FXML
    private TableColumn<?, ?> colOrderDate;

    @FXML
    private TableColumn<?, ?> colOrderId;

    @FXML
    private TableView<OrderDTO> tblOrderTable;

    @FXML
    private TextField txtCustomerId;

    @FXML
    private TextField txtOrderDate;

    @FXML
    private TextField txtOrderId;

    @FXML
    void btnAddOnAction(ActionEvent event) {
        String id = txtOrderId.getText();
        String date = txtOrderDate.getText();
        String customerId=txtCustomerId.getText();

        orderService.addOrders(id,date,customerId);
        loadTable();
        clearText();
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnResetOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colOrderId.setCellValueFactory(new PropertyValueFactory<>("orderId"));
        colOrderDate.setCellValueFactory(new PropertyValueFactory<>("orderDate"));
        colCustomerId.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        loadTable();
        tblOrderTable.getSelectionModel().selectedItemProperty().addListener((observableValue,oldValue, newValue) ->{
            if(newValue!=null){
                txtOrderId.setText(newValue.getOrderId());
                txtOrderDate.setText(newValue.getOrderDate());
                txtCustomerId.setText(newValue.getCustomerId());
            }
        } );
    }
    public void loadTable(){
        tblOrderTable.setItems(orderService.viewOrders());
    }
    public void clearText(){
        txtOrderId.clear();
        txtOrderDate.clear();
        txtCustomerId.clear();
    }
}
