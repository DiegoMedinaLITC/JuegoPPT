package com.example.piedrapapeltijeras

enum class GameMove {
    PIEDRA,
    PAPEL,
    TIJERAS;

    fun playAgainst(otherMove: GameMove): String {
        return when {
            this == otherMove -> "Es un empate!"
            this == PIEDRA && otherMove == TIJERAS ||
                    this == PAPEL && otherMove == PIEDRA ||
                    this == TIJERAS && otherMove == PAPEL -> "Tu ganas!"
            else -> "La computadora gana!"
        }
    }

    companion object {
        fun randomMove(): GameMove {
            return values().random()
        }
    }
}
