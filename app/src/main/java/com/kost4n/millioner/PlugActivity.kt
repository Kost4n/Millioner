package com.kost4n.millioner

import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.kost4n.millioner.databinding.ActivityPlugBinding

class PlugActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPlugBinding
    private val arrayQuestions = mutableMapOf<String, String>()
    private val arrayButtons = mutableListOf<Button>()
    private val arrayAnswers = mutableListOf<String>()
    init {
        arrayQuestions["In which sport do the rules prohibit running?"] = "Sports walking"
        arrayQuestions["Motorcycle racing on a motorcycle track"] = "Speedway"
        arrayQuestions["What kind of sport can be called exclusively female?"] = "Synchronized swimming"
        arrayQuestions["A game in which two teams of seven players try to throw the ball into the goal of the other team"] = "Handball"
        arrayQuestions["Which sports game is the most popular in the world?"] = "Football"
        arrayQuestions["In this sport, various acrobatic exercises are performed on shells"] = "Gymnastic"
        arrayQuestions["In what kind of wrestling did the great Alexander Karelin perform?"] = "Greco-Roman wrestling"
        arrayQuestions["A game of skittles that need to be knocked down with the help of heavy balls"] = "Bowling"
        arrayQuestions["Skiing with shooting"] = "Biathlon"
        arrayQuestions["The playground for which sports game has a size of fourteen by twenty-six meters?"] = "Basketball"
        arrayQuestions["In this sport, an athlete, being on the waves, stands on the board and controls it"] = "Surfing"
        arrayQuestions["Competitions are held on rapiers, sabers, swords"] = "Fencing"
        arrayQuestions["Sports team game with an oval ball"] = "Rugby"
        arrayQuestions["Sports team game on an ice or grass field"] = "Hockey"
        arrayQuestions["A sports game on ice that originated in Scotland back in the 16th century"] = "Curling"
    }
    private var correctAnswer = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlugBinding.inflate(layoutInflater)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(binding.root)

        arrayButtons.add(binding.button1)
        arrayButtons.add(binding.button2)
        arrayButtons.add(binding.button3)
        arrayButtons.add(binding.button4)

        binding.button1.setOnClickListener(this::onClick)
        binding.button2.setOnClickListener(this::onClick)
        binding.button3.setOnClickListener(this::onClick)
        binding.button4.setOnClickListener(this::onClick)

        createAnswer()
    }

    private fun createAnswer() {
        val randomQuestion = arrayQuestions.entries.random()
        if (arrayAnswers.contains(randomQuestion.key))
            createAnswer()
        else {
            binding.textQuestion.text = randomQuestion.key
            correctAnswer = randomQuestion.key
            val randomButton = arrayButtons[arrayButtons.indices.random()]
            randomButton.text = correctAnswer
            fillButtons(randomButton)
        }
    }

    private fun fillButtons(random: Button) {
        for (i in arrayButtons) {
            if (i != random) {
                while (true) {
                    val rd = arrayQuestions.values.random()
                    if (rd != correctAnswer) {
                        i.text = rd
                        break
                    }
                }
            }
        }
    }

    private fun onClick(view : View) {
        val button = view as Button
        if (button.text.toString() == correctAnswer) {
            Toast.makeText(this, "You answer right!", Toast.LENGTH_LONG).show()
            createAnswer()
        } else {
            Toast.makeText(this, "You answered incorrectly", Toast.LENGTH_LONG).show()
        }
    }

}