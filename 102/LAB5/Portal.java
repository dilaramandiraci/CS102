/**
 * This is the portal class for Question 4
 */
public class Portal {
    int rowS;
    int columnS;
    int rowE;
    public int getRowS() {
        return rowS;
    }
    public void setRowS(int rowS) {
        this.rowS = rowS;
    }
    public int getColumnS() {
        return columnS;
    }
    public void setColumnS(int columnS) {
        this.columnS = columnS;
    }
    public int getRowE() {
        return rowE;
    }
    public void setRowE(int rowE) {
        this.rowE = rowE;
    }
    public int getColumnE() {
        return columnE;
    }
    public void setColumnE(int columnE) {
        this.columnE = columnE;
    }
    int columnE;
    public Portal(int x, int y, int a, int b)
    {
        rowS = x;
        columnS = y;
        rowE = a;
        columnE = b;
    }
    
}
