package com.example.chatapp

import android.se.omapi.Channel
import android.view.View
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.viewmodel.compose.viewModel
import io.getstream.chat.android.ui.avatar.AvatarView
import io.getstream.chat.android.ui.channel.list.adapter.ChannelListItem
import io.getstream.chat.android.ui.channel.list.viewmodel.ChannelListViewModel
import io.getstream.chat.android.ui.channel.list.viewmodel.factory.ChannelListViewModelFactory

@Composable
fun ChannelListScreen(
    ChannelListViewModel: ChannelListViewModel = viewModel(//1
        factory = ChannelListViewModelFactory()
    ),
){
    val state by channelListViewModel.state.observeAsState()
    val channelState = state?: return // 2

    Box( //3
        modifier = Modifier.fillMaxSize(),
    contentAlignment = Alignment.Center,
    ){
        if (channelState.isLoading) {
            CircularProgressIndicator() //4
        } else {
            LazyColumn(Modifier.fillMaxSize()) {  //5
                items(channelState.channels) { channel ->
                    ChannelListItem(channel)
                    Divider()
                }
            }
        }
    }
}


@Composable
fun ChannelListItem(channel: Channel) {
    Row(//1
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    )    {
        AvatarView(channel) //2
        Column(modifier = Modifier.padding(start = 8.dp)) { //3
            Text(
                text = channel.getDisplayName(LocalContext.current),
            style = TextStyle(fontWeight = FontWeight.Bold),
                fontSize = 18.sp,
            )

            val lastMessageText = channel.messages.lastOrNull()?.text ?: "..."
            Text(
                text = lastMessageText,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            )
        }
    }
}

@Composable
fun Avatar(channel: Channel) {
    AndroidView(
        factory = { context -> AvatarView(context) },
        update = { view -> view.setChannelData(channel) },
        modifier = Modifier.size(48.dp)
    )
}