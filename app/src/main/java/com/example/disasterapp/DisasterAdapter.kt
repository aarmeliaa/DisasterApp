package com.example.disasterapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.disasterapp.databinding.ItemDisasterBinding

data class Disaster (
    val nameDisaster: String="",
    val disasterType: String=""
)

class DisasterAdapter(private val listDisaster : List<Disaster>) : RecyclerView.Adapter<DisasterAdapter
    .ItemDisasterViewHolder>()  {

    inner class ItemDisasterViewHolder(private val binding: ItemDisasterBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Disaster) {
            with(binding) {
                txtDisasterName.text = data.nameDisaster
                txtDisasterType.text = data.disasterType
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            ItemDisasterViewHolder {
        val binding = ItemDisasterBinding.inflate(LayoutInflater.from(parent.context),
            parent, false)
        return ItemDisasterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemDisasterViewHolder, position: Int) {
        holder.bind(listDisaster[position])
    }

    override fun getItemCount(): Int {
        return listDisaster.size
    }
}