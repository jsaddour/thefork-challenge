package com.thefork.challenge.search

import kotlinx.coroutines.*
import org.junit.After
import org.junit.Rule
import org.junit.rules.TestWatcher
import org.junit.runner.Description
import java.util.concurrent.Executors

@ExperimentalCoroutinesApi
abstract class CoroutineBasedTest {

    @get:Rule
    val coroutineScope = TestCoroutineScopeRule()

    protected val testCoroutineContextProvider = DispatcherProviderTest()


    class TestCoroutineScopeRule : TestWatcher() {

        lateinit var scope: CoroutineScope
        val mainThreadSurrogate = Executors.newSingleThreadExecutor().asCoroutineDispatcher()

        override fun starting(description: Description?) {
            scope = CoroutineScope(Job() + mainThreadSurrogate)
        }

        override fun finished(description: Description?) {
            scope.cancel()
        }
    }
}