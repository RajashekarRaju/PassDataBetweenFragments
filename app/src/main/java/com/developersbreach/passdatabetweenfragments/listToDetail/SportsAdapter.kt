package com.developersbreach.passdatabetweenfragments.listToDetail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.developersbreach.passdatabetweenfragments.R


class SportsAdapter(
    private val sportsList: List<Sports>,
    private val onClickListener: OnClickListener
) :
    ListAdapter<Sports, SportsAdapter.SportsViewHolder>(
        DiffCallback
    ) {

    class SportsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView: TextView = itemView.findViewById(R.id.item_name_text_view)
        private val yearTextView: TextView = itemView.findViewById(R.id.item_year_text_view)

        fun bind(
            sports: Sports,
            onClickListener: OnClickListener
        ) {
            nameTextView.text = sports.name
            yearTextView.text = sports.year
            itemView.setOnClickListener{
                onClickListener.onClick(sports)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SportsViewHolder {
        return SportsViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_list,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: SportsViewHolder, position: Int) {
        val sports: Sports = sportsList[position]
        holder.bind(sports, onClickListener)
    }

    override fun getItemCount() = sportsList.size

    class OnClickListener(val clickListener: (sports: Sports) -> Unit) {
        fun onClick(sports: Sports) = clickListener(sports)
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Sports>() {
        override fun areItemsTheSame(oldItem: Sports, newItem: Sports): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Sports, newItem: Sports): Boolean {
            return oldItem.name == newItem.name
        }
    }
}