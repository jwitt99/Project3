package com.example.project3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProviders
import layout.ScoreViewModel

private lateinit var endGameButton: Button
private lateinit var resetButton: Button
private lateinit var teamAThree: Button
private lateinit var teamATwo: Button
private lateinit var teamAOne: Button
private lateinit var teamBThree: Button
private lateinit var teamBTwo: Button
private lateinit var teamBOne: Button
private lateinit var teamAScore: TextView
private lateinit var teamBScore: TextView
private var scoreIncrease: Int = 0
private var score: Int = 0
private var teamName: Int = 0 //0 = a, 1 = b


private const val TAG = "MainActivity"
private const val TEAM_A_SCORE = "0"
private const val TEAM_B_SCORE = "0"


class MainActivity : AppCompatActivity() {

    private val scoreViewModel: ScoreViewModel by lazy {
        ViewModelProviders.of(this).get(ScoreViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, "onCreate(Bundle?) called")

        resetButton = findViewById(R.id.reset_button)
        endGameButton = findViewById(R.id.end_game_button)

        teamAThree = findViewById(R.id.three_point_a)
        teamATwo = findViewById(R.id.two_point_a)
        teamAOne = findViewById(R.id.free_throw_a)
        teamAScore = findViewById(R.id.team_a_score)

        teamBThree = findViewById(R.id.three_point_b)
        teamBTwo = findViewById(R.id.two_point_b)
        teamBOne = findViewById(R.id.free_throw_b)
        teamBScore = findViewById(R.id.team_b_score)


//        val savedAScoreBundle = savedInstanceState?.getInt(TEAM_A_SCORE, 0) ?: 0
        val savedBScoreBundle = savedInstanceState?.getInt(TEAM_B_SCORE, 0) ?: 0

        val savedAScore = scoreViewModel.getAScore.toString()
//        val savedBScore = scoreViewModel.getBScore.toString()

//        Log.d(TAG, "A's score when turned from bundle : $savedAScoreBundle")
        Log.d(TAG, "A's score when turned from viewLayout: $savedAScore")
        Log.d(TAG, "B's score when turned from bundle: $savedBScoreBundle")


//        Log.d(TAG, "B's score when turned from viewLayout: $savedBScore")

        teamAScore.setText(savedAScore.toString())
        teamBScore.setText(savedBScoreBundle.toString())




        teamAThree.setOnClickListener { view: View ->

            teamName = 0
            scoreIncrease = 3
            updateScore()
        }


        teamATwo.setOnClickListener { view: View ->
            teamName = 0
            scoreIncrease = 2
            updateScore()
        }


        teamAOne.setOnClickListener { view: View ->
            teamName = 0
            scoreIncrease = 1
            updateScore()
        }

        teamBThree.setOnClickListener { view: View ->
            teamName = 1
            scoreIncrease = 3
            updateScore()
        }


        teamBTwo.setOnClickListener { view: View ->
            teamName = 1
            scoreIncrease = 2
            updateScore()
        }


        teamBOne.setOnClickListener { view: View ->
            teamName = 1
            scoreIncrease = 1
            updateScore()
        }

        resetButton.setOnClickListener { view: View ->
            scoreViewModel.setAScore(0)
            scoreViewModel.setBScore(0)
            teamAScore.setText("0")
            teamBScore.setText("0")
        }

        endGameButton.setOnClickListener { view: View ->
            // Start WinnerActivity
            var scoreA = scoreViewModel.getAScore
            var scoreB = scoreViewModel.getBScore
            Log.d(TAG, "A score: $scoreA")
            Log.d(TAG, "B score: $scoreB")
            var winner: String
            if(scoreA > scoreB){
                winner = "The winner is Team A!"
            }
            else if (scoreA < scoreB)
                winner = "The winner is Team B!"
            else
                winner = "The game is a tie!"
            val intent = WinnerActivity.newIntent(this@MainActivity, winner)
            startActivity(intent)
        }
    }

    override fun onSaveInstanceState(savedInstanceState: Bundle) {
        super.onSaveInstanceState(savedInstanceState)
        Log.i(TAG, "onSaveInstanceState")
        savedInstanceState.putInt(TEAM_A_SCORE, scoreViewModel.getAScore)
        savedInstanceState.putInt(TEAM_B_SCORE, scoreViewModel.getBScore)

    }

    private fun updateScore (){

        if(teamName == 0) {
            score = scoreViewModel.getAScore
            score += scoreIncrease
            teamAScore.setText(score.toString())
            scoreViewModel.setAScore(score)
        }
        else {
            score = scoreViewModel.getBScore
            score += scoreIncrease
            teamBScore.setText(score.toString())
            scoreViewModel.setBScore(score)

        }
    }
}