package com.jfalstaff.flashtradingmarket.presentation.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jfalstaff.flashtradingmarket.domain.AppState
import com.jfalstaff.flashtradingmarket.domain.entity.UserProfile
import com.jfalstaff.flashtradingmarket.domain.usecases.GetSavedUserUseCase
import com.jfalstaff.flashtradingmarket.domain.usecases.SignInNewUserUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class LoginViewModel @Inject constructor(
    private val getUserUseCase: GetSavedUserUseCase
): ViewModel() {

    private var _user: MutableLiveData<AppState> = MutableLiveData()
    val user: LiveData<AppState> = _user

    fun getUser(name: String)  {
        viewModelScope.launch {
            try {
                val user = getUserUseCase(name)
                _user.value = user?.let { AppState.Success(it) }
            } catch (error: Throwable) {
                _user.value = AppState.Error(error)
            }
        }
    }

}