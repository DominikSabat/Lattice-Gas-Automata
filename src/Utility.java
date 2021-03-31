import java.awt.*;
import java.util.Random;

public class Utility {
    DataManager dm;
    int[] blank={0,0,0,0};
    int[] alldir ={1,1,1,1};
    int iloscCzasteczek=0;


    public Utility(DataManager dm) {
        this.dm = dm;
    }

    Cell[] getNeighbors(int Width, int Height) {

            Cell[] neighbors = new Cell[4];
            try {
                neighbors[0] = dm.particleLast[Width - 1][Height];
                neighbors[1] = dm.particleLast[Width][Height - 1];
                neighbors[2] = dm.particleLast[Width+1][Height];
                neighbors[3] = dm.particleLast[Width][Height+1];

            }

        catch(Exception e){
            if (Width == 0 && Height == 0) {
                neighbors[0] = dm.particleLast[dm.width - 1][Height];
                neighbors[1] = dm.particleLast[Width][dm.height - 1];
                neighbors[3] = dm.particleLast[Width][Height + 1];
                neighbors[2] = dm.particleLast[Width + 1][Height];
            } else if (Width == dm.width - 1 && Height == 0) {
                neighbors[0] = dm.particleLast[Width - 1][Height];
                neighbors[1] = dm.particleLast[Width][dm.height - 1];
                neighbors[2] = dm.particleLast[0][Height];
                neighbors[3] = dm.particleLast[Width][Height + 1];
            } else if (Width == 0 && Height == dm.height - 1) {
                neighbors[0] = dm.particleLast[dm.width - 1][Height];
                neighbors[1] = dm.particleLast[Width][Height - 1];
                neighbors[2] = dm.particleLast[Width + 1][Height];
                neighbors[3] = dm.particleLast[Width][0];
            } else if (Width == dm.width - 1 && Height == dm.height - 1) {
                neighbors[0] = dm.particleLast[Width - 1][Height];
                neighbors[1] = dm.particleLast[Width][Height - 1];
                neighbors[2] = dm.particleLast[0][Height];
                neighbors[3] = dm.particleLast[Width][0];
            } else if (Height == 0) {
                neighbors[0] = dm.particleLast[Width - 1][Height];
                neighbors[1] = dm.particleLast[Width][dm.height - 1];
                neighbors[2] = dm.particleLast[Width + 1][Height];
                neighbors[3] = dm.particleLast[Width][Height + 1];
            } else if (Height == dm.height - 1) {
                neighbors[0] = dm.particleLast[Width - 1][Height];
                neighbors[1] = dm.particleLast[Width][Height - 1];
                neighbors[2] = dm.particleLast[Width + 1][Height];
                neighbors[3] = dm.particleLast[Width][0];

            } else if (Width == 0) {
                neighbors[0] = dm.particleLast[dm.width - 1][Height];
                neighbors[1] = dm.particleLast[Width][Height - 1];
                neighbors[2] = dm.particleLast[Width + 1][Height];
                neighbors[3] = dm.particleLast[Width][Height + 1];
            } else if (Width == dm.width - 1) {
                neighbors[0] = dm.particleLast[Width - 1][Height];
                neighbors[1] = dm.particleLast[Width][Height - 1];
                neighbors[2] = dm.particleLast[0][Height];
                neighbors[3] = dm.particleLast[Width][Height + 1];
            }
        }

        finally{
            return neighbors;
        }

    }

