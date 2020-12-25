
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part1 {

    public String findSimpleGene(String dna){
        //start codon is "ATG", stop codon is "TAA"
        String result = "";
        
        int startIndex = dna.indexOf("ATG");
        if (startIndex == -1){
            return "Not valid - no ATG";}
            
        int stopIndex = dna.indexOf("TAA", startIndex +3);
        if (stopIndex == -1){
            return "Not valid - no TAA";}
            
        result = dna.substring(startIndex, stopIndex +3);
        if (result.length() % 3 == 0){
       result = result; 
    } else {
        result = " not valid";
    }
    return result;
}

public void testSimpleGene(){
 String dna ="AATGCGTAATAGGT";
 System.out.println("DNA strand is " + dna);
 String gene = findSimpleGene(dna);
 System.out.println("Gene is " + gene);
 
 //no "ATG"
 String dna1 ="ACGTAATAGGT";
 System.out.println("DNA strand is " + dna1);
 String gene1 = findSimpleGene(dna1);
 System.out.println("Gene is " + gene1);
 // no "TAA"
 String dna2 ="AATGCGTAGGT";
 System.out.println("DNA strand is " + dna2);
 String gene2 = findSimpleGene(dna2);
 System.out.println("Gene is " + gene2);
 
 //no "ATG" and "TAA"
 String dna3 ="ACGTAGGT";
 System.out.println("DNA strand is " + dna3);
 String gene3 = findSimpleGene(dna3);
 System.out.println("Gene is " + gene3);
 // substring cannot % 3
 
String dna4 ="AGATGCGATACGCTAATC";
 System.out.println("DNA strand is " + dna4);
 String gene4 = findSimpleGene(dna4);
 System.out.println("Gene is " + gene4);
 // substring can % 3
 
 String dna5 ="AGATGCGATACGCTTAATC";
 System.out.println("DNA strand is " + dna5);
 String gene5 = findSimpleGene(dna5);
 System.out.println("Gene is " + gene5);
 
}
}
