package academy.pocu.comp2500samples.w02.vehicle;

public class Passenger {
    public String Name;

    public Passenger(String name) {
        this.Name = name;
    }

    public void sayName() {
        System.out.println(String.format("My name is %s.", this.Name));
    }
}
