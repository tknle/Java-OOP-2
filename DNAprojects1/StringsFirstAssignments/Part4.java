
import edu.duke.*;
public class Part4 {
    public String findURL(String URL){
        String search = "youtube.com";
        int pos = URL.toLowerCase().indexOf(search.toLowerCase());
       
       if (pos != -1){
           int firstIndex=URL.lastIndexOf("\"",pos);
            if(firstIndex!=-1){
                String found1=URL.substring(firstIndex+1);
                int secondIndex=found1.indexOf("\"");
                String found2=found1.substring(0,secondIndex);
                return found2;
            }
    } 
    return "";
  
        }
        


public void findlinks(){
        
     String url = "http://www.dukelearntoprogram.com/course2/data/manylinks.html";

     URLResource ur = new URLResource(url);

 

     for (String link : ur.lines()) {
               
         System.out.println(findURL(link));
        }
        
    }
}