public class Cell {

    boolean isParticle;
    boolean isSource;
    int[] directions;


    public Cell(boolean isParticle, int[] directions) {
        this.isParticle = isParticle;
        this.directions = new int [4];

        for(int i=0;i<4;i++) {
            this.directions[i]=directions[i];
        }
    }

    public Cell(boolean isSource, boolean isParticle, int[] directions) {
        this.isSource = isSource;
        this.isParticle=isParticle;
        this.directions = new int [4];

        for(int i=0;i<4;i++) {
            this.directions[i]=directions[i];
        }
    }

}
