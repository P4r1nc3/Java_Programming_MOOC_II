import java.util.ArrayList;

public class Herd implements  Movable{

    private ArrayList<Movable> list;

    public Herd() {
        list = new ArrayList<>();
    }

    public void addToHerd(Movable movable) {
        this.list.add(movable);
    }

    @Override
    public void move(int dx, int dy) {
        for(Movable item : list) {
            item.move(dx, dy);
        }
    }

    @Override
    public String toString() {
        String newString = "";
        for (Movable mov : list) {
            newString += mov.toString().trim() + "\n";
        }
        return newString;
    }
}
