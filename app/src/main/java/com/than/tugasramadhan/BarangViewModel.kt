package com.than.tugasramadhan

import androidx.lifecycle.*
import kotlinx.coroutines.launch

class BarangViewModel(private val repository: BarangRepository): ViewModel() {
    val allBarang: LiveData<List<Barang>> = repository.allBarang.asLiveData()

    fun insert(barang: Barang) = viewModelScope.launch {
        repository.insert(barang)
    }

}
class BarangViewModelFactory(private val repository: BarangRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(BarangViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return BarangViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}