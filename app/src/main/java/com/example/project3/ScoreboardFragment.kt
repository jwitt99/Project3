package com.example.project3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import layout.Score

class ScoreboardFragment : Fragment(){
    private lateinit var score: Score

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
    private var teamScore: Int = 0
    private var teamName: Int = 0 //0 = a, 1 = b


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        score = Score()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_scoreboard, container, false)

        resetButton = view.findViewById(R.id.reset_button) as Button
        endGameButton = view.findViewById(R.id.end_game_button) as Button

        teamAThree = view.findViewById(R.id.three_point_a) as Button
        teamATwo = view.findViewById(R.id.two_point_a) as Button
        teamAOne = view.findViewById(R.id.free_throw_a) as Button
        teamAScore = view.findViewById(R.id.team_a_score) as TextView

        teamBThree = view.findViewById(R.id.three_point_b) as Button
        teamBTwo = view.findViewById(R.id.two_point_b) as Button
        teamBOne = view.findViewById(R.id.free_throw_b) as Button
        teamBScore = view.findViewById(R.id.team_b_score) as TextView

        return view
    }

    override fun onStart() {
        super.onStart()

        teamAThree.apply{
            setOnClickListener { view: View ->
                teamName = 0
                scoreIncrease = 3
                updateScore()
            }
        }


        teamATwo.apply {
            setOnClickListener { view: View ->
                teamName = 0
                scoreIncrease = 2
                updateScore()
            }
        }


        teamAOne.apply {
            setOnClickListener { view: View ->
                teamName = 0
                scoreIncrease = 1
                updateScore()
            }
        }

        teamBThree.apply {
            setOnClickListener { view: View ->
                teamName = 1
                scoreIncrease = 3
                updateScore()
            }
        }


        teamBTwo.apply {
            setOnClickListener { view: View ->
                teamName = 1
                scoreIncrease = 2
                updateScore()
            }
        }


        teamBOne.apply {
            setOnClickListener { view: View ->
                teamName = 1
                scoreIncrease = 1
                updateScore()
            }
        }


        resetButton.apply{
            setOnClickListener { view: View ->
                teamAScore.setText("0")
                teamBScore.setText("0")
            }
        }
        endGameButton.setOnClickListener { view: View ->
            // Start WinnerActivity
            var scoreA = Integer.parseInt(teamAScore.text as String)
            var scoreB = Integer.parseInt(teamBScore.text as String)
            var winner: String
            if(scoreA > scoreB){
                winner = "The winner is Team A!"
            }
            else if (scoreA < scoreB)
                winner = "The winner is Team B!"
            else
                winner = "The game is a tie!"
            val intent = getActivity()?.let { WinnerActivity.newIntent(it, winner) }
            startActivity(intent)
        }
    }

    private fun updateScore (){

        if(teamName == 0) {
            teamScore = Integer.parseInt(teamAScore.text as String)
            teamScore += scoreIncrease
            teamAScore.setText(teamScore.toString())
        }
        else {
            teamScore = Integer.parseInt(teamBScore.text as String)
            teamScore += scoreIncrease
            teamBScore.setText(teamScore.toString())
        }
    }
}