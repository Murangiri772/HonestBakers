package com.lewishr.honestbakers.ui.screens.splash

import android.annotation.SuppressLint

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.tooling.preview.Preview

import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.lewishr.honestbakers.R
import com.lewishr.honestbakers.navigation.ROUT_LOGIN
import com.lewishr.honestbakers.ui.theme.newbrown
import com.lewishr.honestbakers.ui.theme.newwite


import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun SplashScreen(navController: NavController){
    //navigation

    var coroutine = rememberCoroutineScope()
    coroutine.launch {
        delay(2000)
        navController.navigate(ROUT_LOGIN)
    }





    //End of navigation





    Column (
        modifier = Modifier.fillMaxSize().background(newbrown),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){


        Text(
            text = "HonestBakers",
            color = newwite,
            fontSize = 30.sp

        )
    }

}



@Preview(showBackground = true)
@Composable
fun SplashScreenPreview(){
    SplashScreen(rememberNavController())

}