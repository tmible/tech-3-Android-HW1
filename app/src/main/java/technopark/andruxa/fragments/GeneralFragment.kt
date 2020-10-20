package technopark.andruxa.fragments

import android.content.res.Configuration
import android.os.Bundle
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

    private var numbersSize: Int? = null

    companion object {
        private const val RANGE_KEY: String = "range"
        private const val PORT_COLUMNS_NUMBER: Int = 3
        private const val LAND_COLUMNS_NUMBER: Int = 4
        fun newInstance(): GeneralFragment = GeneralFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.general_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        this.numbersSize = savedInstanceState?.getInt(RANGE_KEY)
        if (this.numbersSize == null) {
            this.numbersSize = (activity as MainActivity).savedRange
        }
        val defaultAmount: Int =
            if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
                LAND_COLUMNS_NUMBER
            } else {
                PORT_COLUMNS_NUMBER
            }
        numbersRV.layoutManager = GridLayoutManager(activity, defaultAmount)
        val numbers: MutableList<Int> = mutableListOf()
        this.numbersSize?.let { for (i in 1..it) numbers.add(i) }
        if (numbers.size == 0) {
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

    override fun onDestroyView() {
        super.onDestroyView()
        (activity as MainActivity).savedRange = this.numbersSize
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        this.numbersSize?.let { outState.putInt(RANGE_KEY, it) }
    }

    override fun onCellClickListener(number: String, color: Int) {
        fragmentManager
            ?.beginTransaction()
            ?.replace(R.id.fragment_container, NumberFragment.newInstance(number, color))
            ?.addToBackStack(null)
            ?.commit()
    }
}