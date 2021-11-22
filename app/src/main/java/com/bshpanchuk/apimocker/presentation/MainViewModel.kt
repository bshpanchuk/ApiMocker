package com.bshpanchuk.apimocker.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bshpanchuk.apimocker.data.model.PostItem
import com.bshpanchuk.apimocker.domain.Repository
import kotlinx.coroutines.launch

class MainViewModel(
    private val repository: Repository
) : ViewModel() {

    val data = MutableLiveData<List<PostItem>>()

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            data.value = repository.getData()
        }
    }
}