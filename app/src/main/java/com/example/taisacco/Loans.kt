package com.example.taisacco


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.taisacco.databinding.FragmentLoansBinding


class Loans : Fragment() {
    private lateinit var binding: FragmentLoansBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_loans, container, false)
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_loans,
            container,
            false
        )
        binding.card18.setOnClickListener {
            Toast.makeText(context, "Apply Loans Clicked", Toast.LENGTH_SHORT).show()
        }

        binding.card19.setOnClickListener {
            Toast.makeText(context, "Check Eligibility Clicked", Toast.LENGTH_SHORT).show()
        }

        binding.card20.setOnClickListener {
            Toast.makeText(context, "Repay Loans Clicked", Toast.LENGTH_SHORT).show()
        }
        binding.cards21.setOnClickListener {
            Toast.makeText(context, "My Loans Clicked", Toast.LENGTH_SHORT).show()
        }
        return binding.root
    }


}
