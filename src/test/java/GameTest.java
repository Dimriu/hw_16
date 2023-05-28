import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class GameTest {
    Game gamePlayers = new Game();
    Player player1 = new Player(1, "Женя", 10);
    Player player2 = new Player(2, "Игорь", 5);
    Player player3 = new Player(3, "Костя", 12);
    Player player4 = new Player(4, "Витя", 12);


    @Test
    public void OnlyFirstPlayerRegistered() {
        gamePlayers.register(player1);
        gamePlayers.register(player2);
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            gamePlayers.round("Женя", "Яна");
        });
    }

    @Test
    public void OnlySecondPlayerRegistered() {
        gamePlayers.register(player1);
        gamePlayers.register(player2);
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            gamePlayers.round("Дима", "Женя");
        });
    }

    @Test
    public void NoRegisteredPlayers() {
        gamePlayers.register(player1);
        gamePlayers.register(player2);
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            gamePlayers.round("Яна", "Коля");
        });
    }

    @Test
    public void draw() {
        gamePlayers.register(player3);
        gamePlayers.register(player4);
        int expected = 0;
        int actual = gamePlayers.round("Костя", "Витя");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void FirstPlayerWins() {
        gamePlayers.register(player1);
        gamePlayers.register(player2);
        int expected = 1;
        int actual = gamePlayers.round("Женя", "Игорь");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void SecondPlayerWins() {
        gamePlayers.register(player2);
        gamePlayers.register(player3);
        int expected = 2;
        int actual = gamePlayers.round("Игорь", "Костя");
        Assertions.assertEquals(expected, actual);
    }
}
