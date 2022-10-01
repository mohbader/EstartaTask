package com.estarta.task.presentation.home

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.estarta.task.R
import com.estarta.task.data.model.HomeData
import com.estarta.task.databinding.HomeFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private val viewModel: HomeViewModel by viewModels()
    private lateinit var _binding: HomeFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = HomeFragmentBinding.inflate(inflater, container, false)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModelObserver()
    }

    private fun initViewModelObserver() {
        viewModel.homeDataLiveData.observe(viewLifecycleOwner) { initHomeAdapter(it) }
        viewModel.loadingLiveData.observe(viewLifecycleOwner) { handleLoading(it) }
        viewModel.onErrorLiveData.observe(viewLifecycleOwner) { showError(it) }
    }

    private fun initHomeAdapter(homeData: HomeData) {

    }

    private fun handleLoading(isLoading: Boolean) {}

    private fun showError(errorMessage: String) {
        Toast.makeText(context, errorMessage, Toast.LENGTH_LONG).show()
    }

}