package com.udacity.shoestore.models

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentAddingShoeBinding


class AddingShoeFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val viewModel = ShoeViewModel()
        val binding : FragmentAddingShoeBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_adding_shoe, container, false)


        binding.save.setOnClickListener {

            var name = binding.shoeName.text.toString()
            var size = binding.shoeSize.text.toString()
            var company = binding.companyName.text.toString()
            var descreiption = binding.description.text.toString()
            viewModel.addShoe(name, size, company,descreiption)
            NavHostFragment.findNavController(this).navigate(AddingShoeFragmentDirections.
            actionAddingShoeFragmentToShoeListFragment())
        }
        return binding.root
    }

}


