import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Data {
    ArrayList<UFOReport> reports;

    void readData() {
        try {
            UFOReader reader = new UFOReader();
            var data = reader.readFromFile();
            for(String line : data) {
                String[] components = line.split(",");
                reports.add(
                        new UFOReport(
                                LocalDateTime.parse(
                                                components[0],
                                                DateTimeFormatter.ofPattern("M/d/uu HH:MM")
                                        )
                                        .toInstant(ZoneOffset.ofHours(0)),
                                components[1],
                                components[2],
                                components[3],
                                components[4],
                                components[5],
                                Double.parseDouble(components[6]),
                                Double.parseDouble(components[7])
                        )
                );
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    void sortByDate() {
        reports.sort(UFOReport.getDateComparator());
    }
    void sortByCity() {
        reports.sort(UFOReport.getCityComparator());
    }
    void sortByState() {
        reports.sort(UFOReport.getStateComparator());
    }
    void sortByShape() {
        reports.sort(UFOReport.getShapeComparator());
    }

    ArrayList<UFOReport> searchState(String state) {
        ArrayList<UFOReport> result = new ArrayList<>();
        for(UFOReport report : reports) {
            if(report.state.equals(state)) {
                result.add(report);
            }
        }
        return result;
    }
    ArrayList<UFOReport> searchCity(String city) {
        ArrayList<UFOReport> result = new ArrayList<>();
        for(UFOReport report : reports) {
            if(report.city.equals(city)) {
                result.add(report);
            }
        }
        return result;
    }
    ArrayList<UFOReport> searchShape(String shape) {
        ArrayList<UFOReport> result = new ArrayList<>();
        for(UFOReport report : reports) {
            if(report.shape.equals(shape)) {
                result.add(report);
            }
        }
        return result;
    }
    ArrayList<UFOReport> searchKeyword(String keyword) {
        ArrayList<UFOReport> result = new ArrayList<>();
        for(UFOReport report : reports) {
            if(report.summary.contains(keyword)) {
                result.add(report);
            }
        }
        return result;
    }
    public String getMostCommonShape(){
        HashMap<String, Integer> shapes = new HashMap<>();
        for(UFOReport report : reports) {
            if(!shapes.containsKey(report.shape)) {
                shapes.put(report.shape, 1);
            }
        }
        return Collections.max(shapes.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    public String getMostCommonState() {
        HashMap<String, Integer> states = new HashMap<>();
        for(UFOReport report : reports) {
            if(!states.containsKey(report.state)) {
                states.put(report.state, 1);
            }
        }
        return Collections.max(states.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
}