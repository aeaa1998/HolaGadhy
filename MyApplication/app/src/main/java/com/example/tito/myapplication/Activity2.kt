package com.example.tito.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_2.*
import kotlinx.android.synthetic.main.activity_main.*

class Activity2 : AppCompatActivity(), LapHistory{
    var i: Int = 0
    override val lapHistory = Laps.lapHistory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)
        counter.text = i.toString()
        options_id.layoutManager = LinearLayoutManager(this)
        options_id.adapter = OptionsAdapter()
    }

    fun plus(v: View){
        i++
        counter.text = i.toString()
    }
    fun min(v: View){
        if (i> 0){
            i--
            counter.text = i.toString()
        }else{
            Toast.makeText(this, "No se eliminar mas vueltas", Toast.LENGTH_LONG).show()

        }
    }
    fun store(v: View){
        add(i)
        i = 0
        counter.text = i.toString()
    }
    fun Main(v: View) {
        onBackPressed()
    }
    override fun add(element: Int) {
        if (element > 0){
            Laps.lapHistory.add(element)
        }else{
            Toast.makeText(this, "No se puede añandir 0 vueltas", Toast.LENGTH_LONG).show()

        }
    }

    override fun clear() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun del(elementIndex: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
