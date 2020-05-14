package com.example.taisacco

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.taisacco.databinding.FragmentBottomNavigationBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

/**
 * A simple [Fragment] subclass.
 */
class Bottom_Navigation : Fragment() {
    private lateinit var binding: FragmentBottomNavigationBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_bottom__navigation, container, false)
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_bottom__navigation,
            container,
            false
        )

        val bottomNavigation: BottomNavigationView = binding.bottomNavigation

          mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.page_1 -> {

                    return@OnNavigationItemSelectedListener true
                }
                R.id.page_2 -> {

                    return@OnNavigationItemSelectedListener true
                }
                R.id.page_3 -> {

                    return@OnNavigationItemSelectedListener true
                }
                R.id.page_4 -> {

                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }


//        BottomNavigationView.OnNavigationItemSelectedListener { item ->
//            when(item.itemId) {
//                R.id.page_1 -> {
//                    // Respond to navigation item 1 click
//                    binding.textView5.text = "Page One"
//                    Toast.makeText(context, "Page One",Toast.LENGTH_SHORT )
//                    true
//                }
//                R.id.page_2 -> {
//                    // Respond to navigation item 2 click
//                    binding.textView5.text = "Page Two"
//                    Toast.makeText(context, "Page Two",Toast.LENGTH_SHORT )
//                    true
//                }
//                else -> false
//            }
//        }
        return binding.root

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // ...
        bottomNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }
}
