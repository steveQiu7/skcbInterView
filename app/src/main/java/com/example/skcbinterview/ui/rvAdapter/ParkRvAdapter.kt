package com.example.skcbinterview.ui.rvAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.skcbinterview.data.model.DataMuseumIntroduction
import com.example.skcbinterview.databinding.ItemParkBinding
import com.example.skcbinterview.ui.MainViewModel

class ParkRvAdapter(private val viewModel: MainViewModel) : RecyclerView.Adapter<ParkRvAdapter.ViewHolder>() {

    var list: List<DataMuseumIntroduction.DataMuseumIntroductionInfo>? = viewModel.listParkInfo.value

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list?.get(position)
        item?.let { holder.bind(viewModel,it) }
    }

    override fun getItemCount(): Int {
        return list?.size ?: 0
    }

    class ViewHolder private constructor(private val binding: ItemParkBinding) : RecyclerView.ViewHolder(binding.root) {

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemParkBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }

        fun bind(viewModel: MainViewModel, item: DataMuseumIntroduction.DataMuseumIntroductionInfo) {
            binding.viewModel = viewModel
            binding.dataMuseumIntroductionInfo = item
            binding.executePendingBindings()
        }
    }

}