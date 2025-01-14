package race_simulation;
public class Car extends Vehicle {
    public Car(String name, int speed, int durability) {
        super(name, speed, durability);
    }

    @Override
    public double calculatePerformance() {
        return speed * 1.1 - durability * 0.4;
    }
}