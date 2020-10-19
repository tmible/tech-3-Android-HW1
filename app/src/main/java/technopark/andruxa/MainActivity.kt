package technopark.andruxa

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import technopark.andruxa.fragments.GeneralFragment
import kotlin.Int as Int1


class MainActivity : AppCompatActivity() {

    private val SAVED_RANGE_KEY: String = "saved_range"
    var savedRange: Int1? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(getLogTag(), "onCreate")
        setContentView(R.layout.activity_main)
        if (supportFragmentManager.findFragmentById(R.id.fragment_container) == null) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container, GeneralFragment.newInstance())
                .commit()
        }
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onRestart() {
        super.onRestart()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d(getLogTag(), "onSaveInstanceState")
        outState.putInt(SAVED_RANGE_KEY, this.savedRange!!)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.d(getLogTag(), "onRestoreInstanceState")
        this.savedRange = savedInstanceState.getInt(SAVED_RANGE_KEY)
    }

    private fun getLogTag(): String? {
        return javaClass.simpleName
    }
}