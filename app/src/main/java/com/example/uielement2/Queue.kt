package com.example.uielement2

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import java.util.ArrayList


class Queue : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_queue)
        val adapter = ArrayAdapter<String>(this@Queue, android.R.layout.simple_list_item_1, (testList))
        val songListView = findViewById<ListView>(R.id.queueListView)

        songListView.adapter = adapter

        registerForContextMenu(songListView)

    }
/* if notifyDataSetChanged() or that listfunction this is the last resort */
    fun refresh(){
        val refreshActivity = intent
        finish()
        startActivity(refreshActivity)
    }
    fun firenotification(){
        lateinit var notificationManager : NotificationManager
        lateinit var notificationChannel : NotificationChannel
        lateinit var builder : Notification.Builder
        val channelId = "com.example.vicky.notificationexample"
        val description = "Queue has been emptied!!!"
        notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        val intent = Intent(this, Queue::class.java)
        val pendingItent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notificationChannel = NotificationChannel(channelId,description,
                NotificationManager.IMPORTANCE_HIGH)
            notificationChannel.enableLights(true )
            notificationChannel.lightColor = Color.BLUE
            notificationChannel.enableVibration(false)
            notificationManager.createNotificationChannel(notificationChannel)

            builder = Notification.Builder(this, channelId)
                .setContentTitle("ATTENTION!!")
                .setContentText("Your Queue is now Empty.")
                .setSmallIcon(R.drawable.ic_launcher_round)
                .setLargeIcon(BitmapFactory.decodeResource(this.resources,R.drawable.ic_launcher))
                .setContentIntent(pendingItent)
        }else{
            builder = Notification.Builder(this)
                .setContentTitle("ATTENTION!!")
                .setContentText("Your Queue is now Empty.")
                .setSmallIcon(R.drawable.ic_launcher_round)
                .setLargeIcon(BitmapFactory.decodeResource(this.resources,R.drawable.ic_launcher))
                .setContentIntent(pendingItent)
        }
        notificationManager.notify(36663,builder.build())
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
                testList.removeAt(info.position)
                Toast.makeText(applicationContext, "Song removed from Queue", Toast.LENGTH_LONG).show()
                refresh()
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }



    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater : MenuInflater = menuInflater
        inflater.inflate(R.menu.queuemenu, menu)
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
            R.id.emptyQ-> {
                testList.clear()
                firenotification()
                refresh()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
        return super.onOptionsItemSelected(item)
    }
}