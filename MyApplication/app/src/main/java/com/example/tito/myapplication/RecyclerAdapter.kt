package com.example.tito.myapplication

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.tito.myapplication.R.layout.recycler_row
import kotlinx.android.synthetic.main.recycler_row.view.*

class RecyclerAdapter: RecyclerView.Adapter<CustomViewHolder>(){
    override fun getItemCount(): Int {
        return Laps.lapHistory.size
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(p0.context)
        val cellForRow = layoutInflater.inflate(recycler_row, p0, false)
        return CustomViewHolder(cellForRow)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, p1: Int) {
        var laps = Laps.lapHistory.get(p1)
        holder.view.textViewLap.text = "Vueltas: "+laps
        holder.view.textViewLap.setOnClickListener {
            Toast.makeText(holder.view.context, "a $laps", Toast.LENGTH_LONG).show()
        }
    }
}
class CustomViewHolder(val view: View): RecyclerView.ViewHolder(view){

}