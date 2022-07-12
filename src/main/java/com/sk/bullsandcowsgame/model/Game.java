/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sk.bullsandcowsgame.model;

/**
 *
 * @author SHIVALI
 */
public class Game {

    private int gameId;
    private String answer;
    private boolean finished;
    
    public Game() {
    }

    public Game(String Answer, boolean finished) {
        this.answer = Answer;
        this.finished = finished;
}

    public Game(int gameId, String answer, boolean finished) {
        this.gameId = gameId;
        this.answer = answer;
        this.finished = finished;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }
    
    
}