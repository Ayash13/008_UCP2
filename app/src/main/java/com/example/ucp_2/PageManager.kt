package com.example.ucp_2

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ucp_2.data.DataSource.Dosbing1
import com.example.ucp_2.data.DataSource.Dosbing2
import androidx.lifecycle.viewmodel.compose.viewModel

enum class PageManager {
    Home,
    First,
    Second,
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainApp(
    viewModel: ViewController = viewModel(),
    navController: NavHostController = rememberNavController(),
) {
    Scaffold(

    ) { innerPadding ->
        val uiState by viewModel.uiState.collectAsState()
        NavHost(
            navController = navController,
            startDestination = PageManager.Home.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = PageManager.Home.name) {
                WelcomePage(
                    onNextButtonClicked = { navController.navigate(PageManager.First.name) }
                )
            }
            composable(PageManager.First.name) {
                val context = LocalContext.current
                FirstPage(
                    goToNextPage = {
                        viewModel.setContent(it)

                    },
                    onNextButtonClicked = { navController.navigate(PageManager.Second.name) },
                    onSelectionChanged1 = { viewModel.setDosbing1(it) },
                    onSelectionChanged2 = { viewModel.setDosbing2(it) },
                    pilihDosbing1 = Dosbing1.map { id -> context.resources.getString(id) },
                    pilihDosbing2 = Dosbing2.map { id -> context.resources.getString(id) },
                )
            }
            composable(route = PageManager.Second.name) {
                SecondPage(
                    formUIState = uiState,
                    backButton = {
                        navController.navigate(PageManager.First.name)
                    },
                    )
            }
        }


    }
}

