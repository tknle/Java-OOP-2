

public class stupidFriend {
public void findAbc(String input){
       int index = input.indexOf("abc");
       System.out.println("index " + index);
       while (true){
           if (index == -1 || index >= input.length() - 3){
               break;
           }
           String found = input.substring(index+1, index+4);
          
           System.out.println(found);
           index = input.indexOf("abc",index+4);
           System.out.println("index after updating " + index);
       }
   }

   public void test(){
       //findAbc("abcd");
       //findAbc("abcdabc");
       findAbc("abcdkfjsksioehgjfhsdjfhksdfhuwabcabcajfieowj");
   }
  
    
    
}
