package com.want.job.bomberman;

import com.want.job.Field.FieldBuilder;

import java.util.Random;

public class Bomberman {

    public final static int BEGINNER_MINES_AMOUNT = 10;
    public final static int INTERMEDIATE_MINES_AMOUNT = 20;
    public final static int ADVANCED_MINES_AMOUNT = 30;

    private int[][] field;
    private int fieldHeight;
    private int fieldWidth;
    private Difficulty difficulty;
    private int mines;
    private boolean initialCheck;

    public Bomberman(int fieldHeight, int fieldWidth, Difficulty difficulty) {
        this.difficulty = difficulty;
        this.fieldHeight = fieldHeight;
        this.fieldWidth = fieldWidth;
        initialCheck = true;
        field = FieldBuilder.build(fieldHeight, fieldWidth);
    }

    private void initMines() {
        switch (difficulty) {
            case BEGINNER:
                mines = BEGINNER_MINES_AMOUNT;
                break;
            case INTERMEDIATE:
                mines = INTERMEDIATE_MINES_AMOUNT;
                break;
            case ADVANCED:
                mines = ADVANCED_MINES_AMOUNT;
                break;
        }

        int minesLasted = mines;
        while(minesLasted != 0) {
            Random random = new Random();
            int i = random.nextInt(fieldHeight);
            int j = random.nextInt(fieldWidth);
            if (field[i][j] != -1) {
                field[i][j] = -1;
                minesLasted--;
            }

        }
    }

    /**
     *
     * @return
     * true - if mine is found
     * false - if site is empty
     */
    public boolean resolveMine(int i, int j) {
        if (initialCheck) {
            initMines();
            initialCheck = false;
        }
        return field[i][j] == -1;
    }


    public void setMines(int mines) {
        this.mines = mines;
    }
}
