package go_game.GUI;


import go_game.Factory.GameFactory;
import go_game.Factory.GameI;
import go_game.Game;
import go_game.PlayerColor;
import go_game.State.PlayerState;
import javafx.scene.paint.Color;

public class GameController {
    Field[][] fields;
    //    for Singleton Pattern
    private static GameController gameController = null;

    //    for Singleton Pattern
    private GameController() {

    }

    GameI gameI = GameFactory.getGame(9);
    Game game = gameI.createGame();


    void onFieldClicked(Field field, PlayerColor pc) throws java.lang.NullPointerException {
        game.updateBoard(pc, field.getX(), field.getY());
        refreshBoard(9);
    }

    void onPassButtonClicked() {
        game.setPlayerState(game.getPlayerState().pass());
        System.out.println(game.getPlayerState().getState());
    }
    void onSurrenderButtonClicked() {
        game.setPlayerState(game.getPlayerState().surrender());
        System.out.println(game.getPlayerState().getState());
    }


    void refreshBoard(int dimension) {
        char[][] consoleBoard = game.getConsoleBoard();
        for (int i = 0; i < dimension; i++) {
            for (int k = 0; k < dimension; k++) {
                if (consoleBoard[i][k] == 'B') {
                    fields[k][i].setFill(Color.BLACK);
                }
                if (consoleBoard[i][k] == 'W') {
                    fields[k][i].setFill(Color.WHITE);
                }
                if (consoleBoard[i][k] == '.') {
                    fields[k][i].setFill(Color.TRANSPARENT);
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

    void setFields(Field[][] fields) {
        this.fields = fields;
    }

}