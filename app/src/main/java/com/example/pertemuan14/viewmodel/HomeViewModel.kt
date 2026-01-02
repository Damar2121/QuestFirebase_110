package com.example.pertemuan14.viewmodel

import androidx.lifecycle.ViewModel
import com.example.pertemuan14.modeldata.Siswa
import com.example.pertemuan14.repositori.RepositorySiswa
import java.io.IOException

sealed interface StatusUiSiswa {
    data class Success(val siswa: List<Siswa> = listOf()) : StatusUiSiswa
    object Error : StatusUiSiswa
    object Loading : StatusUiSiswa
}

class HomeViewModel(private val repositorySiswa: RepositorySiswa): ViewModel() {
    var statusUiSiswa: StatusUiSiswa by mutableStateOf(StatusUiSiswa.Loading)
        private set

    init{
        loadSiswa()
    }

    fun loadSiswa(){
        viewModelScope.launch {
            statusUiSiswa = StatusUiSiswa.Loading
            statusUiSiswa = try {
                StatusUiSiswa.Success(repositorySiswa.getDataSiswa())
            }catch (e: IOException){
                StatusUiSiswa.Error
            }
            catch (e:Exception){
                StatusUiSiswa.Error
            }
        }
    }
}