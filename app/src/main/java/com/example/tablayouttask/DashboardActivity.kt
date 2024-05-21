package com.example.tablayouttask

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.tablayouttask.databinding.ActivityDashboardBinding
import com.example.tablayouttask.fragment.ChatFragment
import com.example.tablayouttask.fragment.HomeFragment
import com.example.tablayouttask.fragment.ProfileFragment
import com.example.tablayouttask.fragment.SearchFragment
import com.example.tablayouttask.fragment.SettingsFragment

class DashboardActivity : AppCompatActivity() {
    private lateinit var dashboardBinding: ActivityDashboardBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        dashboardBinding = ActivityDashboardBinding.inflate((layoutInflater))

        setContentView(dashboardBinding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        dashboardBinding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.homeBtn -> replaceFragment(HomeFragment())
                R.id.searchBtn -> replaceFragment(SearchFragment())
                R.id.settingsBtn -> replaceFragment(SettingsFragment())
                R.id.profileBtn -> replaceFragment(ProfileFragment())
            }
            true
        }

    }
    private fun replaceFragment(fragment: Fragment){
        val fragmentManager : FragmentManager = supportFragmentManager
        val fragmentTransaction : FragmentTransaction = fragmentManager.beginTransaction()

        fragmentTransaction.replace(R.id.frameDashboard, fragment)
        fragmentTransaction.commit()
    }

}