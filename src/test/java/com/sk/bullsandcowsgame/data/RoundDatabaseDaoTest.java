/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sk.bullsandcowsgame.data;

import com.sk.bullsandcowsgame.model.Game;
import com.sk.bullsandcowsgame.model.Round;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 *
 * @author SHIVALI
 */

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class RoundDatabaseDaoTest {
    
     @Autowired
    RoundDao roundDao;
    
    @Autowired
    GameDao gameDao;
    
    public RoundDatabaseDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
   /*     List<Round> rounds = roundDao.getAllRoundsByGameId(int gameId);
        for (Round round : rounds) {
            roundDao.deleteRound(round.getRoundId());
        }
    */
    }
    @After
    public void tearDown() {
    }

    /**
     * Test of getAllRoundsByGameId method, of class RoundDatabaseDao.
     */
    //@Test
   // public void testGetAllRoundsByGameId() {
    //}

    
     @Test
    public void testAddGetGetAll() {
        
        int gameId = 1;
        
        Game game = new Game();
        game.setAnswer("5678");
        game.setFinished(false);
        game = gameDao.addGame(game);
        
        Round round = new Round();
        round.setGuess("1234");
        round.setResult("e:0:p:0");
        round.setGameId(gameId);
        roundDao.addRound(round);

        Round round2 = new Round();
        round2.setGuess("5678");
        round2.setResult("e:4:p:0");
        round2.setGameId(gameId);
        roundDao.addRound(round2);

        List<Round> rounds = roundDao.getAllRoundsByGameId(gameId);

        assertEquals(2, rounds.size());
        assertNotNull(round = roundDao.getRoundById(round.getRoundId()));
    }
    
}
