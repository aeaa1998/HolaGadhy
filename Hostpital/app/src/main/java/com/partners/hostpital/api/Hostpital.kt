package com.partners.hostpital.api

import android.app.Application
import io.paperdb.Paper

class Hostpital : Application(){
    override fun onCreate() {
        super.onCreate()
        Paper.init(applicationContext)
    }
}