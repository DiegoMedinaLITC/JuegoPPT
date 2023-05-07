package com.example.piedrapapeltijeras

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var resultText: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultText = findViewById(R.id.resultText)

        val rockButton = findViewById<Button>(R.id.rockButton)
        val paperButton = findViewById<Button>(R.id.paperButton)
        val scissorsButton = findViewById<Button>(R.id.scissorsButton)

        rockButton.setOnClickListener(this)
        paperButton.setOnClickListener(this)
        scissorsButton.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v != null) {
            when (v.id) {
                R.id.rockButton -> play(GameMove.PIEDRA)
                R.id.paperButton -> play(GameMove.PAPEL)
                R.id.scissorsButton -> play(GameMove.TIJERAS)
            }
        }
    }

    private fun play(playerMove: GameMove) {
        val computerMove = GameMove.randomMove()
        val result = playerMove.playAgainst(computerMove)

        resultText.text = "Has elegido ${playerMove.name}, la computadora escogio ${computerMove.name}. $result"
    }
}
