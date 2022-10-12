import java.io.File

class ItemController{

}
class ItemService(private val itemRepository: ItemRepository){
    fun selectRandomItems(numberOfItems:Int):List<Item>
    {
        if (numberOfItems>itemRepository.size())
        {
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


data class Item(val question:String,val ans: List<String>,val correct:Int )
{

}
class ItemRepository{

    private var items = mutableListOf<Item>()

    init {
        val lines:List<String> =File("D:\\Egyetem\\2023\\Android\\Android-programozas\\Labor3\\quiz.txt").useLines { it.toList() }

        for(i in lines.indices step 6)
        {
            val  question=lines[i]
            val ans1=lines[i+1]
            val ans2=lines[i+2]
            val ans3=lines[i+3]
            val ans4=lines[i+4]
            val correct =lines[i+5]

            save(Item(question, mutableListOf(ans1,ans2,ans3,ans4),correct.toInt()))
        }

    }
    fun save(item:Item)
    {

    }
    fun randomItem()
    {
        items.shuffle();
    }

    fun size()
    {

    }

}

fun main(args: Array<String>) {
    println("Hello World!")

}