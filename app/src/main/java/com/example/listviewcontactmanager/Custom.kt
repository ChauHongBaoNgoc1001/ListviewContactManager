package com.example.listviewcontactmanager
import android.content.Context
import android.content.Intent
import android.provider.ContactsContract.CommonDataKinds.Email
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity


class CustomListAdapter(context: Context, private val resource: Int, private val items: MutableList<Item>) :
    ArrayAdapter<Item>(context, resource, items) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(resource, null)


        val item: Item = items[position]
        val img: ImageView = view.findViewById(R.id.img)
        val nu:String = "Nữ"

        if(item.Gioitinh == nu){
            img.setImageResource(R.drawable.nu)
        }
        else{  img.setImageResource(R.drawable.nam)}

        var Ten: TextView = view.findViewById(R.id.ten)
        Ten.text =item.ten
        var SDT: TextView = view.findViewById(R.id.sdt)
        SDT.text= item.sdt
        var Email: TextView = view.findViewById(R.id.email)
        Email.text= item.email
        var gioiTinh: TextView = view.findViewById(R.id.Gioitinh)
        gioiTinh.text = item.Gioitinh

        val Xoa: Button = view.findViewById(R.id.delete)
        Xoa.setOnClickListener {
            items.removeAt(position)// xóa item tại vị trí đó
            notifyDataSetChanged()// cập nhật lại listView
        }

        view.setOnClickListener {
            val selectedItem = items[position] // lấy phần tử được chọn trong danh sách items
            val intent = Intent(context, MainActivity2::class.java)
            intent.putExtra("ten", selectedItem.ten) // chuyền dữ liệu
            intent.putExtra("sdt", selectedItem.sdt)
            intent.putExtra("gt", selectedItem.email)
            intent.putExtra("email", selectedItem.Gioitinh)

            context.startActivity(intent) // chuyển màn hình
        }










        return view

    }
}





