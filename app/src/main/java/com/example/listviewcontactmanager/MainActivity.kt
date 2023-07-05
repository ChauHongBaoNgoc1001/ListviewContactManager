package com.example.listviewcontactmanager

import android.annotation.SuppressLint
import android.content.Intent
import android.net.wifi.WifiEnterpriseConfig.Eap
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.ListView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity: AppCompatActivity() {

    private lateinit var ListView: ListView
    private lateinit var customListAdapter: CustomListAdapter

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var Ten1 = findViewById<EditText>(R.id.Ten)
        var SDT = findViewById<EditText>(R.id.Sdt)
        var emailEditText = findViewById<EditText>(R.id.Email)
        var Gt = findViewById<RadioGroup>(R.id.RDGroup)
        val nam:RadioButton =findViewById(R.id.nam)
        val nu:RadioButton =findViewById(R.id.nu)
        val Submit = findViewById<Button>(R.id.Submit)

        var DS= findViewById<ListView>(R.id.List)




        var List:MutableList<Item> = mutableListOf()
        var adapter:CustomListAdapter = CustomListAdapter(this, R.layout.layout_item, List)
        DS.adapter = adapter

        Submit.setOnClickListener{
            val Hoten:String = Ten1.text.toString()
            val SoDT:String =SDT.text.toString()
            val Email:String = emailEditText.text.toString()
            val Gioitinh = if (nam.isChecked) "Nam" else "Nữ"
            val userInfo = Item( Hoten, SoDT, Email, Gioitinh )

            List.add(userInfo)
            adapter.notifyDataSetChanged()// cập nhật lại listview

            Ten1.text.clear()
            SDT.text.clear()
            emailEditText.text.clear()
            Gt.clearCheck()
        }


//        val listView: ListView = findViewById(R.id.List)
//
//        listView.setOnItemClickListener { parent, view, position, id ->
//            // Xử lý sự kiện khi người dùng chọn một mục trong ListView
//            val selectedItem = parent.getItemAtPosition(position) as Item
//            val intent = Intent(this, MainActivity2::class.java)
//            intent.putExtra("ten", selectedItem.ten) // chuyền dữ liệu
//            intent.putExtra("sdt", selectedItem.sdt)
//            intent.putExtra("gt", selectedItem.email)
//            intent.putExtra("email", selectedItem.Gioitinh)
//
//
//            startActivity(intent)// chuyển màn hình
//        }

    }
}
