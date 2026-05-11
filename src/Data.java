import java.util.ArrayList;
import java.util.Collections;

public class Data {
    ArrayList<UFOReport> reports;

    void readData() {
        //TODO use UFO Reader to read data
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
}
