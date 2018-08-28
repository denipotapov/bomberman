package com.want.job.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import com.want.job.components.customFieldWindow.CustomFieldWindow;
import com.want.job.components.gridField.GridField;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    public GridField field;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        field.prepareBeginnerField();
    }

    @FXML
    public void menuBeginnerClicked(ActionEvent actionEvent) {
        field.prepareBeginnerField();
        cropWindow();
    }

    @FXML
    public void menuIntermediateClicked(ActionEvent actionEvent) {
        field.prepareIntermediateField();
        cropWindow();
    }

    @FXML
    public void menuAdvancedClicked(ActionEvent actionEvent) {
        field.prepareAdvancedField();
        cropWindow();
    }

    @FXML
    public void menuCustomClicked(ActionEvent actionEvent) {
        new CustomFieldWindow();
        cropWindow();
    }

    @FXML
    public void menuLoadClicked(ActionEvent actionEvent) {
        System.out.println("To Implement!");
    }

    @FXML
    public void menuSaveClicked(ActionEvent actionEvent) {
        System.out.println("To Implement!");
    }

    @FXML
    public void menuCloseClicked(ActionEvent actionEvent) {
        System.out.println("To Implement!");
    }

    @FXML
    public void menuAboutClicked(ActionEvent actionEvent) {
        System.out.println("To Implement!");
    }

    public void cropWindow(){
        field.getScene().getWindow().sizeToScene();
    }
}
