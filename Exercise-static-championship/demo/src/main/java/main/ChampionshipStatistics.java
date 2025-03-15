package main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChampionshipStatistics {
    public static double calculatePointsPerDriver(List<Driver> drivers){
        int totalPoints = 0;
        for(Driver driver : drivers){
            totalPoints += driver.getPoints();
        }
        return totalPoints / ChampionshipManager.totalDrivers;
    }

    public static String findMostSuccessfulCountry(List<Driver> drivers){
        if (drivers == null || drivers.isEmpty()) {
            return null;
        }

        //Get total points of every country
        Map<String, Integer> countryPoints = new HashMap<>();
        for (Driver driver : drivers) {
            String country = driver.getCountry();
            int currentPoints = countryPoints.getOrDefault(country, 0);
            countryPoints.put(country, currentPoints + driver.getPoints());
        }

        //Find the country with the most points
        String mostSuccessful = null;
        int maxPoints = -1;
        for (String country: countryPoints.keySet()){
            int points = countryPoints.get(country);
            //Update if point is higher
            if (points > maxPoints) {
                maxPoints = points;
                mostSuccessful = country;
            }
            //If points are same, compare name
            else if (points == maxPoints) {
                if (mostSuccessful == null || country.compareTo(mostSuccessful) < 0) {
                    mostSuccessful = country;
                }
            }
        }
        return mostSuccessful;
    }

    public static int getTotalRacesHold(){
        return ChampionshipManager.totalRaces;
    }
}
