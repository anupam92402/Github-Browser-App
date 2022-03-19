package com.example.githubbrowser.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.githubbrowser.data.repository.MainRepository
import com.example.githubbrowser.ui.viewmodel.MainViewModel

class MainViewModelFactory(private val repository: MainRepository) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }
}