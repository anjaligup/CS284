package Interfaces;

public interface ShapesInterface {

    public void setOffSet(int newOffSet); //setter

    /**
     * This method returns the offset attribute that shows the coordinate of the shape
     * @author Anjali
     * @return an integer that indicates the offset of the shape
     */
    public int getOffSet(); //getter

    /**
     * This method draws a shape in the given line number
     * @param lineNumber
     */
    public void drawAt(int lineNumber);

    /**
     * This method draws a shape at the current location
     */
    public void drawHere();
}
