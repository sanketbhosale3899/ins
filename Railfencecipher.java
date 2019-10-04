
package railfencecipher;


public class Railfencecipher {
    public static void main(String[] args) {
        String input="HAPPYBIRTHDAY";
       String output="";
       int len=input.length(),flag=0;
       System.out.println("input string :" +input);
       for(int i=0;i<len;i+=2)
       {
           output += input.charAt(i);
           
       }
       for(int i=1;i<len;i+=2)
       {
           output += input.charAt(i);
           
       }
       System.out.println("Ciphered text :" +output);
 
    }
    
}
