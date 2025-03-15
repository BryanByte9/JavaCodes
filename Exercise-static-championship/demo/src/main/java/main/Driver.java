package main;

public class Driver {
    private String name;
    private String country;
    private int points;
    private RallyCar car;

    public Driver(String name, String country, RallyCar car) {
        this.name = name;
        this.country = country;
        this.car = car;
        this.points = 0;
    }

    public String getName(){
        return name;
    }

    public String getCountry(){
        return country;
    }

    public int getPoints(){
        return points;
    }

    public RallyCar getCar(){
        return car;
    }

    public void setCar(RallyCar car){
        this.car = car;
    }

    public void addPoints(int points){
        this.points += points;
    }

}
