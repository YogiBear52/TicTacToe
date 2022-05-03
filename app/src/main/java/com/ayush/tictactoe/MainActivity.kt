package com.ayush.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import com.ayush.tictactoe.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var player=1
    private lateinit var binding: ActivityMainBinding
    val boardstatus = Array(3){IntArray(3) {-1} }
    var boardButtons = emptyArray<Array<ImageButton>>();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        boardButtons = arrayOf(
            arrayOf(binding.btn11, binding.btn12, binding.btn13),
            arrayOf(binding.btn21, binding.btn22, binding.btn23),
            arrayOf(binding.btn31, binding.btn32, binding.btn33)
        )

        // Register onClick of each board button
        for (i in 0 until 3 step 1) {
            for (j in 0 until 3 step 1) {
                boardButtons[i][j].setOnClickListener {
                    onPress(i,j)
                }
            }
        }

        binding.resetbtn.setOnClickListener {
            resetBoardStatues(boardstatus)
        }

    }
    fun onPress(x: Int,y: Int){
        boardButtons[x][y].isEnabled=false
        if(player==1){boardButtons[x][y].setImageResource(R.drawable.tilex)
            player=1-player
            boardstatus[x][y]=1}
        else{
            boardButtons[x][y].setImageResource(R.drawable.tileo)
            player=1-player
            boardstatus[x][y]=0
        }
        if(!checkIfThereIsAWinner(boardstatus)){
            changeTurn()
        }

    }
    fun checkIfThereIsAWinner(boardstates: Array<IntArray>): Boolean{
        // different scarios of sccuess
        if(boardstates[0][0]==boardstates[0][1] && boardstates[0][1]==boardstates[0][2] && boardstates[0][0]!=-1){
            freezeButtons()
            setWinnerTexts()

        }
        else if(boardstates[1][0]==boardstates[1][1] && boardstates[1][1]==boardstates[1][2] && boardstates[1][0]!=-1){
            freezeButtons()
            setWinnerTexts()
        }
        else if(boardstates[2][0]==boardstates[2][1] && boardstates[2][1]==boardstates[2][2] && boardstates[2][0]!=-1){
            freezeButtons()
            setWinnerTexts()
        }
        else if(boardstates[0][0]==boardstates[1][0] && boardstates[1][0]==boardstates[2][0] && boardstates[0][0]!=-1){
            freezeButtons()
            setWinnerTexts()
        }
        else if(boardstates[0][1]==boardstates[1][1] && boardstates[1][1]==boardstates[2][1] && boardstates[0][1]!=-1){
            freezeButtons()
            setWinnerTexts()
        }
        else if(boardstates[0][2]==boardstates[1][2] && boardstates[1][2]==boardstates[2][2] && boardstates[0][2]!=-1){
            freezeButtons()
            setWinnerTexts()
        }
        else if(boardstates[0][0]==boardstates[1][1] && boardstates[1][1]==boardstates[2][2] && boardstates[0][0]!=-1){
            freezeButtons()
            setWinnerTexts()
        }
        else if(boardstates[2][0]==boardstates[1][1] && boardstates[1][1]==boardstates[0][2] && boardstates[2][0]!=-1){
            freezeButtons()
            setWinnerTexts()
        }
        else{
            return false;
        }
        return true;
    }

    fun changeTurn(){
        if(player==1){
            binding.msgtext.text = "Player X's turn"
        }
        else{
            binding.msgtext.text = "Player O's turn"
        }

    }

    fun setWinnerTexts(){
        if(player==0){
            binding.msgtext.text = "Player 'X' is the Winner!"
        }
        else{
            binding.msgtext.text = "Player 'O' is the Winner!"
        }
    }
    fun freezeButtons(){
        for (i in 0 until 3 step 1){
            for (j in 0 until 3 step 1){
                boardButtons[i][j].isEnabled=false
            }
        }
    }
    fun resetBoardStatues(boardstatus: Array<IntArray>) {
        for (i in 0 until 3 step 1){
            for (j in 0 until 3 step 1){
                boardstatus[i][j]=-1
                boardButtons[i][j].isEnabled=true
                boardButtons[i][j].setImageResource(R.drawable.tileempty)
            }
        }
    }
}
