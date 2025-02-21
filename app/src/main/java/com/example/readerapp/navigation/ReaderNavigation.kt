package com.example.readerapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.readerapp.screens.home.HomeScreen
import com.example.readerapp.screens.login.LoginScreen
import com.example.readerapp.screens.signup.SignupScreen
import com.example.readerapp.screens.splash.SplashScreen

@Composable
fun ReaderNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination = ReaderScreens.SPLASH_SCREEN.path) {
        composable(route = ReaderScreens.SPLASH_SCREEN.path){
            SplashScreen(navController=navController)
        }
        composable(route = ReaderScreens.LOGIN_SCREEN.path){
            LoginScreen(navController = navController)
        }
        composable(route = ReaderScreens.SIGNUP_SCREEN.path){
            SignupScreen(navController = navController)
        }
        composable(route = ReaderScreens.HOME_SCREEN.path){
            HomeScreen(navController = navController)
        }
    }
}