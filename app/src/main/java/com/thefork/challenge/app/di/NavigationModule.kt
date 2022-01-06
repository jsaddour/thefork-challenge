package com.thefork.challenge.app.di

import com.thefork.challenge.app.NavigateToUserImpl
import com.thefork.challenge.search.NavigateToUser
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
abstract class NavigationModule {
    @Binds
    abstract fun provideNavigationToUser(navigateToUserImpl: NavigateToUserImpl) : NavigateToUser
}
