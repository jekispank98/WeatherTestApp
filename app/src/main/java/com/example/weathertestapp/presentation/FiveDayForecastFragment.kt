package com.example.weathertestapp.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.weathertestapp.databinding.FragmentFiveDayForecastBinding
import com.example.weathertestapp.presentation.adapter.FiveDayAdapter
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class FiveDayForecastFragment : Fragment() {
    private lateinit var binding: FragmentFiveDayForecastBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerAdapter: FiveDayAdapter
    private val viewModel: MainViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFiveDayForecastBinding.inflate(inflater, container, false)
        viewModel.getFiveDayForecast()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = binding.rvForecastList
        recyclerAdapter = FiveDayAdapter()
        recyclerView.adapter = recyclerAdapter
        viewModel.fiveDayForecast.observe(viewLifecycleOwner) {
            it?.let { it1 -> recyclerAdapter.updateList(it1) }
        }
    }
}