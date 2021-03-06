package com.example.myshoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.myshoestore.databinding.FragmentLoginBinding

class LoginFragment: Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private  val viewModel:MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)

        binding.viewModel = viewModel

        viewModel.gotoWelcomeScreen.observe(viewLifecycleOwner, Observer { showWelcomeScreen ->
            showWelcomeScreen?.let {
                if (it) {
                    findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
                    viewModel.onEventWelcomeScreenComplete()
                }
            }
        })
        return binding.root
    }

    }