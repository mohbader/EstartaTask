package com.estarta.task.presentation.home

import androidx.lifecycle.*
import com.estarta.task.data.model.HomeData
import com.estarta.task.domain.use_case.GetHomeDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getHomeDataUseCase: GetHomeDataUseCase
) : ViewModel() {

    private val _loadingLiveData = MutableLiveData<Boolean>()
    val loadingLiveData: LiveData<Boolean> = _loadingLiveData

    private val _homeDataLiveData = MutableLiveData<HomeData>()
    val homeDataLiveData: LiveData<HomeData> = _homeDataLiveData

    private val _onErrorLiveData = MutableLiveData<String>()
    val onErrorLiveData: LiveData<String> = _onErrorLiveData

    init {
        getHomeData()
    }

    private fun getHomeData() {
        viewModelScope.launch(Dispatchers.IO) {
            _loadingLiveData.postValue(true)
            try {
                _homeDataLiveData.postValue(getHomeDataUseCase.invoke())
            } catch (e: Exception) {
                _onErrorLiveData.postValue(e.message)
            }
            _loadingLiveData.postValue(false)
        }
    }
}