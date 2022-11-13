package com.example.quizapp.controller

import android.util.Log
import android.widget.*
import androidx.fragment.app.FragmentActivity
import androidx.navigation.findNavController
import com.example.quizapp.R

class ItemController(
    private val itemService: ItemService,
    private val requireActivity: FragmentActivity,
    private val questionTextTv: TextView,
    private val arrayListOf : ArrayList<RadioButton>,
    private val nextbtn: Button,
    private val radioGroup: RadioGroup,
    private val allquestionText :TextView
) {
    private var question = 1
    private val TAG = "YYYYYYYY"
    private var answers = 0
    fun quiz(numberOfItems: Int) {
        val items = itemService.selectRandomItems(numberOfItems)
//        for ((i: Int, item: Item) in items.withIndex()) {
//            println("${i + 1}. " + item.question)
//            for (j in item.ans.indices) {
//                print("     ${j + 1}. " + item.ans[j])
//            }
//            println()
//            print("Your answer: ")
//            val answer: String? = readLine()
//
//            if (answer?.toInt() == item.correct) {
//                println("Correct!")
//            } else {
//                println("Incorrect!")
//            }
//
//        }


        allquestionText.text = "${question}/${items.size}"

        questionTextTv.text = items[0].question
        for (i in items[0].ans.indices){
            arrayListOf[i].text = items[0].ans[i]
        }


//        for ((i: Int, item: Item) in items.withIndex()) {
//           println("${i + 1}. " + item.question)
//            questionTextTv.text = item.question
//            for (j in item.ans.indices) {
//                //print("     ${j + 1}. " + item.ans[j])
//                arrayListOf[j].text = item.ans[j];
//            }
        nextbtn.setOnClickListener{
            if(radioGroup.checkedRadioButtonId != -1)
            {
                if(question <= items.size)
                {
                    updateScreen(items)
                }
                else
                {
                    requireActivity.findNavController(R.id.nav_host_fragment).navigate(R.id.quizEndFragment)

                }
                val checked = radioGroup.indexOfChild(radioGroup.findViewById<RadioButton>(radioGroup.checkedRadioButtonId))
                val goodans = items[question-1].correct-1

                if(checked == goodans)
                {
                    Log.d(TAG,"CORRECT!")
                    answers++
                }
                question++
            }
            else
            {
                Toast.makeText(requireActivity,"Choose an option", Toast.LENGTH_LONG).show()
            }

        }


        }
    private fun updateScreen(items: List<Item>) {
        allquestionText.text = "${question}/${items.size}"
        radioGroup.clearCheck()

        questionTextTv.text = items[question].question
        for(i in items[question].ans.indices){
            arrayListOf[i].text = items[question].ans[i]
        }
    }
    }


