package race_simulation;
public abstract class Vehicle {
    protected String name;
    protected int speed;
    protected int durability;
    public Vehicle(String name, int speed, int durability) {
        this.name = name;
        this.speed = speed;
        this.durability = durability;
    }

    public abstract double calculatePerformance();

    public String getName() {
        return name;
    }
}