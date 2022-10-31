package com.example.quizapp.controller

class ItemController(private val itemService: ItemService) {
    fun quiz(numberOfItems: Int) {
        val items = itemService.selectRandomItems(numberOfItems)
        for ((i: Int, item: Item) in items.withIndex()) {
            println("${i + 1}. " + item.question)
            for (j in item.ans.indices) {
                print("     ${j + 1}. " + item.ans[j])
            }
            println()
            print("Your answer: ")
            val answer: String? = readLine()

            if (answer?.toInt() == item.correct) {
                println("Correct!")
            } else {
                println("Incorrect!")
            }

        }
    }
}