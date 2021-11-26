package com.asl.btnnavmenu.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.asl.btnnavmenu.R
import com.asl.btnnavmenu.databinding.FragmentDashboardBinding
import com.asl.btnnavmenu.databinding.FragmentHomeBinding




class DashboardFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private lateinit var binding : FragmentDashboardBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_dashboard, container, false)

        binding = FragmentDashboardBinding.bind(view)

        binding.DashboardText.text = arguments?.getString("SendText")

        return view
    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("SendText", binding.DashboardText.text.toString())
    }
}
//


//