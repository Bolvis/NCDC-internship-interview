import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Cran
{
    double temp;
    double speed;
    Cran(double speed, double temp)
    {
        this.temp=temp;
        this.speed=speed;
    }
}
public class Wilk {

    public static void main(String[] args) {
        Scanner file = new Scanner(System.in);
        double requiredFuel=0;
        double fillSpeed = 0;
        double temperature;
        double time;
        double temperatureCounter = 0;
        double temperatureDenominator = 0;
        List<Cran> cranes = new ArrayList<>();
        List<String[]> data = new ArrayList<>();
        List<Double> dataDouble=new ArrayList<>();



        while (file.hasNextLine()) {
            data.add(file.nextLine().split(" "));
        }

        for(String[] item: data)
        {
            for(String num:item){
            try{dataDouble.add(Double.valueOf(num));}
            catch(Exception ex){System.out.print("klops"); System.exit(1);} //check data
                 }
        }

            requiredFuel = dataDouble.get(0);
            for (int i = 1; i < dataDouble.size(); i+=2) {

                cranes.add(new Cran(dataDouble.get(i),dataDouble.get(i+1)));
            }
            for(Cran item:cranes)
            {
                fillSpeed+=item.speed;
            }

            fillSpeed /= 60; //per sec
            time = 1000 * requiredFuel / fillSpeed; //in sec

            for (int i = 0; i < cranes.size(); i++) {
                temperatureCounter += cranes.get(i).speed * cranes.get(i).temp;
                temperatureDenominator += cranes.get(i).speed;
            }
            temperature = temperatureCounter / temperatureDenominator;
            time *= 100000;
            time = Math.round(time);
            time /= 100000;
            temperature *= 100000;
            temperature = Math.round(temperature);
            temperature /= 100000;
            System.out.println(time);
            System.out.print(temperature);

    }
    }

