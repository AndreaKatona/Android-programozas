package com.example.quizapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.quizapp.R
import com.example.quizapp.controller.ItemController
import com.example.quizapp.controller.ItemRepository
import com.example.quizapp.controller.ItemService
import com.example.quizapp.databinding.QuestionFragmentBinding

class QuestionFragment:Fragment(R.layout.question_fragment) {

    private lateinit var binding : QuestionFragmentBinding

    override fun onCreateView(inference: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?):View {
        binding = QuestionFragmentBinding.inflate(inference)
        val rootview = binding.root

        return rootview
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    private fun init(view: View)
    {
        val questionTextTv : TextView = binding.questionText
        val radioGroup: RadioGroup = binding.radioGroup
        val answer1Rb : RadioButton = binding.radioButton1
        val answer2Rb : RadioButton = binding.radioButton2
        val answer3Rb : RadioButton = binding.radioButton3
        val answer4Rb : RadioButton = binding.radioButton4
        val nextbtn :Button = binding.nextBtn
        val allquestionText :TextView = binding.textView5

        val nrOfQuestions = 3
        val itemController = ItemController(
            ItemService(ItemRepository),
            requireActivity(),
            questionTextTv,
            arrayListOf(answer1Rb,answer2Rb,answer3Rb,answer4Rb), nextbtn,radioGroup,allquestionText
        )
        itemController.quiz(nrOfQuestions)
    }
}