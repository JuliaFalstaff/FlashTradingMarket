package com.jfalstaff.flashtradingmarket.di


import android.app.Application
import com.jfalstaff.flashtradingmarket.presentation.login.LoginFragment
import com.jfalstaff.flashtradingmarket.presentation.login.SignInFragment
import com.jfalstaff.flashtradingmarket.presentation.pageOne.PageOneFragment
import com.jfalstaff.flashtradingmarket.presentation.pageTwo.PageTwoFragment
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component(modules = [DataModule::class, ViewModelModule::class])
interface ApplicationComponent {
    fun inject(signInFragment: SignInFragment)
    fun inject(loginFragment: LoginFragment)
    fun inject(pageOneFragment: PageOneFragment)
    fun inject(pageTwoFragment: PageTwoFragment)

    @Component.Factory
    interface ApplicationComponentBuilder {

        fun create(
            @BindsInstance application: Application
        ): ApplicationComponent
    }
}