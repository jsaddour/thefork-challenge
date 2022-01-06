package com.thefork.challenge.user

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation


class UserActivity : ComponentActivity() {

    private val viewModel by viewModels<UserViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = {
                            Text(text = stringResource(R.string.profile))
                        },
                        navigationIcon = {
                            IconButton(onClick = { onBackPressed() }) {
                                Icon(Icons.Filled.ArrowBack, "backIcon")
                            }
                        },
                        backgroundColor = Color.DarkGray,
                        contentColor = Color.White,
                        elevation = 10.dp
                    )
                }, content = { ShowUser(viewModel) })

        }
    }

    @Composable
    fun ShowUser(viewModel: UserViewModel) {
        val user by viewModel.user.observeAsState()
        user?.let { user ->
            Column(
                Modifier
                    .background(color = Color.White)
                    .fillMaxSize()
            ) {
                ShowHeader(user)
                ShowUserName(user)
                ShowUserContactInformations(user)
            }
        }
    }

    @Composable
    fun ShowHeader(user: UserViewModel.UiUserModel) {
        Box(Modifier.fillMaxWidth()) {
            Column() {
                Image(
                    painter = rememberImagePainter(
                        data = "https://placeimg.com/640/360/nature"
                    ),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(128.dp),
                    contentScale = ContentScale.FillBounds
                )
                Spacer(modifier = Modifier.size(48.dp))
            }


            Image(
                painter = rememberImagePainter(
                    data = user.picture,
                    builder = {
                        transformations(CircleCropTransformation())
                    }
                ),
                contentDescription = null,
                modifier = Modifier
                    .size(128.dp)
                    .align(Alignment.BottomCenter)
            )
        }
    }

    @Composable
    fun ShowUserName(user: UserViewModel.UiUserModel) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.size(16.dp))
            Text(
                text = user.fullName,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.size(16.dp))
            Text(
                text = "Senior Accountant",
                color = Color.Gray,
                fontSize = 20.sp
            )
        }

    }

    @Composable
    fun ShowUserContactInformations(user: UserViewModel.UiUserModel) {
        Spacer(modifier = Modifier.size(32.dp))
        Text(
            text = stringResource(R.string.contact_info).uppercase(), color = Color.Gray,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 16.dp)
        )
        Divider(color = Color.LightGray, thickness = 1.dp, modifier = Modifier.padding(top = 8.dp))
        ShowContactInfo(title = stringResource(R.string.email), value = user.email)
        ShowContactInfo(title = stringResource(R.string.phone_number), value = user.phone)
        ShowContactInfo(title = stringResource(R.string.birth_date), value = user.dateOfBirth)
        ShowContactInfo(title = stringResource(R.string.register_date), value = user.registerDate)


    }

    @Composable
    fun ShowContactInfo(title: String, value: String) {
        Column(modifier = Modifier.padding(horizontal = 16.dp)) {
            Text(
                text = title,
                color = Color.Gray,
                modifier = Modifier.padding(top = 16.dp)
            )
            Text(text = value, modifier = Modifier.padding(top = 8.dp))
        }
    }

    companion object {

        fun intent(context: Context, userId: String) =
            Intent(context, UserActivity::class.java).apply {
                putExtra(USER_ID, userId)
            }

        const val USER_ID = "USER_ID"
    }
}
