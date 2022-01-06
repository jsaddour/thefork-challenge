package com.thefork.challenge.api

data class User(
    val id: String = "",
    val title: String= "",
    val firstName: String= "",
    val lastName: String= "",
    val picture: String= "",
    val gender: String= "",
    val email: String= "",
    val dateOfBirth: String= "",
    val phone: String= "",
    val location: Location,
    val registerDate: String= "",
    val updatedDate: String= ""
)