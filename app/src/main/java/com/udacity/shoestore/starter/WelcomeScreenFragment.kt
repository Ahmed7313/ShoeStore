package com.udacity.shoestore.starter

import android.database.DatabaseUtils
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginBinding.inflate
import com.udacity.shoestore.databinding.FragmentWelcomescreenBinding

class WelcomeScreenFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var binding : FragmentWelcomescreenBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_welcomescreen, container, false)

        binding.letsgoButton.setOnClickListener {
            NavHostFragment.findNavController(this).navigate(WelcomeScreenFragmentDirections.actionWelcomeScreenFragmentToInstructionFragment())

        }

        return binding.root
    }

}