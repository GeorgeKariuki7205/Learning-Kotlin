package com.example.taisacco


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.taisacco.databinding.FragmentBalanceEnquiryBinding


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class BalanceEnquiry : Fragment() {
    private lateinit var binding: FragmentBalanceEnquiryBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        (activity as MainActivity).supportActionBar?.title = "Balance Enquiry"
//        return inflater.inflate(R.layout.fragment_balance_enquiry, container, false)
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_balance_enquiry,
            container,
            false
        )
        binding.show.setOnClickListener {
            binding.balance.text = "56,781"
        }
        binding.hide.setOnClickListener {
            binding.balance.text = "****"
        }
        return  binding.root
    }


}
