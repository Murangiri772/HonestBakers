package com.lewishr.honestbakers.ui.screens.payment

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.lewishr.honestbakers.R



import com.lewishr.honestbakers.navigation.ROUT_HOME
import com.lewishr.honestbakers.navigation.ROUT_MENU
import com.lewishr.honestbakers.ui.theme.newbrown

val newbrown = Color(0xFF4E342E)
val newwite = Color.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PaymentScreen(navController: NavController) {
    val context = LocalContext.current

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Pay Here",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        color = newwite
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.navigate(ROUT_MENU) }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back", tint = newwite)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = newbrown,
                    titleContentColor = newwite,
                    navigationIconContentColor = newwite
                )
            )
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .background(Color(0xFFF9F7F4))  // Light cream background for warm contrast
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                // Payment instructions card
                Card(
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = newbrown),
                    modifier = Modifier.fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(8.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .padding(20.dp)
                            .fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            "Send your payment to the following number:",
                            color = newwite,
                            fontSize = 16.sp,
                            textAlign = TextAlign.Center
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            "0723704577",
                            color = Color.Yellow,
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 24.sp,
                            textAlign = TextAlign.Center
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            "Use your MPESA app to complete the payment securely.",
                            color = newwite.copy(alpha = 0.8f),
                            fontSize = 14.sp,
                            textAlign = TextAlign.Center
                        )
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // Payment image card
                Card(
                    shape = RoundedCornerShape(16.dp),
                    elevation = CardDefaults.cardElevation(8.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(280.dp)
                ) {
                    Image(
                        painter = painterResource(R.drawable.img_12),
                        contentDescription = "Scan to Pay",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                }

                Spacer(modifier = Modifier.height(24.dp))

                // MPESA Payment button with image from drawable as icon
                Button(
                    onClick = {
                        val simToolKitLaunchPayment =
                            context.packageManager.getLaunchIntentForPackage("com.android.stk")
                        simToolKitLaunchPayment?.let { context.startActivity(it) }
                        navController.navigate(ROUT_MENU)
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = newbrown),
                    shape = RoundedCornerShape(14.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),
                    contentPadding = PaddingValues(horizontal = 20.dp)
                ) {
                    Image(
                        painter = painterResource(R.drawable.mpesa_logo),
                        contentDescription = "MPESA Logo",
                        modifier = Modifier
                            .size(28.dp)
                            .align(Alignment.CenterVertically)
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    Text(
                        text = "Pay via MPESA",
                        color = newwite,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                }
            }
        }
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PaymentScreenPreview() {
    PaymentScreen(rememberNavController())
}


