import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.IOException;
import java.io.File;
public class UFOReader{
    public ArrayList<String> readFromFile() throws IOException {
        File file = new File("UFOs_coords.csv");
        Scanner scan = new Scanner(file);
        String[] arr = new String[0];
        while(scan.hasNextLine()){
            arr = scan.nextLine().split(",");
        }
        ArrayList<String> list = new ArrayList<>(Arrays.asList(arr));
        return list;
    }
}


