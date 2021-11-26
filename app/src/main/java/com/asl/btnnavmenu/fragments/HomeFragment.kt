package com.asl.btnnavmenu.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.asl.btnnavmenu.Comunicator
import com.asl.btnnavmenu.R
import com.asl.btnnavmenu.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private val dashboardFragment = DashboardFragment()
    private lateinit var comunicator: Comunicator
    private lateinit var binding : FragmentHomeBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_home, container, false)
        binding = FragmentHomeBinding.bind(view)
        comunicator = activity as Comunicator
        binding.btnSend.setOnClickListener {
            comunicator.PassData(dashboardFragment,binding.editText.text.toString())
        }

        return view

    }


}