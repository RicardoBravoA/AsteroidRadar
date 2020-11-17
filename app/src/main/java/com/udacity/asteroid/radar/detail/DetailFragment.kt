package com.udacity.asteroid.radar.detail

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.udacity.asteroid.radar.R
import com.udacity.asteroid.radar.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {

    private val viewModel: DetailViewModel by lazy {
        ViewModelProvider(this, DetailViewModelFactory(requireActivity().application)).get(
            DetailViewModel::class.java
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentDetailBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        arguments?.let {
            val asteroid = DetailFragmentArgs.fromBundle(it).asteroidModel
            viewModel.transformData(asteroid)
        }

        val detailAdapter = DetailAdapter(::helpClick)

        binding.detailRecyclerView.adapter = detailAdapter

        viewModel.detailItemList.observe(viewLifecycleOwner, {
            it?.let {
                detailAdapter.submitList(it)
            }
        })

        return binding.root
    }

    private fun helpClick() {
        val builder = AlertDialog.Builder(requireActivity())
            .setMessage(getString(R.string.astronomical_unit_explanation))
            .setPositiveButton(android.R.string.ok, null)
        builder.create().show()
    }
}