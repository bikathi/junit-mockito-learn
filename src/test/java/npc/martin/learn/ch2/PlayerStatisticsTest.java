package npc.martin.learn.ch2;

import npc.martin.learn.entity.Player;
import npc.martin.learn.entity.PlayerStatistics;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerStatisticsTest {
    private Player playerPatrickUnderThirty;
    private PlayerStatistics statisticsOfPatrickUnderThirty;

    // setup() will always run before each test method of this class runs
    @Before
    public void setup() {
        playerPatrickUnderThirty = new Player("Patrick", 27);
        statisticsOfPatrickUnderThirty = new PlayerStatistics(playerPatrickUnderThirty, 3, 3);
    }

    @Test
    public void playerNameEqual() {
        System.out.println("test 1");
        Player player2 = new Player("Patrick", 25);
        assertEquals("Players not equal with same name", playerPatrickUnderThirty, player2);
    }

    @Test
    public void playerNamesNotEqual() {
        System.out.println("test 2");
        Player player2 = new Player("Kalvin", 25);
        assertNotEquals(playerPatrickUnderThirty, player2);
    }

    @Test
    public void youngerPlayerSame() {
        System.out.println("test 3");
        Player player2 = new Player("Patrick", 25);
        assertSame(player2, PlayerStatistics.getYoungerPlayer(playerPatrickUnderThirty, player2));
    }

    @Test
    public void underThirtyTrue() {
        System.out.println("test 4");
        assertTrue(statisticsOfPatrickUnderThirty.underThirty());
    }

    @Test
    public void underThirtyFalse() {
        System.out.println("test 5");
        Player player1 = new Player("Patrick" ,37);
        PlayerStatistics playerStatistics = new PlayerStatistics(player1, 3, 3);
        assertFalse(playerStatistics.underThirty());
    }

    @Test
    public void csvReportNull() {
        System.out.println("test 6");
        Player player1 = new Player("Patrick", 27);
        PlayerStatistics playerStatistics = new PlayerStatistics(player1, 0, 0);
        assertNull(playerStatistics.createCsvRecord());
    }

    @Test
    public void csvReportNotNull() {
        System.out.println("test 7");
        Player player1 = new Player("Patrick", 27);
        assertNotNull(statisticsOfPatrickUnderThirty.createCsvRecord());
    }

    @Test
    public void getCsvStatsRecord() {
        System.out.println("test 8");
        Player player1 = new Player("Patrick", 27);
        PlayerStatistics playerStatistics = new PlayerStatistics(player1, 4, 8);
        Double[] expectedArray = { 2d, 0.5 };
        assertArrayEquals(expectedArray, playerStatistics.createCsvRecord());
    }
}
