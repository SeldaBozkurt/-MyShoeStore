package com.example.myshoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import com.example.myshoestore.databinding.FragmentShoelistBinding
import com.example.myshoestore.databinding.ShoeitemListBinding

class ShoeListFragment:Fragment() {
    private lateinit var binding: FragmentShoelistBinding
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentShoelistBinding.inflate(inflater, container, false)

        viewModel.shoes.observe(viewLifecycleOwner, Observer { shoes ->
            shoes?.let {
                displayShoes(it)
            }
        })

        binding.floatingButton.setOnClickListener {
            it.findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment())
        }

        setHasOptionsMenu(true)

        return binding.root
    }
    private fun displayShoes(shoes: List<Shoe>) {
        shoes.forEach { displayShoes(it) }
    }

    private fun displayShoes(shoe: Shoe) {
        val listItemShoeBinding:ShoeitemListBinding = DataBindingUtil.inflate(layoutInflater, R.layout.shoeitem_list, null, false)

        listItemShoeBinding.nameTextView.text = getString(R.string.string_value, "Shoe name:", shoe.name)
        listItemShoeBinding.companyTextView.text = getString(R.string.string_value, "Company name:", shoe.company)
        listItemShoeBinding.sizeTextView.text = getString(R.string.double_value, "Shoe size:", shoe.size)
        listItemShoeBinding.descriptionTextView.text = getString(R.string.string_value, "Description:", shoe.description)

        binding.linearlayout.addView(listItemShoeBinding.root)
    }
}
