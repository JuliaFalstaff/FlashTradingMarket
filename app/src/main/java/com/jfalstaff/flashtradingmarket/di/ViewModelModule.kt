package com.jfalstaff.flashtradingmarket.di

import androidx.lifecycle.ViewModel
import com.jfalstaff.flashtradingmarket.presentation.LoginViewModel
import com.jfalstaff.flashtradingmarket.presentation.SignInViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    fun bindLoginViewModel(loginViewModel: LoginViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SignInViewModel::class)
    fun bindSignInViewModel(signInViewModel: SignInViewModel): ViewModel
}