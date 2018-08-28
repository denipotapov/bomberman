package com.want.job.Field;

public class FieldBuilder {

    public static int[][] build(int height, int width) {
        return new int[height][width];
    }
    public static int[][] build(int defaultFieldSize) {
        return new int[defaultFieldSize][defaultFieldSize];
    }


}
