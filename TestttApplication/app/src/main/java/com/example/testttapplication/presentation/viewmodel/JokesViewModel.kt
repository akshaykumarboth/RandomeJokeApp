package com.example.testttapplication.presentation.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testttapplication.domain.UseCase
import com.example.testttapplication.data.network.ApiResult
import com.example.testttapplication.data.model.JokeResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

const val limit = 10

//view model to hold jokes business logic
class JokesViewModel(
    private val useCase: UseCase
): ViewModel() {

    /*mutable state list of jokes
    * */
    private val _jokeList = mutableStateListOf<JokeResponse>()
    val jokeList = _jokeList

    /*
    * call to get jokes from remote server
    * */
    private suspend fun getJokeFromRemote(): JokeResponse? {
        val apiResult = useCase.getRemoteJoke()

        if (apiResult is ApiResult.Success) {
            val dataResponse: JokeResponse = apiResult.data
            return dataResponse
        }
        return null
    }

    /*
   * exposed call to get jokes from remote server
   * */
    fun getJoke() {
        viewModelScope.launch(Dispatchers.IO) {
            getJokeFromRemote()?.let {
                _jokeList.add(it)
                addJokeToDB(it)
                if (_jokeList.size > limit) {
                    val first = _jokeList.first()
                    _jokeList.removeFirst()
                    useCase.deleteLocalJoke(first)
                }
            }
        }
    }

    /*
   *  call to add jokes from local database
   * */
    private suspend fun addJokeToDB(joke: JokeResponse) = useCase.addLocalJoke(joke)

    /*
    * exposed call to fetch all jokes all
    * */
    fun loadLocalJokes() {
        viewModelScope.launch(Dispatchers.IO) {
            val list = getLocalJokes()
            _jokeList.addAll(list)
        }
    }
    /*
    *  call to fetch all jokes all
    * */
    private suspend fun getLocalJokes() = useCase.getLocalJokes()

}