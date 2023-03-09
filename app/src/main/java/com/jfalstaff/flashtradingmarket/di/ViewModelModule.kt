package com.jfalstaff.flashtradingmarket.di

import androidx.lifecycle.ViewModel
import com.jfalstaff.flashtradingmarket.presentation.login.LoginViewModel
import com.jfalstaff.flashtradingmarket.presentation.login.SignInViewModel
import com.jfalstaff.flashtradingmarket.presentation.pageOne.PageOneViewModel
import com.jfalstaff.flashtradingmarket.presentation.pageTwo.PageTwoViewModel
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

    @Binds
    @IntoMap
    @ViewModelKey(PageOneViewModel::class)
    fun bindPageOneViewModel(pageOneViewModel: PageOneViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(PageTwoViewModel::class)
    fun bindPageTwoViewModel(pageTwoViewModel: PageTwoViewModel): ViewModel
}