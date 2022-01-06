package com.thefork.challenge.user

import androidx.lifecycle.*
import com.thefork.challenge.api.Api
import com.thefork.challenge.api.User
import com.thefork.challenge.user.UserActivity.Companion.USER_ID
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import utils.DateUtils
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val userId: String = savedStateHandle.get(USER_ID) ?: throw IllegalArgumentException(
        "USER_ID should not be empty"
    )
    private val _user = MutableLiveData(UiUserModel())
    val user: LiveData<UiUserModel> = _user

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val response = Api().userService.getUser(userId)
            response.body()?.let {
                _user.postValue(it.toUiModel())
            }
        }
    }

    data class UiUserModel(
        val id: String = "",
        val fullName: String = "",
        val picture: String = "",
        val email: String = "",
        val dateOfBirth: String = "",
        val phone: String = "",
        val registerDate: String = "",
    )

    private fun User.toUiModel() = UiUserModel(
        id = id,
        fullName = "$firstName $lastName",
        picture = picture,
        email = email,
        dateOfBirth = DateUtils.formatDate(DateUtils.parseDate(dateOfBirth)),
        phone = phone,
        registerDate = DateUtils.formatDate(DateUtils.parseDate(registerDate)),
    )


}