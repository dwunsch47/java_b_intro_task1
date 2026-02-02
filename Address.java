import java.util.Objects;

public class Address {
    private String country;
    private String city;

    Address(String country, String city) {
        this.country = country;
        this.city = city;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Address o = (Address) obj;
        return Objects.equals(o.country, this.country) && Objects.equals(o.city, this.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(country, city);
    }
}
