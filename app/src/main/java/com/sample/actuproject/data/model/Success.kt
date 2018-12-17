package com.sample.actuproject.data.model


data class Success(
    val code: Int,
    val message: String,
    val key: String
)


data class RootObject(
    val success: Success
)

