package com.example.taisacco

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.taisacco.databinding.FragmentLifeCycleBinding

/**
 * A simple [Fragment] subclass.
 */
class LifeCycle : Fragment() {
    private lateinit var binding: FragmentLifeCycleBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_life_cycle, container, false)
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_life_cycle,
            container,
            false
        )



        binding.add.setOnClickListener {
//            var valueInteger: Int = binding.valueManipulated.toInt()
            binding.valueManipulated.text = (((binding.valueManipulated.text.toString()).toInt()+5)).toString()

        }

        binding.subtract.setOnClickListener {

            binding.valueManipulated.text = (((binding.valueManipulated.text.toString()).toInt()-5)).toString()

        }
        return binding.root
    }

}
