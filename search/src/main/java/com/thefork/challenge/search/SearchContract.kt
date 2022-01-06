package com.thefork.challenge.search

import com.thefork.challenge.api.UserPreview

object SearchContract {
    interface View {
        fun displayUsers(users: List<UserPreview>)
        fun displayError()
    }

    interface Presenter {
        fun getData()
    }

    interface ItemClickListener {
        fun onClick(userId: String)
    }
}