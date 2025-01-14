package race_simulation;
public class Truck extends Vehicle {
    public Truck(String name, int speed, int durability) {
        super(name, speed, durability);
    }

    @Override
    public double calculatePerformance() {
        return speed * 0.9 - durability * 0.3;
}
