package com.glushkov.bike_aggregator.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(binding.root)

//        val sectionsPagerAdapter = SectionsPagerAdapter(this)
//        val viewPager: ViewPager2 = binding.viewPager
//        viewPager.adapter = sectionsPagerAdapter
//        val tabs: TabLayout = binding.tabs
//
//        TabLayoutMediator(tabs, viewPager) { tab, position ->
//            tab.text = resources.getString(TAB_TITLES[position])
//            tab.icon = ResourcesCompat.getDrawable(resources, TAB_ICONS[position], theme)
//            viewPager.setCurrentItem(tab.position, true)
//        }.attach()
    }
    override fun onBackPressed() {
//        val navController = findNavController(R.id.nav_host_fragment)
//        if (navController.currentDestination?.id != R.id.wikiManufacturersFragment)
//            navController.popBackStack()

    }
}