package com.dam2.chatgpt


import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_segunda)
        // Recoge el Intent que ha iniciado la actividad
        val intent = intent
        // Get the Intent that started this activity and extract the string
        val message = intent.getIntExtra("REQUEST_EXTRA_MESSAGE", 7)

        // Capture the layout's TextView and set the string as its text
        val textView = findViewById<TextView>(R.id.texto2)
        textView.text = message.toString()


        val botonsalir = findViewById<Button>(R.id.start2)
        botonsalir.setOnClickListener {
            //val intento2 = Intent(this, SecondActivity::class.java)
            intent.putExtra("saludo", "Hola")
            intent.putExtra("despedida", "adios")
            intent.putExtra("despedida2", "chao")
            Log.d("mensaje", "actualizado")
            /* startActivity(intento2)*/
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
        val botonsalir1 = findViewById<Button>(R.id.start3)
        botonsalir1.setOnClickListener {
            //val intento2 = Intent(this, SecondActivity::class.java)
            // Meto un nuevo dato en el intent
            intent.putExtra("despedida", "adios")
            Log.d("mensaje", "actualizado")
            /* startActivity(intento2)*/
            // Configuro el result para que la Main lo tenga disponible
            // Posibles resultados:
            //    Activity.RESULT_OK
            //    Activity.RESULT_CANCELED
            setResult(Activity.RESULT_OK, intent)
            // cierro la activity
            finish()
        }
        val botonsalir2 = findViewById<Button>(R.id.start4)
        botonsalir2.setOnClickListener {
            //val intento2 = Intent(this, SecondActivity::class.java)
            intent.putExtra("despedida2", "chao")
            Log.d("mensaje", "actualizado")
            /* startActivity(intento2)*/
            setResult(Activity.RESULT_OK, intent)
            finish()
        }

    }
}