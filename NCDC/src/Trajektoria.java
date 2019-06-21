public class Trajektoria {

    public static void main(String[] args)
    {
        int amplitude=0;
        int flightLength=0;
        try{
            amplitude = Integer.valueOf(args[0]);
            flightLength = Integer.valueOf(args[1]);
        }catch(Exception ex){System.out.print("klops"); System.exit(1);}

        Integer[][] path = new Integer[amplitude][flightLength];
        for(int y = 0; y < amplitude;y++){
        for (int x = 0; x < flightLength; x++) {
            path[y][x] = 0;
        }}

        for(int x=0;0<flightLength;)
        {
            String direction=null;
            for(int y=0;0<flightLength;){

                if(1==amplitude){direction="cons";}else{
                if(0==y){direction="down";}
                if(amplitude-1==y){direction="up";}}
                path[y][x]=1;
            switch(direction)
            {
                case "down":y++;x++; break;
                case "up":y--;x++;break;
                case "cons":x++;break;
                default: break;
            }
            flightLength--;
            }
        }

        for(int x=0;x<amplitude;x++)
        {
            for(int y=0;y<Integer.valueOf(args[1]);y++)
            {
               if(path[x][y]==1)System.out.print("*");
               if(path[x][y]==0)System.out.print(" ");
            }
            System.out.println();
        }
    }
}
