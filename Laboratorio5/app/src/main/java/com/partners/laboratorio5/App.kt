package com.partners.laboratorio5

import android.app.Application
import com.partners.laboratorio5.Model.Inventary
import com.partners.laboratorio5.Model.Product
import com.partners.laboratorio5.Model.Row

class App: Application()
{
    companion object {
        var invetaryInst: Inventary?=null
        var rows: ArrayList<Row> = arrayListOf()

    }
}