package com.lewishr.honestbakers.ui.screens.recipe

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
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
import androidx.room.util.TableInfo
import com.lewishr.honestbakers.R
import com.lewishr.honestbakers.navigation.ROUT_MENU

import com.lewishr.honestbakers.ui.theme.newbrown
import com.lewishr.honestbakers.ui.theme.newred
import com.lewishr.honestbakers.ui.theme.newwite


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipeScreen(navController: NavController){

    Column (
        modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState())
            .paint(painter = painterResource(R.drawable.img_9), contentScale = ContentScale.FillBounds)
    ){

        //TopAppBar

        TopAppBar(
            title = { Text(text = "Recipes",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = newwite)
                    },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = newbrown,
                titleContentColor = Color.Black,
                navigationIconContentColor = newwite,

                ),
            navigationIcon = {
                IconButton(onClick = {navController.navigate(ROUT_MENU)}) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "")
                }
            },


            )


        Column (
            modifier = Modifier.fillMaxWidth().padding(20.dp)){

            Text(text = "Recipes of some of our products",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp)

        }
        Spacer(modifier = Modifier.height(10.dp))





        Column (
            modifier = Modifier.fillMaxWidth().padding(start = 10.dp, end = 10.dp)
        ){

            Text(text = "Recipe of cake",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp)

        }
        Spacer(modifier = Modifier.height(20.dp))
        Column (
            modifier = Modifier.fillMaxWidth().padding(start = 10.dp)
        ){
            Text(text = "Ingredients required",
                fontWeight = FontWeight.Bold)
        }
        Spacer(modifier = Modifier.height(10.dp))
        Column (
            modifier = Modifier.fillMaxWidth().padding(start = 10.dp)
        ){
            Text(text = "1 cup of white sugar")
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "1/2 cup unsalted butter")
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "2 large eggs")
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "2 teaspoons vanilla extra")
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "1 1/2 cups all-purpose flour")
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "1  3/4 teaspoons baking powder")
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "1/2 cup milk")

        }
        Spacer(modifier = Modifier.height(10.dp))
        Column (
            modifier = Modifier.fillMaxWidth().padding(start = 10.dp)
        ){
            Text(text = "Steps ",
                fontWeight = FontWeight.Bold)
        }
        Spacer(modifier = Modifier.height(10.dp))
        Column (
            modifier = Modifier.fillMaxWidth().padding(start = 10.dp)
        ){
            Text(text = "1. Gather the ingredients together an preheat the oven")
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "2. Cream the butter and surer together")
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "3. Add the eggs and vanilla")
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "4. Add the dry ingredients")
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "5. Bake the cake")

        }
        Spacer(modifier = Modifier.height(10.dp))


        Column (
            modifier = Modifier.padding(start = 20.dp)
        ){
            Text(text = "Recipe of Bread",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp)

        }
        Spacer(modifier = Modifier.height(20.dp))

        Column (
            modifier = Modifier.fillMaxWidth().padding(start = 10.dp)
        ){
            Text(text = "Ingredients required",
                fontWeight = FontWeight.Bold)

        }

        Column (
            modifier = Modifier.fillMaxWidth().padding(start = 10.dp)
        ){
            Text(text = ". Warm water")
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = ". Active Dry Yeast")
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = ". Granulated sugar or honey")
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = ". Salt")
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = ". Oil")
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = ". Flour")


        }
        Spacer(modifier = Modifier.height(10.dp))
        Column (
            modifier = Modifier.fillMaxWidth().padding(10.dp)
        ){
            Text(text = "Steps",
                fontWeight = FontWeight.Bold)

        }
        Spacer(modifier = Modifier.height(10.dp))
        Column (
            modifier = Modifier.fillMaxWidth().padding(start = 10.dp)
        ){
            Text(text = "1. Proof the yeast")
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "2. Prepare the dough")
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "3. Kneed the dough")
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "4. First rise")
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "5. Punch the dough down")
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "6. Divide into equal portions")
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "7. Second rise")
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "8. Bake")
        }








    }






}



@Preview(showBackground = true)
@Composable
fun RecipeScreenPreview(){
    RecipeScreen(rememberNavController())

}