    Cell[] getNeighbors2(int Width, int Height) {

        Cell[] neighbors = new Cell[4];
        try {
            neighbors[0] = dm.particleCurrent[Width - 1][Height];
            neighbors[1] = dm.particleCurrent[Width][Height - 1];
            neighbors[2] = dm.particleCurrent[Width+1][Height];
            neighbors[3] = dm.particleCurrent[Width][Height+1];

        }

        catch(Exception e){
            if (Width == 0 && Height == 0) {
                neighbors[0] = dm.particleCurrent[dm.width - 1][Height];
                neighbors[1] = dm.particleCurrent[Width][dm.height - 1];
                neighbors[3] = dm.particleCurrent[Width][Height + 1];
                neighbors[2] = dm.particleCurrent[Width + 1][Height];
            } else if (Width == dm.width - 1 && Height == 0) {
                neighbors[0] = dm.particleCurrent[Width - 1][Height];
                neighbors[1] = dm.particleCurrent[Width][dm.height - 1];
                neighbors[2] = dm.particleCurrent[0][Height];
                neighbors[3] = dm.particleCurrent[Width][Height + 1];
            } else if (Width == 0 && Height == dm.height - 1) {
                neighbors[0] = dm.particleCurrent[dm.width - 1][Height];
                neighbors[1] = dm.particleCurrent[Width][Height - 1];
                neighbors[2] = dm.particleCurrent[Width + 1][Height];
                neighbors[3] = dm.particleCurrent[Width][0];
            } else if (Width == dm.width - 1 && Height == dm.height - 1) {
                neighbors[0] = dm.particleCurrent[Width - 1][Height];
                neighbors[1] = dm.particleCurrent[Width][Height - 1];
                neighbors[2] = dm.particleCurrent[0][Height];
                neighbors[3] = dm.particleCurrent[Width][0];
            } else if (Height == 0) {
                neighbors[0] = dm.particleCurrent[Width - 1][Height];
                neighbors[1] = dm.particleCurrent[Width][dm.height - 1];
                neighbors[2] = dm.particleCurrent[Width + 1][Height];
                neighbors[3] = dm.particleCurrent[Width][Height + 1];
            } else if (Height == dm.height - 1) {
                neighbors[0] = dm.particleCurrent[Width - 1][Height];
                neighbors[1] = dm.particleCurrent[Width][Height - 1];
                neighbors[2] = dm.particleCurrent[Width + 1][Height];
                neighbors[3] = dm.particleCurrent[Width][0];

            } else if (Width == 0) {
                neighbors[0] = dm.particleCurrent[dm.width - 1][Height];
                neighbors[1] = dm.particleCurrent[Width][Height - 1];
                neighbors[2] = dm.particleCurrent[Width + 1][Height];
                neighbors[3] = dm.particleCurrent[Width][Height + 1];
            } else if (Width == dm.width - 1) {
                neighbors[0] = dm.particleCurrent[Width - 1][Height];
                neighbors[1] = dm.particleCurrent[Width][Height - 1];
                neighbors[2] = dm.particleCurrent[0][Height];
                neighbors[3] = dm.particleCurrent[Width][Height + 1];
            }
        }

        finally{
            return neighbors;
        }

    }

