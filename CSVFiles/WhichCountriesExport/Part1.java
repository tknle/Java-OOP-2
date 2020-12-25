import edu.duke.*;
import org.apache.commons.csv.*;

public class Part1 {
public void testerCSVParser(){
    FileResource fr= new FileResource();
    CSVParser parser= fr.getCSVParser();
    
    parser=fr.getCSVParser();
    
    countryInfo(parser, "Germany");
    parser=fr.getCSVParser();
    listExportersTwoProducts(parser,"gold","diamonds");
    parser=fr.getCSVParser();
    numberOfExporters(parser,"gold");
     parser=fr.getCSVParser();
    bigExporters(parser,"$999,999,999,999");
}


public void testerCSVParserLarge(){
   FileResource fr= new FileResource();
    CSVParser parser= fr.getCSVParser();
    
    parser=fr.getCSVParser();
    /*  listExportersTwoProducts(parser,"gold","diamonds");
     parser=fr.getCSVParser();  
      numberOfExporters( parser,"sugar");
      parser=fr.getCSVParser();   
      countryInfo(parser, "Nauru");
     parser=fr.getCSVParser();
    bigExporters(parser,"$999,999,999,999");*/
    listExportersTwoProducts(parser, "cotton","flowers");
    parser=fr.getCSVParser();  
      numberOfExporters( parser,"cocoa");
      parser=fr.getCSVParser();
    bigExporters(parser,"$999,999,999,999");
} 
      
      

public void countryInfo (CSVParser parser, String country){
    for(CSVRecord record: parser){
        String countries = record.get("Country");
        if(countries.contains(country)){
            
            System.out.print(record.get("Country")+":");
            System.out.print(record.get("Exports")+":");
            System.out.println(record.get("Value (dollars)"));
    } else {
    System.out.println("NOT FOUND");
        
}
}
}

public void listExportersTwoProducts( CSVParser parser, String exportItem1,
String exportItem2) {
    for(CSVRecord record: parser){
        String export = record.get("Exports");
        if (export.contains(exportItem1) && export.contains(exportItem2)){
            String country = record.get("Country");
            System.out.println(country);
        }
   
}

}

public void numberOfExporters( CSVParser parser, String exportItem){
    int countCountries = 0;
    for(CSVRecord record: parser){
        String export = record.get("Exports");
        if(export.contains(exportItem)){
           String country = record.get("Country");
           countCountries ++;
           
}

}
System.out.println(countCountries);
}

public void bigExporters( CSVParser parser, String amount){
   
   // int thresholdLength = thresholdString.length();

 // int thresholdLength = 13;
    int len = amount.length();
    
    for(CSVRecord record: parser){
        String export = record.get("Value (dollars)");
        if(export.length() > len){ 
    String country = record.get("Country");
    System.out.println(country + "" + export);
    
    //System.out.println(export);
}
}
}
}