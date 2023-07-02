package com.example.weathertestapp.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.weathertestapp.databinding.FragmentMainBinding
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import java.text.SimpleDateFormat

class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    val viewModel: MainViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        viewModel.getCurrentForecast()

        binding.apply {
            btNavigateToDetails.setOnClickListener {
                val action = MainFragmentDirections.actionMainFragmentToDetailedForecastFragment()
                findNavController().navigate(action)
            }
            btNavigateToForecasts.setOnClickListener {
                val action = MainFragmentDirections.actionMainFragmentToFiveDayForecastFragment()
                findNavController().navigate(action)
            }
        }

        binding.floatingActionButton.setOnClickListener {
            viewModel.getCurrentForecast()
        }
        viewModel.currentForecast.observe(viewLifecycleOwner) {

            val uri = "https://openweathermap.org/img/wn/${it?.weather?.get(0)?.icon}@2x.png"
            Glide.with(this@MainFragment).load(uri).into(binding.showWeatherIcon)
            binding.apply {
                tvLocation.text = it?.name
                tvCountry.text = it?.sys?.country
                tvDate.text = it?.dt?.let { it1 -> convertDate(it1) }

                tvTemperature.text = it?.main?.temp?.toInt().toString() + "\u2103"
                tvPressure.text = it?.main?.pressure.toString()
                tvHumidity.text = it?.main?.humidity.toString()
                tvSpeedOfWind.text = it?.wind?.speed.toString()
            }
        }
    }
}

@SuppressLint("SimpleDateFormat")
private fun convertDate(date: Int): String {
    return SimpleDateFormat("dd.MM.yyyy").format(date * 1000L)
}

