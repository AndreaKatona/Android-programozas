import java.io.File

class ItemController{

}
class ItemService{

}
data class Item(val question:String,val ans: List<String>,val correct:Int )
{

}
class ItemRepository{

    private var items = mutableListOf<Item>()
    fun save(item:Item)
    {

    }
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

}

fun main(args: Array<String>) {
    println("Hello World!")

}