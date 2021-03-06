package com.example.moflix.tvshow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moflix.R
import com.example.moflix.databinding.FragmentTvshowBinding
import com.example.moflix.utils.DataDummy


class TvshowFragment : Fragment() {

    private lateinit var binding: FragmentTvshowBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentTvshowBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(activity != null){
            val viewModel = ViewModelProvider(this,ViewModelProvider.NewInstanceFactory())[TvshowViewModel::class.java]
            val tvshows = viewModel.getTvshows()
            val tvshowAdapter = TvshowAdapter()
            tvshowAdapter.setTvshow(tvshows)

            with(binding.rvTvshow){
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter= tvshowAdapter
            }
        }
    }

}