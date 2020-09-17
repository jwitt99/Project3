package layout

import androidx.annotation.StringRes

data class Score(@StringRes val textResId: Int = 0, var score: Int = 0)