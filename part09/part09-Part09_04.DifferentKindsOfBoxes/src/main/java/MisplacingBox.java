import java.util.ArrayList;

public class MisplacingBox extends Box{

    private ArrayList<Item> misBoxList;

    public MisplacingBox() {
        this.misBoxList = new ArrayList<>();
    }

    @Override
    public void add(Item item) {
        misBoxList.add(item);
    }




    @Override
    public boolean isInBox(Item item) {
        return false;
    }
}