    void generateParticles() {

        Random x = new Random();
        System.out.println("Wymiary:"+dm.width+"x"+dm.height);

        for (int wi = 0; wi < dm.width; wi++) {
            for (int hi = 0; hi < dm.height; hi++) {

                if (dm.img.getRGB(wi, hi) == Color.BLACK.getRGB())
                {
                    int[] dir = new int[4];
                    for(int i=0;i<4;i++)
                    {
                        if(x.nextInt(2)==0) { dir[i]=0;}
                        else{dir[i]=1;}
                    }

                    //dir= new int[]{1, 1, 1, 1}; //TESTY
                    //dir= new int[]{1, 0, 0, 0};
                    //dir= new int[]{0, 1, 0, 0};
                    //dir= new int[]{0, 0, 1, 0};
                    //dir= new int[]{0, 0, 0, 1};
                    //dir =new int[]{0,0,0,0};

                    if(dir[0]==0&&dir[1]==0&&dir[2]==0&&dir[3]==0)
                    {
                        dir[x.nextInt(4)]=1;
                    }
                    for(int i=0;i<4;i++) {
                        iloscCzasteczek = iloscCzasteczek+dir[i];  //Obliczanie ilosci cząsteczek
                    }
                        dm.particleLast[wi][hi] = new Cell(true,dir);
                }

                else if (dm.img.getRGB(wi,hi)==Color.WHITE.getRGB())
                {
                    dm.particleLast[wi][hi] = new Cell(true, blank);
                }

                else if(dm.img.getRGB(wi,hi)==Color.RED.getRGB())
                {
                 dm.particleLast[wi][hi]=new Cell(true,false, alldir);
                }

                else {
                    dm.particleLast[wi][hi] = new Cell(false, blank);
                }
            }
        }

        System.out.println("Ilość cząsteczek="+iloscCzasteczek);

        for (int wi = 0; wi < dm.width; wi++) {
            for (int hi = 0; hi < dm.height; hi++) {

                if(dm.particleLast[wi][hi].isParticle==true)
                {
                    dm.particleCurrent[wi][hi] = new Cell(true, blank);
                }
                else if(dm.particleLast[wi][hi].isSource==true)
                {
                    dm.particleCurrent[wi][hi]=new Cell(true,false, alldir);
                }
                else{dm.particleCurrent[wi][hi] = new Cell(false, blank);}

                /*for(int i=0;i<4;i++) {
                    //String tmp = Integer.toString(dm.particleLast[wi][hi].directions[i]);
                    dm.particleCurrent[wi][hi].directions[i]=dm.particleLast[wi][hi].directions[i];//Integer.parseInt(tmp);
                }*/

            }
        }
    } //Generowanie cząsteczek i przeszkód na podstawie obrazka

