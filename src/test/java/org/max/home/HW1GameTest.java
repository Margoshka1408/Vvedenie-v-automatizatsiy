package org.max.home;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
public class HW1GameTest {
    Player gamer;
    Game game;
    List<Door> doors;

    @BeforeEach
    void initDoors () {
        doors = new ArrayList<>();
    }

    @Test
    void testChangeChoiceAndLoose () {
        //given
        gamer = new Player("Игрок", true);
        doors.add(new Door(true));
        doors.add(new Door(false));
        doors.add(new Door(false));
        game = new Game(gamer, doors);
        //when
        boolean check = game.round(0).isPrize();
        //then
        Assertions.assertFalse(check);

    }

    @Test
    void testChangeChoiceAndWin () {
        //given
        gamer = new Player("Игрок", true);
        doors.add(new Door(false));
        doors.add(new Door(true));
        doors.add(new Door(false));
        game = new Game(gamer, doors);
        //when
        boolean check = game.round(0).isPrize();
        //then
        Assertions.assertTrue(check);

    }

    @Test
    void testNotChangeChoiceAndLoose () {
        //given
        gamer = new Player("Игрок", false);
        doors.add(new Door(true));
        doors.add(new Door(false));
        doors.add(new Door(false));
        game = new Game(gamer, doors);
        //when
        boolean check = game.round(0).isPrize();
        //then
        Assertions.assertTrue(check);

    }

    @Test
    void testNotChangeChoiceAndWin () {
        //given
        gamer = new Player("Игрок", false);
        doors.add(new Door(false));
        doors.add(new Door(true));
        doors.add(new Door(false));
        game = new Game(gamer, doors);
        //when
        boolean check = game.round(0).isPrize();
        //then
        Assertions.assertFalse(check);

    }

}
