package com.example.galarpe_lab_activity_21

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class AnswersFragment : Fragment() {

    private var questionId: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        questionId = arguments?.getInt("QUESTION_ID", 1) ?: 1
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_answers, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tvQuestion = view.findViewById<TextView>(R.id.tvQuestion)
        val tvResult = view.findViewById<TextView>(R.id.tvResult)

        val btnMercury = view.findViewById<Button>(R.id.btnMercury)
        val btnVenus = view.findViewById<Button>(R.id.btnVenus)
        val btnEarth = view.findViewById<Button>(R.id.btnEarth)
        val btnMars = view.findViewById<Button>(R.id.btnMars)
        val btnJupiter = view.findViewById<Button>(R.id.btnJupiter)
        val btnSaturn = view.findViewById<Button>(R.id.btnSaturn)
        val btnUranus = view.findViewById<Button>(R.id.btnUranus)
        val btnNeptune = view.findViewById<Button>(R.id.btnNeptune)

        val questionText: String
        val correctPlanet: String
        val detailText: String

        when (questionId) {
            1 -> {
                questionText = getString(R.string.question_1)
                correctPlanet = "JUPITER"
                detailText = getString(R.string.answer_jupiter)
            }
            2 -> {
                questionText = getString(R.string.question_2)
                correctPlanet = "SATURN"
                detailText = getString(R.string.answer_saturn)
            }
            3 -> {
                questionText = getString(R.string.question_3)
                correctPlanet = "URANUS"
                detailText = getString(R.string.answer_uranus)
            }
            else -> {
                questionText = getString(R.string.question_1)
                correctPlanet = "JUPITER"
                detailText = getString(R.string.answer_jupiter)
            }
        }

        tvQuestion.text = questionText

        val planetButtons = listOf(btnMercury, btnVenus, btnEarth, btnMars, btnJupiter, btnSaturn, btnUranus, btnNeptune)

        for (button in planetButtons) {
            button.setOnClickListener {
                val selectedPlanet = button.text.toString()
                tvResult.visibility = View.VISIBLE
                if (selectedPlanet == correctPlanet) {
                    tvResult.text = "${getString(R.string.correct_prefix)}${detailText}"
                } else {
                    tvResult.text = "${getString(R.string.wrong_prefix)}The correct answer is $correctPlanet. $detailText"
                }
            }
        }
    }
}