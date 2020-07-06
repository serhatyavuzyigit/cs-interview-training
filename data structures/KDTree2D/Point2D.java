package KDTree2D;
/*
  Points can be double, float or integers.
*/
public class Point2D
{
    private double dx;  // double x coordinate of point
    private double dy;  // double y coordinate of Point
    private int dFlag = 0;

    private float fx;   // float x coordinate of point
    private float fy;   // float y coordinate of point
    private int fFlag = 0;

    private int ix;     // integer x coordinate of point
    private int iy;     // integer y coordinate of point
    private int iFlag = 0;

    public Point2D(double x, double y) {
        dx = x;
        dy = y;
        dFlag = 1;
    }

    public Point2D(float x, float y) {
        fx = x;
        fy = y;
        fFlag = 1;
    }

    public Point2D(int x, int y) {
        ix = x;
        iy = y;
        iFlag = 1;
    }
    public boolean equals(Object other) {
        if(getClass() != other.getClass())
            return false;
        Point2D point = (Point2D) other;
        if(getX()==point.getX() && getY() == point.getY())
            return true;
        else
            return false;
    }
    public double getX() {
        if(dFlag == 1)
            return dx;
        else if(fFlag == 1)
            return (double)fx;
        else
            return (double)ix;
    }

    public double getY() {
        if(dFlag == 1)
            return dy;
        else if(fFlag == 1)
            return (double)fy;
        else
            return (double)iy;
    }

    public String toString()
    {
        if(dFlag == 1)
            return dx + " " + dy;
        else if(fFlag == 1)
            return fx + " " + fy;
        else
            return ix + " " + iy;
    }
}