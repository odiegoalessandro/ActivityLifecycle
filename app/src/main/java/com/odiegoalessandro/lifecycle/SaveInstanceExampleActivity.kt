package com.odiegoalessandro.lifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class SaveInstanceExampleActivity : AppCompatActivity() {
    var name: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_save_instance_example)

        val tvResult = findViewById<TextView>(R.id.tvResult)
        val etName = findViewById<EditText>(R.id.etName)
        val btSend = findViewById<Button>(R.id.btSend)

        btSend.setOnClickListener {
            if(etName.text.isNotBlank()){
                name = etName.text.toString()
                tvResult.text = name
            } else {
                etName.error = getString(R.string.enter_a_name)
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        val nameString = name
        outState.putString("savedName", name)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        val nameString = savedInstanceState.getString("savedName")
        if(nameString != null){
            val tvResult = findViewById<TextView>(R.id.tvResult)
            name = nameString
            tvResult.text = name
        }
    }
}