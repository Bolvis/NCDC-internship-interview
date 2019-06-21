import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Paprotka
{
    private static Scanner file = new Scanner(System.in);
    private static List<String[]> primeFactorsString = new ArrayList<>();
    private static List<Long> primeFactorsLong = new ArrayList<>();
    private static long number;


    private static boolean isPrime(long n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean hasNumber()
    {
        try {
            number = Long.valueOf(file.nextLine());
            return true;
        } catch (Exception ex) {
            number = 1;
            return false;
        }
    }

    private static boolean hasFactors()
    {
        if(primeFactorsString.size()==1&&primeFactorsString.get(0)!=null)return true;
        else return false;
    }

    private static boolean hasCorrectFactors()
    {
        for(Long item:primeFactorsLong)
        {
            if(!isPrime(item)){return false;}
        }
        return true;
    }

    private static List<String[]> Factors(List<String[]> list)
    {
        while (file.hasNextLine())
        {
            list.add(file.nextLine().split(","));
        }
        return list;
    }


    private static List<Long> primeFactorsToLong(List<String[]> strings)
    {
        List<Long> longs = new ArrayList<>();
        for(String[] item: primeFactorsString)
        {
            for(String num:item){
            try {
                longs.add(Long.valueOf(num));
            }catch (Exception ex){}
            }
        }
        return longs;
    }

    private static void printLong(List<Long> list)
    {
        for(int i =0;i<list.size()-1;i++)
        {
            System.out.print(list.get(i)+",");
        }
        System.out.print(list.get(list.size()-1));
    }
    private static void end()
    {
        System.out.print("klops");
        System.exit(1);
    }

    public static List<Long> divideNumber(long number) {
        List<Long> primeFactors = new ArrayList<>();
        for (long i = 2; i <= number; i++) {
            if (number % i == 0) {
                primeFactors.add(i); // prime factor
                number /= i;
                i--;
            }
        }
        return primeFactors;
    }

    private static long valueOfFactors()
    {long num=1;
        for(Long item:primeFactorsLong)
        {
            num*=item;
        }
        return num;
    }

    public static void main(String[] args)
{
    boolean hasNumber;
    hasNumber=hasNumber();
    primeFactorsString=Factors(primeFactorsString);

    if(!hasFactors()&&!hasNumber){end();}
    if(hasFactors())
    {
        primeFactorsLong=primeFactorsToLong(primeFactorsString);
        if(!hasCorrectFactors()){end();}
        if(!hasNumber){number=valueOfFactors();System.out.println(number);System.exit(1);}
        else
        {
            if(number<valueOfFactors())end();
            if(number==valueOfFactors()){System.out.println(number);System.exit(1);}
        }
    }else if(hasNumber)
    {
        primeFactorsLong=divideNumber(number);
        System.out.println(number);
        printLong(primeFactorsLong);
    }

    if(hasNumber&&hasFactors())
    {
        long copyOfNumber=number;
        for(Long item:primeFactorsLong)
        {
            number/=item;
        }
        primeFactorsLong=divideNumber(number);
        System.out.println(copyOfNumber);
        printLong(primeFactorsLong);
    }
}
}