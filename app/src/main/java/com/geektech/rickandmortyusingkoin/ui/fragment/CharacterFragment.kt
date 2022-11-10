package com.geektech.rickandmortyusingkoin.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.geektech.rickandmortyusingkoin.R
import com.geektech.rickandmortyusingkoin.databinding.FragmentCharacterBinding
import com.geektech.rickandmortyusingkoin.ui.adapter.CharacterAdapter
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class CharacterFragment : Fragment(R.layout.fragment_character) {

    private val binding by viewBinding(FragmentCharacterBinding::bind)
    private val viewModel by viewModel<CharacterViewModel>()
    private val characterAdapter = CharacterAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        initialize()
        setContentView()
    }

    private fun initialize() {
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = characterAdapter
        }
    }

    private fun setContentView() {
        viewModel.fetchCharacters().observe(viewLifecycleOwner) {
            lifecycleScope.launch {
                characterAdapter.submitData(it)
            }
        }
    }
}