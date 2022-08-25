import java.util.ArrayList;
import java.util.List;

public class Pipe<T>{
    private List<T> listOfPipe;

    public Pipe() {
        this.listOfPipe = new ArrayList<>();
    }
    public void putIntoPipe(T value) {
        listOfPipe.add(value);
    }

    public T takeFromPipe() {
        if (listOfPipe.isEmpty()) {
            return null;
        }
        T value = listOfPipe.get(0);

        listOfPipe.remove(0);
        return value;
    }

    public boolean isInPipe() {
        if (listOfPipe.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }
}
