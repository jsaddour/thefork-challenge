package com.thefork.challenge.search

import com.thefork.challenge.api.Api
import com.thefork.challenge.api.UserService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import utils.DefaultDispatcher
import utils.DispatcherProvider

class SearchPresenter(
    private val view: SearchContract.View,
    private val coroutineScope: CoroutineScope,
    private val dispatcherProvider: DispatcherProvider,
    private val userService: UserService
) :
    SearchContract.Presenter {

    override fun getData() {

        coroutineScope.launch(dispatcherProvider.main) {
            val response = withContext(dispatcherProvider.io) {
                userService.getUsers(1u) }
            if (response.isSuccessful) {
                view.displayUsers(response.body()!!.data)
            } else {
                view.displayError()
            }
        }
    }
}
