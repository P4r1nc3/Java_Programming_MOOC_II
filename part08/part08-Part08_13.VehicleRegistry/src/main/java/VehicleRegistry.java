
import java.util.ArrayList;
import java.util.HashMap;

public class VehicleRegistry {

    private HashMap<LicensePlate, String> hashmap;

    public VehicleRegistry() {

        this.hashmap = new HashMap<>();

    }

    public boolean add(LicensePlate liPlate, String owner) {

        for (LicensePlate e : hashmap.keySet()) {
            if (e.equals(liPlate)) {
                return false;

            }

        }
        hashmap.put(liPlate, owner);

        return true;

    }

    public String get(LicensePlate licensePlate) {

        return hashmap.getOrDefault(licensePlate, null);

    }

    public boolean remove(LicensePlate licensePlate) {

        if (!hashmap.containsKey(licensePlate)) {

            return false;
        }

        hashmap.remove(licensePlate);

        return true;

    }

    public void printLicensePlates() {

        for (LicensePlate e : hashmap.keySet()) {
            System.out.println(e);
        }
    }

    public void printOwners() {

        ArrayList<String> ownerList = new ArrayList<>();

        for (String position : hashmap.values()) {

            if (!ownerList.contains(position)) {

                ownerList.add(position);
            }
        }
        for (String position : ownerList) {
            System.out.println(position);
        }
    }
}