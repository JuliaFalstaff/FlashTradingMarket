package com.jfalstaff.flashtradingmarket.presentation.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jfalstaff.domain.AppState
import com.jfalstaff.domain.entity.UserProfile
import com.jfalstaff.domain.usecases.CheckUserUseCase
import com.jfalstaff.domain.usecases.SignInNewUserUseCase
import com.jfalstaff.flashtradingmarket.utils.ALREADY_HAVE_ANN_ACCOUNT
import com.jfalstaff.flashtradingmarket.utils.SAVING_USER_ERROR
import com.jfalstaff.flashtradingmarket.utils.isEmailValid
import kotlinx.coroutines.launch
import javax.inject.Inject

class SignInViewModel @Inject constructor(
    private val signInNewUserUseCase: SignInNewUserUseCase,
    private val checkUserUseCase: CheckUserUseCase
) : ViewModel() {

    private var _newUser: MutableLiveData<AppState> = MutableLiveData()
    val newUser: LiveData<AppState> = _newUser

    fun saveNewUser(userProfile: UserProfile) {
        viewModelScope.launch {
            if (emailValidation(userProfile.email)) {
                signInNewUserUseCase(userProfile)
                _newUser.value = AppState.Success(userProfile)
            } else {
                _newUser.value = AppState.ErrorMessage(SAVING_USER_ERROR)
            }
        }
    }

    fun checkUser(userProfile: UserProfile) {
        viewModelScope.launch {
            if (!checkUserUseCase(userProfile.firstName)) {
                saveNewUser(userProfile)
            } else {
                _newUser.value =
                    AppState.ErrorMessage(ALREADY_HAVE_ANN_ACCOUNT)
            }
        }
    }

    private fun emailValidation(email: String): Boolean {
        return (email.isEmailValid())
    }
}