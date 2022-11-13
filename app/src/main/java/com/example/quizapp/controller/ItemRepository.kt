package com.example.quizapp.controller

import java.io.File

object ItemRepository{

    private var items = mutableListOf<Item>()

    init {
//        val lines:List<String> =
//            File("D:\\Egyetem\\2023\\Android\\Android-programozas\\Labor3\\quiz.txt").useLines { it.toList() }
//
//        for(i in lines.indices step 6)
//        {
//            val  question=lines[i]
//
//            val ans1=lines[i+1]
//            val ans2=lines[i+2]
//            val ans3=lines[i+3]
//            val ans4=lines[i+4]
//            val correct =lines[i+5]
//
//            save(Item(question, mutableListOf(ans1,ans2,ans3,ans4),correct.toInt()))
//        }
        val it1 = Item("Inside an extension function, what is the name of the variable that corresponds to the receiver object", listOf("The variable is named it","The variable is named this","The variable is named receiver","The variable is named default"),2)
        val it2 = Item("Which line of code shows how to display a nullable string's length and shows 0 instead of null?", listOf("println(b!!.length ?: 0)","println(b?.length ?: 0)","println(b?.length ?? 0)","println(b == null? 0: b.length)"),2)
        val it3 = Item("Which code snippet correctly shows a for loop using a range to display \"1 2 3 4 5 6\"?", listOf("for(z in 1..7) println(z)","for(z in 1..6) print(z)","for(z in 1..6) print(z)","for(z in 1..6) print(z)"),2)
        val it4 = Item("Your code need to try casting an object. If the cast is not possible, you do not want an exception generated, instead you want null to be assigned. Which operator can safely cast a value?\n" +
                "as?", listOf("??","is","as","1"),1)
        val it5 = Item("Which function changes the value of the element at the current iterator location?",
            listOf("change()","modify()","set()","assign()"),3)

        save(it1)
        save(it2)
        save(it3)
        save(it4)
        save(it5)


    }
    fun save(item:Item)
    {
        items.add(item)
    }
    fun size():Int
    {
        return items.size
    }
    fun randomItem()=items.random()

}