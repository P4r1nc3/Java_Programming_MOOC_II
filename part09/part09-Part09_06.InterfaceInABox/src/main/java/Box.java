import java.util.ArrayList;

public class Box implements Packable{

    private double capacity;
    private ArrayList<Packable> itemsInBox;
    public Box (double capacity) {
        this.capacity = capacity;
        this.itemsInBox = new ArrayList<>();
    }

    public void add (Packable itemToPack) {
        if ( this.weight() + itemToPack.weight() <= capacity) {
            this.itemsInBox.add(itemToPack);
        }
    }

    public double weight() {
        double sum = 0;

        for(Packable item : itemsInBox) {
            sum += item.weight();
        }

        return sum;
    }

    @Override
    public String toString() {
        return "Box: " + itemsInBox.size() + " items, total weight " + this.weight() + " kg";
    }
}
