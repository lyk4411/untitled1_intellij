package OOAD.ch10;

import java.io.File;

public class LoadTester
{
    public static void main(String[] args) {
        try {
            SubwayLoader loader = new SubwayLoader();
            Subway objectville = loader.loadFromFile(new File("ObjectvilleSubway.txt"));
            
            System.out.println("Testing stations");
            if (    objectville.hasStation("A1") &&
                    objectville.hasStation("B1") &&
                    objectville.hasStation("C1")) {
                System.out.println("... station test passed successfully.");
            }
            else
            {
                System.out.println("...station test FAILED.");
                System.exit(-1);
            }
            
            System.out.println("\nTesting connections...");
            if (objectville.hasConnection("A1", "B2","A") &&
                objectville.hasConnection("B4", "B3", "B") &&
                objectville.hasConnection("C1", "C2", "C")) {
                System.out.println("...connections test passed succesfully.");
            }
            else
            {
                System.out.println("...connections test FAILED");
                System.exit(-1);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
}
