package main;

import java.util.List;

public interface RaceResult {
    public void recordResult(Driver driver, int position, int points);

    public int getDriverPoints(Driver drivcer);

    public List<Driver> getResults();

}
