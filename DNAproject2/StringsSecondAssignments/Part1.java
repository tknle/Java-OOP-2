
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part1 {

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

public void testFindStopCodon(){
 String dna = ("xxxyyyzzzTAAxxxyyyzzzTAAxx");
 int dex = findStopCodon(dna,0,"TAA");
 if(dex!=9){ System.out.println("error on 9");}
  dex = findStopCodon(dna,9,"TAA");
 if(dex!=21){ System.out.println("error on 21");}   
 dex = findStopCodon(dna,1,"TAA");
 if(dex!=26){ System.out.println("error on 26");
}

System.out.println("test finished");
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

public void testFindGene(){
 String dna = "ATGCCCGGGAAATAACCC";
 String gene = findGene(dna,0);
 if (! gene.equals("ATGCCCGGGAAATAA"))
 {
     System.out.println("error");
    }
    
 String dna1 = "AATGCTAACTAGCTGACTAAT";
 String gene1 = findGene(dna1,0);
 
     System.out.println("string =" + gene1);
       
    System.out.println("tests finished");

    
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

public void testOn (String dna){
    System.out.println(" Testing printAllGene on" + dna);
    printAllGene(dna);
}
public void test(){
    testOn("ATGATCTAATTTATGCTGCAACGGTGAAGA");
    testOn("");
}
}