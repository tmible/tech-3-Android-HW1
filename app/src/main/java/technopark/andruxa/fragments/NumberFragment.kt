package technopark.andruxa.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.number_fragment.*
import technopark.andruxa.R

class NumberFragment : Fragment() {

    companion object {
        private const val NUMBER_KEY = "number"
        private const val COLOR_KEY = "color"
        fun newInstance(number: String, color: Int): NumberFragment {
            val fragment = NumberFragment()
            val bundle = Bundle()
            bundle.putString(NUMBER_KEY, number)
            bundle.putInt(COLOR_KEY, color)
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.number_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(NUMBER_KEY, big_number.text as String?)
        outState.putInt(COLOR_KEY, big_number.currentTextColor)
    }
}