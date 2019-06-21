import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Krolik {

    public static void main(String[] args) {

        Scanner file = new Scanner(System.in);
        int column = 0;
        int index = 5001;
        List<String[]> lines = new ArrayList<>();

            while (file.hasNextLine())
            {
                String[] s = file.nextLine().split(",");
                lines.add(s);
            }
            for (int i = 0; i < lines.size(); i++) {
                for (int j = 0; j < lines.size() + 1; j++) {
                    if (lines.get(i)[j].equals("{" + args[0] + "}") && index == 5001) {
                        index = j;
                    } else if (lines.get(i)[j].equals("{" + args[0] + "}")) {
                        System.out.print("klops"); System.exit(1);
                    }
                }
            }
            if (index == 5001) {
                System.out.print("klops");System.exit(1);
            }

                for (int i = 0; i < lines.size(); i++)
                {
                    try {
                        if (-10000 < Integer.valueOf(lines.get(i)[index]) && 10000 > Integer.valueOf(lines.get(i)[index]))
                        {
                            column += Integer.valueOf(lines.get(i)[index]);
                        }
                    } catch (Exception ex) {}
                }
                System.out.print(column);

    }
}
