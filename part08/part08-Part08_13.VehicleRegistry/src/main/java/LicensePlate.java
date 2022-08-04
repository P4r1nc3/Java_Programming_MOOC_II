
import java.util.Objects;

public class LicensePlate {

    private final String liNumber;
    private final String country;

    public LicensePlate(String country, String liNumber) {
        this.liNumber = liNumber;
        this.country = country;
    }

    @Override
    public String toString() {
        return country + " " + liNumber;
    }

    @Override
    public boolean equals (Object comparedObject) {
        if (this == comparedObject) {
            return true;
        }

        if (!(comparedObject instanceof LicensePlate )) {
            return false;
        }

        LicensePlate comparedLicense = (LicensePlate) comparedObject;

        if(this.country.equals(comparedLicense.country) &&
                this.liNumber.equals(comparedLicense.liNumber)) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(liNumber, country);
    }
}
