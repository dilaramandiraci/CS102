package LAB6;

public abstract class SortAnalyzer{
    private int numberOfComparisons;
    protected int k = 3;

    public int getNumberOfComparisons() {
        return numberOfComparisons;
    }

    
    protected int compare(Comparable o1, Comparable o2)
    {
        numberOfComparisons++;
        return o1.compareTo(o2);

        /* if(o1 instanceof Integer && o2 instanceof Integer)
        {
            int int1 = (int)o1;
            int int2 = (int)o2;
            if(int1>int2) {return 1;}
            if(int1<int2) {return -1;}
            else {return 0;}
        } */
        
        /* if(o1.compareTo(o2)>0) {return 1;}
        if(o1.compareTo(o2)<0) {return -1;}
        else {return 0;} */

    }

    public boolean isSorted(Comparable[] arr)
    {
        if(arr.length == 1 || arr.length == 0) 
        {return true;}

        if(compare(arr[0], arr[1])<0)
        {
            for(int i = 1; i < arr.length; i++){
                if(compare(arr[i], arr[i-1])>0) return false;
            }
        }
        else
        {
            for(int i = 1; i < arr.length; i++){
                if(compare(arr[i], arr[i-1])<0) return false;
            }
        }
        
        return true;
    }

    public abstract Comparable[] sort(Comparable[] arr);

    public void setNumberOfComparisons(int numberOfComparisons) {
        this.numberOfComparisons = numberOfComparisons;
    }

    public int getK() {
        return k;
    }

    public void setK(int k) {
        this.k = k;
    }

}
