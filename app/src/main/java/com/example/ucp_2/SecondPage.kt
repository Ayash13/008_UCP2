package com.example.ucp_2

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.ucp_2.data.DataClass

@Composable

fun SecondPage(
    formUIState: DataClass,
    backButton: () -> Unit,
    modifier: Modifier = Modifier
) {
    val items = listOf(
        Pair("Dosen Pembingbing 1", formUIState.Dosbing1),
        Pair("Dosen Pembingbing 2", formUIState.Dosbing2),
    )
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(

            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column (modifier = Modifier.fillMaxWidth()){
                Text("Nama Mahasiswa")
                Text(formUIState.nama)
            }
            Spacer(modifier = Modifier.padding(20.dp))
            Column (modifier = Modifier.fillMaxWidth(), ){
                Text("NIM")
                Text(formUIState.nim)
            }
            Spacer(modifier = Modifier.padding(20.dp))
            Column (modifier = Modifier.fillMaxWidth(), ){
                Text("Konsentrasi")
                Text(formUIState.konsentrasi)
            }
            Spacer(modifier = Modifier.padding(20.dp))
            Column (modifier = Modifier.fillMaxWidth(), ){
                Text("Judul Skirpsi")
                Text(formUIState.judul)
            }
            Spacer(modifier = Modifier.padding(20.dp))
            Column (modifier = Modifier.fillMaxWidth(), ){
                Text("Dosen Pembimbing 1")
                Text(formUIState.Dosbing1)
            }
            Spacer(modifier = Modifier.padding(20.dp))
            Column (modifier = Modifier.fillMaxWidth(), ){
                Text("Dosen Pembimbing 2")
                Text(formUIState.Dosbing2)
            }

        }

        Button(onClick = {

        }, modifier = Modifier.fillMaxWidth()) {
            Text("Back")
        }
    }
}


