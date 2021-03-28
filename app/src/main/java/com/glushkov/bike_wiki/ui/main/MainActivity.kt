package com.glushkov.bike_wiki.ui.main

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.glushkov.bike_wiki.data.models.ui.LineChartModel
import com.glushkov.bike_wiki.ui.main.MainViewModel
import com.glushkov.bike_wiki.ui.manufacturers.Manufacturers
import com.glushkov.bike_wiki.ui.tools.LineChart

class MainActivity : AppCompatActivity() {

    private val vm : MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        vm.initRepositories()

        setContent {
            MainView()
        }
    }

    override fun onBackPressed() {

    }

    @Composable
    fun MainView() {
        SetUpNavigation()
    }

    @Composable
    private fun SetUpNavigation() {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = "manufacturers" ) {
            composable("manufacturers") { Manufacturers() }
            composable("motorcycles") {}
            composable("motorcycle_info") {}
        }
    }

    @Preview
    @Composable
    fun PreviewView() {
        MainView()
    }
}