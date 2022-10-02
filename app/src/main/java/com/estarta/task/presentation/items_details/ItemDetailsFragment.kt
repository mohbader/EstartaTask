package com.estarta.task.presentation.items_details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.estarta.task.R
import com.estarta.task.databinding.HomeFragmentBinding
import com.estarta.task.databinding.ItemDetailsFragmentBinding

class ItemDetailsFragment : Fragment() {

    private lateinit var _binding: ItemDetailsFragmentBinding
    private val args by navArgs<ItemDetailsFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = ItemDetailsFragmentBinding.inflate(inflater, container, false)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding.item = args.item

    }

}