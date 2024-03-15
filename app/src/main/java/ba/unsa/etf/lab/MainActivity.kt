package ba.unsa.etf.lab

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.button1);
        button.setOnClickListener {
            showMessage()
        }
    }
    private fun showMessage() {
        val editText = findViewById<EditText>(R.id.editText1)
        val textView = findViewById<TextView>(R.id.text1)
        val message = editText.text.toString()
        textView.text = message
    }
}