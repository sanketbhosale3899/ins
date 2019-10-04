import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Hash {
    public static void main(String[] args) throws NoSuchAlgorithmException
    {
        System.out.println("For null "+md5(""));
        System.out.println("For simple text "+md5("this is my text"));
        System.out.println("For simple numbers "+md5("12345"));
    }
    
    public static String md5(String input) throws NoSuchAlgorithmException
    {
        String md5=null;
        if (null==input) return null;
        
        MessageDigest digest=MessageDigest.getInstance("MD5");
        digest.update(input.getBytes(),0,input.length());
        md5=new BigInteger(1,digest.digest()).toString(16);
        return md5;
        
    }
    
}
