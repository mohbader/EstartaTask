package com.estarta.task.presentation.home

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.estarta.task.R
import com.estarta.task.data.model.HomeData
import com.estarta.task.databinding.HomeFragmentBinding
import com.estarta.task.presentation.items_details.ItemDetailsFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private val viewModel: HomeViewModel by viewModels()
    private lateinit var _binding: HomeFragmentBinding
    private var homeAdapter: HomeAdapter? = null

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
        homeAdapter = HomeAdapter(homeData.resultItemsList) {
            val action = HomeFragmentDirections.actionHomeFragmentToItemDetailsFragment(it)
            findNavController().navigate(action)
        }
        _binding.fragmentHomeItemsRecycleView.apply {
            adapter = homeAdapter
        }
    }

    private fun handleLoading(isLoading: Boolean) {
        _binding.fragmentHomeProgress.isVisible = isLoading
    }

    private fun showError(errorMessage: String) {
        Toast.makeText(context, errorMessage, Toast.LENGTH_LONG).show()
    }

}