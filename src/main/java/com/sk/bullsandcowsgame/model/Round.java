/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sk.bullsandcowsgame.model;

import java.time.LocalDateTime;

/**
 *
 * @author SHIVALI
 */
public class Round {
    
    private int roundId;
    private int gameId;
    private LocalDateTime guessTime;
    private String guess;
    private String result;
    public Round() {
    }

    public Round(int gameId, String guess) {
        this.gameId = gameId;
        this.guess = guess;
    }
    

    public Round(int roundId, int gameId, LocalDateTime guessTime, String guess, String result) {
        this.roundId = roundId;
        this.gameId = gameId;
        this.guessTime = guessTime;
        this.guess = guess;
        this.result = result;
    }

    public int getRoundId() {
        return roundId;
    }

    public void setRoundId(int roundId) {
        this.roundId = roundId;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public LocalDateTime getGuessTime() {
        return guessTime;
    }

    public void setGuessTime(LocalDateTime guessTime) {
        this.guessTime = guessTime;
    }

    public String getGuess() {
        return guess;
    }

    public void setGuess(String guess) {
        this.guess = guess;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
    
    
}
