package com.example.uielement2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import java.util.ArrayList
/*I could have used resource strings but nahhh i dont understand how to use it that well so nahhhh*/
var songArray : ArrayList<String> = ArrayList()
var album1 : ArrayList<String> = arrayListOf("Meow-rried", "Fur-tunate", "Claw-ful", "Furmidable")
var album2 : ArrayList<String> = arrayListOf("Tails", "Paw-sible", "Hiss-tory", "Paw-don Me")
var album3 : ArrayList<String> = arrayListOf("Fur-milliar", "Paw-some", "Fur-get Me", "Cat-astrophe")
var albumid : String? = null
var testList : ArrayList<String> = ArrayList()
var albumlist : ArrayList<String> = ArrayList()

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpList()
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, (songArray))
        val songListView = findViewById<ListView>(R.id.songListView)
        songListView.adapter = adapter
        registerForContextMenu(songListView)

    }
    fun setUpList(){
        songArray.clear()
        songArray.addAll(album1)
        songArray.addAll(album2)
        songArray.addAll(album3)
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
                var snackbar = Snackbar.make(info.targetView, "Song Added to Queue", Snackbar.LENGTH_LONG)
                snackbar.setAction("Go to Queue", View.OnClickListener {
                    startActivity(Intent(this, Queue::class.java))
                })
                snackbar.show()
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