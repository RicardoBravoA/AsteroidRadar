package com.udacity.asteroid.radar.main

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.asteroid.radar.R
import com.udacity.asteroid.radar.databinding.FragmentMainBinding
import com.udacity.asteroid.radar.model.Asteroid

class MainFragment : Fragment() {

    private val mainViewModel: MainViewModel by lazy {
        ViewModelProvider(this, MainViewModelFactory(requireActivity().application)).get(
            MainViewModel::class.java
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentMainBinding.inflate(inflater)
        binding.lifecycleOwner = this

        binding.viewModel = mainViewModel

        setHasOptionsMenu(true)

        val mainAdapter = MainAdapter(::asteroidClick)

        binding.asteroidRecyclerView.adapter = mainAdapter

        mainViewModel.asteroidList.observe(viewLifecycleOwner, {
            it?.let {
                mainAdapter.submitList(it)
            }
        })


        return binding.root
    }

    private fun asteroidClick(asteroid: Asteroid) {
        findNavController().navigate(MainFragmentDirections.actionShowDetail(asteroid))
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_overflow_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return true
    }
}