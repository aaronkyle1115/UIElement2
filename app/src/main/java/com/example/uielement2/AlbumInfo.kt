package com.example.uielement2

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.*
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar

class AlbumInfo : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_album_info)
        albumlist.clear()
        val name = findViewById<TextView>(R.id.textView2)
        val image = findViewById<ImageView>(R.id.imageView)
        val songListView = findViewById<ListView>(R.id.songList)

        when("$albumid"){
            "0" -> {
                name.text = "Meowment"
                albumlist.addAll(album1)
                image.setImageResource(R.drawable.cat)
            }
            "1" -> {
                name.text = "Purrty Feline"
                albumlist.addAll(album2)
                image.setImageResource(R.drawable.cat1)
            }
            "2" -> {
                name.text = "Cat Cobane"
                albumlist.addAll(album3)
                image.setImageResource(R.drawable.cat2)
            }

        }

        
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, (albumlist))
        songListView.adapter = adapter
        registerForContextMenu(songListView)



    }

    fun refresh(){
        val refreshActivity = intent
        finish()
        startActivity(refreshActivity)
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        val inflater : MenuInflater = menuInflater
        inflater.inflate(R.menu.removemenu, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        return when (item!!.itemId) {
            R.id.RemoveSong -> {
                val info = item.menuInfo as AdapterView.AdapterContextMenuInfo
                val builder =AlertDialog.Builder(this)
                builder.setTitle("Are You Sure?")
                builder.setMessage("Do you Wish to delete this song from this album?")
                builder.setPositiveButton("yes",{ dialogInterface: DialogInterface, i: Int ->
                    when("$albumid"){
                        "0" -> {
                            album1.removeAt(info.position)
                        }
                        "1" -> {
                            album2.removeAt(info.position)
                        }
                        "2" -> {
                            album3.removeAt(info.position)
                        }

                    }

                    refresh()
                })
                builder.setNegativeButton("No", { dialogInterface: DialogInterface, i: Int ->
                    dialogInterface.cancel()
                })
                builder.show()
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