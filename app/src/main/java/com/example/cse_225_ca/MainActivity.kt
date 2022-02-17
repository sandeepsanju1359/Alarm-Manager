package com.example.cse_225_ca

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {
   @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var toolbar = findViewById<Toolbar>(R.id.tbar)
        toolbar.setTitle("Alarm Manager")
        setSupportActionBar(toolbar) //replace toolbar as an ActionBar
        toolbar.setNavigationOnClickListener {
            Toast.makeText(this, "Back Arrow", Toast.LENGTH_LONG).show()
        }

        var start = findViewById<Button>(R.id.btnStart)
        var RStart = findViewById<Button>(R.id.btnRep)
        var cancel = findViewById<Button>(R.id.btnCancel)
        var Etext = findViewById<EditText>(R.id.time)
        var alarmManager: AlarmManager
        val intent = Intent(this,MainActivity3::class.java)
        val pendingIntent = PendingIntent.getBroadcast(this,234, intent, 0)


        start.setOnClickListener {
            var i = Etext.text.toString().toInt()
            alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
            alarmManager.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis()+(i*1000),pendingIntent)
            Toast.makeText(this, "Alarm set in $i seconds", Toast.LENGTH_LONG ).show()
        }

        RStart.setOnClickListener {
            alarmManager = getSystemService(ALARM_SERVICE) as AlarmManager
            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,System.currentTimeMillis(),5000,pendingIntent)
            Toast.makeText(this,"Repeating Alarm 5 Seconds", Toast.LENGTH_LONG).show()
        }

        cancel.setOnClickListener {
            alarmManager = getSystemService(ALARM_SERVICE) as AlarmManager
            alarmManager.cancel(pendingIntent)
            Toast.makeText(this,"Alarm Cancelled", Toast.LENGTH_SHORT).show()
        }
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_toolbar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id:Int = item.itemId
        if(id==R.id.settings)
        {
            val vg: ViewGroup? = findViewById(R.id.cstm_tst)
            val inflater = layoutInflater

            val layout: View = inflater.inflate(R.layout.cstm_layout,vg)

            val tv = layout.findViewById<TextView>(R.id.txtVw)
            tv.text = "Setting Clicked"

            val toast = Toast(applicationContext)

            toast.setGravity(Gravity.CENTER_VERTICAL, 0 , 100)
            toast.duration = Toast.LENGTH_LONG
            toast.setView(layout)
            toast.show()
            return true
        }
        else if(id == R.id.itemRating)
        {
            val intent = Intent(this,MainActivity4::class.java)
            startActivity(intent)
        }

        return super.onOptionsItemSelected(item)
    }
}