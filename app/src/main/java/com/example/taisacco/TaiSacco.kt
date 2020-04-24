package com.example.taisacco


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.viewpager2.widget.ViewPager2
import com.example.taisacco.databinding.FragmentTaiSaccoBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.taisacco.Enquiry
import com.example.taisacco.Loans
import com.example.taisacco.Transactions


class TaiSacco : Fragment() {
    private lateinit var binding: FragmentTaiSaccoBinding
    private lateinit var demoCollectionAdapter: DemoCollectionAdapter
    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_tai_sacco,
            container,
            false
        )

//        THIS SECTION OF THE CODE IS USED TO HANDLE THE CLICK FUNCTIONALITY OF THE CARDS.

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        demoCollectionAdapter = DemoCollectionAdapter(this)
        viewPager = view.findViewById(R.id.viewPager)
        viewPager.adapter = demoCollectionAdapter

        tabLayout =view.findViewById(R.id.tabs)
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = when(position) {
                0 -> "Enquiry"
                1->  "Transactions"
                2-> "Loans"
                else-> "About"
            }
        }.attach()
        tabLayout.getTabAt(0)?.setIcon(R.drawable.grow_portfolio256)
        tabLayout.getTabAt(1)?.setIcon(R.drawable.money_bag)
        tabLayout.getTabAt(2)?.setIcon(R.drawable.data_analysis_brain_arrow_graph_think256)
    }

}

class DemoCollectionAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {

        return when(position) {
            0 -> {
                Enquiry()
            }
            1 -> {
                Transactions()
            }
            2-> {
                Loans()
            }
            else -> {
                Enquiry()
            }
        }
    }
}