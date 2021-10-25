package com.udacity.shoestore.starter

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var binding : FragmentLoginBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_login, container, false)

        binding.loginButton.setOnClickListener {
            NavHostFragment.findNavController(this).navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeScreenFragment())

        }

        binding.registerButton.setOnClickListener {
            NavHostFragment.findNavController(this).navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeScreenFragment())

        }
        // Inflate the layout for this fragment
        return binding.root
    }

}