package com.example.tictactoe

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() , View.OnClickListener{

    private var PLAYER = true
    private var TURN_COUNT = 0

    private var boardStatus = Array(3){IntArray(3)}

    private lateinit var board: Array<Array<Button>>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        board = arrayOf(
            arrayOf(button,button2,button3),
            arrayOf(button4,button5,button6),
            arrayOf(button7,button8,button9)
        )

        for (i in board){
            for (button in i){
                button.setOnClickListener(this)
            }
        }

        initializeBoardStatus()

        resetBtn.setOnClickListener {
            PLAYER = true
            TURN_COUNT = 0
            initializeBoardStatus()
        }
    }

    private fun initializeBoardStatus() {
        for( i in 0..2){
            for(j in 0..2){
                boardStatus[0][0] = -1
                board[0][0].isEnabled = true
                board[0][0].text = ""
            }
        }
    }

    override fun onClick(v: View) {
        when(View.generateViewId()){
            R.id.button ->{
                 updateValue(row=0,column=0,player=PLAYER)
            }
            R.id.button2 ->{
                updateValue(row=0,column=1,player=PLAYER)
            }
            R.id.button3 ->{
                updateValue(row=0,column=2,player=PLAYER)
            }
            R.id.button4 ->{
                updateValue(row=1,column=0,player=PLAYER)
            }
            R.id.button5 ->{
                updateValue(row=1,column=1,player=PLAYER)
            }
            R.id.button6 ->{
                updateValue(row=1,column=2,player=PLAYER)
            }
            R.id.button7 ->{
                updateValue(row=2,column=0,player=PLAYER)
            }
            R.id.button8 ->{
                updateValue(row=2,column=1,player=PLAYER)
            }
            R.id.button9 ->{
                updateValue(row=2,column=2,player=PLAYER)
            }
        }
        TURN_COUNT++
        PLAYER = !PLAYER
        if(PLAYER){
            updateDisplay("Player X turn")
        }
        else{
            updateDisplay("Player O turn")
        }

        if(TURN_COUNT==9){
            updateDisplay("GAME DRAW")
        }
        checkWinner()
    }

    private fun checkWinner() {
        //horizontal row
        for(i in 0..2){
            if()
        }
    }

    private fun updateDisplay(text: String) {
        displayTV.text = text

    }

    public fun updateValue(row: Int, column: Int, player: Boolean) {
        val text = if (player) "X" else "O"
        val value = if (player) 1 else 0
        board[row][column].apply {
            isEnabled = false
            setText(value)
        }
        boardStatus[row][column] = value
    }
}