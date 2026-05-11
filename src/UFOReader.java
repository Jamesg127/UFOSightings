import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
import java.io.File;
public class UFOReader{
    public void readFromFile() throws IOException {
        File file = new File("UFOs_coords.csv");
        Scanner scan = new Scanner(file);
        ArrayList<String> list = new ArrayList<>();
        String[] arr;
        while(scan.hasNextLine()){
            arr = scan.nextLine().split(",");
        }
    }
}


