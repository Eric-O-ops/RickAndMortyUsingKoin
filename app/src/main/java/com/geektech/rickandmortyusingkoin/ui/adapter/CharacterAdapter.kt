package com.geektech.rickandmortyusingkoin.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.geektech.rickandmortyusingkoin.databinding.ItemCharacterBinding
import com.geektech.rickandmortyusingkoin.model.CharacterModel

class CharacterAdapter : PagingDataAdapter<CharacterModel, CharacterAdapter.ViewHolder>(diffUtil) {

    class ViewHolder(private val binding: ItemCharacterBinding) :
        RecyclerView.ViewHolder(binding.root) {

            fun onBind(item: CharacterModel?) {
                binding.itemCharacterName.text = item?.name

            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemCharacterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(getItem(position))

    }

    companion object {
        private val diffUtil = object : DiffUtil.ItemCallback<CharacterModel>() {
            override fun areItemsTheSame(
                oldItem: CharacterModel,
                newItem: CharacterModel
            ): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: CharacterModel,
                newItem: CharacterModel
            ): Boolean {
                return oldItem.id == newItem.id
            }
        }
    }
}