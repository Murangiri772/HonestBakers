package com.lewishr.honestbakers.ui.screens.notification

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.text.SimpleDateFormat
import java.util.*

data class Notification(
    val id: Int,
    val title: String,
    val message: String,
    val time: Long,
    val isRead: Boolean = false,
    val icon: ImageVector = Icons.Default.Notifications
)

class NotificationScreenActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                NotificationScreen()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotificationScreen() {
    val notifications = remember {
        mutableStateListOf(
            Notification(
                id = 1,
                title = "Account Alert",
                message = "Your account password was changed successfully.",
                time = System.currentTimeMillis() - 3_600_000L,
                isRead = false
            ),
            Notification(
                id = 2,
                title = "New Message",
                message = "You have received a new message from John.",
                time = System.currentTimeMillis() - 7_200_000L,
                isRead = true
            ),
            Notification(
                id = 3,
                title = "Promotion",
                message = "Get 20% off on your next purchase!",
                time = System.currentTimeMillis() - 86_400_000L,
                isRead = false
            ),
            Notification(
                id = 4,
                title = "Update Available",
                message = "A new update is available. Please update the app.",
                time = System.currentTimeMillis() - 172_800_000L,
                isRead = true
            )
        )
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Notifications", fontWeight = FontWeight.Bold, fontSize = 20.sp) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        }
    ) { paddingValues ->
        if (notifications.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                contentAlignment = Alignment.Center
            ) {
                Text("No notifications", color = MaterialTheme.colorScheme.onSurfaceVariant)
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                items(notifications) { notification ->
                    NotificationItem(notification)
                    Divider(color = MaterialTheme.colorScheme.outlineVariant, thickness = 0.5.dp)
                }
            }
        }
    }
}

@Composable
fun NotificationItem(notification: Notification) {
    val backgroundColor = if (notification.isRead) {
        MaterialTheme.colorScheme.surfaceVariant
    } else {
        MaterialTheme.colorScheme.primary.copy(alpha = 0.1f)
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(backgroundColor)
            .padding(horizontal = 16.dp, vertical = 12.dp)
            .clickable { /* TODO: Handle notification click */ },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = notification.icon,
            contentDescription = "Notification Icon",
            tint = if (notification.isRead) MaterialTheme.colorScheme.onSurfaceVariant else MaterialTheme.colorScheme.primary,
            modifier = Modifier.size(40.dp)
        )
        Spacer(modifier = Modifier.width(12.dp))
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = notification.title,
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = if (notification.isRead) FontWeight.Normal else FontWeight.Bold
                ),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                color = MaterialTheme.colorScheme.onSurface
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = notification.message,
                style = MaterialTheme.typography.bodyMedium,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = getTimeAgo(notification.time),
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

fun getTimeAgo(time: Long): String {
    val now = System.currentTimeMillis()
    val diff = now - time

    val seconds = diff / 1000
    val minutes = seconds / 60
    val hours = minutes / 60
    val days = hours / 24

    return when {
        seconds < 60 -> "Just now"
        minutes < 60 -> "$minutes min ago"
        hours < 24 -> "$hours hr ago"
        days < 7 -> "$days d ago"
        else -> {
            val sdf = SimpleDateFormat("MMM dd", Locale.getDefault())
            sdf.format(Date(time))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NotificationScreenPreview() {
    MaterialTheme {
        NotificationScreen()
    }
}
