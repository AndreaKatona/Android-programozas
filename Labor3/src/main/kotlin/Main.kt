import java.io.File

class ItemService(private val itemRepository: ItemRepository){
    fun selectRandomItems(numberOfItems:Int):List<Item>
    {
        if (numberOfItems>itemRepository.size())
        {
            print("The given number is higher than the number of answers")
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


class ItemController(private val itemService: ItemService){
    fun quiz(numberOfItems: Int)
    {
        val items = itemService.selectRandomItems(numberOfItems)
        for ((i:Int,item:Item) in items.withIndex())
        {
            println("${i+1}. " + item.question)
            for (j in item.ans.indices)
            {
                print("     ${j+1}. " + item.ans[j])
            }
            println()
            print("Your answer: ")
            val answer :String? = readLine()

            if(answer?.toInt() == item.correct)
            {
                println("Correct!")
            }else
            {
                println("Incorrect!")
            }

        }
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
        items.add(item)
    }
    fun size():Int
    {
        return items.size
    }
    fun randomItem()=items.random();

}

fun main(args: Array<String>) {
  val itemController = ItemController(ItemService((ItemRepository())))
  itemController.quiz(3)

}
