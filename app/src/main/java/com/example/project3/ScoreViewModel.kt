package layout

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.project3.R

var scoreBoard = listOf(
    Score(R.string.team_a_text, 0),
    Score(R.string.team_b_text, 0)
)

private const val TAG = "ScoreViewModel"
class ScoreViewModel : ViewModel(){
    init {
        Log.d(TAG, "ViewModel instance created")
    }

    override fun onCleared() {
        super.onCleared()
        Log.d(TAG, "ViewModel instance about to be destroyed")
    }

    val getAScore: Int
        get() = scoreBoard.get(0).score

    val getBScore: Int
        get() = scoreBoard.get(1).score

    fun setAScore(score : Int){
        scoreBoard.get(0).score = score
    }

    fun setBScore(score : Int){
        scoreBoard.get(1).score = score
    }

}