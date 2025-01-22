package com.example.crew.ui.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object NonActive : Screen("nonactive")
}