package com.example.tito.laboratorio3

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.tito.laboratorio3.App.Companion.textToast
import com.example.tito.laboratorio3.R.id.comment_input
import com.example.tito.laboratorio3.databinding.ActivityMainBinding
import com.example.tito.laboratorio3.databinding.ActivityPlaceBinding
import kotlinx.android.synthetic.main.activity_place.*

class Place : AppCompatActivity() {
    var binding :ActivityPlaceBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_place)
        val extras = intent.extras
        binding = DataBindingUtil.setContentView<ActivityPlaceBinding>(
                this, R.layout.activity_place)
        binding?.place = PlaceBinding(extras.getString("PHRASE")?: "", extras.getString("TITLE")?: "", extras.getString("DESCRIPTION")?: "")
    }

    fun sendComment(v:View){
        textToast = if(comment_input.text.toString().length > 0) {comment_input.text.toString() } else{ "No hubo un comentario"}
        onBackPressed()
    }
}
