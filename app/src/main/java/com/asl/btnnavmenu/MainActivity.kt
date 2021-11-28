package com.asl.btnnavmenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.asl.btnnavmenu.databinding.ActivityMainBinding
import com.asl.btnnavmenu.fragments.DashboardFragment
import com.asl.btnnavmenu.fragments.HomeFragment
import com.asl.btnnavmenu.fragments.NotificationFragment
import com.asl.btnnavmenu.fragments.RightFragment

class MainActivity : AppCompatActivity(),Comunicator {
    private lateinit var binding: ActivityMainBinding

    private val homeFragment = HomeFragment()
    private val dashboardFragment = DashboardFragment()
    private val notificationFragment = NotificationFragment()
    private val rightFragment = RightFragment()

    private var savedText : String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        replaceFragment(homeFragment)

        binding.bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.nav_home -> replaceFragment(homeFragment)
                R.id.nav_dashboard -> replaceFragment(dashboardFragment, savedText)
                R.id.nav_notification -> replaceFragment(notificationFragment)
                R.id.nav_right -> replaceFragment(rightFragment)
            }
            true
        }



    }

    private fun replaceFragment(fragment: Fragment){

        val trasaction = supportFragmentManager.beginTransaction()
        trasaction.replace(R.id.fragment_Container,fragment)
        trasaction.commit()
    }
    private fun replaceFragment(fragment: Fragment,text:String){
        val bundle = Bundle()
        bundle.putString("SendText", text)
        val trasaction = supportFragmentManager.beginTransaction()
        fragment.arguments = bundle
        trasaction.replace(R.id.fragment_Container,fragment)
        trasaction.commit()
    }
    override fun PassData(fragment:Fragment, editTextData: String) {
        savedText = editTextData
        binding.bottomNavigationView.selectedItemId = R.id.nav_dashboard
    }

}
