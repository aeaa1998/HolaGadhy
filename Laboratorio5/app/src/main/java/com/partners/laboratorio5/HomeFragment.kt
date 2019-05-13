package com.partners.laboratorio5

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.partners.laboratorio5.App.Companion.invetaryInst
import com.partners.laboratorio5.App.Companion.rows
import com.partners.laboratorio5.Model.CardsFragment
import com.partners.laboratorio5.Model.Inventary
import com.partners.laboratorio5.Model.Product
import com.partners.laboratorio5.Model.Row
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment:  Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var v = inflater.inflate(R.layout.fragment_home, container, false)
        var btn = v.findViewById<View>(R.id.save_btn)
        btn.setOnClickListener {
            if (NameNewProduct.text.toString() != "" && Codigo.text.toString() != ""){
                val p = Product()
                p.setName(NameNewProduct.text.toString())
                p.setCode(Codigo.text.toString())
                val row = Row()
                row.setQuantity(1)
                row.setProduct(p)
                row.getProduct().setName(NameNewProduct.text.toString())
                row.getProduct().setCode(Codigo.text.toString())
//                rows.add(row)
                val r = rows
                invetaryInst!!.rows.add(row)

                activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.fragment_container, CardsFragment())?.commit()
            }else{
                Toast.makeText(context, "No ha llenado los campos", Toast.LENGTH_LONG).show()
            }
        }
        return v
    }



}