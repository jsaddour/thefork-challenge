package com.thefork.challenge.search

import com.thefork.challenge.api.Page
import com.thefork.challenge.api.UserPreview
import com.thefork.challenge.api.UserService
import io.mockk.MockK
import io.mockk.coEvery
import io.mockk.mockk
import io.mockk.verify
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Response
import utils.DispatcherProvider

class SearchPresenterTest : CoroutineBasedTest() {
    lateinit var view: SearchContract.View
    lateinit var presenter: SearchPresenter
    lateinit var dispatcherProvider: DispatcherProvider
    lateinit var userService: UserService


    @Before
    fun setUp() {
        view = mockk()
        userService = mockk(relaxed = true)
        dispatcherProvider = testCoroutineContextProvider
        presenter = SearchPresenter(view, coroutineScope.scope, dispatcherProvider, userService)
    }


    @Test
    fun testSuccess() {
        val users = listOf<UserPreview>(
            UserPreview(
                "test_id",
                "test_title",
                "julien",
                "saddour",
                "test.jpg"
            )
        )
        coEvery {
            userService.getUsers(1u)
        } answers {
            Response.success(
                Page(
                    users, 1u
                )
            )
        }
        presenter.getData()
        verify { view.displayUsers(users) }
    }

    @Test
    fun testError() {

        coEvery {
            userService.getUsers(1u)
        } answers {
            Response.error(404, mockk(relaxed = true))
        }
        presenter.getData()
        verify { view.displayError() }
    }

    @After
    fun tearDown() {

    }
}