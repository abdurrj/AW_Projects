public class Ghost {
    public Position position;

    public Ghost(Position position){
        this.position = position;
    }

    public int getX(){
        return position.getX();
    }

    public int getY(){
        return position.getY();
    }
}
