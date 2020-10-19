package technopark.andruxa.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.number_fragment.*
import technopark.andruxa.R

class NumberFragment : Fragment() {

    companion object {
        private val NUMBER_KEY = "number"
        private val COLOR_KEY = "color"
        fun newInstance(number: String, color: Int): NumberFragment {
            val fragment = NumberFragment()
            val bundle = Bundle()
            bundle.putString(NUMBER_KEY, number)
            bundle.putInt(COLOR_KEY, color)
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(getLogTag(), "onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(getLogTag(), "onCreate")

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(getLogTag(), "onCreateView")
        return inflater.inflate(R.layout.number_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d(getLogTag(), "onActivityCreated")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(getLogTag(), "onViewCreated")
        if (arguments != null) {
            big_number.text = arguments!!.getString(NUMBER_KEY).toString()
            big_number.setTextColor(arguments!!.getInt(COLOR_KEY))
        }
        if (savedInstanceState?.getString(NUMBER_KEY) != null) {
            big_number.text = savedInstanceState.getString(NUMBER_KEY).toString()
        }
        if (savedInstanceState?.getInt(COLOR_KEY) != null) {
            big_number.setTextColor(savedInstanceState.getInt(COLOR_KEY))
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(getLogTag(), "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(getLogTag(), "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(getLogTag(), "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(getLogTag(), "onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(getLogTag(), "onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(getLogTag(), "onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d(getLogTag(), "onDetach")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d(getLogTag(), "onSaveInstanceState")
        outState.putString(NUMBER_KEY, big_number.text as String?)
        outState.putInt(COLOR_KEY, big_number.currentTextColor)
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        Log.d(getLogTag(), "onViewStateRestored")
    }

    private fun getLogTag(): String? {
        return javaClass.simpleName
    }
}