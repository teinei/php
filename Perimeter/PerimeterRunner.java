import edu.duke.*;
import java.io.*;

public class PerimeterRunner {
    public double getPerimeter(Shape s){
        double totalPerim = 0;
        Point prevPt = s.getLastPoint();
        for(Point currPt:s.getPoints()){
            double currDist = prevPt.distance(currPt);
            totalPerim = totalPerim +currDist;
            prevPt = currPt;
        }
        return totalPerim;
    }  
    //get largest perimeter
    public double getLargestPerimeterMultipleFiles(){
        double largestP = 0;
        String fn = "";
        DirectoryResource dr = new DirectoryResource();
        for(File f:dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double currP = getPerimeter(s);
            if(currP > largestP) {
                largestP = currP;
                fn = f.getName();
            }
        }  
        System.out.println(fn);
        return largestP;
    }
    public void testPerimeterMultipleFiles(){
        double largest = getLargestPerimeterMultipleFiles();
        System.out.println("largest perimeter among all is "+largest);
    }
    //q2 everage length
    public double averageLength(Shape s){
        double avrl=0;
        Point prevPt = s.getLastPoint();
        System.out.println("prevPoint is ("+prevPt.getX()+","+prevPt.getY()+")");
        for(Point currPt:s.getPoints()){
            double currDist = prevPt.distance(currPt);
            System.out.println("current distance is "+currDist);
            avrl = (avrl + currDist)/2.0;
            System.out.println("average length is  "+avrl);
        }
        return avrl;
    }
    public double longestSide(Shape s){
        double longest = 0;
        Point prevPt = s.getLastPoint();
        for(Point currPt:s.getPoints()){
            double currDist = prevPt.distance(currPt);
            if(currDist > longest){
                longest = currDist;
            }
        }
        //System.out.printl
        return longest;
    }
    public void testLongest(){
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double longest = longestSide(s);
        System.out.println("Longest side is "+ longest);
    }
    
    public void PerimeterAssignmentRunner(){
    }
    public void testAverageLength(){
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double avr = averageLength(s);
        System.out.println("average length is "+avr);
    }
    public void testPerimeter(){
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        //PerimeterRunner pr = new PerimeterRunner();
        double length = getPerimeter(s);
        System.out.println("perimeter is "+length);
    }
    //triangle method
    //the triangle method has no return value and creates a triangle 
    //that you can use to test the methods you will create in this assignment.
    public void triangle(){
        
    }
    
    //The printFileNames method, which we will discuss in Assignment 2.
    public void printFileNames(){
        DirectoryResource dr = new DirectoryResource();
        for(File f:dr.selectedFiles()){
            System.out.println(f.getName());
        }
    }
    public static void main(String[] args){
        PerimeterRunner pr = new PerimeterRunner();
        pr.testPerimeter();
        
        //pr.getPerimeter();
    }
}
