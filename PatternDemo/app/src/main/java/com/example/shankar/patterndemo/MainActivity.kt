package com.example.shankar.patterndemo

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.preference.PreferenceManager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.Toast
import com.example.shankar.patterndemo.iterator.MenuTestDrive
import com.example.shankar.patterndemo.qrgenerator.QRGContents
import com.example.shankar.patterndemo.qrgenerator.QRGEncoder
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.zxing.WriterException
import org.osmdroid.config.Configuration
import java.util.*

class MainActivity : AppCompatActivity(), ServiceConnection {
    private var s: LocalWordService? = null
    private var wordList: ArrayList<String>? = null
    private var adapter: ArrayAdapter<String>? = null
    private var ivQR: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView = findViewById<View>(R.id.list) as ListView
        wordList = ArrayList()
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, android.R.id.text1, wordList!!)
        listView.adapter = adapter

        ivQR = findViewById<View>(R.id.ivQR) as ImageView

        val ctx = applicationContext
        //important! set your user agent to prevent getting banned from the osm servers
        Configuration.getInstance().load(ctx, PreferenceManager.getDefaultSharedPreferences(ctx))


        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        val fab = findViewById<View>(R.id.fab) as FloatingActionButton
        fab.setOnClickListener {
            //				Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
            //						.setAction("Action", null).show();
            MenuTestDrive.main()
            //				Util.scheduleJob(MainActivity.this);
            //				startActivity(new Intent(MainActivity.this, PlayerActivity.class));
        }

        //		container
        //		getSupportFragmentManager().beginTransaction()
        //				.add(R.id.container, new StarterMapFragment(), StarterMapFragment.class.getName())
        //				.commit();

        //		IntentFilter filter = new IntentFilter(Intent.ACTION_MEDIA_BUTTON);
        //		MediaButtonIntentReceiver r = new MediaButtonIntentReceiver();
        //		registerReceiver(r, filter);


        //		((AudioManager)getSystemService(AUDIO_SERVICE)).registerMediaButtonEventReceiver(
        //				new ComponentName(
        //						getPackageName(),
        //						MediaButtonIntentReceiver.class.getName()));

        start()

        FirebaseAnalytics.getInstance(this).logEvent(FirebaseAnalytics.Event.APP_OPEN, Bundle().apply {
            putString("here", "there")
        })

    }

    override fun onResume() {
        super.onResume()
        //this will refresh the osmdroid configuration on resuming.
        //if you make changes to the configuration, use
        //SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        //Configuration.getInstance().save(this, prefs);
        Configuration.getInstance().load(this, PreferenceManager.getDefaultSharedPreferences(this))
        val intent = Intent(this, LocalWordService::class.java)
        bindService(intent, this, Context.BIND_AUTO_CREATE)
    }

    override fun onPause() {
        super.onPause()
        unbindService(this)
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId


        return if (id == R.id.action_settings) {
            true
        } else super.onOptionsItemSelected(item)

    }

    fun onClick(view: View) {
        when (view.id) {
            R.id.updateList -> if (s != null) {
                Toast.makeText(this, "Number of elements" + s!!.wordList.size,
                        Toast.LENGTH_SHORT).show()
                wordList!!.clear()
                wordList!!.addAll(s!!.wordList)
                adapter!!.notifyDataSetChanged()
            }
            R.id.triggerServiceUpdate -> {
                val service = Intent(applicationContext, LocalWordService::class.java)
                applicationContext.startService(service)

                val qrgEncoder = QRGEncoder(
                        "Shankar", null,
                        QRGContents.Type.TEXT,
                        200)
                try {
                    val bitmap = qrgEncoder.encodeAsBitmap()
                    ivQR!!.setImageBitmap(bitmap)
                } catch (e: WriterException) {
                    Log.v("HElo", e.toString())
                }

            }
        }
    }

    override fun onServiceConnected(name: ComponentName, binder: IBinder) {
        val b = binder as LocalWordService.MyBinder
        s = b.service
        Toast.makeText(this@MainActivity, "Connected", Toast.LENGTH_SHORT).show()
    }

    override fun onServiceDisconnected(name: ComponentName) {
        s = null
    }


}
