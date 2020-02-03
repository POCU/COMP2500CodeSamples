package academy.pocu.comp2500samples.w02.vehicle;

import java.util.ArrayList;

public class Vehicle {
    public VehicleType Type;
    public ArrayList<Passenger> Passengers;
    public double FuelAmount = 0;
    public int Mileage = 0;

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
        this.Type = type;
        this.Passengers = passengers;
        this.FuelAmount = fuelAmount;
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

        double gasMileage = 100000;

        switch (this.Type) {
            case MOTOR_CYCLE:
                gasMileage = 0.05;
                break;
            case SEDAN:
                gasMileage = 0.07;
                break;

            case MINIVAN:
                gasMileage = 0.1;
                break;

            default:
                assert (false) : "Unrecognized vehicle type: " + this.Type;
                break;
        }

        double requiredFuel = gasMileage * distance + 0.01 * this.Passengers.size();

        if (requiredFuel > this.FuelAmount) {
            System.out.println("Not enough fuel to travel that far!");
            return;
        }

        this.FuelAmount -= requiredFuel;
        this.Mileage += distance;

        System.out.println(String.format("FuelAmount %.2fL.", this.FuelAmount));
        System.out.println(String.format("Mileage %dkm.", this.Mileage));
    }
}
