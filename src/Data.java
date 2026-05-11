import java.io.IOException;
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
    public String getMostCommonShape() throws IOException {
        int circleCount;
        int sphereCount;
        int cylinderCount;
        int triangleCount;
        int abstractCount;
        int unknownCount;
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(circleCount);
        arr.add(sphereCount);
        arr.add(cylinderCount);
        arr.add(triangleCount);
        arr.add(abstractCount);
        arr.add(unknownCount);
        for(int i = 0; i < reports.size(); i++){
            if(reports.getShape().equals("Circle"){
                circleCount++;
            }
            else if(reports.getShape().equals("Sphere"){
                sphereCount++;
            }
            else if(reports.getShape().equals("Cylinder"){
                cylinderCount++;
            }
            else if(reports.getShape().equals("Triangle"){
                triangleCount++;
            }
            else if(reports.getShape().equals("Unknown"){
                unknownCount++;
            }
            else{
                abstractCount++;
            }



            
        }
        
    }
}
