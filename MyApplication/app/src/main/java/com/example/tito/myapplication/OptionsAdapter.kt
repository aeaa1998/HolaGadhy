package com.example.tito.myapplication

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.tito.myapplication.R.layout.recycler_row
import kotlinx.android.synthetic.main.recycler_row.view.*

class OptionsAdapter: RecyclerView.Adapter<CustomViewHolder>(){
    val options = listOf(1,2,3,4)
    override fun getItemCount(): Int {
        return options.size
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(p0.context)
        val cellForRow = layoutInflater.inflate(R.layout.recycler_row, p0, false)
        return CustomViewHolder(cellForRow)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, p1: Int) {
        var laps = options.get(p1)
        holder.view.textViewLap.text = "Agregar un numero de $laps vueltas"
        holder.view.textViewLap.setOnClickListener {
            Toast.makeText(holder.view.context, "Se creo $laps vueltas", Toast.LENGTH_LONG).show()
            Laps.lapHistory.add(laps)
        }

    }
}
