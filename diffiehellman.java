import java.util.*;
import java.math.BigInteger;
public class diffiehellman {
    
    final static BigInteger one=new BigInteger("1");
    
    public static void main(String[] args)
    {
        Scanner stdin=new Scanner(System.in);
        BigInteger p;
        System.out.println("Enter the approximate value of p and you want :");
        String ans=stdin.next();
        p=getNextPrime(ans);
        System.out.println("Your prime is "+p+".");
        System.out.println("now enter a number in between 2 and p-1.");
        BigInteger g=new BigInteger(stdin.next());
        System.out.println("Person A:enter your secret number now.");
        BigInteger a=new BigInteger(stdin.next());
        BigInteger resulta=g.modPow(a, p);
        System.out.println("person A sends to person B "+resulta+".");
        System.out.println("Person B: enter your secret number now .");
        BigInteger b=new BigInteger(stdin.next());
        BigInteger resultb=g.modPow(b, p);
        System.out.println("Person B sends to person A "+resultb+".");
        BigInteger KeyACalculates=resultb.modPow(a, p);
        BigInteger KeyBCalculates=resulta.modPow(b,p);
        System.out.println("A takes "+resultb+" raises it to the power "+a+"mod "+p);
        System.out.println("A takes A calculates is "+KeyACalculates+".");
        System.out.println("B takes "+resulta+" raises it to the power "+b+"mod "+p);
        System.out.println("The key B calculates is "+KeyBCalculates+".");
           
    }
    private static BigInteger getNextPrime(String ans) {
        BigInteger test=new BigInteger(ans);
        while (!test.isProbablePrime(99))
            test=test.add(one);
        return test;
        
    }
    
    
}
