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

    public int getNumPoints (Shape s) {
        // Put code here
        int totalNumsPts = 0;
        Point prevPt = s.getLastPoint();
        for(Point currPt: s.getPoints()){
            totalNumsPts =totalNumsPts + 1;
            prevPt = currPt;
        }
        return totalNumsPts;
    }

    public double getAverageLength(Shape s) {
        // Put code here
        double perimeter = getPerimeter(s)/ getNumPoints(s);
        return perimeter;
    }

    public double getLargestSide(Shape s) {
        // Put code here
        double largeDist = 0.0;
        double currDist = 0.0;
        Point prevPt = s.getLastPoint();
        for (Point currPt : s.getPoints()){
        currDist =prevPt.distance(currPt);
        if( currDist >= largeDist){
            largeDist = currDist;
           
        }
        else {
        largeDist = largeDist;
        }
        
    }
    return largeDist;
}

    public double getLargestX(Shape s) {
        // Put code here
        double largestX = 0.0;
       double currX = 0.0;
     
        Point prevPt = s.getLastPoint();
        for ( Point currPt : s.getPoints()){
        currX = currPt.getX();
        if (Math.abs(currX) >= largestX){
            largestX=currX;
        } else {
            largestX=largestX;
        }
       
    }
     return largestX;
}

    public double getLargestPerimeterMultipleFiles() {
        // Put code here
        double largePerim = 0.0;
        DirectoryResource dr = new DirectoryResource();
        
        for ( File f: dr.selectedFiles()){
          
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
           
            double perim = getPerimeter(s);
            if(perim>= largePerim){
                largePerim = perim;
            } else {
                largePerim = largePerim;
        }
        
    }return largePerim;
}

    public String getFileWithLargestPerimeter() {
        // Put code here
        double largePerim = 0.0;
         DirectoryResource dr = new DirectoryResource();
         String name = null;
        
           for ( File f: dr.selectedFiles()){
               FileResource fr = new FileResource(f);
       Shape s = new Shape(fr);
       name = f.getName();
       double perim = getPerimeter(s);
       if(perim>= largePerim){
           largePerim = perim;
            //name = f.getName();
            } else {
                largePerim = largePerim;
            }
       
    }
    return name;
}

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
        System.out.println("num point(s) ="+ getNumPoints(s));
        System.out.println("average length =" + getAverageLength(s));
        System.out.println("largest side =" + getLargestSide(s));
        System.out.println("largest X =" + getLargestX(s));
    }
    
    public void testPerimeterMultipleFiles() {
        // Put code here
        double largestShpeMultipleFiles = getLargestPerimeterMultipleFiles();
        System.out.println(" The largest shape of all files is =" + 
        getLargestPerimeterMultipleFiles());
    }

    public void testFileWithLargestPerimeter() {
        // Put code here
        String largestPerimeter = getFileWithLargestPerimeter();
        System.out.println(" The NAME of the largest perimeter is" + 
        getFileWithLargestPerimeter());
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(-4,-3));
        triangle.addPoint(new Point(4,-2));
        triangle.addPoint(new Point(12,2));
        triangle.addPoint(new Point(6,5));
        triangle.addPoint(new Point(-3,3));
        triangle.addPoint(new Point(-8,1));
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
        pr.printFileNames();
       //pr.testPerimeter();
        }
}
