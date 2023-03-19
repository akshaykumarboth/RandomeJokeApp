package com.example.testttapplication.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.testttapplication.presentation.JokesContent
import com.example.testttapplication.ui.theme.TestttApplicationTheme
import com.example.testttapplication.presentation.viewmodel.JokesViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

const val delayTime = 60000L
class MainActivity : ComponentActivity() {

    private val viewModel by viewModel<JokesViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestttApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                    JokesContent(padding = PaddingValues(20.dp), jokes = viewModel.jokeList)
                }
            }
        }
        displayLocalJokes()
        startRepeatingJob()
    }

    private fun displayLocalJokes() {
        if (viewModel.jokeList.isEmpty())
            viewModel.loadLocalJokes()
    }

    var job: Job? = null

    fun startRepeatingJob() {
        val lifecycle = this // in Activity
        lifecycle.lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                // this block is automatically executed when moving into
                // the started state, and cancelled when stopping.
                while (true) {
                    viewModel.getJoke() // the function to repeat
                    delay(delayTime)
                }
            }
        }
    }

    fun stopUpdates() {
        job?.cancel()
        job = null
    }

    override fun onDestroy() {
        super.onDestroy()
        stopUpdates()
    }
}

