package com.partners.laboratorio5

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBar
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.view.menu.MenuView
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import android.widget.Toolbar
import com.partners.laboratorio5.App.Companion.invetaryInst
import com.partners.laboratorio5.App.Companion.rows
import com.partners.laboratorio5.Model.CardsFragment
import com.partners.laboratorio5.Model.Inventary
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener{
    var toolbar: android.support.v7.widget.Toolbar? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        invetaryInst = Inventary()
        setContentView(R.layout.activity_main)
        toolbar = findViewById<android.support.v7.widget.Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val drawer = findViewById<DrawerLayout>(R.id.drawer_layout)
        val navView = findViewById<NavigationView>(R.id.nav_view)

        navView.setNavigationItemSelectedListener(this)
        val toogle =  ActionBarDrawerToggle(this, drawer, toolbar, R.string.nav_drawer_open, R.string.nav_drawer_close)

        drawer.addDrawerListener(toogle)
        toogle.syncState()
        if (savedInstanceState == null){
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container, CardsFragment()).commit()
        }
    }

    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
        when(p0.itemId){
            R.id.navNew -> {supportFragmentManager.beginTransaction().replace(R.id.fragment_container, HomeFragment()).commit()}
            R.id.Home -> {supportFragmentManager.beginTransaction().replace(R.id.fragment_container, CardsFragment()).commit()}
        }
        onBackPressed()
        return true
    }



    override fun onBackPressed() {
        val drawer = findViewById<DrawerLayout>(R.id.drawer_layout)

        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START)
        }else{
            super.onBackPressed()
        }
    }
}
