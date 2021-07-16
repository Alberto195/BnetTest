package com.example.binettest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.binettest.repository.preference.IAppPreference
import com.example.binettest.viewmodels.MainViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.getViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        viewModel = getViewModel()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel.initPreference()

        if(viewModel.getSession() == "") {
            viewModel.setSession()
        }

        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.entryListFragment,
                R.id.addEntryFragment,
                R.id.wholeEntryFragment
            )
        )

        val navController = findNavController(R.id.fragment_container)
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_bar)
        bottomNavigationView.setupWithNavController(navController)
        setupActionBarWithNavController(this, navController, appBarConfiguration)
    }
}