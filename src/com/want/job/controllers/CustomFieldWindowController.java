package com.want.job.controllers;

import com.want.job.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import com.want.job.components.gridField.GridField;

public class CustomFieldWindowController {

    private MainController mainController = App.getMainController();
    private GridField field = mainController.field;

    @FXML
    TextField heightTxt;

    @FXML
    TextField widthTxt;

    @FXML
    TextField minesTxt;

    @FXML
    Button okBtn;

    @FXML
    Button cancelBtn;

    @FXML
    public void accept(ActionEvent actionEvent) {
        int height = Integer.parseInt(heightTxt.getText());
        int width = Integer.parseInt(widthTxt.getText());
        int mines = Integer.parseInt(minesTxt.getText());
        field.prepareCustomField(height,width);
        field.setMines(mines);
        field.getScene().getWindow().sizeToScene();
        mainController.cropWindow();
        ((Stage)((Node)actionEvent.getSource()).getScene().getWindow()).close();
    }

    @FXML
    public void cancel(ActionEvent actionEvent) {
        ((Stage)((Node)actionEvent.getSource()).getScene().getWindow()).close();
    }
}
