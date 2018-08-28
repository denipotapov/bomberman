package com.want.job.components.gridField;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

public class Site2D extends Label {

    private int i;
    private int j;

    private boolean isOpened;

    public Site2D() {
        super();
        this.getStyleClass().add("site2d");
        this.setAlignment(Pos.CENTER);
        this.setFont(Font.font(18));
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }

    public boolean isOpened() {
        return isOpened;
    }

    public void open() {
        isOpened = true;
        this.getStyleClass().add("open");
    }

    public void close() {
        isOpened = false;
        this.getStyleClass().remove("open");
    }
}
