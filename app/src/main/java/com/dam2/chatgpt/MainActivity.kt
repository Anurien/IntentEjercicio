package com.dam2.chatgpt

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var enviar: Button = findViewById(R.id.start)
        enviar.setOnClickListener {
            val intento1 = Intent(this, SecondActivity::class.java)
            // Añade datos adicionales al Intent
            intento1.putExtra("EXTRA_MESSAGE", 8)
            // Inicia la segunda actividad
            startActivityForResult(intento1, REQUEST_EXTRA_MESSAGE)
            startActivityForResult(intento1, REQUEST_PERMISSION)
            startActivityForResult(intento1, REQUEST_TO_POST)
        }
    }
    // recoje el intent cuando hacemos setResult() en la SecondActivity
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        // Definimos el text view para mostrar el dato que nos manda la Second
        val textView1 = findViewById<TextView>(R.id.texto)
        val textView2 = findViewById<TextView>(R.id.texto3)
        val textView3 = findViewById<TextView>(R.id.texto4)
        // Comprueba que el resultado es OK
        if (resultCode != Activity.RESULT_OK) return
        Log.d("asd", requestCode.toString())
        // Puedo distinguir diferentes acciones según el requestCode
        when (requestCode) {
            REQUEST_EXTRA_MESSAGE -> {
                // si el intent no es null muestro el resultado
                if (data != null) {
                    Log.d("asd", "recibido")
                    textView1.text = data.getStringExtra("saludo")
                }; }
            REQUEST_PERMISSION -> {
                if (data != null) {
                    Log.d("asd", "recibido")
                    textView2.text = data.getStringExtra("despedida")
                }; }

            REQUEST_TO_POST -> {
                if (data != null) {
                    Log.d("asd", "recibido")
                    textView3.text = data.getStringExtra("despedida2")
                }; }

        }
    }

    companion object {
        const val REQUEST_EXTRA_MESSAGE = 1
        const val REQUEST_PERMISSION = 2
        const val REQUEST_TO_POST = 3
    }
}
