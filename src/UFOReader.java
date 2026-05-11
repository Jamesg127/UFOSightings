import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.IOException;
import java.io.File;
public class UFOReader{
    public ArrayList<String> readFromFile() throws IOException {
        File file = new File("UFOs_coords.csv");
        Scanner scan = new Scanner(file);
        ArrayList<String> data = new ArrayList<>();
        while(scan.hasNextLine()){
            data.add(scan.nextLine());
        }
        return data;
    }
}
