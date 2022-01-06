package com.thefork.challenge.search

import android.content.Context
import android.content.Intent

interface NavigateToUser {
    fun navigateToUser(userId: String,  context: Context): Intent
}
