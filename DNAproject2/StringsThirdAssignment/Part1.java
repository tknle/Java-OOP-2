import edu.duke.*;

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
    String dnaUp = dna.toUpperCase();
  int startIndex = dnaUp.indexOf("ATG",where);
  if (startIndex == -1){
      return "";}
  int taaIndex = findStopCodon(dnaUp, startIndex, "TAA");
  int tagIndex = findStopCodon(dnaUp, startIndex, "TAG");
  int tgaIndex = findStopCodon(dnaUp, startIndex, "TGA");
  
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
    System.out.println("startIndex = "+ startIndex);
    System.out.println("minIndex" +minIndex);
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

public void testOn (String dna){
    System.out.println(" Testing printAllGene on" + dna);
    //getAllGene(dna);
    
    StorageResource sr = getAllGene(dna);
    for ( String g: sr.data()){
        System.out.println(g);
    }
}
public void test(){
    //testOn("ATGATCTAATTTATGCTGCAACGGTGAAGA");
    //testOn("");
    testOn("CTGONEAtGONEcCCGGGAAAXXXYYYGGGGTAGYYCTGCCCATGENDZZZTAAONEXXXYYYZZZTAAXXxXXTWOATGTWOYYYZZZCCCATGATGENDZZZTAGTWOXXTHREEATGATGTAATHREESTOPTAGAGGGCCCCCFOURATGTAGGXXXFIVEAtgYYYFIVZZZAAAXXXFIVENDZZZTGAFIVESTOPSIXATGSIXCGGGCCGGGATCAAASIXENDTAASEVATGSIXCGGGCCGGGATCAAASEVENDENDtaAEIGSTOPTAGAGLASTONEATgtAACTG");
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


public void testCgRatio (){
    cgRatio("ATGCCATAG");
    
    
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

public void testCountCTG(){
    countCTG("ATGCTGAAACTGTGA");

}

public void processGenes(String sr){
   
    StorageResource genes = getAllGene(sr);
    
    //FileResource fr = new FileResource("brca1line.fa");
   // String dna = fr.asString();
  
    System.out.println(genes);
    if(sr.length()> 60){
        System.out.println(genes);
    }else {
        System.out.println("");
    }
    
    for(String g: genes.data()){
        //print all the Strings in sr that are longer than 9 characters
        if( sr.length() >= 9){
            System.out.println("String is longer than 9 characters: " +sr);
        } else {
            System.out.println("");
        }
        //print the number of Strings in sr that are longer than 9 characters
        if(sr.length() >= 9){
            System.out.println("Number of char in string is: " + sr.length());
        } else {
             System.out.println("");
            }
        //print the Strings in sr whose C-G-ratio is higher than 0.35
        if( cgRatio(sr) > 0.35){
            System.out.println("cg ratio in this string is higher than 0.35:" 
            + cgRatio(sr));}
          else {
              System.out.println("");
            }
        //print the number of strings in sr whose C-G-ratio is higher than 0.35
        if( cgRatio(sr) > 0.35){
            System.out.println("the number of cgratio > 0.35 is:"+ sr.length()); 
        }  
          else {
              System.out.println("");
            }
        //print the length of the longest gene in sr
        int max = 0;
        if(sr.length()>max){
            max = sr.length();
        } else {max = max;}
        System.out.println("The longest is: " + max);
}
}

public void testProcessGenes (){
    String a = "ATGCTGCACATATGA";
    String b = "ATGTGA";
    processGenes(a);
    processGenes(b);
    String c = "ATGCGCGCCTGA";
    processGenes(c);
    String d = "ATGATATTATGA";
    processGenes(d);
}


        }
