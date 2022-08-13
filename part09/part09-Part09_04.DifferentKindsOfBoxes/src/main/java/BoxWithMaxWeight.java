import java.util.ArrayList;

public class BoxWithMaxWeight extends Box {

    private ArrayList<Item> itemsInMaxBox;

    private int capcity;

    public BoxWithMaxWeight(int capcity) {
        this.capcity = capcity;
        this.itemsInMaxBox = new ArrayList<>();
    }

    public int currentAmount() {
        int sum = 0;

        for (Item e : itemsInMaxBox) {
            sum += e.getWeight();
        }
        return sum;
    }

    @Override
    public void add(Item item) {
        if (currentAmount() + item.getWeight() <= this.capcity) {
            itemsInMaxBox.add(item);
        }
    }

    @Override
    public boolean isInBox(Item item) {
        return itemsInMaxBox.contains(item);
    }
}