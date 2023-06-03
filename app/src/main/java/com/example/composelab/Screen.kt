package com.example.composelab

enum class Screen(val route: String, var titleId: Int) {
    HomePageScren("homepage_screen", R.string.homepage_screen),
    DetailScreen("detail_screen", R.string.detailpage_screen)
}