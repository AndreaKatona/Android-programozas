package com.example.quizapp.controller

class ItemService(private val itemRepository: ItemRepository){
    fun selectRandomItems(numberOfItems:Int):List<Item>
    {
        if (numberOfItems>itemRepository.size())
        {
            //print("The given number is higher than the number of answers")
            println("The given number is too high ! Max Value is ${ItemRepository.size()}")
            return emptyList()
        }
        val items = mutableListOf<Item>()
        while (items.size < numberOfItems)
        {
            val item = itemRepository.randomItem()
            if(!items.contains(item))
            {
                items.add(item)
            }
        }
        return items
    }
}