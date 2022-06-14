package com.example.myapplicationapivolley

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.View
import android.widget.TextView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun eventEnviar(view:View){
        val textView = findViewById<TextView>(R.id.txtText)
        val cola = Volley.newRequestQueue(this)
        val url = "https://gorest.co.in/public/v1/users"

        val stringRequest = StringRequest(
            Request.Method.GET, url,
            Response.Listener<String> { response ->
                textView.text = "Resultado----> ${response.toString()}"
            },
            Response.ErrorListener { textView.text = "Ocurrio un error!" })
        textView.movementMethod=ScrollingMovementMethod()
        cola.add(stringRequest)

    }
}