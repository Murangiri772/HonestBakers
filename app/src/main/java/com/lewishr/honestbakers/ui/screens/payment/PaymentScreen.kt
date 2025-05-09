package com.lewishr.honestbakers.ui.screens.payment

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.lewishr.honestbakers.R
import com.lewishr.honestbakers.navigation.ROUT_HOME
import com.lewishr.honestbakers.navigation.ROUT_MENU
import com.lewishr.honestbakers.ui.theme.newbrown


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PaymentScreen(navController: NavController){
    //Scaffold
   var mContext = LocalContext.current

    var selectedIndex by remember { mutableStateOf(0) }

    Scaffold(
        //TopBar
        topBar = {
            TopAppBar(
                title = { Text("Pay here") },
                navigationIcon = {
                    IconButton(onClick = {navController.navigate(ROUT_MENU) }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")

                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = newbrown,
                    titleContentColor = Color.White,
                    navigationIconContentColor = Color.White
                )
            )
        },




        //Contents
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .paint(
                        painter = painterResource(R.drawable.img_9),
                        contentScale = ContentScale.FillBounds
                    ),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Column {
                    Text(text = "Pay via tel:0723704577")
                }


                Card(
                    modifier = Modifier.fillMaxWidth().height(500.dp).padding(10.dp)

                ) {
                    Column(
                        modifier = Modifier.fillMaxSize().background(newbrown).padding(10.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center


                    ) {
                        Image(
                            painter = painterResource(R.drawable.img_12),
                            contentDescription = "",
                            modifier = Modifier.fillMaxWidth().height(500.dp),
                            contentScale = ContentScale.FillHeight)





                    }

                }




                //MPESA
                Button(
                    onClick = {
                        val simToolKitLaunchPayment =
                            mContext.packageManager.getLaunchIntentForPackage("com.android.stk")
                        simToolKitLaunchPayment?.let { mContext.startActivity(it) }


                        navController.navigate(ROUT_MENU)
                    },
                    colors = ButtonDefaults.buttonColors(newbrown),
                    shape = RoundedCornerShape(size = 10.dp),
                    modifier = Modifier.fillMaxWidth().padding(start = 20.dp, end = 20.dp, bottom = 50.dp)
                )
                {
                    Text(text = "Via MPESA", color = Color.Green)
                }

                Spacer(modifier = Modifier.width(20.dp))
                //CALL














            }


        }
    )











}
@Preview()
@Composable
fun PaymentScreenPreview(){
    PaymentScreen(rememberNavController())

}