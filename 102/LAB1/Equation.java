/**
 * This is the equation class which can make some calculations, comparisons.
 * @author Dilara Mandıracı
 * @date 20.02.2022
 */
public class Equation {
    int a;
    int b;
    int c;
    int x;
    String equation;
    
    /**
     * This is the constructor of equation class. If the given coefficient of x (b) is negative then multiply all coefficients with -1.
     * @param a
     * @param b
     * @param c
     */
    public Equation(int a , int b, int c)
    {
        if(b>0)
        {
            this.a = a;
            this.b = b;
            this.c = c;
        }
        else
        {
            this.a = -1*a;
            this.b = -1*b;
            this.c = -1*c;
        }

        //a = b*x + c;
        this.x = (this.a-this.c)/this.b;
        this.equation = "" + this.a + " = " + this.b +"x + " + this.c;
       
    }

    /**
     * This is the method for reduce the given equation as much as it possible
     */
    public void reduceEquation()
    {
        if(this.a!=0 && this.b!=0 && this.c!=0)
        {
            int s = gcd(gcd(this.a, this.b), this.c);
            this.a = a/s;
            this.b = b/s;
            this.c = c/s;
            this.x = (a-c)/b;
            this.equation = "" + this.a + " = " + this.b +"x + " + this.c;
        }
        if(this.a == 0)
        {
            int s = gcd(this.b, this.c);
            this.b = b/s;
            this.c = c/s;
            this.equation = "" + this.a + " = " + this.b +"x + " + this.c;
        }
        if(this.c == 0)
        {
            int s = gcd(this.a, this.b);
            this.a = a/s;
            this.b = b/s;
            this.equation = "" + this.a + " = " + this.b +"x + ";
        }
        
    }

    /**
     * This is the gcd calculator based on the euclids gcd algortihm. If the given number is negatif firts multiply it with -1.
     * @param x
     * @param y
     * @return greatest common divisors of the given two integers.
     */
    private int gcd(int x, int y)
    {
        int r;
        int recursion;
        if(x<0)
        {
            x = x * -1;
        }
        if(y<0)
        {
            y = y * -1;
        }
        if (x>y)
        {
            r = x%y;
            if(r == 0)
            {
                return y;
            }
            recursion = gcd(y, r);
        }
        else
        {
            r = y%x;
            if(r == 0)
            {
                return x;
            }
            recursion = gcd(x, r);
        }
        
        return recursion;
    }

    //PART2
    /**
     * This is the method of adding two equations one is the implicit and the other one is the given. 
     * @param eq2 given equation
     * @return added equation 
     */
    public Equation addEquation(Equation eq2)
    {
        int addedA = this.a + eq2.a;
        int addedB = this.b + eq2.b;
        int addedC = this.c + eq2.c;
        //this.x = (addedA-addedC) / addedB;
        //this.equation = "" + addedA + " = " + addedB +"x + " + addedC;
        Equation addedEquation = new Equation(addedA, addedB, addedC);
        return addedEquation;
    }

    /**
     * This is the method of substracting two equations one is the implicit and the other one is the given. 
     * @param eq2 given equation
     * @return substact of two equation
     */
    public Equation substractEquation(Equation eq2)
    {
        int subtraectedA = this.a - eq2.a;
        int subtractedB = this.b - eq2.b;
        int subtractedC = this.c - eq2.c;
        //this.x = (subtraectedA-subtractedC) / subtractedB;
        //this.equation = "" + subtraectedA + " = " + subtractedB +"x + " + subtractedC;
        Equation subsractedEquation = new Equation(subtraectedA, subtractedB, subtractedC);
        return subsractedEquation;
    }

    /**
     * Checks if the two equations are equal or not.
     * @param eq2 given equation which will be compared with the implicit one.
     * @return true if equals ,else false.
     */
    public boolean equals(Equation eq2)
    {
        if(this.a % eq2.a == 0 && this.b % eq2.b == 0 && this.c % eq2.c == 0 && this.x == eq2.x)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

/*     public boolean equals(Object otherobject)
    {
        Equation eq2 = (Equation) otherobject;
        Equation eq3 = eq2.reduceEquation();
        return equation.equals(eq3);
    } */

    /**
     * This is the toString method
     */
    public String toString()
    {
        if(this.b == 0)
        {
            return "" + a + " = " + c;
        }
        if(this.c == 0)
        {
            return "" + a + "=" + b + "x";
        }
        else
        {
            return equation;
        }
        
    }    
}
