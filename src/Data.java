import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;

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

    ArrayList searchState(String state) {
    }
}
