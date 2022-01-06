package com.thefork.challenge.search

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.thefork.challenge.api.Api
import com.thefork.challenge.api.UserPreview
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.GlobalScope
import utils.DefaultDispatcher
import javax.inject.Inject

@AndroidEntryPoint
class SearchActivity : AppCompatActivity(), SearchContract.View, SearchContract.ItemClickListener {

    @Inject
    lateinit var navigateToUser: NavigateToUser

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        SearchPresenter(this, lifecycleScope, DefaultDispatcher(), Api().userService).getData()
    }



    override fun displayUsers(users: List<UserPreview>) {
        findViewById<RecyclerView>(R.id.recycler_view).adapter = UsersAdapter(users, this)
    }

    override fun displayError() {
        Snackbar
            .make(findViewById(R.id.recycler_view), R.string.error, Snackbar.LENGTH_LONG)
            .show()
    }

    fun navigateToUser(userId: String) {
        startActivity(navigateToUser.navigateToUser(userId, this))
    }

    override fun onClick(userId: String) {
        navigateToUser(userId)
    }

}


