package com.company.day17_线性回归;

/**
 * Java实现一元线性回归的算法，座标点实体类，(可实现统计指标的预测)
 */

public class DataPoint {

    /** the x value */
    private double x;

    /** the y value */
    private double y;

    /**
     * Constructor.
     * 
     * @param x the x value
     * @param y the y value
     */
    public DataPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}