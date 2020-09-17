package com.example.project3

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_winner.*

private const val winnerExtra = ""

private var winnerT = ""

private lateinit var winnerText: TextView

private const val TAG = "WinnerActivity"

class WinnerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_winner)
        winnerT = intent.getStringExtra(winnerExtra).toString()

        winnerText = findViewById(R.id.winning_team_text)

        Log.d(TAG, "Score a : $winnerT")

        winnerText.setText(winnerT)


    }

    companion object {
        fun newIntent(packageContext: Context, w: String): Intent {
            return Intent(packageContext, WinnerActivity::class.java).apply {
                putExtra(winnerExtra, w)
            }
        }
    }
}