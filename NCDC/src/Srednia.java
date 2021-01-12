import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Srednia {

    private static float Wyliczone(String[] list)
    {
        List<Float> oceny = new ArrayList<>();
        float dodane = 0;
        int num_of_bad = 0;

        for(String item: list)
        {
           try{ 
                if (Float.valueOf(item) <= 6 && Float.valueOf(item) >=1 ){
                   oceny.add(Float.valueOf(item));
                }
                else {
                    System.out.println("Bledna ocena nr:" + (Arrays.asList(list).indexOf(item) + 1));
                    num_of_bad++;
                }
            }
            catch(Exception ex) {
                System.out.println("Bledna ocena nr:" + (Arrays.asList(list).indexOf(item) + 1));
                num_of_bad++;
            }
        }

        for(Float item:oceny){
            dodane+=item;
        }

        return dodane/(list.length - num_of_bad);
    }

    public static void main(String[] args)
    {
        System.out.print(Wyliczone(args));
    }
}
