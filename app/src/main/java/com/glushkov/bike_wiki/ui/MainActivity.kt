package com.glushkov.bike_wiki.ui

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.res.ResourcesCompat
import androidx.viewpager2.widget.ViewPager2
import com.glushkov.bike_wiki.data.models.ui.LineChartModel
import com.glushkov.bike_wiki.ui.tools.LineChart
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainView()
        }
    }
    override fun onBackPressed() {
//        val navController = findNavController(R.id.nav_host_fragment)
//        if (navController.currentDestination?.id != R.id.wikiManufacturersFragment)
//            navController.popBackStack()

    }

    @Composable
    fun MainView() {
        LineChart(data = LineChartModel(4f))
    }

    @Preview
    @Composable
    fun PreviewView() {
        MainView()
    }
}