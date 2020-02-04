package academy.pocu.comp2500samples.w02.vehicle;

public class Passenger {
    public String name;

    public Passenger(String name) {
        this.name = name;
    }

    public void sayName() {
        System.out.println(String.format("Hi, I'm %s!", this.name));
    }
}
