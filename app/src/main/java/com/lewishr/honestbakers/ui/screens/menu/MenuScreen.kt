package com.lewishr.honestbakers.ui.screens.Menu

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.compose.foundation.shape.RoundedCornerShape
import com.lewishr.honestbakers.navigation.ROUT_CHAT
import com.lewishr.honestbakers.navigation.ROUT_HOME
import com.lewishr.honestbakers.navigation.ROUT_LOCATION
import com.lewishr.honestbakers.navigation.ROUT_PAYMENT
import com.lewishr.honestbakers.navigation.ROUT_RECIPE
import com.lewishr.honestbakers.R
import com.lewishr.honestbakers.navigation.ROUT_NOTIFICATION
import com.lewishr.honestbakers.navigation.ROUT_PROFILE





// Deep brown color definition
val deepBrown = Color(0xFF4E342E)
val whiteColor = Color.White

data class MenuData(val name: String, val price: String, val imageRes: Int)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuScreen(navController: NavController) {
    var selectedIndex by remember { mutableStateOf(0) }
    var search by remember { mutableStateOf("") }

    val menuItems = listOf(
        MenuData("Birthday Cake", "Ksh.700", R.drawable.bt),
        MenuData("Wedding Cake", "Ksh.1500", R.drawable.wd),
        MenuData("Anniversary Cake", "Ksh.2000", R.drawable.an),
        MenuData("Holiday Cake", "Ksh.1170", R.drawable.hd),
        MenuData("Oreo Ice", "Ksh.1000", R.drawable.oreo),
        MenuData("Red Velvet", "Ksh.800", R.drawable.redvert),
        MenuData("Chicken", "Ksh.1500", R.drawable.ck),
        MenuData("Fish", "Ksh.1770", R.drawable.fish),
        MenuData("Beef", "Ksh.1000", R.drawable.bf),
        MenuData("Duck", "Ksh.1770", R.drawable.duck),
        MenuData("Chapati", "Ksh.70", R.drawable.chapati),
        MenuData("Smokie", "Ksh.60", R.drawable.smokie),
        MenuData("Madazi", "Ksh.30", R.drawable.madazi),
        MenuData("Chips", "Ksh.170", R.drawable.chips),
        MenuData("Samosa", "Ksh.40", R.drawable.samosa),
        MenuData("Packed Bakes", "Ksh.50", R.drawable.packed),
        MenuData("Fresh Meat", "Ksh.800", R.drawable.meat),
        MenuData("Pork", "Ksh.1200", R.drawable.pock)
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Welcome to our Menu",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                },
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
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = deepBrown,
                    titleContentColor = Color.White,
                    navigationIconContentColor = Color.White,
                    actionIconContentColor = Color.White
                )
            )
        },
        bottomBar = {
            NavigationBar(containerColor = deepBrown) {
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
                .padding(paddingValues)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .background(Color(0xFFF5F5F5)) // Light contrast background
        ) {

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(horizontal = 16.dp, vertical = 12.dp),
                shape = RoundedCornerShape(16.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.img_1),
                    contentDescription = "Header Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }

            // Search bar
            OutlinedTextField(
                value = search,
                onValueChange = { search = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .height(56.dp),
                leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Search") },
                placeholder = { Text("Search here...") },
                shape = RoundedCornerShape(12.dp),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Filter menu items based on search
            val filteredItems = if (search.isBlank()) menuItems else {
                menuItems.filter {
                    it.name.contains(search, ignoreCase = true)
                }
            }

            // Display items in two columns
            val chunkedItems = filteredItems.chunked(2)

            chunkedItems.forEach { rowItems ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    for (item in rowItems) {
                        MenuCard(
                            item = item,
                            onOrderClick = {
                                navController.navigate(ROUT_PAYMENT)
                            },
                            modifier = Modifier.weight(1f)
                        )
                    }
                    if (rowItems.size < 2) {
                        Spacer(modifier = Modifier.weight(1f))
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

@Composable
fun MenuCard(item: MenuData, onOrderClick: () -> Unit, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .height(220.dp),
        shape = RoundedCornerShape(15.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Column(
            modifier = Modifier
                .background(deepBrown)
                .fillMaxSize()
                .padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = painterResource(item.imageRes),
                contentDescription = item.name,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .height(110.dp)
                    .fillMaxWidth()
            )
            Text(
                text = item.name,
                color = whiteColor,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
            Text(
                text = item.price,
                color = whiteColor,
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp
            )
            Button(
                onClick = onOrderClick,
                colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray),
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Order now", color = whiteColor)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MenuScreenPreview() {
    MenuScreen(navController = rememberNavController())
}
