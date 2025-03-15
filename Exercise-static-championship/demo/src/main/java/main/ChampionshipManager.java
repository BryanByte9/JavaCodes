package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChampionshipManager {
    //Static instance of this class
    private static ChampionshipManager instance;


    private List<Driver> drivers;
    private List<RallyRaceResult> races;

    //Static variables.
    protected static int totalDrivers;
    protected static int totalRaces;
    

    //Private constructor, Singleton.
    private ChampionshipManager(){
        this.drivers = new ArrayList<>();
        this.races = new ArrayList<>();
        //Initialize lists

        totalDrivers = 0;
        totalRaces = 0;
    }

    //Public constructor
    public static ChampionshipManager getInstance(){
        if(instance == null){
            instance = new ChampionshipManager();
        } else {
            System.out.println("Instance already exists.");
        }
        return instance;
    }

    public List<RallyRaceResult> getRaces(){
        return new ArrayList<>(races);
    }

    public void registerDriver(Driver driver){
        drivers.add(driver);
        totalDrivers++;
    }

    public void addRaceResult(RallyRaceResult result){
        races.add(result);
        totalRaces++;
    }

    public List<Driver> getDriverStandings() {
        // Use this list to store sorted drivers
        List<Driver> sortedDrivers = new ArrayList<>(drivers);

        // Sorting
        for (int i = 0; i < sortedDrivers.size() - 1; i++) {
            for (int j = 0; j < sortedDrivers.size() - 1 - i; j++) {
                // Point of current driver
                int currentPoints = sortedDrivers.get(j).getPoints();
                // Point of next driver
                int nextPoints = sortedDrivers.get(j+1).getPoints();
                
                // Put bigger points on top
                if (currentPoints < nextPoints) {
                    Driver temp = sortedDrivers.get(j);
                    sortedDrivers.set(j, sortedDrivers.get(j+1));
                    sortedDrivers.set(j+1, temp);
                }
            }
        }
        return sortedDrivers;
    }

    public Driver getLeadingDriver(){
        Map<Driver, Integer> totalPoints = new HashMap<>();
        //Map of <Driver, Points of every race they have been>

        for(RallyRaceResult race: races){
            List<Driver> sortedDrivers = race.getResults();
            for (Driver driver: sortedDrivers){
                int points = race.getDriverPoints(driver);
                totalPoints.put(driver, totalPoints.getOrDefault(driver, 0) + points);
            }
        }

        //Look for the driver with the most points
        Driver leadingDriver = null;
        int maxPoints = -1;

        for (Driver driver : totalPoints.keySet()) {
            int currentPoints = totalPoints.get(driver);
    
            // Update the leading driver
            if (currentPoints > maxPoints) {
                maxPoints = currentPoints;
                leadingDriver = driver;
            } 
            
        }
    
        return leadingDriver; // When no data return null
    }

    public static int getTotalChampionshipPoints() {
        if (instance == null) {
            return 0;
        }
    
        // get drivers list from instance
        List<Driver> drivers = instance.drivers;
        
        int totalPoints = 0;
    
        // Add points one by one
        for (int i = 0; i < drivers.size(); i++) {
            Driver driver = drivers.get(i);
            totalPoints += driver.getPoints();
        }
    
        return totalPoints;
    }

}
