import java.util.ArrayList;
import java.util.Collections;

public class IntegerArrayList {
    private ArrayList<IntegerArray> numbers = new ArrayList<IntegerArray>();

    public IntegerArrayList(ArrayList<String> strings)
    {
        for(int i= 0; i< strings.size(); i++)
        {
            this.numbers.add(new IntegerArray(strings.get(i)));
        }
    }

    public int getSize()
    {
        return this.numbers.size();
    }

    public IntegerArray getIntegerArrayAt(int index)
    {
        return this.numbers.get(index);
    }

    public void setIntegerArrayAt(int index, IntegerArray intArr)
    {
        this.numbers.set(index, intArr);
    }

    public void addIntegerArray(String number)
    {
        this.numbers.add(new IntegerArray(number));
    }
    
    public void removeIntegerArray(int index)
    {
        this.numbers.remove(index);
    }

    public void removeIntegerArray(IntegerArray intArr)
    {
        this.numbers.remove(intArr);
    }

    public IntegerArray min(int start, int end)
    {
        ArrayList<IntegerArray> wanted = new ArrayList<IntegerArray>(this.numbers.subList(start, end));
        Collections.sort(wanted);
        return wanted.get(0);
    }
}
