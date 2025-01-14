package race_simulation;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RaceSimulation {
    private List<Vehicle> vehicles = new ArrayList<>();
    private int numberOfRaces;

    public RaceSimulation(int numberOfRaces) {
        this.numberOfRaces = numberOfRaces;
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public void simulateRaces() {
        Random random = new Random();
        int[] wins = new int[vehicles.size()];

        for (int i = 0; i < numberOfRaces; i++) {
            double bestPerformance = Double.MIN_VALUE;
            int winnerIndex = -1;

            for (int j = 0; j < vehicles.size(); j++) {
                double performance = vehicles.get(j).calculatePerformance() + random.nextDouble() * 10;
                if (performance > bestPerformance) {
                    bestPerformance = performance;
                    winnerIndex = j;
                }
            }
            wins[winnerIndex]++;
        }

        System.out.println("Race Results:");
        for (int i = 0; i < vehicles.size(); i++) {
            System.out.println(vehicles.get(i).getName() + " won " + wins[i] + " races.");
        }
    }

    public static void main(String[] args) {
        RaceSimulation simulation = new RaceSimulation(10);

        simulation.addVehicle(new Motorcycle("Motorcycle1", 120, 80));
        simulation.addVehicle(new Car("Car1", 100, 90));
        simulation.addVehicle(new Truck("Truck1", 80, 120));

        simulation.simulateRaces();
    }
}
