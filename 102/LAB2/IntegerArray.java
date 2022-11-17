import java.util.Arrays;

public class IntegerArray implements Comparable <IntegerArray>{
    private int[] digits;
    private boolean isSignPositive = true;
    private String onlyNumber = "";
    private boolean subtractionsign = true;
    private boolean additionsign = true;
    private boolean changed;

    public IntegerArray(String anInteger)
    {
        this.digits = convert(anInteger);
        this.onlyNumber = str(anInteger);
    }
    public IntegerArray()
    {

    }

    public String str(String anInteger)
    {
        this.digits = convert(anInteger);
        for(int i =0; i<this.digits.length; i++)
        {
            this.onlyNumber += this.digits[i];
        }
        return this.onlyNumber;
    }

    public int[] convert(String anInt)
    {
        int[] converted = new int[anInt.length()];
        int currentSize = 0;
        boolean isIntStarted = false;
        for(int i=0; i<anInt.length(); i++)
        {
            char temp = anInt.charAt(i);
            if(temp == '-')
            {
                this.isSignPositive = false;
            }
            int digit = temp -'0';
            if(digit>0)
            {
                isIntStarted = true;
            }
            if(isIntStarted)
            {
                converted[currentSize] = digit;
                currentSize++;
            }
        }
        if(!isIntStarted)
        {
            converted[currentSize] = 0;
        }
        return Arrays.copyOf(converted, currentSize);
    }

    public int numberOfDigits()
    {
        return this.digits.length;
    }
    
    public int MID()
    {
        return digits[0];
    }

    public int LID()
    {
        return digits[digits.length-1];
    }

    public int getDigit(int index)
    {
        return digits[index];
    }

    public IntegerArray add(IntegerArray other)
    {
        if(this.isSignPositive == other.isSignPositive)
        {
            int a = this.digits.length-1;
            int b = other.digits.length-1;
            IntegerArray added = new IntegerArray();
            int[] addedNumber = new int[Math.max(a, b)+2];

            if(a>b)
            {
                for(int i=0; i<a; i++)
                {
                    addedNumber[i+1] = this.digits[i];
                }
            }
            else
            {
                for(int i=0; i<b; i++)
                {
                    addedNumber[i+1] = other.digits[i];
                }
            }

            int prev=0;
            for(int i = 0; i<Math.min(a, b)+1; i++)
            {
                if(i>0)
                {
                    if(prev>=10)
                    {
                        addedNumber[addedNumber.length-1-i] = (((this.digits[a-i] + other.digits[b-i]) % 10) + 1)%10 ;
                        prev = (this.digits[a-i] + other.digits[b-i])+1;
                        continue;
                    }
                }
                addedNumber[addedNumber.length-1-i] = (this.digits[a-i] + other.digits[b-i]) % 10;
                prev = (this.digits[a-i] + other.digits[b-i]);
            }
            if(prev>=10)
            {
                if(a>b)
                {
                    addedNumber[a-b]+=1;
                }
                else
                {
                    addedNumber[b-a]+=1;
                }
            }

            if(addedNumber[0]==0)
            {
                added.digits = Arrays.copyOfRange(addedNumber,1, addedNumber.length);
            }
            else
            {
                added.digits = Arrays.copyOf(addedNumber,addedNumber.length);
            }
            if(!this.isSignPositive)
            {
                added.isSignPositive = false;
            }
            if(subtractionsign == false)
            {
                added.isSignPositive = false;
                this.isSignPositive = false;
            }
            else if(changed && additionsign == true)
            {
                other.isSignPositive = false;
            }
            return added;
        }
        else 
        {
            if(this.isSignPositive && !other.isSignPositive)
            {
                if(this.compareTo(other)<0)
                {
                    additionsign = false;
                    changed = true;
                }
                other.isSignPositive = true;
            }
            if(!this.isSignPositive && other.isSignPositive)
            {
                if(this.compareTo(other)>0)
                {
                    additionsign = false;
                    changed=true;
                }
                this.isSignPositive = true;
            }
            return subtract(other);
        }
    }

