


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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.lewishr.honestbakers.viewmodel.BakesViewModel
import com.lewishr.honestbakers.model.Bakes
import com.lewishr.honestbakers.navigation.*
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
                    title = { Text("Menu Bakes", fontSize = 20.sp) },
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
                        focusedBorderColor = Color.Black,
                        unfocusedBorderColor = Color.Gray,
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
                    MenuBakesItem(navController, filteredBakes[index])
                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun MenuBakesItem(navController: NavController, bakes: Bakes) {
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
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Box(modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = painter,
                contentDescription = "Bakes Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp),
                contentScale = ContentScale.Crop
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .align(Alignment.BottomStart)
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(Color.Transparent, Color(0xFF4A2E0F))
                        )
                    )
            )
            Column(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(start = 16.dp, bottom = 64.dp)
            ) {
                Text(
                    text = bakes.name,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color(0xFFFFE5B4)
                )
                Text(
                    text = "Price: Ksh${bakes.price}",
                    fontSize = 18.sp,
                    color = Color(0xFFFFE5B4)
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
                    .align(Alignment.BottomEnd)
            ) {
                Button(
                    onClick = {
                        navController.navigate(ROUT_PAYMENT)
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF7C4A00)),
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier.fillMaxWidth(0.5f)
                ) {
                    Text(text = "Order Now", color = Color.Yellow)
                }
            }
        }
    }
}


