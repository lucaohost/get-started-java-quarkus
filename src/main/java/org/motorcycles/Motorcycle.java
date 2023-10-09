package org.motorcycles;

public class Motorcycle {

    private Long id;
    private String brand;
    private String model;
    private int year;
    private int cv; // Horsepower
    private String torque;
    private String additionalInfo;

    public Motorcycle(Long id, String brand, String model, int year, int cv, String torque, String additionalInfo) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.cv = cv;
        this.torque = torque;
        this.additionalInfo = additionalInfo;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getCv() {
        return cv;
    }

    public void setCv(int cv) {
        this.cv = cv;
    }

    public String getTorque() {
        return torque;
    }

    public void setTorque(String torque) {
        this.torque = torque;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Motorcycle{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", cv=" + cv +
                ", torque='" + torque + '\'' +
                ", additionalInfo='" + additionalInfo + '\'' +
                '}';
    }
}
