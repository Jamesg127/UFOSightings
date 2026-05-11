import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Comparator;

public class UFOReport {
    Instant dateTime;
    String country;
    String city;
    String state;
    String shape;
    String summary;
    double lat;
    double lng;

    public UFOReport(Instant dateTime, String country, String city, String state, String shape, String summary, double lat, double lng) {
        this.dateTime = dateTime;
        this.country = country;
        this.city = city;
        this.state = state;
        this.shape = shape;
        this.summary = summary;
        this.lat = lat;
        this.lng = lng;
    }

    static Comparator<UFOReport> getDateComparator() {
        return new Comparator<UFOReport>() {
            @Override
            public int compare(UFOReport o1, UFOReport o2) {
                return o1.dateTime.compareTo(o2.dateTime);
            }
        };
    }
    static Comparator<UFOReport> getCityComparator() {
        return new Comparator<UFOReport>() {
            @Override
            public int compare(UFOReport o1, UFOReport o2) {
                return o1.city.compareTo(o2.city);
            }
        };
    }
    static Comparator<UFOReport> getCountryComparator() {
        return new Comparator<UFOReport>() {
            @Override
            public int compare(UFOReport o1, UFOReport o2) {
                return o1.country.compareTo(o2.country);
            }
        };
    }
    static Comparator<UFOReport> getStateComparator() {
        return new Comparator<UFOReport>() {
            @Override
            public int compare(UFOReport o1, UFOReport o2) {
                return o1.state.compareTo(o2.state);
            }
        };
    }
    static Comparator<UFOReport> getShapeComparator() {
        return new Comparator<UFOReport>() {
            @Override
            public int compare(UFOReport o1, UFOReport o2) {
                return o1.shape.compareTo(o2.shape);
            }
        };
    }

    @Override
    public String toString() {
        return LocalDateTime.ofInstant(dateTime, ZoneOffset.UTC).toString() + "in " + city + ", " + state + ". Saw " + shape;
    }
}