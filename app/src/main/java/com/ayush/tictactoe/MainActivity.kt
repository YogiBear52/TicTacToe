package com.ayush.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import com.ayush.tictactoe.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var player=1

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val boardstatus = Array(3){IntArray(3) {-1} }

        val board = arrayOf(
                arrayOf(binding.btn11, binding.btn12, binding.btn13),
                arrayOf(binding.btn21, binding.btn22, binding.btn23),
                arrayOf(binding.btn31, binding.btn32, binding.btn33)
        )

        board[0][0].setOnClickListener {
            binding.btn11.isEnabled=false
            if(player==1){binding.btn11.setImageResource(R.drawable.tilex)
            player=1-player
                boardstatus[0][0]=1}
            else{
                binding.btn11.setImageResource(R.drawable.tileo)
                player=1-player
                boardstatus[0][0]=0
            }
            checkIfThereIsAWinner(boardstatus,board,player,binding.msgtext)
        }
        board[0][1].setOnClickListener {
            binding.btn12.isEnabled=false
            if(player==1){binding.btn12.setImageResource(R.drawable.tilex)
                player=1-player
                boardstatus[0][1]=1}
            else{
                binding.btn12.setImageResource(R.drawable.tileo)
                player=1-player
                boardstatus[0][1]=0
            }
            checkIfThereIsAWinner(boardstatus,board,player,binding.msgtext)
        }
        board[0][2].setOnClickListener {
            binding.btn13.isEnabled=false
            if(player==1){binding.btn13.setImageResource(R.drawable.tilex)
                player=1-player
                boardstatus[0][2]=1}
            else{
                binding.btn13.setImageResource(R.drawable.tileo)
                player=1-player
                boardstatus[0][2]=0
            }
            checkIfThereIsAWinner(boardstatus,board,player,binding.msgtext)
        }
        board[1][0].setOnClickListener {
            binding.btn21.isEnabled=false
            if(player==1){binding.btn21.setImageResource(R.drawable.tilex)
                player=1-player
                boardstatus[1][0]=1}
            else{
                binding.btn21.setImageResource(R.drawable.tileo)
                player=1-player
                boardstatus[1][0]=0
            }
            checkIfThereIsAWinner(boardstatus,board,player,binding.msgtext)
        }
        board[1][1].setOnClickListener {
            binding.btn22.isEnabled=false
            if(player==1){binding.btn22.setImageResource(R.drawable.tilex)
                player=1-player
                boardstatus[1][1]=1}
            else{
                binding.btn22.setImageResource(R.drawable.tileo)
                player=1-player
                boardstatus[1][1]=0
            }
            checkIfThereIsAWinner(boardstatus,board,player,binding.msgtext)
        }
        board[1][2].setOnClickListener {
            binding.btn23.isEnabled=false
            if(player==1){binding.btn23.setImageResource(R.drawable.tilex)
                player=1-player
                boardstatus[1][2]=1}
            else{
                binding.btn23.setImageResource(R.drawable.tileo)
                player=1-player
                boardstatus[1][2]=0
            }
            checkIfThereIsAWinner(boardstatus,board,player,binding.msgtext)
        }
        board[2][0].setOnClickListener {
            binding.btn31.isEnabled=false
            if(player==1){binding.btn31.setImageResource(R.drawable.tilex)
                player=1-player
                boardstatus[2][0]=1}
            else{
                binding.btn31.setImageResource(R.drawable.tileo)
                player=1-player
                boardstatus[2][0]=0
            }
            checkIfThereIsAWinner(boardstatus,board,player,binding.msgtext)
        }
        board[2][1].setOnClickListener {
            binding.btn32.isEnabled=false
            if(player==1){binding.btn32.setImageResource(R.drawable.tilex)
                player=1-player
                boardstatus[2][1]=1}
            else{
                binding.btn32.setImageResource(R.drawable.tileo)
                player=1-player
                boardstatus[2][1]=0
            }
            checkIfThereIsAWinner(boardstatus,board,player,binding.msgtext)
        }
        board[2][2].setOnClickListener {
            binding.btn33.isEnabled=false
            if(player==1){binding.btn33.setImageResource(R.drawable.tilex)
                player=1-player
            boardstatus[2][2]=1}
            else{
                binding.btn33.setImageResource(R.drawable.tileo)
                player=1-player
                boardstatus[2][2]=0
            }
            checkIfThereIsAWinner(boardstatus,board,player,binding.msgtext)
        }

        binding.resetbtn.setOnClickListener {
            resetFun(board,boardstatus)
        }

    }
    fun checkIfThereIsAWinner(boardstates: Array<IntArray>, board: Array<Array<ImageButton>>, Player: Int, msgtext: TextView){
        //top row
        if(boardstates[0][0]==boardstates[0][1] && boardstates[0][1]==boardstates[0][2] && boardstates[0][0]!=-1){
            freezeButtons(board)
            if(player==0){
                binding.msgtext.text = "Player 'X' is the Winner!"
            }
            else{
                binding.msgtext.text = "Player 'O' is the Winner!"
            }

        }
        //middle row
        else if(boardstates[1][0]==boardstates[1][1] && boardstates[1][1]==boardstates[1][2] && boardstates[1][0]!=-1){
            freezeButtons(board)
            if(player==0){
                binding.msgtext.text = "Player X is the Winner!"
            }
            else{
                binding.msgtext.text = "Player O is the Winner!"
            }
        }
        //last row
        else if(boardstates[2][0]==boardstates[2][1] && boardstates[2][1]==boardstates[2][2] && boardstates[2][0]!=-1){
            freezeButtons(board)
            if(player==0){
                binding.msgtext.text = "Player X is the Winner!"
            }
            else{
                binding.msgtext.text = "Player O is the Winner!"
            }
        }
        //first col
        else if(boardstates[0][0]==boardstates[1][0] && boardstates[1][0]==boardstates[2][0] && boardstates[0][0]!=-1){
            freezeButtons(board)
            if(player==0){
                binding.msgtext.text = "Player X is the Winner!"
            }
            else{
                binding.msgtext.text = "Player O is the Winner!"
            }
        }
        //second col
        else if(boardstates[0][1]==boardstates[1][1] && boardstates[1][1]==boardstates[2][1] && boardstates[0][1]!=-1){
            freezeButtons(board)
            if(player==0){
                binding.msgtext.text = "Player X is the Winner!"
            }
            else{
                binding.msgtext.text = "Player O is the Winner!"
            }
        }
        //third col
        else if(boardstates[0][2]==boardstates[1][2] && boardstates[1][2]==boardstates[2][2] && boardstates[0][2]!=-1){
            freezeButtons(board)
            if(player==0){
                binding.msgtext.text = "Player X is the Winner!"
            }
            else{
                binding.msgtext.text = "Player O is the Winner!"
            }
        }
        //primary diagonal
        else if(boardstates[0][0]==boardstates[1][1] && boardstates[1][1]==boardstates[2][2] && boardstates[0][0]!=-1){
            freezeButtons(board)
            if(player==0){
                binding.msgtext.text = "Player X is the Winner!"
            }
            else{
                binding.msgtext.text = "Player O is the Winner!"
            }
        }
        //secondary diagonal
        else if(boardstates[2][0]==boardstates[1][1] && boardstates[1][1]==boardstates[0][2] && boardstates[2][0]!=-1){
            freezeButtons(board)
            if(player==0){
                binding.msgtext.text = "Player X is the Winner!"
            }
            else{
                binding.msgtext.text = "Player O is the Winner!"
            }
        }
        else{
            if(player==1){
                binding.msgtext.text = "Player X's turn"
            }
            else{
                binding.msgtext.text = "Player O's turn"
            }
        }
    }
    fun freezeButtons(board: Array<Array<ImageButton>>){
        for (i in 0 until 3 step 1){
            for (j in 0 until 3 step 1){
                board[i][j].isEnabled=false
            }
        }
    }
    fun resetFun(board: Array<Array<ImageButton>>, boardstatus: Array<IntArray>) {
        for (i in 0 until 3 step 1){
            for (j in 0 until 3 step 1){
                board[i][j].setImageResource(R.drawable.tileempty)
                boardstatus[i][j]=-1
                board[i][j].isEnabled=true
            }
        }
    }
}
