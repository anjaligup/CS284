package Interfaces;

public abstract class ShapeBase implements ShapesInterface{ //class implements an interface
    private int offset;

    public ShapeBase(int newOffSet) {
        offset = newOffSet;
    }

    public void setOffSet(int off) {
        offset = off;
    }

    public int getOffSet() {
        return offset;
    }

    public void drawAt(int lineNumber) {

    }

    public abstract void drawHere();

}
