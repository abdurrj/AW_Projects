public class Position {
    private int x;
    private int y;
    private boolean hasBeenVisited;

    public Position(int x, int y){
        setX(x);
        setY(y);
        setHasBeenVisited(false);
    }

    public void setHasBeenVisited(boolean hasBeenVisited) {
        this.hasBeenVisited = hasBeenVisited;
    }

    public boolean getHasBeenVisited(){
        return hasBeenVisited;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

}
