package com.udacity.asteroid.radar.detail

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.udacity.asteroid.radar.R
import com.udacity.asteroid.radar.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentDetailBinding.inflate(inflater)
        binding.lifecycleOwner = this

        arguments?.let {
            val asteroid = DetailFragmentArgs.fromBundle(it).asteroid
            binding.asteroid = asteroid
            Log.i("z- asteroid", asteroid.toString())
        }

        /*binding.helpButton.setOnClickListener {
            displayAstronomicalUnitExplanationDialog()
        }*/

        return binding.root
    }

    private fun displayAstronomicalUnitExplanationDialog() {
        val builder = AlertDialog.Builder(requireActivity())
            .setMessage(getString(R.string.astronomical_unit_explanation))
            .setPositiveButton(android.R.string.ok, null)
        builder.create().show()
    }
}