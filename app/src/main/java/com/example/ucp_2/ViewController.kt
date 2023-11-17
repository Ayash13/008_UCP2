package com.example.ucp_2

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.ucp_2.data.DataClass
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ViewController : ViewModel() {
    var nama : String by mutableStateOf("")
        private set
    var nim : String by mutableStateOf("")
        private set
    var konsentrasi : String by mutableStateOf("")
        private set
    var judul : String by mutableStateOf("")
        private set
    var dosenbing1 : String by mutableStateOf("")
        private set
    var dosenbing2 : String by mutableStateOf("")
        private set

    private val _uiState = MutableStateFlow(DataClass())
    val uiState : StateFlow<DataClass> = _uiState.asStateFlow()


    fun setDosbing1(dosbing1Pilih: String){
        _uiState.update { stateSaatIni ->
            stateSaatIni.copy(Dosbing1 = dosbing1Pilih)
        }
    }
    fun setDosbing2(dosbing2Pilih: String){
        _uiState.update { stateSaatIni ->
            stateSaatIni.copy(Dosbing2 = dosbing2Pilih)
        }
    }


    fun setContent(listData : MutableList<String>) {
        _uiState.value = DataClass(
            nama = listData[0],
            nim = listData[1],
            konsentrasi = listData[2],
            judul = listData[3]

        )
    }
}