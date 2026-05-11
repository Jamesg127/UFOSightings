import java.util.ArrayList;
import java.util.Collections;

public class Data {
    ArrayList<UFOReport> reports;

    void readData() {
        //TODO use UFO Reader to read data
    }

    void sortByDate() {
        Collections.sort(reports, UFOReport.getDateComparator());
    }
    void sortByCity() {
        Collections.sort(reports, UFOReport.getCityComparator());
    }
    void sortByState() {
        Collections.sort(reports, UFOReport.getStateComparator());
    }
    void sortByShape() {
        Collections.sort(reports, UFOReport.getShapeComparator());
    }
}
