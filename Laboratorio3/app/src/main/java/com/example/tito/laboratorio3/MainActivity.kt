package com.example.tito.laboratorio3

import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.example.tito.laboratorio3.App.Companion.atitlan
import com.example.tito.laboratorio3.App.Companion.atitlanDescrption
import com.example.tito.laboratorio3.App.Companion.atitlanPhrase
import com.example.tito.laboratorio3.App.Companion.rio
import com.example.tito.laboratorio3.App.Companion.rioDescrption
import com.example.tito.laboratorio3.App.Companion.rioPhrase
import com.example.tito.laboratorio3.App.Companion.textToast
import com.example.tito.laboratorio3.App.Companion.tikal
import com.example.tito.laboratorio3.App.Companion.tikalDescrption
import com.example.tito.laboratorio3.App.Companion.tikalPhrase
import com.example.tito.laboratorio3.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
         binding = DataBindingUtil.setContentView<ActivityMainBinding>(
                this, R.layout.activity_main)
        binding?.main = MainBinding(true, "")

    }

    override fun onResume() {
        super.onResume()
        if (textToast !== null){
            Toast.makeText(this, textToast, Toast.LENGTH_LONG).show()
            textToast = null
        }


    }
    fun changeVisibility(v:View){
        binding?.main = MainBinding(!(binding?.main?.show ?: false), nameInput.getText().toString())
    }

    fun openNewTikal(v: View){
        val intent = Intent(this, Place::class.java)
        intent.putExtra("DESCRIPTION", tikalDescrption)
        intent.putExtra("PHRASE", tikalPhrase)
        intent.putExtra("TITLE", tikal)
        startActivity(intent)
    }

    fun openNewRio(v: View){
        val intent = Intent(this, Place::class.java)
        intent.putExtra("DESCRIPTION", rioDescrption)
        intent.putExtra("PHRASE", rioPhrase)
        intent.putExtra("TITLE", rio)
        startActivity(intent)
    }

    fun openNewAtitlan(v: View){
        val intent = Intent(this, Place::class.java)
        intent.putExtra("DESCRIPTION", atitlanDescrption)
        intent.putExtra("PHRASE", atitlanPhrase)
        intent.putExtra("TITLE", atitlan)
        startActivity(intent)
    }

}
