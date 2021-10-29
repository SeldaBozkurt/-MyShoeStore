package com.example.myshoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.myshoestore.databinding.FragmentInstructionBinding

class InstructionFragment: Fragment() {
    private lateinit var binding:FragmentInstructionBinding
    private val viewModel:MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentInstructionBinding.inflate(inflater,container,false)
        binding.viewModel=viewModel

        viewModel.gotoshoeListScreen.observe(viewLifecycleOwner, Observer { showShoeListScreen ->
            showShoeListScreen?.let {
                if (it) {
                    findNavController().navigate(InstructionFragmentDirections.actionInstructionFragmentToShoeListFragment())
                    viewModel.onEventShowShoeListScreencomplete()
                }
            }
        })

        return binding.root
    }


}