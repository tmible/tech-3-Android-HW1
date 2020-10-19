package technopark.andruxa

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NumbersRVViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val number: TextView = itemView.findViewById(R.id.number)
}