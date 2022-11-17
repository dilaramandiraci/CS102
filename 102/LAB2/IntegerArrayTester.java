import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class IntegerArrayTester {

  //https://www.w3schools.com/java/java_files_read.asp 
  //necesarry changes was made to integrate my code.
    public static IntegerArrayList readIntegerArraysFromFile(String fileName)
    {
        ArrayList<String> inputtedNumbers = new ArrayList<String>();
        try {
            File myObj = new File(fileName);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
              String data = myReader.nextLine();
              inputtedNumbers.add(data);
            }
            myReader.close();
          } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
        IntegerArrayList list = new IntegerArrayList(inputtedNumbers);
        return list;
    }
    
    public static void main(String[] args) {
        System.out.println("\nSOME EXAMPLE CASES:\n ");
        IntegerArray n1 = new IntegerArray("-580");
        System.out.println("number 1: " +n1);
        IntegerArray n2 = new IntegerArray("-320");
        System.out.println("number 2: " + n2);
        System.out.println("substraction of these: " + n1.subtract(n2));
        System.out.println("addition of these: " + n1.add(n2)); 
        
        System.out.println("\n");

        IntegerArray n3 = new IntegerArray("920");
        System.out.println("number 1: " +n3);
        IntegerArray n4 = new IntegerArray("654");
        System.out.println("number 2: " + n4);
        System.out.println("addition of these: " + n3.add(n4)); 
        System.out.println("substraction of these: " + n3.subtract(n4));
       

        System.out.println("\n");

        IntegerArray n7 = new IntegerArray("59");
        System.out.println("number 1: " +n7);
        IntegerArray n8 = new IntegerArray("-15");
        System.out.println("number 2: " + n8);
        System.out.println("substraction of these: " + n7.subtract(n8));
        System.out.println("addition of these: " + n7.add(n8));

        System.out.println("\n");

        IntegerArray n9 = new IntegerArray("-1500");
        System.out.println("number 1: " +n9);
        IntegerArray n10 = new IntegerArray("1200");
        System.out.println("number 2: " + n10);
        System.out.println("substraction of these: " + n9.subtract(n10));
        System.out.println("addition of these: " + n9.add(n10));

        System.out.println("\n");

        IntegerArray n11 = new IntegerArray("2340019");
        System.out.println("number 1: " +n11);
        IntegerArray n12 = new IntegerArray("25611");
        System.out.println("number 2: " + n12);
        System.out.println("substraction of these: " + n11.subtract(n12));
        System.out.println("addition of these: " + n11.add(n12));

        System.out.println("\n");

        IntegerArray n5 = new IntegerArray("658945702785487486379697447395375473");
        System.out.println("number 1: " +n5);
        IntegerArray n6 = new IntegerArray("43097086793246575774386585");
        System.out.println("number 2: " + n6);
        System.out.println("addition of these: " + n5.add(n6));
        System.out.println("substraction of these: " + n5.subtract(n6)); 
        
        System.out.println("\n");


        System.out.println("Please enter the filename: ");
        Scanner in = new Scanner(System.in);
        String inputtedFileName = in.nextLine();
        IntegerArrayList list = readIntegerArraysFromFile(inputtedFileName);
        
        int middleIndex = list.getSize()/2;
        int endIndex = list.getSize();

        System.out.println("Output:      \n \n  ");
        System.out.println("start index = 0 ");
        System.out.println("middle index = " + middleIndex);
        System.out.println("end index = " + endIndex );
        System.out.println();

        System.out.println("Minimum of all the numbers: " + list.min(0, endIndex));
        System.out.println("Minimum of the first half: " + list.min(0, middleIndex));
        System.out.println("Minimum of the second half: " + list.min(middleIndex, endIndex));

    }
    
}
