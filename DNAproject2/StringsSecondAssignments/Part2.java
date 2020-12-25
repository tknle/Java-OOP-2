
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
 public int howMany( String stringa, String stringb){
     int occurrIndex = 0;
    int count = 0;
    
    while( occurrIndex != -1){
        occurrIndex = stringb.indexOf(stringa, occurrIndex);
        if(occurrIndex != -1){
            count ++;
            occurrIndex += stringa.length();
        }
    } 
    
    return count;
}

    public void test(){
    String a = "GAA";
    String b = "ATGAACGAATTGAATC";
    int ans = howMany(a,b);
        if (ans != 3){
    System.out.println("error in test 1");
}

    String c="AA";
    String d="ATAAAA";
    int ans2 = howMany(c,d);
    if(ans2 != 2){
        System.out.println("error in test 2");
    }
    System.out.println("No error, well done !");
}
}