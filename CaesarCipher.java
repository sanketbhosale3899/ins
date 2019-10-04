
package caesarcipher;
import java.io.*;

public class CaesarCipher {
    public static void main(String[] args) {
        String s="";
        int i;
        try
        {
           File ip=new File("G:\\vishnu\\1.txt");
           File op=new File("G:\\vishnu\\2.txt");
           File op1=new File("G:\\vishnu\\3.txt");
           FileInputStream fis=new FileInputStream(ip);
           FileOutputStream fos=new FileOutputStream(op);
           FileOutputStream fos1=new FileOutputStream(op1);
           while((i=fis.read())!=-1)
           {
               fos.write(i);
               fos1.write(i+4);
           }
           System.out.println("File copied...");
        }
        catch(Exception e)
        {
          System.out.println("big error...");  
        }

    }
    
}
