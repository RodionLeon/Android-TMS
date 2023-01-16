package by.sergey.customview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sadEmotionalFace = findViewById<EmotionalFace>(R.id.sadEmotionalFace)
        val happyEmotionalFace = findViewById<EmotionalFace>(R.id.happyEmotionalFace)
        val passiveEmotionalFace = findViewById<EmotionalFace>(R.id.passiveEmotionalFace)
        val userEmotionalFace = findViewById<EmotionalFace>(R.id.userEmotionalFace)

        happyEmotionalFace.setOnClickListener {
            userEmotionalFace.happinessState = EmotionalFace.HAPPY
        }
        passiveEmotionalFace.setOnClickListener {
            userEmotionalFace.happinessState = EmotionalFace.PASSIVE
        }

        sadEmotionalFace.setOnClickListener {
            userEmotionalFace.happinessState = EmotionalFace.SAD
        }


    }
}