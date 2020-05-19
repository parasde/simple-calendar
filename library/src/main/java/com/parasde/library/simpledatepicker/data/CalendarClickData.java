package com.parasde.library.simpledatepicker.data;

import android.widget.LinearLayout;

public class CalendarClickData {
    private LinearLayout layout = null;
    private int year;
    private int month;
    private int date;

    private CalendarClickData.Shape shape;

    public enum Shape {
        RECTANGLE,
        CIRCLE
    }

    public CalendarClickData() { }

    public CalendarClickData(LinearLayout layout, int year, int month, int date) {
        this.layout = layout;
        this.year = year;
        this.month = month;
        this.date = date;
    }

    public LinearLayout getLayout() {
        return layout;
    }

    public void setLayout(LinearLayout layout) {
        this.layout = layout;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public Shape getShape() {
        return shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }
}
