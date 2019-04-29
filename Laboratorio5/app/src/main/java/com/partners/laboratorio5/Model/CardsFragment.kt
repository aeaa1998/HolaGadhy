package com.partners.laboratorio5.Model

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.content.ContextCompat
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.*
import android.widget.Toast
import com.partners.laboratorio5.*
import kotlinx.android.synthetic.main.fragment_cardview.*
import kotlinx.android.synthetic.main.fragment_cardview.view.*
import java.util.jar.Manifest

class CardsFragment: Fragment() {
    var recycler: RecyclerView? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var v = inflater.inflate(R.layout.fragment_cardview, container, false)
        recycler = v.findViewById<RecyclerView>(R.id.recycler)
        recycler?.layoutManager = LinearLayoutManager(context)
        recycler?.adapter = RecyclerAdapter()
        recycler?.adapter?.notifyDataSetChanged()


        setHasOptionsMenu(true);
        return v
    }

    override fun onResume() {

        recycler?.adapter?.notifyDataSetChanged()
        setHasOptionsMenu(true)
        super.onResume()

    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        inflater?.inflate(R.menu.menu_dots, menu)
        super.onCreateOptionsMenu(menu, inflater)

    }



    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item!!.itemId){
            R.id.new_product_two -> {
                if (ContextCompat.checkSelfPermission(activity!!.applicationContext, android.Manifest.permission.CAMERA)
                        != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(activity!!,
                            arrayOf(android.Manifest.permission.CAMERA),
                            1)
                }else{
                    val intent = Intent(activity?.applicationContext, ScanCode::class.java)
                    startActivity(intent)
                }

            }
            R.id.reboot -> {
                if (App.rows.size > 0){
                    App.rows.clear()
                    App.invetaryInst?.rows?.clear()
                    recycler?.adapter?.notifyDataSetChanged()
                }else{
                    Toast.makeText(context, "No hay filas por limpiar", Toast.LENGTH_LONG).show()
                }
            }
            R.id.inv_show -> {
                if (App.rows.size > 0){
                    App.invetaryInst?.toString()
                }else{
                    Toast.makeText(context, "No hay inventario", Toast.LENGTH_LONG).show()
                }
            }

        }
        return true
    }

}