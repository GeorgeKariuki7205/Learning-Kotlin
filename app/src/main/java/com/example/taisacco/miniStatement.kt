package com.example.taisacco

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.taisacco.databinding.FragmentMiniStatementBinding

/**
 * A simple [Fragment] subclass.
 */
class miniStatement : Fragment() {
    private lateinit var binding: FragmentMiniStatementBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_mini_statement, container, false)
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_mini_statement,
            container,
            false
        )
        (activity as MainActivity).supportActionBar?.title = "Statements."
        return  binding.root
    }

}
