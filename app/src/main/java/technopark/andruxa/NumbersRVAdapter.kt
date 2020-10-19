package technopark.andruxa

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class NumbersRVAdapter(
    private val numbers: MutableList<Int>,
    private val cellClickListener: CellClickListener
) : RecyclerView.Adapter<NumbersRVViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NumbersRVViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.number_cell, parent, false)
        return NumbersRVViewHolder(view)
    }

    override fun getItemCount(): Int {
        return this.numbers.size
    }

    override fun onBindViewHolder(holder: NumbersRVViewHolder, position: Int) {
        holder.number.text = this.numbers[position].toString()
        holder.number.setTextColor(if (this.numbers[position] % 2 == 0) Color.RED else Color.BLUE)
        holder.number.setOnClickListener {
            this.cellClickListener.onCellClickListener(holder.number.text as String, holder.number.currentTextColor)
        }
    }
}