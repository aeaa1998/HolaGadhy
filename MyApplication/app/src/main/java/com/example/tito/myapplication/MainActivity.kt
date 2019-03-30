package com.example.tito.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),  LapHistory{
    override val lapHistory = Laps.lapHistory
    override fun onCreate(savedInstanceState: Bundle?) {
        val lapHistory = lapHistory
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lapRecycler.layoutManager = LinearLayoutManager(this)
        lapRecycler.adapter = RecyclerAdapter()
    }

    override fun onResume() {
        super.onResume()
        lapRecycler.adapter?.notifyDataSetChanged()


    }
    override fun clear() {
        Laps.lapHistory.clear()
        lapRecycler.adapter?.notifyDataSetChanged()

    }

    override fun add(element: Int) {
        lapHistory.add(element)
    }

    override fun del(elementIndex: Int) {
        lapHistory.removeAt(elementIndex)
    }

    fun startActivity2(v: View) {
        val intent = Intent(this, Activity2::class.java)
        startActivity(intent)
    }
    fun eraseHistorial(v :View){
        clear()
    }
}
