package com.example.notificationapp


import android.app.NotificationManager
import android.content.Intent
import android.util.Log
import androidx.core.app.NotificationCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class firebaseNotification : FirebaseMessagingService() {

    override fun onNewToken(token: String) {
        super.onNewToken(token)
        Log.i("FCM_TOKEN: ", token)
    }

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)
        remoteMessage.notification?.let {
            val title = it.title
            val body = it.body

            val notification = NotificationCompat.Builder(this, channelID)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle(title)
                .setContentText(body)
                .build()

            val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            manager.notify(notificationID, notification)
        }

        Log.i("DATA_MESSAGE", remoteMessage.data.toString())
        super.onMessageReceived(remoteMessage)
    }


    }
