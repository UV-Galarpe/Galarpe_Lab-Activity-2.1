package com.example.galarpe_lab_activity_21

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class QuestionsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_questions, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnQuestion1 = view.findViewById<Button>(R.id.btnQuestion1)
        val btnQuestion2 = view.findViewById<Button>(R.id.btnQuestion2)
        val btnQuestion3 = view.findViewById<Button>(R.id.btnQuestion3)

        btnQuestion1.setOnClickListener {
            navigateToAnswers(1)
        }

        btnQuestion2.setOnClickListener {
            navigateToAnswers(2)
        }

        btnQuestion3.setOnClickListener {
            navigateToAnswers(3)
        }
    }

    private fun navigateToAnswers(questionId: Int) {
        val fragment = AnswersFragment().apply {
            arguments = Bundle().apply {
                putInt("QUESTION_ID", questionId)
            }
        }
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .addToBackStack(null)
            .commit()
    }
}
