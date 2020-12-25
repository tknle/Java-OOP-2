import edu.duke.*;
import java.util.*;
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
    //return dna.length();
    return -1;
}

public String findGene(String dna, int where){
  String dnaUp = dna.toUpperCase();
  int startIndex = dnaUp.indexOf("ATG",where);
  if (startIndex == -1){
      return "";}
  int taaIndex = findStopCodon(dnaUp, startIndex, "TAA");
  int tagIndex = findStopCodon(dnaUp, startIndex, "TAG");
  int tgaIndex = findStopCodon(dnaUp, startIndex, "TGA");
  
  int minIndex = -1;
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

public StorageResource getAllGene(String dna){
    StorageResource sr = new StorageResource();
    
    int startIndex = 0;
    
    while(true){
        String currGene = findGene(dna, startIndex);
        if(currGene.isEmpty()){
            break;
        }
        
        sr.add(currGene);
        
        //System.out.println(currGene);
        
        startIndex = dna.indexOf(currGene, startIndex)+ 
                        currGene.length();
                    } 
       
    return sr;
}

public float cgRatio (String dna){
   StorageResource genes = getAllGene(dna);
  
   int startIndexC = 0;
   int countC = 0;
  
  String dnaUppercase = dna.toUpperCase();
  while (true){
    int indexC = dnaUppercase.indexOf("C", startIndexC);
      if(indexC == -1){
        break;
        }
    countC +=1;
    startIndexC = indexC+1;
    }
    //System.out.println(countC);
    int startIndexG = 0;
    int countG = 0;

  while (true){
    int indexG = dnaUppercase.indexOf("G", startIndexG);
      if(indexG == -1){
        break;
        }
    countG +=1;
    startIndexG = indexG+1;
    }
    //System.out.println(countG);
    float sum = countC + countG;
    float cgRatio = sum/dna.length();
    
    //System.out.println(cgRatio);
    return cgRatio;
}

public int countCTG (String dna){
 StorageResource ganes = getAllGene(dna);
 int startIndexCTG = 0;
 int countCTG = 0;
 
 while(true){
     int indexCTG = dna.indexOf("CTG", startIndexCTG);
        if(indexCTG == -1){
            break;}
            countCTG+=1;
            startIndexCTG = indexCTG +1;
}
//System.out.println(countCTG);
return countCTG;
}

public void processGenes(String sr){
   
    StorageResource genes = getAllGene(sr);
    int count = 0;
    int countLongerThan60 = 0;
    int countcgRatio = 0;
    int countctgAppear = 0;
    
    int max = 0;
    
    for(String g: genes.data()){
        System.out.println(g);
        count ++;
        if(g.length()> 60){
          countLongerThan60++;
        }
        if( cgRatio(g)> 0.35){
          countcgRatio ++;
        }
        
         if(g.length() > max){
             max = g.length();
            } else {
              max = max;
            }
       
    }
    System.out.println("Number of genes: " + count);
    System.out.println("Number of genes that longer than 60: "+ countLongerThan60);
    System.out.println("Number of genes that cgRatio greater than 0.35 is: "
    + countcgRatio);
    System.out.println(" codon CTG appears in strand gene are: " + countCTG(sr));
    System.out.println("the length of the longest gene in the collection of genes is:"
    + max);
}

public void testProcessGenes2 (){
    FileResource fr = new FileResource("brca1line.fa");
    String dna = fr.asString().toUpperCase();
    
   

    processGenes(dna);

   
}

public void testOnGRch38(){
 FileResource fr = new FileResource("GRch38dnapart.fa");
 String dna = fr.asString().toUpperCase();   
 processGenes(dna);   
}
}
