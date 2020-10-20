package technopark.andruxa

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import technopark.andruxa.fragments.GeneralFragment

class MainActivity : AppCompatActivity() {

    var savedRange: Int? = null

    companion object {
        private const val SAVED_RANGE_KEY: String = "saved_range"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (supportFragmentManager.findFragmentById(R.id.fragment_container) == null) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container, GeneralFragment.newInstance())
                .commit()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        this.savedRange?.let { outState.putInt(SAVED_RANGE_KEY, it) }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        this.savedRange = savedInstanceState.getInt(SAVED_RANGE_KEY)
    }
}