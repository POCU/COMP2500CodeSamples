package academy.pocu.comp2500samples.w02.vehicle;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Passenger blackWidow = new Passenger("Natasha");
        blackWidow.sayName();

        Vehicle motorcycle = new Vehicle(VehicleType.MOTOR_CYCLE);
        motorcycle.addPassenger(blackWidow);
        motorcycle.addFuel(22);

        ArrayList<Passenger> taxiPassengers = new ArrayList<Passenger>();
        taxiPassengers.add(new Passenger("Tony"));
        taxiPassengers.add(new Passenger("Thor"));

        Vehicle taxi = new Vehicle(VehicleType.SEDAN, taxiPassengers);
        taxi.addFuel(60);

        ArrayList<Passenger> vanPassengers = new ArrayList<Passenger>();
        vanPassengers.add(new Passenger("Steve"));
        vanPassengers.add(new Passenger("Bucky"));
        vanPassengers.add(new Passenger("Wanda"));
        vanPassengers.add(new Passenger("Bruce"));
        vanPassengers.add(new Passenger("Clint"));

        Vehicle van = new Vehicle(VehicleType.MINIVAN, vanPassengers, 70.5);

        System.out.println("Motorcycle:");
        motorcycle.drive(50);

        System.out.println("Taxi:");
        taxi.drive(50);

        System.out.println("Van:");
        van.drive(50);

        van.removePassenger("Steve");
        van.removePassenger("Bucky");

        System.out.println("Van:");
        van.drive(1000);

        System.out.println("Van:");
        van.addFuel(50);
        van.drive(100);
    }
}
