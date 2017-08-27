package net.blueness.broadcasttest

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.support.v4.content.LocalBroadcastManager
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var intentFilter: IntentFilter? = null
//    private var networkChangeReceiver: NetworkChangeReceiver? = null
    private var localReceiver: LocalReceiver? = null
    private var localBroadcastManager: LocalBroadcastManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        intentFilter = IntentFilter()
//        intentFilter?.addAction("android.net.conn.CONNECTIVITY_CHANGE")
//        networkChangeReceiver = NetworkChangeReceiver()
//        registerReceiver(networkChangeReceiver, intentFilter)
        localBroadcastManager = LocalBroadcastManager.getInstance(this)

        button.setOnClickListener{
//            val intent = Intent("net.blueness.broadcasttest.MY_BROADCAST")
//            sendOrderedBroadcast(intent, null)
            val intent = Intent("net.blueness.broadcasttest.LOCAL_BROADCAST")
            localBroadcastManager?.sendBroadcast(intent)
        }
        intentFilter = IntentFilter()
        intentFilter?.addAction("net.blueness.broadcasttest.LOCAL_BROADCAST")
        localReceiver = LocalReceiver()
        localBroadcastManager?.registerReceiver(localReceiver, intentFilter)
    }

    override fun onDestroy() {
        super.onDestroy()
//        unregisterReceiver(networkChangeReceiver)
    }

//    inner class NetworkChangeReceiver: BroadcastReceiver() {
//
//        override fun onReceive(context: Context?, intent: Intent?) {
//
//            val connectionManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
//            val networkInfo = connectionManager.activeNetworkInfo
//            if (networkInfo != null && networkInfo.isAvailable) {
//                Toast.makeText(context, "network is available",
//                        Toast.LENGTH_SHORT).show()
//            } else {
//                Toast.makeText(context, "network is unavailable",
//                        Toast.LENGTH_SHORT).show()
//            }
//        }
//    }

    class LocalReceiver: BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            Toast.makeText(context, "received local broadcast", Toast.LENGTH_SHORT).show()
        }

    }

}

