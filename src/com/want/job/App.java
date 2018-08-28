package com.want.job;

import com.want.job.controllers.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.jetbrains.annotations.NotNull;

public class App extends Application {

    private static MainController mainController;

    @Override
    public void start(@NotNull Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("sample.fxml"));
        VBox root = loader.load();
        mainController = loader.getController();
        primaryStage.setTitle("Bomberman");
        primaryStage.setResizable(false);
        Scene scene = new Scene(root);
        scene.getStylesheets().add("com/want/job/style.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static MainController getMainController() {
        return mainController;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
