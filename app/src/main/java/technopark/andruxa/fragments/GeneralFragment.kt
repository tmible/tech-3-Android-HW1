package technopark.andruxa.fragments

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.general_fragment.*
import technopark.andruxa.CellClickListener
import technopark.andruxa.MainActivity
import technopark.andruxa.NumbersRVAdapter
import technopark.andruxa.R


class GeneralFragment : Fragment(), CellClickListener {

    private val RANGE_KEY: String = "range"
    var numbersSize: Int? = null

    companion object {
        fun newInstance(): GeneralFragment = GeneralFragment()
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
        return inflater.inflate(R.layout.general_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d(getLogTag(), "onActivityCreated")
        this.numbersSize = savedInstanceState?.getInt(RANGE_KEY)
        if (this.numbersSize == null) {
            Log.d(getLogTag(), (activity as MainActivity).savedRange.toString())
            this.numbersSize = (activity as MainActivity).savedRange
        }
        val defaultAmount = if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) 4 else 3
        numbersRV.layoutManager = GridLayoutManager(activity, defaultAmount)
        val numbers: ArrayList<Int> = ArrayList()
        Log.d(getLogTag(), this.numbersSize.toString())
        if (this.numbersSize != null) {
            for (i in 1..this.numbersSize!!) numbers.add(i)
        } else {
            for (i in 1..defaultAmount) numbers.add(i)
            this.numbersSize = defaultAmount
        }
        numbersRV.adapter = NumbersRVAdapter(numbers, this)
        add_number_button.setOnClickListener {
            if (numbers.size < 100) {
                numbers.add(numbers[numbers.size - 1] + 1)
                (numbersRV.adapter as NumbersRVAdapter).notifyItemInserted(numbers.size - 1)
                this.numbersSize = numbers.size
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(getLogTag(), "onViewCreated")
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
        (activity as MainActivity).savedRange = this.numbersSize
        Log.d(getLogTag(), this.numbersSize.toString())
        Log.d(getLogTag(), (activity as MainActivity).savedRange.toString())
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
        outState.putInt(RANGE_KEY, this.numbersSize!!)
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        Log.d(getLogTag(), "onViewStateRestored")
    }

    private fun getLogTag(): String? {
        return javaClass.simpleName
    }

    override fun onCellClickListener(number: String, color: Int) {
        fragmentManager
            ?.beginTransaction()
            ?.replace(R.id.fragment_container, NumberFragment.newInstance(number, color))
            ?.addToBackStack(null)
            ?.commit()
    }
}