package com.example.hw52.boarding

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.hw52.databinding.ItemBoardingBinding

class BoardingAdapter(val names:ArrayList<OnBoard>, private val onClick:() -> Unit):RecyclerView.Adapter<BoardingAdapter.BoardingViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BoardingViewHolder {
        return BoardingViewHolder(ItemBoardingBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: BoardingViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int = names.size

    inner class BoardingViewHolder(private val binding: ItemBoardingBinding) :RecyclerView.ViewHolder(binding.root){
        fun bind(){
            with(binding) {
                val item = names[adapterPosition]

                tvTitle.text = item.title
                tvDescription.text = item.desc
                item.img?.let { ivBoard.setImageResource(it) }


                btnStart.isVisible = adapterPosition == names.lastIndex
                btnStart.setOnClickListener {
                    onClick()
                }
                if (adapterPosition == names.lastIndex) {
                    tvTitle.visibility = View.GONE
                }
            }
        }
    }
}