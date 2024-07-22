import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    public void testFirstPlayerWins() {
        Player andrey = new Player(1, "Андрей", 1500);
        Player sergey = new Player(2, "Сергей", 1000);
        Game game = new Game();
        game.register(andrey);
        game.register(sergey);
        int actual = game.round("Андрей", "Сергей");
        int expected = 1;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSecondPlayerWins() {
        Player sergey = new Player(123, "Сергей", 1500);
        Player andrey = new Player(12413554, "Андрей", 1000);
        Game game = new Game();
        game.register(sergey);
        game.register(andrey);
        int actual = game.round("Андрей", "Сергей");
        int expected = 2;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testStrengthIsEqual() {
        Player andrey = new Player(1, "Андрей", 1000);
        Player sergey = new Player(2, "Сергей", 1000);
        Game game = new Game();
        game.register(andrey);
        game.register(sergey);
        int actual = game.round("Андрей", "Сергей");
        int expected = 0;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testFirstPlayerDoesntExist() {
        Player andrey = new Player(1, "Андрей", 1000);
        Game game = new Game();
        game.register(andrey);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Николай", "Андрей")

        );
    }

    @Test
    public void testSecondPlayerDoesntExist() {
        Player andrey = new Player(1, "Андрей", 1000);
        Game game = new Game();
        game.register(andrey);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Андрей", "Николай")

        );
    }

}
