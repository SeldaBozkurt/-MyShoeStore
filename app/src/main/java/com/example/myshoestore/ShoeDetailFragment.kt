package com.example.myshoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.myshoestore.databinding.FragmentShoedetailBinding

class ShoeDetailFragment: Fragment(){
   private lateinit var binding: FragmentShoedetailBinding
   private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    binding = FragmentShoedetailBinding.inflate(inflater, container, false)

    binding.viewModel = viewModel
    viewModel.createNewShoe()

    viewModel.eventCloseScreen.observe(viewLifecycleOwner, { close ->
        close?.let {
            if (it) {
                findNavController().navigateUp()
                viewModel.onEventCloseComplete()
            }
        }
    })

    return binding.root
}
}