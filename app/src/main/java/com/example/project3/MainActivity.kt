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

        val currentFragment =
            supportFragmentManager.findFragmentById(R.id.fragment_container)

        if (currentFragment == null) {
            val fragment = ScoreboardFragment()
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container, fragment)
                .commit()
        }
    }
}