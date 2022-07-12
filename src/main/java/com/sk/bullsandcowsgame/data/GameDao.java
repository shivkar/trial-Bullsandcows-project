/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sk.bullsandcowsgame.data;

import com.sk.bullsandcowsgame.model.Game;
import java.util.List;

/**
 *
 * @author SHIVALI
 */
public interface GameDao {
    
    List<Game> getAllGames();
    Game getGameById(int gameId);
    Game addGame(Game game);
    void updateGame(Game round);
    void deleteGame(int gameId);
}
