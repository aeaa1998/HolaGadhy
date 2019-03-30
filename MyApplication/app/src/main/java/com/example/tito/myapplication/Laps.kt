package com.example.tito.myapplication

import android.app.Application
import java.util.ArrayList

class Laps : Application(){


    companion object {
        var lapHistory = ArrayList<Int>()
    }

}
