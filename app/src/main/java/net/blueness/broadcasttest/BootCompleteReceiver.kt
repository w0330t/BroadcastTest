package net.blueness.broadcasttest

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class BootCompleteReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {

//        throw UnsupportedOperationException("Not yet implemented")
        Toast.makeText(context, "Boot Complete", Toast.LENGTH_LONG).show()
    }
}