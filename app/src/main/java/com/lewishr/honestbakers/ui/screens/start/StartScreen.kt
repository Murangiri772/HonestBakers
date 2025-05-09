package com.lewishr.honestbakers.ui.screens.start

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
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
import com.lewishr.honestbakers.navigation.ROUT_HOME
import com.lewishr.honestbakers.ui.theme.newred
import com.lewishr.honestbakers.ui.theme.newbrown


@Composable
fun StartScreen(navController: NavController){

    Column (
        modifier = Modifier.fillMaxSize()

    ){
        Card (
            modifier = Modifier.fillMaxWidth()
        ){


            Column (
                modifier = Modifier.fillMaxWidth().background(newbrown)
            ){

                Image(
                    painter = painterResource(R.drawable.img_2),
                    contentDescription = "",
                    modifier = Modifier.fillMaxWidth().height(500.dp),
                    contentScale = ContentScale.FillHeight)
            }

        }
        Card (
            modifier = Modifier.fillMaxWidth().height(500.dp),

            ){
            Column(
                modifier = Modifier.fillMaxWidth().padding(start = 20.dp, end = 20.dp)

            ) {
                Column (
                    modifier = Modifier.padding(20.dp)
                ){
                    Text(text = "Welcome to our delicious bakes Bakery HonestBakers",
                        fontWeight = FontWeight.Bold,
                        fontSize = 30.sp,
                        color = newred
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "Thanks for your successful log in to our HonestBakers App home of delicious bakes in the country ")


            }
            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                    navController.navigate(ROUT_HOME)

                },
                colors = ButtonDefaults.buttonColors(Color.DarkGray),
                modifier = Modifier.fillMaxWidth().padding(start = 20.dp, end = 20.dp)





            ) {
                Text(text = "Let's Get started")


            }

        }


    }








}
@Preview()
@Composable
fun StartScreenPreview(){
    StartScreen(rememberNavController())

}