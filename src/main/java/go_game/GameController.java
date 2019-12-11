package go_game;

import javafx.scene.paint.Color;

public class GameController {
    Field[][] fields;
    //    for Singleton Pattern
    private static GameController gameController = null;

    //    for Singleton Pattern
    private GameController() {

    }

    Game game = new Game(9);


    void onFieldClicked(Field field) {

        game.updateBoard(PlayerColor.BLACK, field.getY(), field.getX());
        refreshBoard(9);
    }

    void refreshBoard(int dimension){
        char[][] consoleBoard = game.getConsoleBoard();
        for(int i=0;i<dimension;i++){
            for(int k=0;k<dimension;k++){
                if(consoleBoard[i][k]=='B'){
                    fields[i][k].setFill(Color.BLACK);
                }
                if(consoleBoard[i][k]=='W'){
                    fields[i][k].setFill(Color.WHITE);
                }
            }
        }
    }

    //	Singleton Pattern
    static GameController getInstance() {
        if (gameController == null) {
            gameController = new GameController();
        }
        return gameController;
    }
    void setFields(Field[][] fields){this.fields=fields;}

}