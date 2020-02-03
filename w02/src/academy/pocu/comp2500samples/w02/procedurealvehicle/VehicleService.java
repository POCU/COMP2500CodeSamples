package academy.pocu.comp2500samples.w02.procedurealvehicle;

public class VehicleService {
    public static void addPassenger(Vehicle vehicle, Passenger passenger) {
        vehicle.Passengers.add(passenger);
    }

    public static void removePassenger(Vehicle vehicle, String name) {
        for (Passenger p : vehicle.Passengers) {
            if (p.Name.equals(name)) {
                vehicle.Passengers.remove(p);
                break;
            }
        }
    }

    public static void addFuel(Vehicle vehicle, double fuelAmount) {
        vehicle.FuelAmount += fuelAmount;
    }

    public static void drive(Vehicle vehicle, int distance) {
        System.out.println(String.format("Traveling %dkm.", distance));

        vehicle.FuelAmount -= Math.max(0.1 * distance + 0.01 * vehicle.Passengers.size(), 0);
        vehicle.Mileage += distance;

        System.out.println(String.format("FuelAmount %f.2km.", vehicle.FuelAmount));
        System.out.println(String.format("Mileage %dkm.", vehicle.Mileage));
    }
}
