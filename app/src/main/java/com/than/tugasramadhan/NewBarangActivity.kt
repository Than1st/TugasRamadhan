package com.than.tugasramadhan

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText

class NewBarangActivity : AppCompatActivity() {
    private lateinit var editBarangView : EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_barang)
        setContentView(R.layout.activity_new_barang)
        editBarangView = findViewById(R.id.edit_barang)

        val button = findViewById<Button>(R.id.button_save)
        button.setOnClickListener {
            val replyIntent = Intent()
            if (TextUtils.isEmpty(editBarangView.text)) {
                setResult(Activity.RESULT_CANCELED, replyIntent)
            } else {
                val word = editBarangView.text.toString()
                replyIntent.putExtra(EXTRA_REPLY, word)
                setResult(Activity.RESULT_OK, replyIntent)
            }
            finish()
        }
    }
    companion object {
        const val EXTRA_REPLY = "com.example.android.wordlistsql.REPLY"
    }
}