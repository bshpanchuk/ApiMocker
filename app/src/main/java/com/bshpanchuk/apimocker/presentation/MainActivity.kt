package com.bshpanchuk.apimocker.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bshpanchuk.apimocker.R
import com.bshpanchuk.apimocker.databinding.ActivityMainBinding
import com.bshpanchuk.apimocker.presentation.adapter.PostAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val viewModel: MainViewModel by viewModel()
    private val binding by viewBinding(ActivityMainBinding::bind)

    private val postAdapter = PostAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
        observeData()
    }

    private fun initView() {
        with(binding) {
            recycler.adapter = postAdapter
            recycler.setHasFixedSize(true)
        }
    }

    private fun observeData() {
        viewModel.data.observe(this) {
            postAdapter.submitList(it)
        }
    }
}