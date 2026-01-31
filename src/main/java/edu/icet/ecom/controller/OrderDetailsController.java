package edu.icet.ecom.controller;

import edu.icet.ecom.dto.OrderDetailsDTO;
import edu.icet.ecom.service.impl.OrderDetailsService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class OrderDetailsController implements Initializable {
    OrderDetailsService orderDetailsService = new OrderDetailsService();
    @FXML
    private TableColumn<?, ?> colDiscount;

    @FXML
    private TableColumn<?, ?> colOrderQTY;

    @FXML
    private TableColumn<?, ?> colItemCode;

    @FXML
    private TableColumn<?, ?> colOrderId;

    @FXML
    private TableView<OrderDetailsDTO> tblOrderDetails;

    @FXML
    private TextField txtDiscount;

    @FXML
    private TextField txtItemCode;

    @FXML
    private TextField txtOrderId;

    @FXML
    private TextField txtOrderQTY;

    @FXML
    void btnAddOnAction(ActionEvent event) {

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
        colItemCode.setCellValueFactory(new PropertyValueFactory<>("itemCode"));
        colOrderQTY.setCellValueFactory(new PropertyValueFactory<>("qty"));
        colDiscount.setCellValueFactory(new PropertyValueFactory<>("discount"));

        loadTable();
        tblOrderDetails.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
            if(newValue!=null){
                txtOrderId.setText(newValue.getOrderId());
                txtItemCode.setText(newValue.getItemCode());
                txtDiscount.setText(String.valueOf(newValue.getDiscount()));
                txtOrderQTY.setText(String.valueOf(newValue.getQty()));
            }
        });
    }
    public void loadTable(){
        tblOrderDetails.setItems(orderDetailsService.viewOrderDetails());
    }
}