    void animateLGA() { //Animowanie
        do {
            dm.iteracje++;
            for (int wi = 0; wi < dm.width; wi++) {
                for (int hi = 0; hi < dm.height; hi++) {

                    if(dm.particleLast[wi][hi].isParticle==true)
                    {
                        dm.particleCurrent[wi][hi] = new Cell(true, blank);
                    }
                    else if(dm.particleLast[wi][hi].isSource==true)
                    {
                        dm.particleCurrent[wi][hi]=new Cell(true,false, alldir);
                    }
                    else{dm.particleCurrent[wi][hi] = new Cell(false, blank);}
                }
            }

            for (int wi = 0; wi < dm.width; wi++) {
                for (int hi = 0; hi < dm.height; hi++) {

                        ////Streaming

                    if (dm.particleLast[wi][hi].isParticle == true)
                    {

                           Cell[] localNeighbor = getNeighbors(wi, hi);

                            if (localNeighbor[0].directions[2] == 1) {
                                    dm.particleCurrent[wi][hi].directions[2] = 1;
                            }
                            if (localNeighbor[1].directions[3] == 1) {
                                    dm.particleCurrent[wi][hi].directions[3] = 1;
                            }
                            if (localNeighbor[2].directions[0] == 1) {
                                    dm.particleCurrent[wi][hi].directions[0] = 1;
                            }
                            if (localNeighbor[3].directions[1] == 1) {
                                    dm.particleCurrent[wi][hi].directions[1] = 1;
                            }
                    }
                }
            }

            for (int wi = 0; wi < dm.width; wi++) {
                for (int hi = 0; hi < dm.height; hi++) {
                    if (dm.particleLast[wi][hi].isParticle == true) {

                        // Kolizja

                 if (dm.particleCurrent[wi][hi].directions[0] == 1 && dm.particleCurrent[wi][hi].directions[1] == 0 && dm.particleCurrent[wi][hi].directions[2] ==1 && dm.particleCurrent[wi][hi].directions[3] ==0 )
                            {
                                dm.particleCurrent[wi][hi].directions[0] = 0;
                                dm.particleCurrent[wi][hi].directions[2] =0;

                                dm.particleCurrent[wi][hi].directions[1] = 1 ;
                                dm.particleCurrent[wi][hi].directions[3] = 1 ;
                            }

                else if (dm.particleCurrent[wi][hi].directions[0] == 0 && dm.particleCurrent[wi][hi].directions[1] == 1 && dm.particleCurrent[wi][hi].directions[2] == 0 && dm.particleCurrent[wi][hi].directions[3] == 1)
                            {
                                dm.particleCurrent[wi][hi].directions[1] = 0;
                                dm.particleCurrent[wi][hi].directions[3] = 0;

                                dm.particleCurrent[wi][hi].directions[0] = 1 ;
                                dm.particleCurrent[wi][hi].directions[2] = 1 ;
                            }
                    }

                    //Reakcja na przeszkody

                    if (getNeighbors(wi,hi)[0].isParticle==false&&dm.particleCurrent[wi][hi].directions[0]==1){dm.particleCurrent[wi][hi].directions[0]=0;dm.particleCurrent[wi][hi].directions[2]=1;}
                    if (getNeighbors(wi,hi)[1].isParticle==false&&dm.particleCurrent[wi][hi].directions[1]==1){dm.particleCurrent[wi][hi].directions[1]=0;dm.particleCurrent[wi][hi].directions[3]=1;}
                    if (getNeighbors(wi,hi)[2].isParticle==false&&dm.particleCurrent[wi][hi].directions[2]==1){dm.particleCurrent[wi][hi].directions[2]=0;dm.particleCurrent[wi][hi].directions[0]=1;}
                    if (getNeighbors(wi,hi)[3].isParticle==false&&dm.particleCurrent[wi][hi].directions[3]==1){dm.particleCurrent[wi][hi].directions[3]=0;dm.particleCurrent[wi][hi].directions[1]=1;}

                }
            }


            for (int x = 0; x < dm.width; x++) {
                for (int z = 0; z < dm.height; z++) {
                        if(dm.particleLast[x][z].isParticle==true) {
                            for (int i = 0; i < 4; i++) {
                                // String tmp = Integer.toString(dm.particleCurrent[x][z].directions[i]);
                                dm.particleLast[x][z].directions[i] = dm.particleCurrent[x][z].directions[i];//Integer.parseInt(tmp);
                            }
                            int suma = dm.particleLast[x][z].directions[0] + dm.particleLast[x][z].directions[1] + dm.particleLast[x][z].directions[2] + dm.particleLast[x][z].directions[3];

                            //System.out.println(suma);

                            if (suma == 0) {
                                dm.img.setRGB(x, z, Color.WHITE.getRGB());
                            } else if (suma == 1) {
                                dm.img.setRGB(x, z, Color.LIGHT_GRAY.getRGB());
                            } else if (suma == 2) {
                                dm.img.setRGB(x, z, Color.GRAY.getRGB());
                            } else if (suma == 3) {
                                dm.img.setRGB(x, z, Color.DARK_GRAY.getRGB());
                            } else if (suma == 4) {
                                dm.img.setRGB(x, z, Color.BLACK.getRGB());
                            }
                            //else{dm.img.setRGB(x, z, Color.BLACK.getRGB()); }

                        }
                }
            }
        } while (true) ;
    }

    void showIteration() {
        System.out.println("Obecna iteracja:"+dm.iteracje);
        int iloscTeraz=0;

        for (int wi = 0; wi < dm.width; wi++) {
            for (int hi = 0; hi < dm.height; hi++) {
                for (int i = 0; i < 4; i++) {
                    iloscTeraz = iloscTeraz + dm.particleLast[wi][hi].directions[i];  //Obliczanie ilosci cząsteczek
                }
            }
        }
        System.out.println("Ilość cząsteczek teraz:"+iloscTeraz);
    }

    void Initial() {
        for (int wi = 0; wi < dm.width; wi++) {
            for (int hi = 0; hi < dm.height; hi++) {
                Random random=new Random();
                int randomInteger = random.nextInt(100);

                if (randomInteger < 10) {
                    dm.img.setRGB(wi, hi,Color.BLACK.getRGB());
                } else {
                    dm.img.setRGB(wi, hi,Color.WHITE.getRGB());
                }
            }
        }

    }
}