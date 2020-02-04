package academy.pocu.comp2500samples.w02.vehicle;

import java.util.ArrayList;

public class Vehicle {
    public VehicleType type;
    public ArrayList<Passenger> passengers;
    public double fuelAmount;
    public int mileage;

    public Vehicle(VehicleType type) {
        this(type, new ArrayList<Passenger>(), 0);
    }

    public Vehicle(VehicleType type, ArrayList<Passenger> passengers) {
        this(type, passengers, 0);
    }

    public Vehicle(VehicleType type, double fuelAmount) {
        this(type, new ArrayList<Passenger>(), fuelAmount);
    }

    public Vehicle(VehicleType type, ArrayList<Passenger> passengers, double fuelAmount) {
        this.type = type;
        this.passengers = passengers;
        this.fuelAmount = fuelAmount;
        this.mileage = 0;
    }

    public void addPassenger(Passenger passenger) {
        this.passengers.add(passenger);
    }

    public void removePassenger(String name) {
        for (Passenger p : this.passengers) {
            if (p.name.equals(name)) {
                this.passengers.remove(p);
                break;
            }
        }
    }

    public void addFuel(double fuelAmount) {
        this.fuelAmount += fuelAmount;
    }

    public void drive(int distance) {
        System.out.println(String.format("Traveling %dkm.", distance));

        double gasMileage = 100000;

        switch (this.type) {
            case MOTORCYCLE:
                gasMileage = 0.05;
                break;
            case SEDAN:
                gasMileage = 0.07;
                break;
            case MINIVAN:
                gasMileage = 0.1;
                break;
            default:
                assert (false) : "Unrecognized vehicle type: " + this.type;
                break;
        }

        double requiredFuel = gasMileage * distance + 0.01 * this.passengers.size();

        if (requiredFuel > this.fuelAmount) {
            System.out.println("Not enough fuel to travel that far!");
            return;
        }

        this.fuelAmount -= requiredFuel;
        this.mileage += distance;

        System.out.println(String.format("FuelAmount %.2fL.", this.fuelAmount));
        System.out.println(String.format("Mileage %dkm.", this.mileage));
    }
}
