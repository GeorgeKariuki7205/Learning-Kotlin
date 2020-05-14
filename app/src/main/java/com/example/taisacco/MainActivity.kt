package com.example.taisacco

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.taisacco.databinding.ActivityMainBinding
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var toolbar: Toolbar
    private lateinit var drawerLayout: DrawerLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        toolbar = binding.toolbar
        setSupportActionBar(toolbar)


        drawerLayout = binding.drawer
        val navController = this.findNavController(R.id.myNavHostFragment)

        NavigationUI.setupActionBarWithNavController(this,navController,drawerLayout)

        NavigationUI.setupWithNavController(binding.navView, navController)

//        setHasOptionsMenu(true)
    }
    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.myNavHostFragment)

        return NavigationUI.navigateUp(navController, drawerLayout)
    }

//    THIS SECTION OF THE CODE IS USED TO IMPLEMENT THE MENU ON THE TOOL BAR.
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        val inflater2: MenuInflater = menuInflater
        inflater.inflate(R.menu.toolbar_navgation_menu, menu)
        inflater2.inflate(R.menu.navigationmenu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection
        return when (item.itemId) {
            R.id.create_new -> {
                Toast.makeText(this, "Create New Clicked", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.open -> {
                Toast.makeText(this, "Open Clicked", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.nav_logout->{
                Toast.makeText(this, "LogOut Clicked", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }


//    THIS SECTION OF THE CODE IS USED TO GET THE ONSTART FUNCTIONALITY OF THE APPLICATION.

    override fun onStart() {
        super.onStart()
//        Log.i("OnStart", "This is the OnStart Functionality.")
        Timber.i("This is the OnStart Functionality.")
    }

    override fun onResume() {
        super.onResume()
        Timber.i("This is the OnResume Functionality.")
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.i("This is the OnDestroy Functionality.")
    }
    override fun onPause() {
        super.onPause()
        Timber.i("onPause Called")
    }

    override fun onStop() {
        super.onStop()
        Timber.i("onStop Called")
    }
    override fun onRestart() {
        super.onRestart()
        Timber.i("onRestart Called")
    }
}
