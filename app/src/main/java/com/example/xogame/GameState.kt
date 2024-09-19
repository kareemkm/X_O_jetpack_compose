package com.example.xogame

data class GameState(
    val PlayerCircleCount: Int = 0,
    val PlayerCrossCount: Int = 0,
    val drowCount: Int = 0,
    val hintText: String = "Plyer '0' turn",
    val Currenturn: BoardCallValue = BoardCallValue.CROSS,
    val victoryType: VictoryType = VictoryType.NUNE,
    val haswon: Boolean = false


)


enum class BoardCallValue{
    CIRCLE,
    CROSS,
    NUNE

}
enum class VictoryType{
    HORIZONTAL1,
    HORIZONTAL2,
    HORIZONTAL3,
    VERTICAL1,
    VERTICAL2,
    VERTICAL3,
    NUNE
}
