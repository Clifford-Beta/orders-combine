package com.cb.graph;

public class Order {
    private double [] pickUp;
    private double [] destination;
    public  int u;
    public  int v;
    private double orderDistance;

    public Order(double[] pickUp, double[] destination, double orderDistance){
        this.pickUp = pickUp;
        this.destination = destination;
        this.orderDistance = orderDistance;
    }
    public Order(double[] pickUp, double[] destination){
        this.pickUp = pickUp;
        this.destination = destination;
    }

    public double[] getDestination() {
        return destination;
    }

    public double getOrderDistance() {
        return orderDistance;
    }

    public void setOrderDistance(double orderDistance) {
        this.orderDistance = orderDistance;
    }

    public double[] getPickUp() {
        return pickUp;
    }

    public void setDestination(double[] destination) {
        this.destination = destination;
    }

    public void setPickUp(double[] pickUp) {
        this.pickUp = pickUp;
    }
    public static double calculateOrderDistance(Order order){
        return 1;
    }

}
