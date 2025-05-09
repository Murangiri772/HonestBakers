package com.lewishr.honestbakers.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.lewishr.honestbakers.data.ChatDatabase
import com.lewishr.honestbakers.data.UserDatabase
import com.lewishr.honestbakers.repository.ChatRepository
import com.lewishr.honestbakers.repository.UserRepository
import com.lewishr.honestbakers.ui.screens.Bakes.AddBakesScreen
import com.lewishr.honestbakers.ui.screens.Bakes.BakesListScreen
import com.lewishr.honestbakers.ui.screens.Bakes.EditBakesScreen
import com.lewishr.honestbakers.ui.screens.Menu.MenuScreen
import com.lewishr.honestbakers.ui.screens.about.AboutScreen
import com.lewishr.honestbakers.ui.screens.auth.LoginScreen
import com.lewishr.honestbakers.ui.screens.auth.RegisterScreen
import com.lewishr.honestbakers.ui.screens.chat.ChatScreen


import com.lewishr.honestbakers.ui.screens.home.HomeScreen
import com.lewishr.honestbakers.ui.screens.lonation.LocationScreen
import com.lewishr.honestbakers.ui.screens.payment.PaymentScreen

import com.lewishr.honestbakers.ui.screens.profile.ProfileScreen
import com.lewishr.honestbakers.ui.screens.recipe.RecipeScreen
import com.lewishr.honestbakers.ui.screens.splash.SplashScreen
import com.lewishr.honestbakers.ui.screens.start.StartScreen
import com.lewishr.honestbakers.viewmodel.AuthViewModel
import com.lewishr.honestbakers.viewmodel.BakesViewModel
import com.lewishr.honestbakers.viewmodel.ChatViewModel
import com.lewishr.honestbakers.viewmodel.ChatViewModelFactory


@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = ROUT_START,
    bakesViewModel: BakesViewModel = viewModel()

) {
    var context = LocalContext.current
    // Initialize Room Database and Repository for Chat
    val chatDatabase = ChatDatabase.getDatabase(context)
    val chatRepository = ChatRepository(chatDatabase.messageDao()) // ✅ Correct DAO reference
    val chatViewModel: ChatViewModel = viewModel(factory = ChatViewModelFactory(chatRepository))

    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(ROUT_HOME) {
            HomeScreen(navController)
        }
        composable(ROUT_ABOUT) {
            AboutScreen(navController)
        }
        composable(ROUT_MENU) {
            MenuScreen(navController)
        }
        composable(ROUT_START) {
            StartScreen(navController)
        }
        composable(ROUT_RECIPE) {
            RecipeScreen(navController)
        }

        composable(ROUT_PAYMENT) {
            PaymentScreen(navController)
        }
        composable(ROUT_LOCATION) {
            LocationScreen(navController)
        }
        composable(ROUT_SPLASH) {
            SplashScreen(navController)
        }
        composable(ROUT_PROFILE) {
            ProfileScreen(navController)
        }
        composable(ROUT_CHAT) {
            ChatScreen(chatViewModel) // ✅ Correct ViewModel reference
        }

        //AUTHENTICATION

        // Initialize Room Database and Repository for Authentication
        val appDatabase = UserDatabase.getDatabase(context)
        val authRepository = UserRepository(appDatabase.userDao())
        val authViewModel: AuthViewModel = AuthViewModel(authRepository)
        composable(ROUT_REGISTER) {
            RegisterScreen(authViewModel, navController) {
                navController.navigate(ROUT_LOGIN) {
                    popUpTo(ROUT_REGISTER) { inclusive = true }
                }
            }
        }

        composable(ROUT_LOGIN) {
            LoginScreen(authViewModel, navController) {
                navController.navigate(ROUT_HOME) {
                    popUpTo(ROUT_LOGIN) { inclusive = true }
                }
            }
        }

        // BAKES
        composable(ROUT_ADD_BAKES) {
            AddBakesScreen(navController, bakesViewModel)
        }

        composable(ROUT_BAKES_LIST) {
            BakesListScreen(navController, bakesViewModel)
        }

        composable(
            route = ROUT_EDIT_BAKES,
            arguments = listOf(navArgument("bakesId") { type = NavType.IntType })
        ) { backStackEntry ->
            val bakesId = backStackEntry.arguments?.getInt("bakesId")
            if (bakesId != null) {
                EditBakesScreen(bakesId, navController, bakesViewModel)
            }
        }









    }
}