    public IntegerArray subtract(IntegerArray other)
    {
        if(this.isSignPositive && !other.isSignPositive)
        {
            other.isSignPositive = true;
            additionsign = true;
            changed = true;
            return add(other);
        }
        if(!this.isSignPositive && other.isSignPositive)
        {
            this.isSignPositive = true;
            subtractionsign = false;
            return add(other);
        }
    
        int need = 0;
        String result = "";
        String bigger;
        String smaller;
        if(this.compareTo(other)>0)
        {
            bigger = this.onlyNumber;
            smaller = other.onlyNumber;
        }
        else
        {
            bigger = other.onlyNumber;
            smaller = this.onlyNumber;
        }

        for(int i = 0; i< smaller.length(); i++)
        {
            
            int digit1 = bigger.charAt(bigger.length()-1-i) - '0' ;
            if(need==1)
            {
                digit1 = bigger.charAt(bigger.length()-1-i) -1 - '0';
            }
            int digit2 = smaller.charAt(smaller.length()-1-i) - '0';

            int substraction = (digit1-digit2);
            if(substraction<0)
            {
                substraction = digit1 + 10 -digit2;
                need = 1;
                result = substraction + result;
            }   
            else
            {
                need = 0;
                result = substraction + result;
            }
        }
        
        if(need==1)
        {
            int digit = bigger.charAt(bigger.length() - smaller.length()-1) -'0' -1;
            result = digit + result;
            result = bigger.substring(0, bigger.length() - smaller.length()-1) + result;
        }
        else
        {
            result = bigger.substring(0, bigger.length() - smaller.length()) + result;
        }

        IntegerArray substracted = new IntegerArray(result);

        if(this.compareTo(other)>0)
        {
            substracted.isSignPositive = this.isSignPositive;
        }
        else
        {
            if(other.isSignPositive==false)
            {
                substracted.isSignPositive=true;
            }
            else
            {substracted.isSignPositive = other.isSignPositive;}
        }
        if(additionsign==false)
        {
            substracted.isSignPositive = false;
        }
        return substracted;

    } 
    public boolean equals(Object other)
    {
        IntegerArray intArray2 = (IntegerArray) other;
        return Arrays.equals(this.digits, intArray2.digits);
    }

    public int compareTo(IntegerArray otherArray)
    {
        if(this.digits.length > otherArray.digits.length)
        {
            return 1;
        }
        if(this.digits.length < otherArray.digits.length)
        {
            return -1;
        }
        if(this.digits.length == otherArray.digits.length)
        {
            for(int i=0 ; i<this.digits.length; i++)
            {
                if (this.digits[i] > otherArray.digits[i])
                {
                    return 1;
                }
                else if(this.digits[i]< otherArray.digits[i])
                {
                    return -1;
                }
            }
        }
        if(this.equals(otherArray))
        {
            return 0;
        }
        return 1;
    }

    public String toString()
    {
        String print = "";
        if(this.isSignPositive == false)
        {
            print +="-";
        }
        for(int i=0; i<this.digits.length; i++)
        {
            print += digits[i];
        }
        return print;
    }
}
/*             if(this.onlyNumber.length() > other.onlyNumber.length())
            {
                bigger = this.onlyNumber;
                smaller = other.onlyNumber;
            }
            else if(this.onlyNumber.length() < other.onlyNumber.length())
            {
                smaller = this.onlyNumber;
                bigger = other.onlyNumber;
            }
            else
            {
                int i = this.onlyNumber.charAt(0) - '0';
                int j = other.onlyNumber.charAt(0) - '0';
                if(i==j)
                {
                    i = this.onlyNumber.charAt(1) - '0';
                    j = other.onlyNumber.charAt(1) - '0';
                }
                if(i > j)
                {
                    bigger = this.onlyNumber;
                    smaller = other.onlyNumber;
                }
                else
                {
                    smaller = this.onlyNumber;
                    bigger = other.onlyNumber;
                }
            } */

        