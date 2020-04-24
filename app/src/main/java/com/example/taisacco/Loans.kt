package com.example.taisacco


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.taisacco.databinding.FragmentLoansBinding


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
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
            Toast.makeText(context, "Withdraw Cash Clicked", Toast.LENGTH_SHORT).show()
        }

        binding.card19.setOnClickListener {
            Toast.makeText(context, "Inter Account Transfer Clicked", Toast.LENGTH_SHORT).show()
        }

        binding.card20.setOnClickListener {
            Toast.makeText(context, "Deposit Clicked", Toast.LENGTH_SHORT).show()
        }
        binding.cards21.setOnClickListener {
            Toast.makeText(context, "Buy Airtime Clicked", Toast.LENGTH_SHORT).show()
        }
        return binding.root
    }


}
