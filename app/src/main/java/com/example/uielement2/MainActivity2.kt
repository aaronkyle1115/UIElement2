package com.example.uielement2

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.GridView
import android.widget.Toast

class MainActivity2 : AppCompatActivity(), AdapterView.OnItemClickListener{

    private var gridView:GridView ? = null
    private var arrayList : ArrayList<LanguageItem> ? = null
    private var languageAdapter : LanguageAdapter ? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        gridView = findViewById(R.id.gridview)
        arrayList = ArrayList()
        arrayList = setDataList()
        languageAdapter = LanguageAdapter(applicationContext, arrayList!!)
        gridView?.adapter = languageAdapter
        gridView?.onItemClickListener = this
    }

    private fun setDataList() :ArrayList<LanguageItem>{

        var arrayList:ArrayList<LanguageItem> = ArrayList()

        arrayList.add(LanguageItem(R.drawable.cat, "Meowment"))
        arrayList.add(LanguageItem(R.drawable.cat1, "Purrty Feline"))
        arrayList.add(LanguageItem(R.drawable.cat2, "Cat Cobane"))

        return arrayList
    }






    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater : MenuInflater = menuInflater
        inflater.inflate(R.menu.mainmenu, menu)
        return true
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.gotoQueue ->{
                startActivity(Intent(this, Queue::class.java))
                true
            }
            R.id.gotoSongs ->{
                startActivity(Intent(this, MainActivity::class.java))
                true
            }
            R.id.gotoalbum -> {
                startActivity(Intent(this, MainActivity2::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

        val intent =  Intent(this, AlbumInfo::class.java)
        albumid = position.toString()
        startActivity(intent)

        }

    }
