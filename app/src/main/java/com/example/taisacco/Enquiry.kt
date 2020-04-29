package com.example.taisacco


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.taisacco.databinding.FragmentEnquiryBinding



class Enquiry : Fragment() {
    private lateinit var binding: FragmentEnquiryBinding
            override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_enquiry, container, false)
                binding = DataBindingUtil.inflate(
                    inflater,
                    R.layout.fragment_enquiry,
                    container,
                    false
                )

                binding.card.setOnClickListener {
//                    Toast.makeText(context, "Balance Enquiry Clicked", Toast.LENGTH_SHORT).show()
                    it.findNavController().navigate(R.id.action_taiSacco_to_balanceEnquiry)
                }

                binding.cards.setOnClickListener {
//                    Toast.makeText(context, "Mini Statement Clicked", Toast.LENGTH_SHORT).show()
                      it.findNavController().navigate(R.id.action_taiSacco_to_miniStatement)
                }

                binding.card12.setOnClickListener {
                    Toast.makeText(context, "Loan BalanceClicked", Toast.LENGTH_SHORT).show()
                }
                binding.cards13.setOnClickListener {
                    Toast.makeText(context, "Share Balance Clicked", Toast.LENGTH_SHORT).show()
                }
                return  binding.root
    }


}
