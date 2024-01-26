package com.example.ecosystemalphatest.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.ecosystemalphatest.domain.repository.NewsRepository

class ViewModelProviderFactory(private val newsRepository: NewsRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(newsRepository) as T
    }
}