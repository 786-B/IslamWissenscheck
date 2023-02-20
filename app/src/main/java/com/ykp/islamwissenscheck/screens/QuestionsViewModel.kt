package com.ykp.islamwissenscheck.screens

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ykp.islamwissenscheck.data.DataOrException
import com.ykp.islamwissenscheck.model.QuestionItem
import com.ykp.islamwissenscheck.repository.DatastoreRepo
import com.ykp.islamwissenscheck.repository.QuestionRepository
import com.ykp.islamwissenscheck.util.Constants.USER_SCORE
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
class QuestionsViewModel @Inject constructor(
    private val repository: QuestionRepository,
    private val datastoreRepository: DatastoreRepo
) :
    ViewModel() {

    fun storeScore(score: Int) = runBlocking {
        datastoreRepository.putScore(USER_SCORE, score)
    }

    fun getUserScore(): Int = runBlocking {
        if (datastoreRepository.getScore(USER_SCORE) == null) {
            datastoreRepository.putScore(USER_SCORE, 0)
        }
        datastoreRepository.getScore(USER_SCORE)!!
    }

    fun clearPreferences(key: String) = runBlocking {
        datastoreRepository.clearPReferences(key)
    }


    val data: MutableState<DataOrException<ArrayList<QuestionItem>, Boolean, Exception>> =
        mutableStateOf(
            DataOrException(null, true, Exception(""))
        )

    init {
        getAllQuestions()
    }

    private fun getAllQuestions() {
        viewModelScope.launch {
            data.value.loading = true
            data.value = repository.getAllQuestions()

            if (data.value.toString().isNotEmpty()) data.value.loading = false

        }
    }
}