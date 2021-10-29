package com.udacity.shoestore.models

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
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

        binding.viewmodel = viewModel
        binding.shoe = viewModel.shoe


        viewModel.eventSaveShoeDetailPress.observe(viewLifecycleOwner, {
            if (it) {
                NavHostFragment.findNavController(this).navigate(
                    AddingShoeFragmentDirections.actionAddingShoeFragmentToShoeListFragment())
                viewModel.saveShoeDetailComplete()
            }
        })

        binding.cancel.setOnClickListener {
            NavHostFragment.findNavController(this).navigate(
                AddingShoeFragmentDirections.actionAddingShoeFragmentToShoeListFragment()
            )
        }
        return binding.root
    }
}



