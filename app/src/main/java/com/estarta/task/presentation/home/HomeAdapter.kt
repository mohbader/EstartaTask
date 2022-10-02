package com.estarta.task.presentation.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.estarta.task.data.model.Item
import com.estarta.task.databinding.RowItemsLayoutBinding

class HomeAdapter(
    private val itemsList: List<Item>, val onItemClick: (item: Item) -> Unit
) : RecyclerView.Adapter<HomeAdapter.ViewHolder>() {

    private lateinit var layoutInflater: LayoutInflater

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        layoutInflater = LayoutInflater.from(recyclerView.context)
    }

    inner class ViewHolder(private val binding: RowItemsLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.item = itemsList[position]
            itemView.setOnClickListener {
                onItemClick(itemsList[position])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(RowItemsLayoutBinding.inflate(layoutInflater, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return itemsList.size
    }
}