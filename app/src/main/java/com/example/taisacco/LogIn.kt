package com.example.taisacco

import android.os.Bundle
import android.util.Log
import android.content.Intent
import androidx.navigation.findNavController
import android.app.Activity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.taisacco.databinding.FragmentLogInBinding
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.IdpResponse
import com.example.taisacco.Enquiry

private lateinit var binding: FragmentLogInBinding
private val RC_SIGN_IN = 123
class LogIn : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_log_in,
            container,
            false
        )

        binding.button3.setOnClickListener {
            createSignInIntent()
        }

        binding.button4.setOnClickListener {
            signOut()

        }

        binding.button5.setOnClickListener {
            delete()
        }
        return  binding.root

    }

    private fun createSignInIntent() {

        val providers = arrayListOf(
            AuthUI.IdpConfig.GoogleBuilder().build(),
            AuthUI.IdpConfig.PhoneBuilder()
                .setDefaultNumber("+25456789")
                .build()
        )

        startActivityForResult(
            AuthUI.getInstance()
                .createSignInIntentBuilder()
                .setAvailableProviders(providers)
                .build(),
            RC_SIGN_IN)
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == RC_SIGN_IN) {
            val response = IdpResponse.fromResultIntent(data)

            if (resultCode == Activity.RESULT_OK) {
                view?.findNavController()?.navigate(R.id.action_logIn_to_taiSacco)
                Log.i("chei","succesful")
            } else {

                Log.i("chei","not successful ${response?.error?.errorCode}")
            }
        }
    }

    private fun signOut() {
        // [START auth_fui_signout]
        AuthUI.getInstance()
            .signOut(requireContext())
            .addOnCompleteListener {
                // ...
                view?.findNavController()?.navigate(R.id.action_logIn_to_taiSacco)
                Toast.makeText(context, "Logged Out.", Toast.LENGTH_SHORT).show()
            }
        // [END auth_fui_signout]
    }

    private fun delete() {
        // [START auth_fui_delete]
        AuthUI.getInstance()
            .delete(requireContext())
            .addOnCompleteListener {
                // ...
                view?.findNavController()?.navigate(R.id.action_logIn_to_taiSacco)
                Toast.makeText(context, "Deleted Account", Toast.LENGTH_SHORT).show()
            }
        // [END auth_fui_delete]
    }

    override fun onDestroy() {
        super.onDestroy()
        signOut()
        Log.i("chei","signed out")
    }
}

