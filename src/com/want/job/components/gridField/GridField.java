package com.want.job.components.gridField;

import com.want.job.bomberman.Bomberman;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;
import com.want.job.Field.DefaultFieldSize;
import com.want.job.bomberman.Difficulty;

import java.io.IOException;

public class GridField extends GridPane {

    private static final int SITE_WIDTH = 25;
    private static final int SITE_HEIGHT = 25;

    private Difficulty difficulty;
    private Bomberman bomberman;

    public GridField() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setRoot(this);
        loader.setLocation(getClass().getResource("gridField.fxml"));
        loader.load();
    }

    public void prepareBeginnerField() {
        difficulty = Difficulty.BEGINNER;
        prepareField(DefaultFieldSize.SMALL_FIELD, DefaultFieldSize.SMALL_FIELD);
    }

    public void prepareIntermediateField() {
        difficulty = Difficulty.INTERMEDIATE;
        prepareField(DefaultFieldSize.MEDIUM_FIELD, DefaultFieldSize.MEDIUM_FIELD);
    }

    public void prepareAdvancedField() {
        difficulty = Difficulty.ADVANCED;
        prepareField(DefaultFieldSize.LARGE_FIELD, DefaultFieldSize.LARGE_FIELD);
    }

    public void prepareCustomField(int height, int width) {
        difficulty = Difficulty.CUSTOM;
        prepareField(height, width);
    }

    private void prepareField(int height, int width) {
        bomberman = new Bomberman(height, width, difficulty);
        this.getChildren().clear();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                Site2D site = new Site2D();
                site.setI(i);
                site.setJ(j);
                site.setMinWidth(SITE_WIDTH);
                site.setMinHeight(SITE_HEIGHT);
                site.setOnMouseClicked( e -> {
                    Site2D currentSite = ((Site2D)e.getSource());
                    currentSite.open();
                    if (bomberman.resolveMine(currentSite.getI(), currentSite.getJ())) {
                        currentSite.getStyleClass().add("bomb");
                    }
                });
                this.add(site, j, i);
            }
        }
    }

    public void setMines(int mines) {
        if (bomberman == null) {
            throw new NullPointerException("You must first initialize the field of bomberman");
        }
        bomberman.setMines(mines);

    }
}
