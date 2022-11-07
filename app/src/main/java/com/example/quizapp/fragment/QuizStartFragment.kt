package com.example.quizapp.fragment

import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.quizapp.R
import com.example.quizapp.databinding.FragmentStartBinding

class QuizStartFragment:Fragment(R.layout.fragment_start) {

    //val TAG : String = javaClass.simpleName
    private lateinit var binding : FragmentStartBinding

    override fun onCreateView(inference: LayoutInflater,container: ViewGroup?,savedInstanceState: Bundle?):View {
        binding = FragmentStartBinding.inflate(inference)
        val rootview = binding.root

        return rootview
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val startQuizButton = view.findViewById<Button>(R.id.start_quiz_button)
        startQuizButton.setOnClickListener {
            this.findNavController().navigate(R.id.questionFragment)
        }

        val chooseContactButton = view.findViewById<Button>(R.id.button_contact)
 //       chooseContactButton.setOnClickListener {

//            getContent.launch(
//                Intent(
//                    Intent.ACTION_PICK,
//                    ContactsContract.Contacts.CONTENT_URI
//                ).also {
//                    it.type = ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE
//                })
//
//     }
    }



    }
