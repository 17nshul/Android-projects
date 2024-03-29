package com.example.chatapp

import android.app.Application
import io.getstream.chat.android.client.ChatClient
import io.getstream.chat.android.client.models.User
import io.getstream.chat.android.client.models.image
import io.getstream.chat.android.client.models.name
import io.getstream.chat.android.livedata.ChatDomain

class ChatApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        val client = ChatClient.Builder(appContext = this, apiKey = "b67pax5b2wdq").build()

        val user = User().apply {
            id = "tutorial-droid"
            image = "https://bit.ly/2TIt8NR"
            name = "Tutorial Droid"
        }

        ChatDomain.Builder(client, this)
            .offlineEnabled()
            .build()

        client.connectUser(
            user,
            "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX2lkIjoidHV0b3JpYWwtZHJvaWQifQ.NhEr0hP9W9nwqV7ZkdShxvi02C5PR7SJE7Cs4y7kyqg"
        ).enqueue()
    }
}