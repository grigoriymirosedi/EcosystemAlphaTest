package com.example.ecosystemalphatest.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ecosystemalphatest.app.App
import com.example.ecosystemalphatest.core.Resource
import com.example.ecosystemalphatest.databinding.ActivityMainBinding
import com.example.ecosystemalphatest.domain.repository.NewsRepository
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var newsRepository: NewsRepository

    private lateinit var binding: ActivityMainBinding

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        (applicationContext as App).appComponent.inject(this)
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpRecyclerView()

        val viewModelProviderFactory = ViewModelProviderFactory(newsRepository)
        viewModel = ViewModelProvider(this, viewModelProviderFactory).get(MainViewModel::class.java)

        viewModel.newsResponse.observe(this) { newsResponse ->
            when (newsResponse) {
                is Resource.Success -> newsResponse.data?.let {
                    hideProgressBar()
                    binding.newsRV.adapter = NewsAdapter(it)
                }
                is Resource.Loading -> showProgressBar()
                else -> {
                    Toast.makeText(
                        this,
                        "An error occurred. Please check the Internet connection", Toast.LENGTH_SHORT
                    ).show()
                    hideProgressBar()
                }
            }
        }
    }

    private fun setUpRecyclerView() {
        binding.apply {
            newsRV.layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }

    private fun showProgressBar() {
        binding.newsProgressBar.visibility = View.VISIBLE
    }

    private fun hideProgressBar() {
        binding.newsProgressBar.visibility = View.INVISIBLE
    }
}