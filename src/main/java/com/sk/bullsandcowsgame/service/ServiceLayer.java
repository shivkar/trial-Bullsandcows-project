/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sk.bullsandcowsgame.service;

import com.sk.bullsandcowsgame.model.Game;
import com.sk.bullsandcowsgame.model.Round;
import java.util.List;

/**
 *
 * @author SHIVALI
 */
public interface ServiceLayer {

    List<Game> getAllGames();

    List<Round> getAllRoundsByGameId(int gameId);

    Round makeGuess(Round round);

    Game getGameById(int gameId);

    Game addGame(Game game);
    
    int newGame() ;

    String generateAnswer();

    String calculateResult(String guess, String answer);
}
