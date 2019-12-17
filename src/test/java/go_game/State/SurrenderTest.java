package go_game.State;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class SurrenderTest {
    Surrender playerState = new Surrender();

    @Test
    void getState() {
        Assert.assertTrue(playerState instanceof Surrender);
    }

    @Test
    void play() {
        Assert.assertTrue(playerState.play() instanceof Play);
    }

    @Test
    void pass() {
        Assert.assertTrue(playerState.pass() instanceof Pass);
    }

    @Test
    void surrender() {
        Assert.assertTrue(playerState instanceof Surrender);
    }
}