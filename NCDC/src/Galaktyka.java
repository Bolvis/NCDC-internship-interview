import javax.xml.stream.events.Characters;

public class Galaktyka {

    public static void main(String[] args)
    {
        int size=0;
        int lastXL,lastXR,lastYD,lastYU;
        int lightYears=0;
        char orientation=',';
        Integer[][] galaxy=null;
        switch (args[0].length())
        {
            case 2:try {size=Integer.valueOf(String.valueOf(args[0].charAt(0)));}
            catch(Exception ex){System.out.print("klops");System.exit(1);}
            orientation=args[0].charAt(1);
            break;
            case 3:try {size=Integer.valueOf(String.valueOf(args[0].charAt(0))+ String.valueOf(args[0].charAt(1)));}
            catch(Exception ex){System.out.print("klops");System.exit(1);}
            orientation=args[0].charAt(2);
            break;
            case 4:
                try {size=Integer.valueOf(String.valueOf(args[0].charAt(0))+ String.valueOf(args[0].charAt(1)
                        +String.valueOf(args[0].charAt(2))));}
                catch(Exception ex){System.out.print("klops");System.exit(1);}
                orientation=args[0].charAt(3);
                break;
            case 5:
                try {size=Integer.valueOf(String.valueOf(args[0].charAt(0))+ String.valueOf(args[0].charAt(1)
                        +String.valueOf(args[0].charAt(2)+String.valueOf(args[0].charAt(3)))));}
                catch(Exception ex){System.out.print("klops");System.exit(1);}
                orientation=args[0].charAt(4);
                break;
            case 6:
                try {size=Integer.valueOf(String.valueOf(args[0].charAt(0))+ String.valueOf(args[0].charAt(1)
                        +String.valueOf(args[0].charAt(2)+String.valueOf(args[0].charAt(3)+(String.valueOf(args[0].charAt(4)))))));}
                catch(Exception ex){System.out.print("klops");System.exit(1);}
                orientation=args[0].charAt(5);
                break;
                default:System.out.print("klops");System.exit(1);break;
        }
        switch(orientation)
        {
            case 'S':
            case 'N':galaxy = new Integer[(size+2)][(size+3)]; break;
            case 'W':
            case 'E':galaxy = new Integer[(size+3)][(size+2)]; break;
            default:System.out.print("klops");System.exit(1);break;
        }
        for(int x=0;x<galaxy.length;x++)
        {
            for(int y=0;y<galaxy[0].length;y++)
            {
                galaxy[x][y]=1;
            }
        }

        switch(orientation)
        {
            case 'N':
                lastXR=galaxy[0].length;
                lastXL=0;
                lastYD=galaxy.length;
                lastYU=0;

                for(int i=0;i<size/2;i++){
                for(int y=lastYU;y<lastYD-1;y++)
                {
                    galaxy[y][lastXR-2]=0;
                }
                lastXR-=2;
                for(int x=lastXR-1;x>lastXL;x--)
                {
                    galaxy[lastYD-2][x]=0;
                }
                lastYD-=2;
                for(int y=lastYD-1;y>lastYU;y--)
                {
                    galaxy[y][lastXL+1]=0;
                }
                lastXL+=2;
                for(int x=lastXL;x<lastXR-1;x++)
                {
                    galaxy[lastYU+1][x]=0;
                }
                lastYU+=2;
                }
                break;
            case 'S':
                lastXR=galaxy[0].length;
                lastXL=0;
                lastYD=galaxy.length;
                lastYU=0;

                for(int i=0;i<size/2;i++){
                    for(int y=lastYU;y<lastYD-1;y++)
                    {
                        galaxy[y][lastXR-2]=0;
                    }
                    lastXR-=2;
                    for(int x=lastXR-1;x>lastXL;x--)
                    {
                        galaxy[lastYD-2][x]=0;
                    }
                    lastYD-=2;
                    for(int y=lastYD-1;y>lastYU;y--)
                    {
                        galaxy[y][lastXL+1]=0;
                    }
                    lastXL+=2;
                    for(int x=lastXL;x<lastXR-1;x++)
                    {
                        galaxy[lastYU+1][x]=0;
                    }
                    lastYU+=2;
                }
                Integer[][] rotatedMap = new Integer[galaxy.length][galaxy[0].length];

                for (int y = 0; y < galaxy.length; y++) {
                    for (int x = 0; x < galaxy[0].length; x++) {
                        rotatedMap[y][x] = galaxy[galaxy.length - y - 1][galaxy[0].length - x - 1];
                    }}
                galaxy =rotatedMap;
                break;
            case 'E':
                lastXR=galaxy[0].length;
                lastXL=0;
                lastYD=galaxy.length;
                lastYU=0;

               for(int i=0;i<size/2;i++){
                    for(int x=lastXR-1;x>lastXL;x--)
                    {
                        galaxy[lastYD-2][x]=0;
                    }
                    lastYD-=2;
                    for(int y=lastYD-1;y>lastYU;y--)
                    {
                        galaxy[y][lastXL+1]=0;
                    }
                    lastXL+=2;
                    for(int x=lastXL;x<lastXR-1;x++)
                    {
                        galaxy[lastYU+1][x]=0;
                    }
                    lastYU+=2;
                    for(int y=lastYU;y<lastYD-1;y++)
                    {
                        galaxy[y][lastXR-2]=0;
                    }
                    lastXR-=2;
                }
                break;
            case 'W':
                lastXR=galaxy[0].length;
                lastXL=0;
                lastYD=galaxy.length;
                lastYU=0;

                for(int i=0;i<size/2;i++){
                    for(int x=lastXR-1;x>lastXL;x--)
                    {
                        galaxy[lastYD-2][x]=0;
                    }
                    lastYD-=2;
                    for(int y=lastYD-1;y>lastYU;y--)
                    {
                        galaxy[y][lastXL+1]=0;
                    }
                    lastXL+=2;
                    for(int x=lastXL;x<lastXR-1;x++)
                    {
                        galaxy[lastYU+1][x]=0;
                    }
                    lastYU+=2;
                    for(int y=lastYU;y<lastYD-1;y++)
                    {
                        galaxy[y][lastXR-2]=0;
                    }
                    lastXR-=2;
                }
                Integer[][] rotatedGalaxy = new Integer[galaxy.length][galaxy[0].length];

                for (int y = 0; y < galaxy.length; y++) {
                    for (int x = 0; x < galaxy[0].length; x++) {
                        rotatedGalaxy[y][x] = galaxy[galaxy.length - y - 1][galaxy[0].length - x - 1];
                    }}
                galaxy =rotatedGalaxy;
                break;

            default:break;
        }
        for(int x=0;x<galaxy.length;x++)
        {
            for(int y=0;y<galaxy[0].length;y++)
            {
               if(galaxy[x][y]==1){System.out.print("*");}
               if(galaxy[x][y]==0){System.out.print(" ");lightYears+=1;}
            }
            System.out.println();
        }
        System.out.print(lightYears);
    }
}