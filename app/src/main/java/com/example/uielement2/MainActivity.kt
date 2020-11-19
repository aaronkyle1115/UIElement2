package com.example.uielement2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import java.util.ArrayList

val songArray : Array<String> = arrayOf("Meow-rried", "Fur-tunate", "Claw-ful", "Furmidable"
    , "Tails", "Paw-sible", "Hiss-tory", "Paw-don Me", "Fur-milliar", "Paw-some", "Fur-get Me", "Cat-astrophe"
    )
var testList : ArrayList<String> = ArrayList()
var  tempItem : String? = null

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, (songArray))
        val songListView = findViewById<ListView>(R.id.songListView)
        songListView.adapter = adapter
        registerForContextMenu(songListView)
        songListView.setOnItemClickListener { parent, view, position:Int, id ->
            tempItem = songArray[position]
            Log.i("Possition", "Possistion $position" )

        }

    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        val inflater : MenuInflater = menuInflater
        inflater.inflate(R.menu.songmenu, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        return when (item!!.itemId) {
            R.id.addToQueue -> {
                val info = item.menuInfo as AdapterView.AdapterContextMenuInfo
                testList.add(songArray[info.position])
                Toast.makeText(applicationContext, "Song Added To Queue", Toast.LENGTH_LONG).show()
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
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