import java.math.*;
import java.security.*;

public class Rsa3 {
    BigInteger p,q,n,d,e,ph,t;
    SecureRandom r;
    public Rsa3(){
        r=new SecureRandom();
        p=new BigInteger(512,100,r);
        q=new BigInteger(512,100,r);
        System.out.println("Prime nos p and q are "+p.intValue()+","+q.intValue());
        n=p.multiply(q);
        ph=(p.subtract(new BigInteger("1")));
        ph=ph.multiply(q.subtract(new BigInteger("1")));
        e=new BigInteger("2");
        while(ph.gcd(e).intValue()>1 || e.compareTo(ph)!=-1)
            e=e.add(new BigInteger("1"));
            d=e.modInverse(ph);
            System.out.println("public key is ("+n.intValue()+","+e.intValue()+")");
            System.out.println("private key is("+n.intValue()+","+d.intValue()+")");
            BigInteger msg=new BigInteger("15");
            System.out.println("\nMessage is: "+msg);
            BigInteger emsg=encrypt(msg,e,n);
            System.out.println("\nEncrypted msg is: "+emsg.intValue());
            BigInteger demsg=decrypt(emsg,d,n);
            System.err.println("\nDecryption msg is: "+demsg.intValue());
            
         
    }
    BigInteger encrypt(BigInteger msg,BigInteger e,BigInteger n)
    {
        return msg.modPow(e, n);
                
    }
    BigInteger decrypt(BigInteger msg,BigInteger d,BigInteger n)
    {
        return msg.modPow(d, n);
    }
    
    public static void main(String[] args)
    {
        new Rsa3();
    }
}
