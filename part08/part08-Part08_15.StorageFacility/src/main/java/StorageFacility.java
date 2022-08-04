import java.util.ArrayList;
import java.util.HashMap;

public class StorageFacility {

    private HashMap<String, ArrayList<String>> storageHashMap;

    public StorageFacility() {
        this.storageHashMap = new HashMap<>();
    }

    public void add(String unit, String item) {
        this.storageHashMap.putIfAbsent(unit, new ArrayList<>());
        this.storageHashMap.get(unit).add(item);
    }

    public ArrayList<String> contents(String storageUnit) {
        ArrayList<String> emptyList = new ArrayList<>();
        return this.storageHashMap.getOrDefault(storageUnit, emptyList);
    }

    public void remove(String storageUnit, String item) {

        this.storageHashMap.get(storageUnit).remove(item);

        if (this.storageHashMap.get(storageUnit).isEmpty()) {
            this.storageHashMap.remove(storageUnit);
        }
    }

    public ArrayList<String> storageUnits(){
        ArrayList<String> sUnitsKeys = new ArrayList<>();
        for(String e: storageHashMap.keySet()){
            if(!storageHashMap.get(e).isEmpty()){
                sUnitsKeys.add(e);
            }
        }
        return sUnitsKeys;
    }
}