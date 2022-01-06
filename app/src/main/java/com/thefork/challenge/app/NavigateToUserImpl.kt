package com.thefork.challenge.app

import android.content.Context
import android.content.Intent
import com.thefork.challenge.search.NavigateToUser
import com.thefork.challenge.user.UserActivity
import javax.inject.Inject

class NavigateToUserImpl  @Inject constructor(): NavigateToUser  {
    override fun navigateToUser(userId: String, context: Context): Intent {
        return UserActivity.intent(context, userId)
    }
}