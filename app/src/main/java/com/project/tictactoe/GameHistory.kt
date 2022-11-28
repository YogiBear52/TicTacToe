package com.project.tictactoe


public class  GameHistory {
    companion object {
        val Game = GameHistory();
    }

    val gameScores = arrayOfNulls<GameScore>(10);
    var currentIndex = 0;

    fun addScore(score: GameScore) {
        this.gameScores[this.currentIndex] = score;

        this.currentIndex++;
        if (currentIndex == 10){
            currentIndex = 0;
        }
    }

    fun getOrderdScoreList(): List<GameScore>{
        return this.gameScores.filterNotNull().sortedBy { it.gameDuration }
    }
}

public class GameScore {
    val firstPlayerName: String
    val secondPlayerName: String
    val winner : String
    val gameDuration: Long;

    constructor(firstName: String, secondName: String,winner:Int, duration: Long){
        this.firstPlayerName = firstName
        this.secondPlayerName = secondName
        this.gameDuration = duration
        if (winner == 0){
            this.winner = this.firstPlayerName
        }
        else{
            this.winner = this.secondPlayerName
        }
    }
}