package com.lewishr.honestbakers.ui.screens.Menu

import androidx.compose.foundation.Image
import androidx.compose.foundation.MarqueeAnimationMode
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
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.lewishr.honestbakers.R

import com.lewishr.honestbakers.navigation.ROUT_CHAT
import com.lewishr.honestbakers.navigation.ROUT_HOME
import com.lewishr.honestbakers.navigation.ROUT_LOCATION
import com.lewishr.honestbakers.navigation.ROUT_PAYMENT
import com.lewishr.honestbakers.navigation.ROUT_RECIPE
import com.lewishr.honestbakers.ui.theme.newbrown
import com.lewishr.honestbakers.ui.theme.newwite


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuScreen(navController: NavController){
    //Scaffold

    var selectedIndex by remember { mutableStateOf(0) }

    Scaffold(
        //TopBar
        topBar = {
            TopAppBar(
                title = { Text(text = "Welcom to our menu",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp) },
                navigationIcon = {
                    IconButton(onClick = {  navController.navigate(ROUT_HOME) }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")

                    }
                },
                actions = {
                    IconButton(onClick = {navController.navigate(ROUT_RECIPE)}) {
                        Icon(imageVector = Icons.Default.ArrowForward, contentDescription = "")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = newbrown,
                    titleContentColor = Color.White,
                    navigationIconContentColor = Color.White,
                    actionIconContentColor = Color.White

                )
            )
        },

        //BottomBar
        bottomBar = {
            NavigationBar(
                containerColor = newbrown
            ){
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
                    label = { Text("Home") },
                    selected = selectedIndex == 0,
                    onClick = { selectedIndex = 0
                        navController.navigate(ROUT_HOME)
                    }
                )

                NavigationBarItem(
                    icon = { Icon(Icons.Default.LocationOn, contentDescription = "Profile") },
                    label = { Text("Location") },
                    selected = selectedIndex == 2,
                    onClick = { selectedIndex = 2
                          navController.navigate(ROUT_LOCATION)
                    }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.MailOutline, contentDescription = "Profile") },
                    label = { Text("Message") },
                    selected = selectedIndex == 2,
                    onClick = { selectedIndex = 2
                         navController.navigate(ROUT_CHAT)
                    }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Person, contentDescription = "Profile") },
                    label = { Text("Profile") },
                    selected = selectedIndex == 2,
                    onClick = { selectedIndex = 2
                        //  navController.navigate(ROUT_HOME)
                    }
                )

            }
        },


        //Contents
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())

            ) {
                Card (
                    modifier = Modifier.fillMaxWidth()
                ){


                    Column (
                        modifier = Modifier.fillMaxWidth()
                    ){
                        Image(
                            painter = painterResource(R.drawable.img_1),
                            contentDescription = "",
                            modifier = Modifier.fillMaxWidth().height(200.dp),
                            contentScale = ContentScale.FillWidth)
                    }
                }
                Spacer(modifier = Modifier.height(10.dp))
                //SearchBar
                var search by remember { mutableStateOf("") }
                OutlinedTextField(
                    value = search,
                    onValueChange = { search = it },
                    modifier = Modifier.fillMaxWidth().padding(start = 10.dp, end = 10.dp),
                    leadingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = "") },
                    placeholder = { Text("search here......") }
                )


                //End Of SearchBar
                Spacer(modifier = Modifier.height(10.dp))
                Column (
                    modifier = Modifier.fillMaxWidth().padding(start = 20.dp, end = 20.dp)
                ){
                    Row (

                    ) {
                        //Card1
                        Card(
                            modifier = Modifier.width(150.dp).height(180.dp)

                        ) {
                            Column(
                                modifier = Modifier.fillMaxSize().background(newbrown),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center


                            ) {
                                Image(
                                    painter = painterResource(R.drawable.bt),
                                    contentDescription = "",
                                    alignment = Alignment.Center,
                                    modifier = Modifier.fillMaxWidth(),
                                )
                                Text(text = "Bathday cake")
                                Text(text = "Ksh.700")
                                Button(
                                    onClick = {
                                        navController.navigate(ROUT_PAYMENT)

                                    },
                                    colors = ButtonDefaults.buttonColors(Color.DarkGray),
                                    shape = RoundedCornerShape(size = 10.dp)
                                ) {
                                    Text(
                                        text = "Order now",
                                        color = newwite
                                    )
                                }


                            }

                        }
                        //card1
                        Spacer(modifier = Modifier.width(30.dp))
                        //Card2
                        Card(
                            modifier = Modifier.width(150.dp).height(180.dp)

                        ) {
                            Column(
                                modifier = Modifier.fillMaxSize().background(newbrown),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center


                            ) {
                                Image(
                                    painter = painterResource(R.drawable.wd),
                                    contentDescription = "",
                                    alignment = Alignment.Center,
                                    modifier = Modifier.fillMaxWidth(),
                                )
                                Text(text = "Wedding Cake")
                                Text(text = "Ksh.1500")
                                Button(
                                    onClick = {
                                        navController.navigate(ROUT_PAYMENT)

                                    },
                                    colors = ButtonDefaults.buttonColors(Color.DarkGray),
                                    shape = RoundedCornerShape(size = 10.dp)
                                ) {
                                    Text(
                                        text = "Order now",
                                        color = newwite
                                    )
                                }


                            }

                        }
                        //card2

                    }
                    Spacer(modifier = Modifier.height(10.dp))

                    Row (

                    ) {
                        //Card1
                        Card(
                            modifier = Modifier.width(150.dp).height(180.dp)

                        ) {
                            Column(
                                modifier = Modifier.fillMaxSize().background(newbrown),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center


                            ) {
                                Image(
                                    painter = painterResource(R.drawable.an),
                                    contentDescription = "",
                                    alignment = Alignment.Center,
                                    modifier = Modifier.fillMaxWidth(),
                                )
                                Text(text = "Anniversary")
                                Text(text = "Ksh.2000")
                                Button(
                                    onClick = {
                                        navController.navigate(ROUT_PAYMENT)

                                    },
                                    colors = ButtonDefaults.buttonColors(Color.DarkGray),
                                    shape = RoundedCornerShape(size = 10.dp)
                                ) {
                                    Text(
                                        text = "Order now",
                                        color = newwite
                                    )
                                }


                            }

                        }
                        //card1
                        Spacer(modifier = Modifier.width(30.dp))
                        //Card2
                        Card(
                            modifier = Modifier.width(150.dp).height(180.dp)

                        ) {
                            Column(
                                modifier = Modifier.fillMaxSize().background(newbrown),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center


                            ) {
                                Image(
                                    painter = painterResource(R.drawable.hd),
                                    contentDescription = "",
                                    alignment = Alignment.Center,
                                    modifier = Modifier.fillMaxWidth(),
                                )
                                Text(text = "Holiday")
                                Text(text = "Ksh.1170")
                                Button(
                                    onClick = {
                                        navController.navigate(ROUT_PAYMENT)

                                    },
                                    colors = ButtonDefaults.buttonColors(Color.DarkGray),
                                    shape = RoundedCornerShape(size = 10.dp)
                                ) {
                                    Text(
                                        text = "Order now",
                                        color = newwite
                                    )
                                }


                            }

                        }
                        //card2

                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Row (
                        modifier = Modifier.horizontalScroll(rememberScrollState())
                    ) {
                        //Card1
                        Card(
                            modifier = Modifier.width(150.dp).height(180.dp)

                        ) {
                            Column(
                                modifier = Modifier.fillMaxSize().background(newbrown),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center


                            ) {
                                Image(
                                    painter = painterResource(R.drawable.oreo),
                                    contentDescription = "",
                                    alignment = Alignment.Center,
                                    modifier = Modifier.fillMaxWidth(),
                                )
                                Text(text = "Oreo Ice")
                                Text(text = "Ksh.1000")
                                Button(
                                    onClick = {
                                        navController.navigate(ROUT_PAYMENT)

                                    },
                                    colors = ButtonDefaults.buttonColors(Color.DarkGray),
                                    shape = RoundedCornerShape(size = 10.dp)
                                ) {
                                    Text(
                                        text = "Order now",
                                        color = newwite
                                    )
                                }


                            }

                        }
                        //card1
                        Spacer(modifier = Modifier.width(30.dp))
                        //Card2
                        Card(
                            modifier = Modifier.width(150.dp).height(180.dp)

                        ) {
                            Column(
                                modifier = Modifier.fillMaxSize().background(newbrown),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center


                            ) {
                                Image(
                                    painter = painterResource(R.drawable.redvert),
                                    contentDescription = "",
                                    alignment = Alignment.Center,
                                    modifier = Modifier.fillMaxWidth(),
                                )
                                Text(text = "Red Vert")
                                Text(text = "Ksh.800")
                                Button(
                                    onClick = {
                                        navController.navigate(ROUT_PAYMENT)

                                    },
                                    colors = ButtonDefaults.buttonColors(Color.DarkGray),
                                    shape = RoundedCornerShape(size = 10.dp)
                                ) {
                                    Text(
                                        text = " Order now",
                                        color = newwite
                                    )
                                }


                            }

                        }
                        //card2


                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Row (

                    ) {
                        //Card1
                        Card(
                            modifier = Modifier.width(150.dp).height(180.dp)

                        ) {
                            Column(
                                modifier = Modifier.fillMaxSize().background(newbrown),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center


                            ) {
                                Image(
                                    painter = painterResource(R.drawable.ck),
                                    contentDescription = "",
                                    alignment = Alignment.Center,
                                    modifier = Modifier.fillMaxWidth(),
                                )
                                Text(text = "Chicken")
                                Text(text = "Ksh.1500")
                                Button(
                                    onClick = {
                                        navController.navigate(ROUT_PAYMENT)

                                    },
                                    colors = ButtonDefaults.buttonColors(Color.DarkGray),
                                    shape = RoundedCornerShape(size = 10.dp)
                                ) {
                                    Text(
                                        text = "Order now",
                                        color = newwite
                                    )
                                }


                            }

                        }
                        //card1
                        Spacer(modifier = Modifier.width(30.dp))
                        //Card2
                        Card(
                            modifier = Modifier.width(150.dp).height(180.dp)

                        ) {
                            Column(
                                modifier = Modifier.fillMaxSize().background(newbrown),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center


                            ) {
                                Image(
                                    painter = painterResource(R.drawable.fish),
                                    contentDescription = "",
                                    alignment = Alignment.Center,
                                    modifier = Modifier.fillMaxWidth(),
                                )
                                Text(text = "Fish")
                                Text(text = "Ksh.1770")
                                Button(
                                    onClick = {
                                        navController.navigate(ROUT_PAYMENT)

                                    },
                                    colors = ButtonDefaults.buttonColors(Color.DarkGray),
                                    shape = RoundedCornerShape(size = 10.dp)
                                ) {
                                    Text(
                                        text = "Order now",
                                        color = newwite
                                    )
                                }


                            }

                        }
                        //card2

                    }
                    Spacer(modifier = Modifier.height(10.dp))

                    Row (

                    ) {
                        //Card1
                        Card(
                            modifier = Modifier.width(150.dp).height(180.dp)

                        ) {
                            Column(
                                modifier = Modifier.fillMaxSize().background(newbrown),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center


                            ) {
                                Image(
                                    painter = painterResource(R.drawable.bf),
                                    contentDescription = "",
                                    alignment = Alignment.Center,
                                    modifier = Modifier.fillMaxWidth(),
                                )
                                Text(text = "Beef")
                                Text(text = "Ksh.1000")
                                Button(
                                    onClick = {
                                        navController.navigate(ROUT_PAYMENT)

                                    },
                                    colors = ButtonDefaults.buttonColors(Color.DarkGray),
                                    shape = RoundedCornerShape(size = 10.dp)
                                ) {
                                    Text(
                                        text = "Order now",
                                        color = newwite
                                    )
                                }


                            }

                        }
                        //card1
                        Spacer(modifier = Modifier.width(30.dp))
                        //Card2
                        Card(
                            modifier = Modifier.width(150.dp).height(180.dp)

                        ) {
                            Column(
                                modifier = Modifier.fillMaxSize().background(newbrown),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center


                            ) {
                                Image(
                                    painter = painterResource(R.drawable.duck),
                                    contentDescription = "",
                                    alignment = Alignment.Center,
                                    modifier = Modifier.fillMaxWidth(),
                                )
                                Text(text = "Duck")
                                Text(text = "Ksh.1770")
                                Button(
                                    onClick = {
                                        navController.navigate(ROUT_PAYMENT)

                                    },
                                    colors = ButtonDefaults.buttonColors(Color.DarkGray),
                                    shape = RoundedCornerShape(size = 10.dp)
                                ) {
                                    Text(
                                        text = "Order now",
                                        color = newwite
                                    )
                                }


                            }

                        }
                        //card2

                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Row (
                        modifier = Modifier.horizontalScroll(rememberScrollState())
                    ) {
                        //Card1
                        Card(
                            modifier = Modifier.width(150.dp).height(180.dp)

                        ) {
                            Column(
                                modifier = Modifier.fillMaxSize().background(newbrown),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center


                            ) {
                                Image(
                                    painter = painterResource(R.drawable.pock),
                                    contentDescription = "",
                                    alignment = Alignment.Center,
                                    modifier = Modifier.fillMaxWidth(),
                                )
                                Text(text = "Pock")
                                Text(text = "Ksh.1200")
                                Button(
                                    onClick = {
                                        navController.navigate(ROUT_PAYMENT)

                                    },
                                    colors = ButtonDefaults.buttonColors(Color.DarkGray),
                                    shape = RoundedCornerShape(size = 10.dp)
                                ) {
                                    Text(
                                        text = "Order now",
                                        color = newwite
                                    )
                                }


                            }

                        }
                        //card1
                        Spacer(modifier = Modifier.width(30.dp))
                        //Card2
                        Card(
                            modifier = Modifier.width(150.dp).height(180.dp)

                        ) {
                            Column(
                                modifier = Modifier.fillMaxSize().background(newbrown),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center


                            ) {
                                Image(
                                    painter = painterResource(R.drawable.meat),
                                    contentDescription = "",
                                    alignment = Alignment.Center,
                                    modifier = Modifier.fillMaxWidth(),
                                )
                                Text(text = "Fresh Meat")
                                Text(text = "Ksh.800")
                                Button(
                                    onClick = {
                                        navController.navigate(ROUT_PAYMENT)

                                    },
                                    colors = ButtonDefaults.buttonColors(Color.DarkGray),
                                    shape = RoundedCornerShape(size = 10.dp)
                                ) {
                                    Text(
                                        text = "Order now",
                                        color = newwite
                                    )
                                }


                            }

                        }
                        //card2


                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Row (

                    ) {
                        //Card1
                        Card(
                            modifier = Modifier.width(150.dp).height(180.dp)

                        ) {
                            Column(
                                modifier = Modifier.fillMaxSize().background(newbrown),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center


                            ) {
                                Image(
                                    painter = painterResource(R.drawable.chapati),
                                    contentDescription = "",
                                    alignment = Alignment.Center,
                                    modifier = Modifier.fillMaxWidth(),
                                )
                                Text(text = "Chapati")
                                Text(text = "Ksh.70")
                                Button(
                                    onClick = {
                                        navController.navigate(ROUT_PAYMENT)

                                    },
                                    colors = ButtonDefaults.buttonColors(Color.DarkGray),
                                    shape = RoundedCornerShape(size = 10.dp)
                                ) {
                                    Text(
                                        text = "Order now",
                                        color = newwite
                                    )
                                }


                            }

                        }
                        //card1
                        Spacer(modifier = Modifier.width(20.dp))
                        //Card2
                        Card(
                            modifier = Modifier.width(150.dp).height(180.dp)

                        ) {
                            Column(
                                modifier = Modifier.fillMaxSize().background(newbrown),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center


                            ) {
                                Image(
                                    painter = painterResource(R.drawable.smokie),
                                    contentDescription = "",
                                    alignment = Alignment.Center,
                                    modifier = Modifier.fillMaxWidth(),
                                )
                                Text(text = "Smokie")
                                Text(text = "Ksh.60")
                                Button(
                                    onClick = {
                                        navController.navigate(ROUT_PAYMENT)

                                    },
                                    colors = ButtonDefaults.buttonColors(Color.DarkGray),
                                    shape = RoundedCornerShape(size = 10.dp)
                                ) {
                                    Text(
                                        text = "Order now",
                                        color = newwite
                                    )
                                }


                            }

                        }
                        //card2

                    }
                    Spacer(modifier = Modifier.height(10.dp))

                    Row (

                    ) {
                        //Card1
                        Card(
                            modifier = Modifier.width(150.dp).height(180.dp)

                        ) {
                            Column(
                                modifier = Modifier.fillMaxSize().background(newbrown),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center


                            ) {
                                Image(
                                    painter = painterResource(R.drawable.madazi),
                                    contentDescription = "",
                                    alignment = Alignment.Center,
                                    modifier = Modifier.fillMaxWidth(),
                                )
                                Text(text = "Madazi")
                                Text(text = "Ksh.30")
                                Button(
                                    onClick = {
                                        navController.navigate(ROUT_PAYMENT)

                                    },
                                    colors = ButtonDefaults.buttonColors(Color.DarkGray),
                                    shape = RoundedCornerShape(size = 10.dp)
                                ) {
                                    Text(
                                        text = "Order now",
                                        color = newwite
                                    )
                                }


                            }

                        }
                        //card1
                        Spacer(modifier = Modifier.width(30.dp))
                        //Card2
                        Card(
                            modifier = Modifier.width(150.dp).height(180.dp)

                        ) {
                            Column(
                                modifier = Modifier.fillMaxSize().background(newbrown),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center


                            ) {
                                Image(
                                    painter = painterResource(R.drawable.chips),
                                    contentDescription = "",
                                    alignment = Alignment.Center,
                                    modifier = Modifier.fillMaxWidth(),
                                )
                                Text(text = "Chips")
                                Text(text = "Ksh.170")
                                Button(
                                    onClick = {
                                        navController.navigate(ROUT_PAYMENT)

                                    },
                                    colors = ButtonDefaults.buttonColors(Color.DarkGray),
                                    shape = RoundedCornerShape(size = 10.dp)
                                ) {
                                    Text(
                                        text = "Order now",
                                        color = newwite
                                    )
                                }


                            }

                        }
                        //card2

                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Row (
                        modifier = Modifier.horizontalScroll(rememberScrollState())
                    ) {
                        //Card1
                        Card(
                            modifier = Modifier.width(150.dp).height(180.dp)

                        ) {
                            Column(
                                modifier = Modifier.fillMaxSize().background(newbrown),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center


                            ) {
                                Image(
                                    painter = painterResource(R.drawable.samosa),
                                    contentDescription = "",
                                    alignment = Alignment.Center,
                                    modifier = Modifier.fillMaxWidth(),
                                )
                                Text(text = "Samosa")
                                Text(text = "Ksh.40")
                                Button(
                                    onClick = {
                                        navController.navigate(ROUT_PAYMENT)

                                    },
                                    colors = ButtonDefaults.buttonColors(Color.DarkGray),
                                    shape = RoundedCornerShape(size = 10.dp)
                                ) {
                                    Text(
                                        text = "Order now",
                                        color = newwite
                                    )
                                }


                            }

                        }
                        //card1
                        Spacer(modifier = Modifier.width(30.dp))
                        //Card2
                        Card(
                            modifier = Modifier.width(150.dp).height(180.dp)

                        ) {
                            Column(
                                modifier = Modifier.fillMaxSize().background(newbrown),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center


                            ) {
                                Image(
                                    painter = painterResource(R.drawable.packed),
                                    contentDescription = "",
                                    alignment = Alignment.Center,
                                    modifier = Modifier.fillMaxWidth(),
                                )
                                Text(text = "Packed Bakes")
                                Text(text = "Ksh.50")
                                Button(
                                    onClick = {
                                        navController.navigate(ROUT_PAYMENT)

                                    },
                                    colors = ButtonDefaults.buttonColors(Color.DarkGray),
                                    shape = RoundedCornerShape(size = 10.dp)
                                ) {
                                    Text(
                                        text = "Orger now",
                                        color = newwite
                                    )
                                }


                            }

                        }
                        //card2


                    }


                }
































            }
        }
    )
    //End of Scaffold

}



@Preview(showBackground = true)
@Composable
fun MenuScreenPreview(){
    MenuScreen(rememberNavController())

}
