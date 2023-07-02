package com.example.weathertestapp.presentation.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.weathertestapp.R
import com.example.weathertestapp.domain.model.fivedaymodel.FiveDayModel

class FiveDayAdapter : RecyclerView.Adapter<FiveDayAdapter.FiveDayHolder>() {

    private var forecastList = mutableListOf<FiveDayModel>()

    class FiveDayHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val date = itemView.findViewById<TextView>(R.id.tv_date)
        val temp = itemView.findViewById<TextView>(R.id.tv_temp)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FiveDayHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.forecast_item, parent, false)
        return FiveDayHolder(view)
    }

    override fun onBindViewHolder(holder: FiveDayHolder, position: Int) {
        val forecastItem = forecastList[position]
        holder.apply {
            date.text = forecastItem.date
            temp.text = forecastItem.temp.dropLast(1) + "\u2103"
        }
    }

    override fun getItemCount(): Int {
        return forecastList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(list: List<FiveDayModel>) {
        forecastList = list.toMutableList()
        notifyDataSetChanged()
    }
}