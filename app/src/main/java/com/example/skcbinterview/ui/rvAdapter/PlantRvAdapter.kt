package com.example.skcbinterview.ui.rvAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.ViewParent
import androidx.recyclerview.widget.RecyclerView
import com.example.skcbinterview.data.model.DataPlant
import com.example.skcbinterview.databinding.ItemPlantBinding
import com.example.skcbinterview.ui.MainViewModel

class PlantRvAdapter(private val viewModel: MainViewModel) : RecyclerView.Adapter<PlantRvAdapter.ViewHolder>() {

    var list: List<DataPlant.DataPlantInfo>? = viewModel.listPlantInfo.value

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list?.get(position)
        item?.let { holder.bind(viewModel, it) }
    }

    override fun getItemCount(): Int = list?.size ?: 0

    class ViewHolder private constructor(private val binding: ItemPlantBinding) : RecyclerView.ViewHolder(binding.root) {

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemPlantBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }

        fun bind(viewModel: MainViewModel, item: DataPlant.DataPlantInfo) {
            binding.viewModel = viewModel
            binding.item = item
            binding.executePendingBindings()
        }

    }
}