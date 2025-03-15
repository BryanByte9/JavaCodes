package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RallyRaceResult {
    protected String raceName;
    protected String location;
    protected Map<Driver, int[]> results;

    public RallyRaceResult(String raceName, String location){
        this.raceName = raceName;
        this.location = location;
        this.results = new HashMap<>();
    }

    public String getRaceName(){
        return raceName;
    }

    public String getLocation(){
        return location;
    }

    public void recordResult(Driver driver, int position, int points){
        results.put(driver, new int[]{position, points});
        driver.addPoints(points);
        //Needs to store 2 values, so Use tuple to store positions & points
    }

    public int getDriverPoints(Driver driver){
        return results.get(driver)[1];
    }

    public List<Driver> getResults(){
        List<Driver> driverList = new ArrayList<>(results.keySet());

        for (int i = 0; i < driverList.size(); i++){
            for (int j = 0; j < driverList.size()-1-i; j++){
                int current = results.get(driverList.get(j))[0];
                int next = results.get(driverList.get(j+1))[0];

                if (current > next) {
                    Driver temp = driverList.get(j);
                    driverList.set(j, driverList.get(j+1));
                    driverList.set(j+1, temp);
            }
        }
    }
    //This returns a list of drivers sorted by their posistion.
    return driverList;
    }
}
