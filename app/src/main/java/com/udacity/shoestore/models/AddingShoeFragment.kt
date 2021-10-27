package com.udacity.shoestore.models

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.NavHostFragment
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentAddingShoeBinding
import kotlinx.android.synthetic.main.fragment_adding_shoe.*


class AddingShoeFragment : Fragment() {


    private val viewModel: ShoeViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentAddingShoeBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_adding_shoe, container, false
        )


        binding.save.setOnClickListener {
            var name = shoe_name.text.toString()
            var size = shoe_size.text.toString()
            var company = company_name.text.toString()
            var descreiption = company_description.text.toString()

                viewModel.addShoe(name, size, company, descreiption)
                NavHostFragment.findNavController(this).navigate(
                    AddingShoeFragmentDirections.actionAddingShoeFragmentToShoeListFragment()
                )
        }

        binding.cancel.setOnClickListener {
            NavHostFragment.findNavController(this).navigate(
                AddingShoeFragmentDirections.actionAddingShoeFragmentToShoeListFragment()
            )
        }
        return binding.root
    }


}



