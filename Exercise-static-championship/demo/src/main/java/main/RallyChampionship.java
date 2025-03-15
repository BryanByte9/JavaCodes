package main;

import java.util.List;

/**
 * Test Run of Everything
 *
 */
public class RallyChampionship 
{
    public static void main( String[] args )
    {   
        //Initialize ChampionshipManager
        ChampionshipManager manager = ChampionshipManager.getInstance();

        //Create cars and drivers, then register drivers to Manager
        AsphaltCar car1 = new AsphaltCar("Toyota", "ABC", 20, 10);
        GravelCar car2 = new GravelCar("Mercedes", "XYZ", 30, 20);
        Driver Sebastian = new Driver("Sebastian Ogier", "France", car1);
        Driver Thierry = new Driver("Thierry Neuville", "Belgium", car2);
        Driver Kalle = new Driver("Kalle Rovanpera", "Finland", car1);
        Driver Ott = new Driver("Ott Tanak", "Estonia", car2);

        manager.registerDriver(Ott);
        manager.registerDriver(Sebastian);
        manager.registerDriver(Thierry);
        manager.registerDriver(Kalle);

        //Set races and results, then register results to Manager
        RallyRaceResult race1 = new RallyRaceResult("Rally Finland","Jyvaskyla");
        race1.recordResult(Sebastian, 1, 25);
        race1.recordResult(Ott, 2, 18);
        race1.recordResult(Kalle, 3, 15);
        race1.recordResult(Thierry, 4, 12);
        RallyRaceResult race2 = new RallyRaceResult("Monte Carlo ", "Monaco");
        race2.recordResult(Kalle, 1, 25);
        race2.recordResult(Thierry, 2, 18);
        race2.recordResult(Sebastian, 3, 15);
        race2.recordResult(Ott, 4, 12);

        manager.addRaceResult(race1);
        manager.addRaceResult(race2);

        //Print drivers by standings
        int rank = 1;
        for (Driver driver : manager.getDriverStandings()){
            System.out.println(rank++ + ". " + driver.getName() + " (" + driver.getCountry() + "): " + driver.getPoints() + " points");
        }

        System.out.println("\n==== CHAMPIONSHIP LEADER ====");
        Driver leader = manager.getLeadingDriver();
        System.out.println(leader.getName() + " with " + leader.getPoints() + " points.");

        System.out.println("\n==== CHAMPIONSHIP STATISTICS ====");
        System.out.println("Total Drivers: " + ChampionshipManager.totalDrivers);
        System.out.println("Total races:" + ChampionshipManager.totalRaces);
        System.out.println("Average Points Per Driver:" + ChampionshipStatistics.calculatePointsPerDriver(manager.getDriverStandings()));
        System.out.println("Most Successful Country:" + ChampionshipStatistics.findMostSuccessfulCountry(manager.getDriverStandings()));
        System.out.println("Total championship Points:" + ChampionshipManager.getTotalChampionshipPoints());

        System.out.println("\n==== RACE RESULTS ====");
        for (RallyRaceResult race : manager.getRaces()) {
            System.out.println("Race: " + race.getRaceName() + " (" + race.getLocation() + ")");
            List<Driver> results = race.getResults();
            for (int i = 0; i < results.size(); i++) {
                Driver driver = results.get(i);
                int racePoints = race.getDriverPoints(driver);
                System.out.println(
                    "\tPosition " + (i + 1) + ": " + 
                    driver.getName() + " - " + 
                    racePoints + " points"
                );
            }
            System.out.println();
}

        System.out.println("==== CAR PERFORMANCE RATINGS ====");
        System.out.println("Gravel Car Performance: " + car2.calculatePerformance());
        System.out.println("Asphalt Car Performance: " + car1.calculatePerformance());
        
    }
}
