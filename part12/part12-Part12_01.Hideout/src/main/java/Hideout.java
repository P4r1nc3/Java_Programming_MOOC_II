import java.util.ArrayList;
import java.util.List;

public class Hideout<T>{

    private List<T> hideoutList;

    public Hideout() {
        this.hideoutList = new ArrayList<>();
    }

    public void putIntoHideout(T toHide) {

        if (!hideoutList.isEmpty()) {
            hideoutList.clear();
        }
        this.hideoutList.add(toHide);
    }

    public T takeFromHideout() {

        T value = hideoutList.get(0);
        hideoutList.clear();
        return value;

    }

    public boolean isInHideout() {

        if (hideoutList.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

}
