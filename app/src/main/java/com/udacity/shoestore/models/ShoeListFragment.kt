package com.udacity.shoestore.models

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.databinding.ListItemBindingImpl
import kotlinx.android.synthetic.main.list_item.view.*


class ShoeListFragment : Fragment() {

    private val shoeViewModel: ShoeViewModel by activityViewModels()
    private lateinit var shoe : Shoe

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var binding : FragmentShoeListBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list,
            container, false)
        setHasOptionsMenu(true)


        binding.addingShoe.setOnClickListener {
            NavHostFragment.findNavController(this).navigate(ShoeListFragmentDirections
                .actionShoeListFragmentToAddingShoeFragment())
        }

        shoeViewModel.shoeList.observe(viewLifecycleOwner, Observer { newShoe ->
            newShoe.forEach { shoe ->
                var linearLayout = binding.listOfShoes
                val bindingItem : ListItemBindingImpl = DataBindingUtil.inflate(inflater, R.layout.list_item,
                    container, false)
                bindingItem.viewModel = shoeViewModel
                bindingItem.setLifecycleOwner(this)
                var name: TextView = bindingItem.root.shoe_name
                var size: TextView = bindingItem.root.shoe_size
                var company: TextView = bindingItem.root.company_name
                var description: TextView = bindingItem.root.description

                shoeViewModel.bindShoetoView(name, size, company, description,shoe )
                linearLayout.addView(bindingItem.root)
            }
        })


        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.overflow_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        NavHostFragment.findNavController(this).navigate(ShoeListFragmentDirections.actionShoeListFragmentToLoginFragment())
        return super.onOptionsItemSelected(item)

    }
}