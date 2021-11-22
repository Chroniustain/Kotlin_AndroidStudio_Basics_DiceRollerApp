@file:Suppress("SpellCheckingInspection")

package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

/** This activity lets the user to roll a virtual dice and see the result in his/here screen **/
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
            Toast.makeText(this, "Good Luck! Dices Rolled!", Toast.LENGTH_SHORT).show()
            rollDice()
            rollDice2()
        }

        // Do a dice roll when the app starts
        rollDice()
        rollDice2()
    }

    /** This function will set the number of sides on our dice and when roll will be execute will show
    a dice image with the result.**/
    private fun rollDice() {
        val dice = Dice(6)
        val diceRoll = dice.roll()
        val diceImage: ImageView = findViewById(R.id.imageView)

        // We are using a when condition into a variable to check what our roll function rolled and then assign
        // the proper image for our dice.
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        // Update the ImageView with the correct drawable resource ID
        diceImage.setImageResource(drawableResource)

        // Update the content description
        diceImage.contentDescription = diceRoll.toString()
    }

    private fun rollDice2() {
        val dice2 = Dice(8)
        val diceRoll2 = dice2.roll()
        val diceImage: ImageView = findViewById(R.id.imageView2)

        val drawableResourse = when (diceRoll2) {
            1 -> R.drawable._8side_dice__side1
            2 -> R.drawable._8side_dice__side2
            3 -> R.drawable._8side_dice__side3
            4 -> R.drawable._8side_dice__side4
            5 -> R.drawable._8side_dice__side5
            6 -> R.drawable._8side_dice__side6
            7 -> R.drawable._8side_dice__side7
            else -> R.drawable._8side_dice__side8
        }

        diceImage.setImageResource(drawableResourse)

        diceImage.contentDescription = diceRoll2.toString()
    }
}

/** This is our class-blueprint of our 1st dice **/
class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}
