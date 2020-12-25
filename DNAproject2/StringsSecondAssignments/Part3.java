
/**
 * Write a description of Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part3 {
public int findStopCodon(String dna, int startIndex, String stopCodon){
      int currIndex = dna.indexOf(stopCodon, startIndex +3);
      
      while ( currIndex != -1){
          if( (currIndex-startIndex) % 3 == 0 ){
              return currIndex;
            } else{
                currIndex = dna.indexOf(stopCodon, currIndex +1);
            }
      
    }
    return dna.length();
}

public String findGene(String dna, int where){
  int startIndex = dna.indexOf("ATG",where);
  if (startIndex == -1){
      return "";}
  int taaIndex = findStopCodon(dna, startIndex, "TAA");
  int tagIndex = findStopCodon(dna, startIndex, "TAG");
  int tgaIndex = findStopCodon(dna, startIndex, "TGA");
  
  int minIndex = 0;
  if (taaIndex == -1 ||
            (tgaIndex != -1  && tgaIndex < taaIndex )){
                minIndex = tgaIndex;
            }
    else {
        minIndex = taaIndex;
    }
    if (minIndex == -1 ||
            (tagIndex != -1 && tagIndex < minIndex)){
            minIndex = tagIndex;
        }
        
        if (minIndex == -1){
            return "";}
    
    return dna.substring(startIndex, minIndex +3);
    
}

public void printAllGene (String dna){
    int startIndex = 0;
    
    while(true){
        String currGene = findGene(dna, startIndex);
        if(currGene.isEmpty()){
            break;
        }
        System.out.println(currGene);
        
        startIndex = dna.indexOf(currGene, startIndex)+ 
                        currGene.length();
                    }               
    
}

public int countGenes (String dna){
   int currIndex = 0;
   int count = 0;
   int startIndex = 0;
   while(true){
       String currGene = findGene(dna, startIndex);
       if (currGene.isEmpty()){
           break;}
           count ++;
        startIndex = dna.indexOf(currGene,startIndex)+
                        currGene.length();
                    }
   
   return count;
  
}

public void tetsCountGenes (){
 String test = "ATGTAAGATGCCCTAGT";   
 int ans = countGenes(test);
 if (ans != 2){
     System.out.println("Error in test 1");
    }
  System.out.println(" No error, well done !");  
}
}
