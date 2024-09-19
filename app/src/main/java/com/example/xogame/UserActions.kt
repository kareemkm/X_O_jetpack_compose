package com.example.xogame

sealed class UserActions {
    object PlayAgainButtonClicked: UserActions()
    data class BoardTapped(val cellNo: Int): UserActions()
}