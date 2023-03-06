package com.jfalstaff.flashtradingmarket.di

import dagger.Component

@ApplicationScope
@Component(modules = [DataModule::class, ViewModelModule::class])
interface ApplicationComponent {
}