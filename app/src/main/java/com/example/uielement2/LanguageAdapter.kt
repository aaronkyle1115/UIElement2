package com.example.uielement2

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class LanguageAdapter(var context: Context, var arrayList: ArrayList<LanguageItem>) : BaseAdapter() {

    override fun getItem(position: Int): Any {
        return arrayList.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return arrayList.size
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        var view: View = View.inflate(context, R.layout.albumlist, null)

        var icons: ImageView = view.findViewById(R.id.icons)
        var names: TextView = view.findViewById(R.id.textView)

        var languageItem: LanguageItem = arrayList.get(position)

        icons.setImageResource(languageItem.icons!!)
        names.text = languageItem.name

        return view
    }
}