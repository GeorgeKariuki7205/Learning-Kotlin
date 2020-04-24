package com.example.taisacco


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.taisacco.databinding.FragmentTransactionsBinding


class Transactions : Fragment() {
    private lateinit var binding: FragmentTransactionsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_transactions, container, false)
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_transactions,
            container,
            false
        )
        binding.card14.setOnClickListener {
            Toast.makeText(context, "Withdraw Cash Clicked", Toast.LENGTH_SHORT).show()
        }

        binding.card15.setOnClickListener {
            Toast.makeText(context, "Inter Account Transfer Clicked", Toast.LENGTH_SHORT).show()
        }

        binding.card16.setOnClickListener {
            Toast.makeText(context, "Deposit Clicked", Toast.LENGTH_SHORT).show()
        }
        binding.cards17.setOnClickListener {
            Toast.makeText(context, "Buy Airtime Clicked", Toast.LENGTH_SHORT).show()
        }
        return binding.root
    }


}
