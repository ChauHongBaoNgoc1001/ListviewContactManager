package com.example.listviewcontactmanager

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 :AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        var Ten = intent.getStringExtra("ten")
        var Ten2:TextView = findViewById(R.id.ten1)
        Ten2.text = Ten.toString()

        var sdt = intent.getStringExtra("sdt")
        var sdt1:TextView = findViewById(R.id.sdt1)
        sdt1.text = sdt.toString()

        var Gioitinh = intent.getStringExtra("gt")
        var gt1:TextView = findViewById(R.id.gt1)
        gt1.text = Gioitinh.toString()

        var Email = intent.getStringExtra("email")
        var email1:TextView = findViewById(R.id.email1)
        email1.text = Email.toString()



    }

}