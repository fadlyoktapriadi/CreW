package com.example.crew.ui.screen.NonActive

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.crew.data.CrewRepository
import com.example.crew.data.db.Anggota
import com.example.crew.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class NonActiveViewModel(
    private val repository: CrewRepository
) : ViewModel() {
    private val _uiState: MutableStateFlow<UiState<List<Anggota>>> = MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<List<Anggota>>>
        get() = _uiState

    fun getAllDataAnggotaNonAktif() {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            try {
                val data = repository.getAllAnggotaNonAktif()
                _uiState.value = UiState.Success(data)
            } catch (e: Exception) {
                _uiState.value = UiState.Error(e.message ?: "Unknown Error")
            }
        }
    }
}