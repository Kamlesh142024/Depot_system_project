package model;



public class Parcel {
    private String id;
    private int length, width, height, weight, days;

    public Parcel(String id, int length, int width, int height, int weight, int days) {
        this.id = id;
        this.length = length;
        this.width = width;
        this.height = height;
        this.weight = weight;
        this.days = days;
    }

    public String getId() {
        return id;
    }
    public int getheight() {
        return height;
    }
    public int getlength() {
        return length;
    }
    public int getwidth() {
        return width;
    }
    public int getVolume() {
        return length * width * height;
    }

    public int getWeight() {
        return weight;
    }

    public int getDays() { 
        return days;
    }

    @Override
    public String toString() {
        return "Parcel ID: " + id + ", Weight: " + weight + ", Days: " + days;
    }
}
