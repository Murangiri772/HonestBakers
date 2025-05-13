package com.lewishr.honestbakers.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box

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
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults

import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
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
import androidx.compose.ui.graphics.Brush
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
import com.lewishr.honestbakers.navigation.ROUT_MENU_BAKES

import com.lewishr.honestbakers.navigation.ROUT_NOTIFICATION
import com.lewishr.honestbakers.navigation.ROUT_PROFILE
import com.lewishr.honestbakers.navigation.ROUT_RECIPE
import com.lewishr.honestbakers.ui.theme.newwite


val deepbrown = Color(0xFF4E342E)    // Deep brown color used
val newbrown = deepbrown             // For usage consistency, using deepbrown as newbrown

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    var selectedIndex by remember { mutableStateOf(0) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Welcome to HonestBakers",
                        fontWeight = FontWeight.Bold,
                        fontSize = 24.sp
                        ,color = newwite
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.navigate(ROUT_HOME) }) {
                        Icon(Icons.Default.Menu, contentDescription = "Back", tint = Color.White)
                    }
                },
                actions = {

                    IconButton(onClick = { navController.navigate(ROUT_NOTIFICATION) }) {
                        Icon(imageVector = Icons.Default.Notifications, contentDescription = "Notification", tint = Color.White)
                    }
                    IconButton(onClick = { navController.navigate(ROUT_RECIPE) }) {
                        Icon(imageVector = Icons.Default.ArrowForward, contentDescription = "Forward", tint = Color.White)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = deepbrown,
                    titleContentColor = Color.White,
                    navigationIconContentColor = Color.White,
                    actionIconContentColor = Color.White
                )
            )
        },
        bottomBar = {
            NavigationBar(containerColor = deepbrown) {
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Home, contentDescription = "Home", tint = Color.White) },
                    label = { Text("Home",color = newwite) },
                    selected = selectedIndex == 0,
                    onClick = {
                        selectedIndex = 0
                        navController.navigate(ROUT_HOME)
                    },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = deepbrown,
                        selectedTextColor = deepbrown,
                        indicatorColor = Color(0xFFFFF3E0)
                    )
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.LocationOn, contentDescription = "Location", tint = Color.White) },
                    label = { Text("Location",color = newwite) },
                    selected = selectedIndex == 1,
                    onClick = {
                        selectedIndex = 1
                        navController.navigate(ROUT_LOCATION)
                    },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = deepbrown,
                        selectedTextColor = deepbrown,
                        indicatorColor = Color(0xFFFFF3E0)
                    )
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.MailOutline, contentDescription = "Messages", tint = Color.White) },
                    label = { Text("Messages",color = newwite) },
                    selected = selectedIndex == 2,
                    onClick = {
                        selectedIndex = 2
                        navController.navigate(ROUT_CHAT)
                    },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = deepbrown,
                        selectedTextColor = deepbrown,
                        indicatorColor = Color(0xFFFFF3E0)
                    )
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Person, contentDescription = "Profile", tint = Color.White) },
                    label = { Text("Profile",color = newwite) },
                    selected = selectedIndex == 3,
                    onClick = {
                        selectedIndex = 3
                        navController.navigate(ROUT_PROFILE)
                    },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = deepbrown,
                        selectedTextColor = deepbrown,
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
                    .background(color = Color(0xFFFFF8E1))
            ) {
                // Top banner card with gradient overlay
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 12.dp),
                    shape = RoundedCornerShape(16.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
                ) {
                    Box {
                        Image(
                            painter = painterResource(R.drawable.img_1),
                            contentDescription = "Bakery Top Banner",
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(220.dp),
                            contentScale = ContentScale.Crop
                        )
                        Box(
                            modifier = Modifier
                                .matchParentSize()
                                .background(
                                    Brush.verticalGradient(
                                        colors = listOf(
                                            Color.Transparent,
                                            Color.Black.copy(alpha = 0.5f)
                                        )
                                    )
                                )
                        )
                        Text(
                            text = "Freshly Baked Every Day!",
                            color = Color.White,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .align(Alignment.BottomCenter)
                                .padding(16.dp)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = "At HonestBakers, we craft every loaf with passion and the finest ingredients. " +
                            "From classic sourdough to delicate pastries, our baked goods bring warmth and sweetness " +
                            "to every moment. Explore our delicious menu and find your new favorite treat today!",
                    fontSize = 16.sp,
                    color = Color(0xFF5D4037),
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier
                        .padding(horizontal = 24.dp)
                        .fillMaxWidth(),
                    lineHeight = 22.sp
                )

                Spacer(modifier = Modifier.height(18.dp))

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    shape = RoundedCornerShape(16.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
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
                    color = deepbrown,
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
                                .background(deepbrown)
                                .shadow(6.dp, RoundedCornerShape(16.dp))
                                .padding(4.dp),
                            shape = RoundedCornerShape(16.dp),
                            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
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
                    onClick = { navController.navigate(ROUT_MENU_BAKES) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 32.dp)
                        .height(52.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = deepbrown,
                        contentColor = Color(0xFFFFF3E0)
                    ),
                    shape = RoundedCornerShape(28.dp),
                    elevation = ButtonDefaults.buttonElevation(
                        defaultElevation = 12.dp,
                        pressedElevation = 16.dp
                    )
                ) {
                    Text(
                        text = "Explore Our Delicious Menu",
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
