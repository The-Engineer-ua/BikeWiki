package com.glushkov.bike_wiki.ui.main

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.glushkov.bike_wiki.ui.manufacturers.Manufacturers
import com.glushkov.bike_wiki.ui.motorcycle_info.MotorcycleInfo
import com.glushkov.bike_wiki.ui.motorcycles.Motorcycles
import kotlinx.coroutines.InternalCoroutinesApi

class MainActivity : AppCompatActivity() {

    @InternalCoroutinesApi
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainView()
        }
    }

    override fun onBackPressed() {

    }

    @InternalCoroutinesApi
    @ExperimentalFoundationApi
    @Composable
    fun MainView() {
        SetUpNavigation()
    }

    @InternalCoroutinesApi
    @ExperimentalFoundationApi
    @Composable
    private fun SetUpNavigation() {
        val navController: NavHostController = rememberNavController()
        NavHost(navController = navController, startDestination = "manufacturers") {
            composable("manufacturers") { Manufacturers(navController) }
            composable(
                "motorcycles/{id}",
                arguments = listOf(navArgument("id") { type = NavType.IntType })
            ) { backStackEntry ->
                backStackEntry.arguments?.getInt("id")?.let { id ->
                    Motorcycles(navController, id)
                }

            }
            composable(
                "motorcycleInfo/{id}",
                arguments = listOf(navArgument("id") { type = NavType.IntType })
            ) { backStackEntry ->
                backStackEntry.arguments?.getInt("id")?.let { id ->
                    MotorcycleInfo(navController, id)
                }

            }
        }
    }

    @InternalCoroutinesApi
    @ExperimentalFoundationApi
    @Preview
    @Composable
    fun PreviewView() {
        MainView()
    }
}