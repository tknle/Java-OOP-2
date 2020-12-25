
/**
 * Write a description of Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part3 {
    
    public boolean twoOccurrences( String stringa, String stringb){
        int occurrIndex = 0;
        int count=0;
       
       while( occurrIndex != -1){
           occurrIndex = stringb.indexOf(stringa, occurrIndex);
           if( occurrIndex != -1){
               count ++;
               occurrIndex += stringa.length();
            }
        }
        
       if (count >=2){
           return true;
        } else{
            return false;
        }
                 
      }
    
    public String lastPart( String stringa, String stringb){
      int occurrIndex=0;
      String ans="";
     
        occurrIndex = stringb.indexOf(stringa);
         if( occurrIndex == -1){
             return stringb;}
             else{
         occurrIndex += stringa.length();
        }
     ans=stringb.substring(occurrIndex,stringb.length());
    return ans;
}

public void testLastPart(){
  String string1 = "an";
  String string2 ="banana";
  String ans = lastPart(string1,string2);
  System.out.println(ans);
  
  String string3 = "zoo";
  String string4 ="forest";
  String ans2 = lastPart(string3,string4);
  System.out.println(ans2);
}
    public void testTwoOccurrences (){
        
       String string1 = "by";
       String string2 = "A story by Abby Long";
       boolean result1 = twoOccurrences(string1, string2);
       System.out.println(result1);
       
       String string3 = "a";
       String string4 = "banana";
       boolean result2 = twoOccurrences(string3, string4);
       System.out.println(result2);
       
       String string5 = "o";
       String string6 = "elephant";
       boolean result3 = twoOccurrences(string5, string6);
       System.out.println(result3);
        
        
    
    }
}
