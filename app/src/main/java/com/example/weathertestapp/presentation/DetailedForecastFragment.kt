package com.example.weathertestapp.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.weathertestapp.databinding.FragmentDetailedForecastBinding
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class DetailedForecastFragment : Fragment() {

    private lateinit var binding: FragmentDetailedForecastBinding
    private val viewModel: MainViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailedForecastBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.currentForecast.observe(viewLifecycleOwner) {
            binding.apply {
                tvLocation.text = it?.name
                tvCurrentTemp.text = it?.main?.temp?.toInt().toString()
                tvFeelsLikeTemp.text = it?.main?.feels_like?.toInt().toString()
                tvMaxDayTemp.text = it?.main?.temp_max?.toInt().toString()
                tvMinDayTemp.text = it?.main?.temp_min?.toInt().toString()

                tvWindSpeed.text = it?.wind?.speed.toString()
                tvDirection.text = it?.wind?.deg.toString()

                tvPressure.text = it?.main?.pressure.toString()
                tvHumidity.text = it?.main?.humidity.toString()
                tvVisibility.text = it?.visibility.toString()
            }
        }
    }
}