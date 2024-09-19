package com.example.xogame

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel


class GameViewModel: ViewModel() {

    var state by mutableStateOf(GameState())

    val boardItems: MutableMap<Int,BoardCallValue> = mutableMapOf(
        1 to BoardCallValue.NUNE,
        2 to BoardCallValue.NUNE,
        3 to BoardCallValue.NUNE,
        4 to BoardCallValue.NUNE,
        5 to BoardCallValue.NUNE,
        6 to BoardCallValue.NUNE,
        7 to BoardCallValue.NUNE,
        8 to BoardCallValue.NUNE,
        9 to BoardCallValue.NUNE
    )

    fun onAction(action : UserActions){
        when(action){
            is UserActions.BoardTapped -> {
                addValueToBoard(action.cellNo)

            }
            UserActions.PlayAgainButtonClicked -> {

            }
        }

    }

    private fun addValueToBoard(cellNo: Int) {
        if (boardItems[cellNo] != BoardCallValue.NUNE){
            return
        }
        if (state.Currenturn == BoardCallValue.CIRCLE){
            boardItems[cellNo] = BoardCallValue.CIRCLE
            state = state.copy(
                hintText = "Player 'X' turn",
                Currenturn = BoardCallValue.CROSS
            )
        }else if (state.Currenturn== BoardCallValue.CROSS){
            boardItems[cellNo] = BoardCallValue.CROSS
            state = state.copy(
                hintText = "Player 'O' turn",
                Currenturn = BoardCallValue.CIRCLE
            )
        }

    }
}