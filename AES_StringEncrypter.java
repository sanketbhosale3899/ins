
import java.security.*;
import javax.crypto.*;
import java.io.*;

public class AES_StringEncrypter {
    Cipher ecipher;
    Cipher decipher;
    AES_StringEncrypter(SecretKey key) 
    {
        try{
        ecipher=Cipher.getInstance("AES");
        decipher=Cipher.getInstance("AES");
        ecipher.init(Cipher.ENCRYPT_MODE, key);
        decipher.init(Cipher.DECRYPT_MODE, key);  
        }
        catch(Exception e){}
    }
        
    public String encrypt(String str) throws UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException
    {
        byte[]utf8=str.getBytes("UTF8");
        byte[]enc=ecipher.doFinal(utf8);
        return new sun.misc.BASE64Encoder().encode(enc);
        
    }
    public String decrypt(String str) throws IOException, IllegalBlockSizeException, BadPaddingException
    {
        byte[]dec=new sun.misc.BASE64Decoder().decodeBuffer(str);
        byte[]utf8=decipher.doFinal(dec);
        return new String(utf8,"UTF8");
        
    }
    public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, UnsupportedEncodingException, IOException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException
    {
        SecretKey key=null;
        KeyGenerator keyGen=KeyGenerator.getInstance("AES");
        key=keyGen.generateKey();
        AES_StringEncrypter dese=new AES_StringEncrypter(key);
        String o="Welcome to UDCS......";
        String en=dese.encrypt(o);
        String de=dese.decrypt(en);
        System.out.println("Original Text : "+o);
        System.out.println("Encrypted Text : "+en);
        System.out.println("Decrypted Text : "+de);
    }
    
}
