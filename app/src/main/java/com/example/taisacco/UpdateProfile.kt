package com.example.taisacco

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.taisacco.databinding.FragmentUpdateProfileBinding
import com.example.taisacco.UpdateProfileDirections
/**
 * A simple [Fragment] subclass.
 */
class UpdateProfile : Fragment() {
    private lateinit var binding: FragmentUpdateProfileBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_update_profile, container, false)
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_update_profile,
            container,
            false
        )


        binding.submit.setOnClickListener {
            var name = binding.value.text
            findNavController().navigate(UpdateProfileDirections.actionUpdateProfileToReciever(name.toString()))
//            Toast.makeText(context, "NumCorrect: ${name}, NumQuestions: ${name}", Toast.LENGTH_LONG).show()
        }

        return  binding.root
    }

}
