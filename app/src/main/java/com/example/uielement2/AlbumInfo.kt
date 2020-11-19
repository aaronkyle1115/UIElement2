package com.example.uielement2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView

class AlbumInfo : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_album_info)
        val intent =  Intent(this, AlbumInfo::class.java)
        val name = findViewById<TextView>(R.id.textView2)
        val image = findViewById<ImageView>(R.id.imageView)
        val songListView = findViewById<ListView>(R.id.songList)
        var album : String? = intent.getStringExtra("album")


        when("$album"){
            "0" -> {
                name.text = "Meowment"
                val albumSong : Array<String> = arrayOf("Meow-rried", "Fur-tunate", "Claw-ful", "Furmidable")
                val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, (albumSong))
                songListView.adapter = adapter
                image.setImageResource(R.drawable.cat)
            }
            "1" -> {
                name.text = "Purrty Feline"
                val albumSong : Array<String> = arrayOf("Tails", "Paw-sible", "Hiss-tory", "Paw-don Me")
                val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, (albumSong))
                songListView.adapter = adapter
                image.setImageResource(R.drawable.cat1)
            }
            "2" -> {
                name.text = "Cat Cobane"
                val albumSong : Array<String>  = arrayOf("Meow-rried", "Fur-tunate", "Claw-ful", "Furmidable")
                val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, (albumSong))
                songListView.adapter = adapter
                image.setImageResource(R.drawable.cat2)
            }
            else ->{
                name.text = "Eh Didn't Work"
                val albumSong : Array<String>  = arrayOf("I ", "Think", "I'm", "Done")
                val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, (albumSong))
                songListView.adapter = adapter
                image.setImageResource(R.drawable.fail)
            }
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