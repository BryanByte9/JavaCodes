package main;

public class AsphaltCar extends RallyCar {
    private double downforce;

    public AsphaltCar(String make, String model, int horsepower, double downforce){
        super(make, model, horsepower);
        this.downforce = downforce;
    }

    public double getDownforce(){
        return downforce;
    }

    public double calculatePerformance(){
        return (horsepower * 0.5) + (downforce * 0.5);
    }

}
