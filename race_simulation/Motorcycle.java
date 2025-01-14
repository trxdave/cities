package race_simulation;
public class Motorcycle extends Vehicle {
    public Motorcycle(String name, int speed, int durability) {
        super(name, speed, durability);
    }

    @Override
    public double calculatePerformance() {
        return speed * 1.2 - durability * 0.5;
    }
}