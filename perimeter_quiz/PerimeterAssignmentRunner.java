import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints( Shape s){
      double totalPerim = 0.0;
      int numPoint = 0;
      Point prevPt = s.getLastPoint();
      for (Point currPt : s.getPoints()) {
       numPoint = numPoint + 1;
       double currDist = prevPt.distance(currPt);
       totalPerim = totalPerim + currDist;
       prevPt = currPt; 
      }
    return numPoint;
    }

    public double getAverageLength (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
    int nbrOfPoint = 0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint(); //getting the two points on graph
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) { //current point in the graph
        nbrOfPoint = nbrOfPoint + 1;
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);  
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
    // totalPerim is the answer
    totalPerim = totalPerim / nbrOfPoint;
        return totalPerim;
        }

    public double getLargestSide (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
              if (currDist > totalPerim ){
            totalPerim = currDist;
    }
    else{
        totalPerim  = totalPerim;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
    }
    // totalPerim is the answer
        return totalPerim;
    }

    public double getLargestX ( Shape s){
      double totalPerim = 0.0;
      double largestValue = 0.0;
      Point prevPt = s.getLastPoint();
      for (Point currPt : s.getPoints()) {
       double Value = currPt .getX();
        if (Value  > largestValue ){
            largestValue = Value;
    }
    else{
        largestValue  = largestValue;
       prevPt = currPt; 
      
       }  
        }
    return largestValue;
    }

    public double getLargestPerimeterMultipleFiles() {
        double largePerimeter = 0.0;
        DirectoryResource dr = new DirectoryResource();
    for (File f : dr.selectedFiles( )) {
     FileResource fr = new FileResource(f);
     Shape s = new Shape(fr);
         double Perimeter = getPerimeter(s);
       if(Perimeter > largePerimeter){
        largePerimeter = Perimeter;
       }
       else {
         largePerimeter = largePerimeter;
       }
       }
    return largePerimeter;
    }

    public String getFileWithLargestPerimeter() {
    double largePerimeter = 0.0;
        String FILENAME = null  ;
        File temp = null;
        DirectoryResource dr = new DirectoryResource();
    for (File f : dr.selectedFiles( )) {
     FileResource fr = new FileResource(f);  
     Shape s = new Shape(fr);
         double Perimeter = getPerimeter(s);
    if(Perimeter > largePerimeter){
        largePerimeter = Perimeter;
        temp = f;
        System.out.println(temp.getName());
        System.out.println(Perimeter);
        System.out.println(largePerimeter);
       }
       }
      FILENAME = temp.getName();
       return FILENAME;
     }  

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
    int numPoints = getNumPoints(s);
    System.out.println("Number of Points = " + numPoints);
    double average = getAverageLength(s);
        System.out.println("Average Side Length is = " + average);
    double largeSide= getLargestSide(s);
        System.out.println("Longest side is = " + largeSide);
    double largeValue= getLargestX (s);
        System.out.println("Largest Value is = " + largeValue);
    }
    
       public void testPerimeterMultipleFiles() {
    double largerValue= getLargestPerimeterMultipleFiles();
        System.out.println("Largest perimeter over all the shapes is = " + largerValue);
       }

      public void testFileWithLargestPerimeter() {
        String filename = getFileWithLargestPerimeter();
        System.out.println(" File with Largest perimeter = " + filename);
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
        //pr.testPerimeter();
//pr.testPerimeter();
//pr.testPerimeter();
       // pr.testPerimeter();
        //pr.testPerimeterMultipleFiles();
        pr.testFileWithLargestPerimeter();
    }
}

