import javafx.geometry.Pos;

import java.nio.channels.Pipe;

public class Posicion {

    private int x;
    private int y;


    public Posicion(int x, int y){

        this.setX(x);
        this.setY(y);

    }

    public boolean equals(Posicion p){

        if(this.getX() == p.getX() && this.getY() == p.getY())
            return true;
        else return false;
    }

    public Posicion get(){

        return this;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;

    }

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }

    public String toString(){

        String resul= " ";

        resul = resul + this.getX() +this.getY();

        return resul;
    }
}
