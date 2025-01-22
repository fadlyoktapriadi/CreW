package com.example.crew.di

import android.content.Context
import com.example.crew.data.CrewRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

object Injection {
    private val applicationScope = CoroutineScope(SupervisorJob())

    fun provideRepository(context: Context): CrewRepository {
        val appContext = context.applicationContext
        return CrewRepository.getInstance(appContext, applicationScope)
    }
}