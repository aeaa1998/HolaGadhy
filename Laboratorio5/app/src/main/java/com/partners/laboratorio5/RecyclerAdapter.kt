package com.partners.laboratorio5

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.partners.laboratorio5.App.Companion.rows
import com.partners.laboratorio5.databinding.RecyclerRowBinding
import kotlinx.android.synthetic.main.recycler_row.view.*


class RecyclerAdapter: RecyclerView.Adapter<RecyclerAdapter.CustomViewHolder>() {
    override fun getItemCount(): Int {
        return rows!!.size
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(p0.context)
        val d = rows
        val row = rows!![p1]
        val binding = DataBindingUtil.inflate<RecyclerRowBinding>(layoutInflater, R.layout.recycler_row, p0, false)
        binding.product = ProductBinding(row.getProduct().getName(), row.getQuantity())
        val cellForRow = layoutInflater.inflate(R.layout.recycler_row, p0, false)

        return CustomViewHolder(cellForRow)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, p1: Int) {
            holder.view.namep.text = rows!![p1].getProduct().getName()
            holder.view.quantityp.text = rows!![p1].getQuantity().toString()
            holder.view.plus_quantity.setOnClickListener {
                val row = rows!!.get(p1)
                var q =row.getQuantity()
                q++
                row.setQuantity(q)
                holder.view.quantityp.text = row.getQuantity().toString()

            }
            holder.view.minus_quantity.setOnClickListener {
                val row = rows!!.get(p1)
                var q =row.getQuantity()
                q--
                if (q >= 0){
                    row.setQuantity(q)
                    holder.view.quantityp.text = row.getQuantity().toString()
                }else{
                    Toast.makeText(holder.view.context, "No se pueden borrar mas", Toast.LENGTH_LONG).show()
                }
            }

//        holder.view.CardViewRow.setOnClickListener(object : OnSwipeTouchListener() {
//            override fun onSwipeLeft() {
//                Log.e("ViewSwipe", "Left")
//            }
//
//            override fun onSwipeRight() {
//                Log.e("ViewSwipe", "Right")
//            }
//        })
    }

    class CustomViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

    }
}