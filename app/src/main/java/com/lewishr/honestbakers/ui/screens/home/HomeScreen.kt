package com.lewishr.honestbakers.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults

import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.lewishr.honestbakers.R

import com.lewishr.honestbakers.navigation.ROUT_CHAT
import com.lewishr.honestbakers.navigation.ROUT_HOME
import com.lewishr.honestbakers.navigation.ROUT_LOCATION
import com.lewishr.honestbakers.navigation.ROUT_MENU
import com.lewishr.honestbakers.navigation.ROUT_PROFILE
import com.lewishr.honestbakers.ui.theme.newbrown

@Composable
fun HomeScreen(navController: NavController) {
    var selectedIndex by remember { mutableStateOf(0) }

    Scaffold(
        bottomBar = {
            NavigationBar(containerColor = newbrown) {
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
                    label = { Text("Home") },
                    selected = selectedIndex == 0,
                    onClick = {
                        selectedIndex = 0
                        navController.navigate(ROUT_HOME)
                    },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = Color(0xFF4E342E), // Dark Brown
                        selectedTextColor = Color(0xFF4E342E),
                        indicatorColor = Color(0xFFFFF3E0) // Light cream highlight
                    )
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.LocationOn, contentDescription = "Location") },
                    label = { Text("Location") },
                    selected = selectedIndex == 1,
                    onClick = {
                        selectedIndex = 1
                        navController.navigate(ROUT_LOCATION)
                    },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = Color(0xFF4E342E),
                        selectedTextColor = Color(0xFF4E342E),
                        indicatorColor = Color(0xFFFFF3E0)
                    )
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.MailOutline, contentDescription = "Messages") },
                    label = { Text("Messages") },
                    selected = selectedIndex == 2,
                    onClick = {
                        selectedIndex = 2
                        navController.navigate(ROUT_CHAT)
                    },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = Color(0xFF4E342E),
                        selectedTextColor = Color(0xFF4E342E),
                        indicatorColor = Color(0xFFFFF3E0)
                    )
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Person, contentDescription = "Profile") },
                    label = { Text("Profile") },
                    selected = selectedIndex == 3,
                    onClick = {
                        selectedIndex = 3
                        navController.navigate(ROUT_PROFILE)
                    },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = Color(0xFF4E342E),
                        selectedTextColor = Color(0xFF4E342E),
                        indicatorColor = Color(0xFFFFF3E0)
                    )
                )
            }
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .background(color = Color(0xFFFFF8E1)) // Warm light cream background
            ) {
                // Top banner card
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 12.dp),
                    shape = RoundedCornerShape(16.dp),

                ) {
                    Image(
                        painter = painterResource(R.drawable.img_8),
                        contentDescription = "Bakery Top Banner",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(220.dp),
                        contentScale = ContentScale.Crop
                    )
                }

                Spacer(modifier = Modifier.height(12.dp))

                // Introductory bakery text paragraph
                Text(
                    text = "At HonestBakers, we craft every loaf with passion and the finest ingredients. " +
                            "From classic sourdough to delicate pastries, our baked goods bring warmth and sweetness " +
                            "to every moment. Explore our delicious menu and find your new favorite treat today!",
                    fontSize = 16.sp,
                    color = Color(0xFF5D4037), // Deep brown text
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier
                        .padding(horizontal = 24.dp)
                        .fillMaxWidth(),
                    lineHeight = 22.sp
                )

                Spacer(modifier = Modifier.height(18.dp))

                // Highlight image card
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    shape = RoundedCornerShape(16.dp),

                ) {
                    Image(
                        painter = painterResource(R.drawable.img_3),
                        contentDescription = "Featured Bakery Image",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp),
                        contentScale = ContentScale.Crop
                    )
                }

                Spacer(modifier = Modifier.height(24.dp))

                Text(
                    text = "Recommended for you",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF4E342E), // Dark Brown
                    modifier = Modifier.padding(start = 24.dp, bottom = 12.dp)
                )

                Row(
                    modifier = Modifier
                        .padding(horizontal = 20.dp)
                        .horizontalScroll(rememberScrollState())
                ) {
                    val cardImages = listOf(
                        R.drawable.img_5,
                        R.drawable.img_6,
                        R.drawable.img_4,
                        R.drawable.hd,
                        R.drawable.ck
                    )
                    cardImages.forEachIndexed { index, imageResId ->
                        Card(
                            modifier = Modifier
                                .width(160.dp)
                                .height(200.dp)
                                .clip(RoundedCornerShape(16.dp))
                                .background(newbrown)
                                .shadow(6.dp, RoundedCornerShape(16.dp))
                                .padding(4.dp),
                            shape = RoundedCornerShape(16.dp),
                          
                        ) {
                            Image(
                                painter = painterResource(imageResId),
                                contentDescription = "Recommended Item $index",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier.fillMaxSize()
                            )
                        }
                        Spacer(modifier = Modifier.width(16.dp))
                    }
                }

                Spacer(modifier = Modifier.height(28.dp))

                Button(
                    onClick = { navController.navigate(ROUT_MENU) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 32.dp)
                        .height(52.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF6D4C41), // Medium brown
                        contentColor = Color(0xFFFFF3E0) // Light cream text
                    ),
                    shape = RoundedCornerShape(28.dp),
                    elevation = ButtonDefaults.buttonElevation(
                        defaultElevation = 12.dp,
                        pressedElevation = 16.dp
                    )
                ) {
                    Text(
                        text = "Welcome to our HonestBakers Menu",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }

                Spacer(modifier = Modifier.height(36.dp))
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(rememberNavController())
}
