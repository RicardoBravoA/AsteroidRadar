package com.udacity.asteroid.radar.main

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.asteroid.radar.R
import com.udacity.asteroid.radar.data.util.DataDateUtil
import com.udacity.asteroid.radar.databinding.FragmentMainBinding
import com.udacity.asteroid.radar.domain.model.AsteroidModel
import com.udacity.asteroid.radar.util.DateUtil

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

        Log.i("z- currentDate", DataDateUtil.currentDate())
        Log.i("z- nextDate", DataDateUtil.currentDate(DataDateUtil.DEFAULT_END_DATE_DAYS))

        return binding.root
    }

    private fun asteroidClick(asteroidModel: AsteroidModel) {
        findNavController().navigate(MainFragmentDirections.actionShowDetail(asteroidModel))
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_overflow_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return true
    }
}