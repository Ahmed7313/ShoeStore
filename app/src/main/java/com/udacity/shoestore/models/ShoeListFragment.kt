package com.udacity.shoestore.models

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListBinding


class ShoeListFragment : Fragment() {

    private lateinit var shoeViewModel: ShoeViewModel
    private lateinit var shoe : Shoe

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var binding : FragmentShoeListBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list,
            container, false)
        setHasOptionsMenu(true)


        shoeViewModel = ViewModelProvider(this).get(ShoeViewModel::class.java)

        binding.addingShoe.setOnClickListener {
            NavHostFragment.findNavController(this).navigate(ShoeListFragmentDirections
                .actionShoeListFragmentToAddingShoeFragment())
        }

        shoeViewModel.getLivedataList.observe(viewLifecycleOwner, Observer { newShoe ->

            var linearLayout = binding.listOfShoes
            val view = layoutInflater.inflate(R.layout.list_item, null)
            var name : TextView = view.findViewById(R.id.shoe_name)
            var size : TextView = view.findViewById(R.id.shoe_size)
            var company : TextView = view.findViewById(R.id.company_name)
            var description : TextView = view.findViewById(R.id.description)

            name.text = newShoe[0].name
            size.text = newShoe[0].size.toString()
            company.text = newShoe[0].company
            description.text = newShoe[0].description

            linearLayout.addView(view)


        })


        return binding.root
    }



}