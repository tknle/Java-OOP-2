import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class findColdestDay {

    public CSVRecord coldestHourInFile( CSVParser parser){
        CSVRecord coldestSoFar = null;
        for (CSVRecord currRow : parser){
            if( coldestSoFar == null){
                coldestSoFar = currRow;
            } else {
                double currTemp = Double.parseDouble(currRow.get("TemperatureF"));
                double coldestTemp = Double.parseDouble(coldestSoFar.get("TemperatureF"));
                if (currTemp < coldestTemp){
                    coldestSoFar = currRow;
                }
    }
}
return coldestSoFar;
}

 public void testColdestHourInFile(){
     FileResource fr = new FileResource("nc_weather/2014/weather-2014-05-01.csv");
     CSVRecord largest = coldestHourInFile(fr.getCSVParser());
     System.out.println("coldest temperature was " + largest.get("TemperatureF")+
      " at " + largest.get("TimeEDT"));
    
     
    }
    
    public CSVRecord fileWithColdestTemperature (){
        CSVRecord coldestSoFar = null;
        //to choose many files at once
        DirectoryResource dr = new DirectoryResource();
        //iterate over file
        for(File f: dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            CSVRecord currRow = coldestHourInFile(fr.getCSVParser());
            if(coldestSoFar == null){
                coldestSoFar = currRow;
            }else{
                double currTemp = Double.parseDouble(currRow.get("TemperatureF"));
                double coldestTemp = Double.parseDouble(coldestSoFar.get("TemperatureF"));
                if (currTemp < coldestTemp && currTemp != -9999){
                    coldestSoFar = currRow;
                }
    }
       
    }
    
   return coldestSoFar;
}

public void testFileWithColdestTemperature(){
    CSVRecord largest = fileWithColdestTemperature();
    System.out.println("coldest temperature was" + largest.get("TemperatureF")
    + " at " + largest.get("DateUTC"));
    System.out.println("All the Temperatures on the coldest day were:"+
    largest.get("DateUTC") + ": "+ largest.get("TemperatureF"));
    
}

public CSVRecord lowestHumidityInFile (CSVParser parser){
 CSVRecord lowestSoFar = null;
 for(CSVRecord currRow : parser){
     if(lowestSoFar == null){
         lowestSoFar = currRow;
        } else {
            if(currRow.get("Humidity").equals("N/A")){
                System.out.println("N/A");}
                else{
            int currHumi = Integer.parseInt(currRow.get("Humidity"));
            int lowestHumi = Integer.parseInt(lowestSoFar.get("Humidity"));
        if(currHumi<lowestHumi ){
            lowestSoFar = currRow;
        }
    }
}
}
  return lowestSoFar;

}

public void testLowestHumidityInFile(){
   FileResource fr = new FileResource();
  CSVParser parser = fr.getCSVParser();
  
  CSVRecord csv = lowestHumidityInFile(parser);
  
    System.out.println("Lowest Humidity was "+ csv.get("Humidity")
    + " at " + csv.get("DateUTC"));
  
}

public CSVRecord lowestHumidityInManyFiles(){
   
    CSVRecord lowestSoFar = null;
 DirectoryResource dr = new DirectoryResource();
 
    for(File f: dr.selectedFiles()){
        FileResource fr = new FileResource(f);
        CSVRecord currRow = lowestHumidityInFile(fr.getCSVParser());
        
      if(lowestSoFar == null){
         lowestSoFar = currRow;
        } else {
            if(currRow.get("Humidity").equals("N/A")){
                System.out.println("N/A");}
                else{
            int currHumi = Integer.parseInt(currRow.get("Humidity"));
            int lowestHumi = Integer.parseInt(lowestSoFar.get("Humidity"));
        if(currHumi<lowestHumi ){
            lowestSoFar = currRow;
        }
    }
    
}
 
} return lowestSoFar; 
}

public void testLowestHumidityInManyFiles(){
    CSVRecord largest = lowestHumidityInManyFiles();
    System.out.println(" Lowest Humidity was " + largest.get("Humidity") +
    " at " + largest.get("DateUTC")) ;
}


public double averageTemperatureInFile (CSVParser parser){
    CSVRecord sumTemp = null;
    double sum = 0;
    double average = 0;
   
    int count = 0;
    for(CSVRecord currRow : parser){
        
            double currTemp = Double.parseDouble(currRow.get("TemperatureF"));
            sum += currTemp;
            
            count++;
        }
        average = sum/count;
        
        return average;
    }
    
public  void testaverageTemperatureInFile() {
    FileResource fr = new FileResource();
    CSVParser parser = fr.getCSVParser();
    double average = averageTemperatureInFile(parser);
     System.out.println("Average temperature in file is " + average);
    }  
    
public  double averageTemperatureWithHighHumidityInFile(CSVParser parser, int value) {
    double sum = 0;
    double average = 0;
    int count = 1;
    for (CSVRecord currentRow: parser) {
        double currentHumidity = Double.parseDouble(currentRow.get("Humidity"));
        double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
        if(currentHumidity >= value) {
            sum += currentTemp;
            average = sum/count;
            count++;
        }
    }
return average;
}

public  void testAverageTemperatureWithHighHumidityInFile() {
    FileResource fr = new FileResource();
    CSVParser parser = fr.getCSVParser();
    double average = averageTemperatureWithHighHumidityInFile(parser,80);
    if(average == 0)
    {
        System.out.println("No temperatures with that humidity");
    }
    else {System.out.println("Average temperature when high Humidity is" +average);
}
}



}