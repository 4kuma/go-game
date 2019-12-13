package go_game;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

//Field class for represent player pawns
public class Field extends Circle {
    private int player;
    private int x, y;

    //setting properties of single field  and adding listener to field
    public Field(int y, int x) {
        this.y = y;
        this.x = x;

        setRadius(30);
        setStrokeWidth(1);
        setFill(Color.TRANSPARENT);
        setStroke(Color.BLACK);
//        setOnMouseClicked(t -> GameController.getInstance().onFieldClicked(this));
    }
    int getX(){return x;}
    int getY(){return y;}
}