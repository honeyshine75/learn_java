package com.company.day17_���Իع�;

/**
 * Javaʵ��һԪ���Իع���㷨�������ʵ���࣬(��ʵ��ͳ��ָ���Ԥ��)
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