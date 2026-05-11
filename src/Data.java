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
    void sortByCountry() {
        reports.sort(UFOReport.getCountryComparator());
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
    public String totalSightingsPerCountry(){
        int USA = 0;
        int Canada = 0;
        for(UFOReport report : reports) {
            if(report.country.equals("USA")){
                USA++;
            }
            else if(report.country.equals("Canada")){
                Canada++;
            }
        }
        return "Usa " + USA + "\nCanada " + Canada;
    }
    public String getMostCommonShape(){
        ArrayList<Integer> shapes = new ArrayList<>(6);
        for(UFOReport report : reports) {
            if(report.shape.equals("Circle")){
                shapes.set(0, shapes.get(0) + 1);
            }
            if(report.shape.equals("Sphere")){
                shapes.set(1, shapes.get(1) + 1);
            }
            if(report.shape.equals("Cylinder")){
                shapes.set(2, shapes.get(2) + 1);
            }
            if(report.shape.equals("triangle")){
                shapes.set(3, shapes.get(3) + 1);
            }
            if(report.shape.equals("Unknown")){
                shapes.set(4, shapes.get(4) + 1);
            }
            else{
                shapes.set(5, shapes.get(5) + 1);
            }
        }
        int max = -1;
        String maxString = "";
        for(int i = 0; i < shapes.size(); i++){
            if (shapes.get(i) > max){
                max = shapes.get(i);
                if(i == 0){
                    maxString = "Circle";
                }
                if(i == 1){
                    maxString = "Sphere";
                }
                if(i == 2){
                    maxString = "Cylinder";
                }
                if(i == 3){
                    maxString = "triangle";
                }
                if(i == 4){
                    maxString = "Unknown";
                }
                if(i == 5){
                    maxString = "Abstract";
                }
            }
        }
        return maxString;
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