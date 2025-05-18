package com.ryanmhildan.exchangerate.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ryanmhildan.exchangerate.R
import com.ryanmhildan.exchangerate.model.Country

class ListCountryAdapter (
    private val listCountry: ArrayList<Country>,
    private val onItemClick:(Country) -> Unit): RecyclerView.Adapter<ListCountryAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListCountryAdapter.ListViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_hero, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, buy, sell, photo) = listCountry[position]
        holder.imgPhoto.setImageResource(photo)
        holder.txtName.text = name
        holder.txtBuy.text = buy
        holder.txtSell.text = sell
        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listCountry[position])
        }

    }

    override fun getItemCount(): Int = listCountry.size

    class ListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val txtName: TextView = itemView.findViewById(R.id.txt_item_name)
        val txtBuy: TextView = itemView.findViewById(R.id.txt_item_buy)
        val txtSell: TextView = itemView.findViewById(R.id.txt_item_sell)
    }

    interface OnItemClickCallback{
        fun onItemClicked(data: Country)
    }

}