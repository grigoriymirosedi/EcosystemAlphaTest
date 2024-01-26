package com.example.ecosystemalphatest.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ecosystemalphatest.core.Resource
import com.example.ecosystemalphatest.data.remote.dto.NewsResponseDTO
import com.example.ecosystemalphatest.data.remote.dto.toNewsArticle
import com.example.ecosystemalphatest.domain.models.NewsArticle
import com.example.ecosystemalphatest.domain.repository.NewsRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val newsRepository: NewsRepository): ViewModel() {

    private val _newsResponse: MutableLiveData<Resource<List<NewsArticle>>> = MutableLiveData()
    val newsResponse: LiveData<Resource<List<NewsArticle>>>
        get() = _newsResponse

    init {
        getAllNews()
    }

    private fun getAllNews() = viewModelScope.launch {
        _newsResponse.postValue(Resource.Loading())
        val response = newsRepository.getAllNews()
        _newsResponse.postValue(handleResponse(response))
    }

    private fun handleResponse(response: Response<NewsResponseDTO>): Resource<List<NewsArticle>> {
        if(response.isSuccessful) {
            response.body()?.let { responseResult ->
                return Resource.Success(responseResult.results.map{ it.toNewsArticle() })
            }
        }
        return Resource.Error(response.message())
    }
}