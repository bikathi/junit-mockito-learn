package npc.martin.learn.ch1;

import npc.martin.learn.entity.Player;
import npc.martin.learn.entity.PlayerStatistics;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerStatisticsTest {
    @Test
    public void playerNameEqual() {
        Player player1 = new Player("Martin", 27);
        Player player2 = new Player("Martin", 25);

        // test whether two things are equals as per objects .equals method
        // first string argument is a description and is optional
        assertEquals("Players not equal with same name", player1, player2);
    }

    @Test
    public void playerNamesNotEqual() {
        Player player1 = new Player("Martin", 27);
        Player player2 = new Player("Patrick", 25);

        // test whether two things are not equals as per the objects .equals method
        assertNotEquals(player1, player2);
    }

    @Test
    public void youngerPlayerSame() {
        Player player1 = new Player("Martin", 27);
        Player player2 = new Player("Martin", 25);

        // test two objects are identical/ different as per MEMORY LOCATION
        assertSame(player1, PlayerStatistics.getYoungerPlayer(player1, player2));
    }

    @Test
    public void underThirtyTrue() {
        Player player1 = new Player("Patrick", 27);
        PlayerStatistics playerStatistics = new PlayerStatistics(player1, 3, 3);

        // test whether something returns true
        assertTrue(playerStatistics.underThirty());
    }

    @Test
    public void underThirtyFalse() {
        Player player1 = new Player("Patrick", 37);
        PlayerStatistics playerStatistics = new PlayerStatistics(player1, 3, 3);

        // test whether something returns false
        assertFalse(playerStatistics.underThirty());

        // we can also use assertEquals as a direct replacement for assertTrue and assertFalse
        // use the latter for more readability
        assertEquals(false, playerStatistics.underThirty());
    }

    @Test
    public void csvReportNull() {
        Player player1 = new Player("Patrick", 27);
        PlayerStatistics playerStatistics = new PlayerStatistics(player1, 0, 0);

        // test whether an object is null
        assertNull(playerStatistics.createCsvRecord());
    }

    @Test
    public void csvReportNotNull() {
        Player player1 = new Player("Patrick", 27);
        PlayerStatistics playerStatistics = new PlayerStatistics(player1, 3, 3);

        // test whether an object is not null - meaning object is present
        assertNotNull(playerStatistics.createCsvRecord());
    }

    @Test
    public void getCsvStatsRecord() {
        Player player1 = new Player("Patrick", 27);
        PlayerStatistics playerStatistics = new PlayerStatistics(player1, 4, 8);
        Double[] expectedArray = { 2d, 0.5 };

        // test on the contents of an array
        assertArrayEquals(expectedArray, playerStatistics.createCsvRecord());
    }
}
