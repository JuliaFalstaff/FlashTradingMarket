package com.jfalstaff.flashtradingmarket.presentation.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jfalstaff.domain.AppState
import com.jfalstaff.domain.usecases.GetSavedUserUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class LoginViewModel @Inject constructor(
    private val getUserUseCase: com.jfalstaff.domain.usecases.GetSavedUserUseCase
) : ViewModel() {

    private var _user: MutableLiveData<com.jfalstaff.domain.AppState> = MutableLiveData()
    val user: LiveData<com.jfalstaff.domain.AppState> = _user

    fun getUser(name: String) {
        viewModelScope.launch {
            try {
                val user = getUserUseCase(name)
                _user.value = user?.let { com.jfalstaff.domain.AppState.Success(it) }
            } catch (error: Throwable) {
                _user.value = com.jfalstaff.domain.AppState.Error(error)
            }
        }
    }

}