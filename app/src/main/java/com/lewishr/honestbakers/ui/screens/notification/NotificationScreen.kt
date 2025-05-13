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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController



// Data class for a Notification item
data class NotificationItem(
    val id: Int,
    val title: String,
    val message: String,
    val time: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotificationScreen(navController: NavController) {
    // Sample notification list. Replace with your dynamic data source.
    val notifications = listOf(
        NotificationItem(1, "Order Confirmed", "Your order #1234 has been confirmed.", "10:30 AM"),
        NotificationItem(2, "Payment Received", "We received your payment successfully.", "9:15 AM"),
        NotificationItem(3, "New Message", "You have a new message from support.", "Yesterday"),
        NotificationItem(4, "Discount Offer", "Get 10% off your next order!", "2 days ago")
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Notifications") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF4E342E), // Deep brown color
                    titleContentColor = Color.White
                )
            )
        },
        content = { paddingValues ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                // List each notification item
                items(notifications) { notification ->
                    NotificationCard(notification)
                }
            }
        }
    )
}

@Composable
fun NotificationCard(notification: NotificationItem) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = notification.title,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = notification.message,
                fontSize = 14.sp,
                color = Color.DarkGray
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = notification.time,
                fontSize = 12.sp,
                color = Color.Gray
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NotificationScreenPreview() {
    NotificationScreen(navController = rememberNavController())
}
