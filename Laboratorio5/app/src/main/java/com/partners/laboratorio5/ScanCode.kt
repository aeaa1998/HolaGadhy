package com.partners.laboratorio5

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.zxing.Result
import com.partners.laboratorio5.App.Companion.invetaryInst
import com.partners.laboratorio5.App.Companion.rows
import com.partners.laboratorio5.Model.Row
import kotlinx.android.synthetic.main.fragment_home.*
import me.dm7.barcodescanner.zxing.ZXingScannerView

class ScanCode : AppCompatActivity(),  ZXingScannerView.ResultHandler{
    var scannerView: ZXingScannerView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        scannerView = ZXingScannerView(this)
        setContentView(scannerView)

    }

    override fun handleResult(p0: Result?) {
        var b = false
        invetaryInst?.rows?.forEach {
            val p =  it.getProduct()
            if (p.getCode() == p0.toString() && !rows.contains(it)){
                rows.add(it)
                b = true
            }

        }
        if (b==false){
            Toast.makeText(application.applicationContext, "No fue un qr valido o ya agrego el elemento", Toast.LENGTH_LONG).show()
        }
        onBackPressed()
    }

    override fun onPause() {
        super.onPause()
        scannerView?.stopCamera()
    }

    override fun onResume() {
        super.onResume()
        scannerView?.setResultHandler(this)
        scannerView?.startCamera()
    }
}
