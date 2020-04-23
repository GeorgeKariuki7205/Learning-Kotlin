package com.example.taisacco


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.taisacco.databinding.FragmentEnquiryBinding


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
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
                    Toast.makeText(context, "Balance Enquiry Clicked", Toast.LENGTH_SHORT).show()
                }

                binding.cards.setOnClickListener {
                    Toast.makeText(context, "Mini Statement Clicked", Toast.LENGTH_SHORT).show()
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
