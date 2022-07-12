/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sk.bullsandcowsgame.service;

import com.sk.bullsandcowsgame.data.GameDao;
import com.sk.bullsandcowsgame.data.RoundDao;
import com.sk.bullsandcowsgame.model.Game;
import com.sk.bullsandcowsgame.model.Round;
import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author SHIVALI
 */
@Service
public class ServiceLayerImpl implements ServiceLayer {

    @Autowired
    GameDao gameDao;

    @Autowired
    RoundDao roundDao;

    @Override
    public List<Game> getAllGames() {

        List<Game> games = gameDao.getAllGames();
        for (Game game : games) {
            if (!game.isFinished()) {
                game.setAnswer("****");
            }
        }

        return games;
    }

    @Override
    public List<Round> getAllRoundsByGameId(int gameId) {
        return roundDao.getAllRoundsByGameId(gameId);
    }

    @Override
    public Round makeGuess(Round round) {
        String answer = gameDao.getGameById(round.getGameId()).getAnswer();
        String guess = round.getGuess();
        String result = calculateResult(guess, answer);
        round.setResult(result);

        if (guess.equals(answer)) {
            Game game = getGameById(round.getGameId());
            game.setFinished(true);
            gameDao.updateGame(game);
        }

        return roundDao.addRound(round);
    }

    @Override
    public Game getGameById(int gameId) {

        Game game = gameDao.getGameById(gameId);
        if (!game.isFinished()) {
            game.setAnswer("****");
        }

        return game;

    }

    @Override
    public Game addGame(Game game) {
        return gameDao.addGame(game);
    }
    @Override
    public int newGame() {
        Game game = new Game();
        game.setAnswer(generateAnswer());
        game = gameDao.addGame(game);

        return game.getGameId();
    }

    @Override
    public String generateAnswer() {
        Random rnd = new Random();
        int digit1 = rnd.nextInt(10);

        int digit2 = rnd.nextInt(10);
        while (digit2 == digit1) {
            digit2 = rnd.nextInt(10);
        }

        int digit3 = rnd.nextInt(10);
        while (digit3 == digit2 || digit3 == digit1) {
            digit3 = rnd.nextInt(10);
        }

        int digit4 = rnd.nextInt(10);
        while (digit4 == digit3 || digit4 == digit2 || digit4 == digit1) {
            digit4 = rnd.nextInt(10);
        }

        String answer = String.valueOf(digit1) + String.valueOf(digit2)
                + String.valueOf(digit3) + String.valueOf(digit4);

        return answer;
    }

    @Override
    public String calculateResult(String guess, String answer) {
        char[] guessChars = guess.toCharArray();
        char[] answerChars = answer.toCharArray();
        int exact = 0;
        int partial = 0;

        for (int i = 0; i < guessChars.length; i++) {
            // -1 indicates that index value of guessChars DNE in answer
            // otherwise the number must be in the string. Then check where
            if (answer.indexOf(guessChars[i]) > -1) {
                if (guessChars[i] == answerChars[i]) {
                    exact++;
                } else {
                    partial++;
                }
            }
        }

        String result = "e:" + exact + ":p:" + partial;

        return result;
    }

}
