package perimeter_quiz;

import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public int getNumPoints (Shape s) {
        // Put code here
        int count =0;
        for(Point p:s.getPoints()){
            count = count +1;
        }
        return count;
    }

    public double getAverageLength(Shape s) {
        // Put code here
        double avl=0;
        double total=0;
        Point prevPt=s.getLastPoint();
        for(Point currPt:s.getPoints()){
            double currDist=prevPt.distance(currPt);
            prevPt=currPt;
            System.out.println("current distance is "+currDist);
            total=total+currDist;
        }
        avl=total/getNumPoints(s);
        return avl;
    }

    public double getLargestSide(Shape s) {
        // Put code here
        double largest =0;
        Point prevPt=s.getLastPoint();
        //System.out.println("prevPt "+prevPt);
        for(Point currPt:s.getPoints()){
            double currDist=prevPt.distance(currPt);
            prevPt=currPt;
            if(currDist>largest){
                largest=currDist;
            }
        }
        return largest;
    }

    public double getLargestX(Shape s) {
        // Put code here
        return 0.0;
    }

    public double getLargestPerimeterMultipleFiles() {
        double largestP = 0;
        String fn="";//fine name
        DirectoryResource dr = new DirectoryResource();
        for(File f:dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            Shape s=new Shape(fr);
            double currP=getPerimeter(s);
            if(currP>largestP){
                largestP=currP;
                fn=f.getName();
            }
        }
        // Put code here
        return largestP;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        File temp = null;    // replace this code
        return temp.getName();
    }

    public void testPerimeterMultipleFiles() {
        // Put code here
    }

    public void testFileWithLargestPerimeter() {
        // Put code here
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
    }
}
