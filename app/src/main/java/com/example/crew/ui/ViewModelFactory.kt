package com.example.crew.ui

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.crew.data.CrewRepository
import com.example.crew.di.Injection
import com.example.crew.ui.screen.Home.HomeViewModel
import com.example.crew.ui.screen.NonActive.NonActiveViewModel

class ViewModelFactory(private val repository: CrewRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return HomeViewModel(repository) as T
        }
        if (modelClass.isAssignableFrom(NonActiveViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return NonActiveViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

    companion object {
        fun provideFactory(context: Context): ViewModelFactory {
            val repository = Injection.provideRepository(context)
            return ViewModelFactory(repository)
        }
    }
}