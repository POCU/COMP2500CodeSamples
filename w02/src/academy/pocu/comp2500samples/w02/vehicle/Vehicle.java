package academy.pocu.comp2500samples.w02.vehicle;

import java.util.ArrayList;

public class Vehicle {
    public ArrayList<Passenger> Passengers = new ArrayList<Passenger>();
    public double FuelAmount = 0;
    public int Mileage = 0;

    public Vehicle() {
    }

    public Vehicle(ArrayList<Passenger> passengers) {
        this.Passengers = passengers;
    }

    public Vehicle(ArrayList<Passenger> passengers, int fuelAmount) {
        this(passengers);
        FuelAmount = fuelAmount;
    }

    public void addPassenger(Passenger passenger) {
        this.Passengers.add(passenger);
    }

    public void removePassenger(String name) {
        for (Passenger p : this.Passengers) {
            if (p.Name.equals(name)) {
                this.Passengers.remove(p);
                break;
            }
        }
    }

    public void addFuel(double fuelAmount) {
        this.FuelAmount += fuelAmount;
    }

    public void drive(int distance) {
        System.out.println(String.format("Traveling %dkm.", distance));

        this.FuelAmount -= Math.max(0.1 * distance + 0.01 * this.Passengers.size(), 0);
        this.Mileage += distance;

        System.out.println(String.format("FuelAmount %f.2km.", this.FuelAmount));
        System.out.println(String.format("Mileage %dkm.", this.Mileage));
    }
}
