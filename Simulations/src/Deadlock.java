public class Deadlock {
    private final String name;

    public Deadlock(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public synchronized void bow(Deadlock bower) {
        System.out.format("%s: %s" + "  has bowed to me!%n", this.name, bower.getName());
        bower.bowBack(this);
    }

    public synchronized void bowBack(Deadlock bower) {
        System.out.format("%s: %s" + " has bowed back to me!%n", this.name, bower.getName());
    }
}
