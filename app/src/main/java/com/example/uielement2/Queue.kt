package com.example.uielement2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.ListView
import java.util.ArrayList

class Queue : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_queue)

        var adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, (testList))
        var songListView = findViewById<ListView>(R.id.queueListView)
        songListView.adapter = adapter
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
}