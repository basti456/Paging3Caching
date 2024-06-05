package com.example.paging3caching

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.paging3caching.data.presentation.BeerScreen
import com.example.paging3caching.data.presentation.BeerViewModel
import com.example.paging3caching.ui.theme.Paging3CachingTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Paging3CachingTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val viewModel= hiltViewModel<BeerViewModel>()
                    val beers=viewModel.beerPagingFlow.collectAsLazyPagingItems()
                    BeerScreen(beers = beers)
                }
            }
        }
    }
}
