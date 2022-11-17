import java.util.Scanner;

public class EquationTester {

    public static void main(String[] args) {
        
        Equation eq1 = new Equation(2431, 102, 595);
        eq1.reduceEquation();
        System.out.println(eq1);

        Equation eq2 = new Equation(208, -368, 1276);
        eq2.reduceEquation();
        System.out.println(eq2);

        Equation eq3 = new Equation(-7038, 2646, 558);
        eq3.reduceEquation();
        System.out.println(eq3);

        Equation eq4 = new Equation(28, 3, 25);
        eq4.reduceEquation();
        System.out.println(eq4);

        Scanner in = new Scanner(System.in);
        System.out.println("Enter the value of a, b and c for first equation: ");
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();

        Equation eq5 = new Equation(a, b, c);
        
        System.out.println("Enter the value of a, b and c for second equation: ");
        int v = in.nextInt();
        int y = in.nextInt();
        int z = in.nextInt();

        Equation eq6 = new Equation(v, y ,z);
        Equation added = eq5.addEquation(eq6);
        added.reduceEquation();
        System.out.println("Sum of the equations: " + added);

        
    }
    
    
}
