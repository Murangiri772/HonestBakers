package com.lewishr.honestbakers.ui.screens.Bakes


import android.net.Uri
import android.os.Build

import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale

import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter

import com.lewishr.honestbakers.viewmodel.BakesViewModel
import com.lewishr.honestbakers.model.Bakes

import com.lewishr.honestbakers.navigation.ROUT_CHAT
import com.lewishr.honestbakers.navigation.ROUT_EDIT_BAKES
import com.lewishr.honestbakers.navigation.ROUT_HOME
import com.lewishr.honestbakers.navigation.ROUT_LOCATION
import com.lewishr.honestbakers.navigation.ROUT_NOTIFICATION
import com.lewishr.honestbakers.navigation.ROUT_PAYMENT
import com.lewishr.honestbakers.navigation.ROUT_PROFILE
import com.lewishr.honestbakers.navigation.ROUT_RECIPE

import com.lewishr.honestbakers.ui.screens.Menu.deepBrown
import com.lewishr.honestbakers.ui.screens.Menu.whiteColor



@RequiresApi(Build.VERSION_CODES.Q)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuBakesScreen(navController: NavController, viewModel: BakesViewModel) {
    val menuBakes by viewModel.allBakes.observeAsState(emptyList())

    var searchQuery by remember { mutableStateOf("") }


    val filteredBakes = menuBakes.filter {
        it.name.contains(searchQuery, ignoreCase = true)
    }




    Scaffold(
        topBar = {
            Column {
                TopAppBar(
                    title = { Text("Bakes", fontSize = 20.sp) },
                    colors = TopAppBarDefaults.mediumTopAppBarColors(
                        containerColor = deepBrown,
                        titleContentColor = Color.White,
                        navigationIconContentColor = Color.White,
                        actionIconContentColor = Color.White
                    ),
                    navigationIcon = {
                        IconButton(onClick = { navController.navigate(ROUT_HOME) }) {
                            Icon(Icons.Default.ArrowBack, contentDescription = "Back", tint = Color.White)
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

                    )


                //Search Bar
                OutlinedTextField(
                    value = searchQuery,
                    onValueChange = { searchQuery = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp, vertical = 8.dp),
                    placeholder = { Text("Search bakess...") },
                    singleLine = true,
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Search",
                            tint = Color.Gray
                        )
                    },
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color.Black,  // Border color when focused
                        unfocusedBorderColor = Color.Gray, // Border color when not focused
                        focusedTextColor = Color.Black,
                        unfocusedTextColor = Color.DarkGray
                    )
                )
            }
        },
        bottomBar = {
            NavigationBar(containerColor = deepBrown) {
                var selectedIndex by remember { mutableStateOf(0) }
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Home, contentDescription = "Home", tint = Color.White) },
                    label = { Text("Home", color = whiteColor) },
                    selected = selectedIndex == 0,
                    onClick = {
                        selectedIndex = 0
                        navController.navigate(ROUT_HOME)
                    }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.LocationOn, contentDescription = "Location", tint = Color.White) },
                    label = { Text("Location", color = whiteColor) },
                    selected = selectedIndex == 1,
                    onClick = {
                        selectedIndex = 1
                        navController.navigate(ROUT_LOCATION)
                    }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.MailOutline, contentDescription = "Messages", tint = Color.White) },
                    label = { Text("Messages", color = whiteColor) },
                    selected = selectedIndex == 2,
                    onClick = {
                        selectedIndex = 2
                        navController.navigate(ROUT_CHAT)
                    }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Person, contentDescription = "Profile", tint = Color.White) },
                    label = { Text("Profile", color = whiteColor) },
                    selected = selectedIndex == 3,
                    onClick = {
                        selectedIndex = 3
                        navController.navigate(ROUT_PROFILE)

                    }
                )
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {

            LazyColumn {
                items(filteredBakes.size) { index ->
                    BakesItem1(navController, filteredBakes[index], viewModel)
                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun BakesItem1(navController: NavController, bakes: Bakes, viewModel: BakesViewModel) {
    val painter: Painter = rememberAsyncImagePainter(
        model = bakes.imagePath?.let { Uri.parse(it) } ?: Uri.EMPTY
    )


    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable {
                if (bakes.id != 0) {
                    navController.navigate(ROUT_EDIT_BAKES)
                }
            },
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Box(modifier = Modifier.fillMaxWidth()) {
            // Bakes Image
            Image(
                painter = painter,
                contentDescription = "Bakes Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop
            )

            // Gradient Overlay
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .align(Alignment.BottomStart)
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(Color.Transparent, Color.Black.copy(alpha = 0.7f))
                        )
                    )
            )

            // Product Info
            Column(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(start = 12.dp, bottom = 60.dp)
            ) {
                Text(
                    text = bakes.name,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Text(
                    text = "Price: Ksh${bakes.price}",
                    fontSize = 16.sp,
                    color = Color.White
                )
            }

            // Buttons (Message, Edit, Delete, Download PDF)

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .align(Alignment.BottomEnd)
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Spacer(modifier = Modifier.width(20.dp))

                    Button(
                        onClick = {




                            navController.navigate(ROUT_PAYMENT)
                        },
                        colors = ButtonDefaults.buttonColors(Color.DarkGray),
                        shape = RoundedCornerShape(size = 10.dp),
                        modifier = Modifier.fillMaxWidth().padding(start = 20.dp, end = 20.dp)
                    )
                    {
                        Text(text = "Order Now", color = Color.Green)
                    }







                }
            }
        }
    }
}


