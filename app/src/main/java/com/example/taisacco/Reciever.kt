package com.example.taisacco

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.taisacco.databinding.FragmentRecieverBinding

/**
 * A simple [Fragment] subclass.
 */
class Reciever : Fragment() {
    private lateinit var binding: FragmentRecieverBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_reciever, container, false)
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_reciever,
            container,
            false
        )

        var args = RecieverArgs.fromBundle(arguments!!)
        Toast.makeText(context, "NumCorrect: ${args.name}, NumQuestions: ${args.name}", Toast.LENGTH_LONG).show()
        binding.textView4.text = args.name
        return binding.root
    }

}
