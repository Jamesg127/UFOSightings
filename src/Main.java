import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Hello and welcome to theUFO report user interface.");
        System.out.println("What would you like to do?");
        System.out.println("1) Sort the data\n2) Find the most common UFO shape\n3) Find the state with the most sightings\n4) Find the total sightings per country\n5) Find the average length of the comment");
        int inpalimpa = scan.nextInt();
        if (inpalimpa == 1) {
            System.out.println("How wouldyou like to sort the data?");
            System.out.println("Sort by:\n1) Data\n2) City\n3) State\n4) Shape");
            int sort = scan.nextInt();
            if (sort == 1) {

            }
            else if (sort == 2) {

            }
            else if (sort == 3) {

            }
            else if (sort == 4) {

            }
        }
        else if (inpalimpa == 2) {

        }
        else if (inpalimpa == 3) {

        }
        else if (inpalimpa == 4) {

        }
        else if (inpalimpa == 5) {

        }
    }
}
