package com.want.job.components.customFieldWindow;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class CustomFieldWindow extends BorderPane{

    public CustomFieldWindow() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("customFieldWindow.fxml"));
            loader.setRoot(this);
            BorderPane pane = loader.load();
            Scene scene = new Scene(pane);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.sizeToScene();
            stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
