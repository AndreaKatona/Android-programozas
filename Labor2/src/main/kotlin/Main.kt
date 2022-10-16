import java.io.File
import java.util.*
import kotlin.random.Random
interface iDictionary{

    fun add(word : String) : Boolean
    fun find(word: String) : Boolean
    fun size() : Int

    companion object {
        const val PATH = "D:\\Egyetem\\2023\\Android\\Android-programozas\\Labor2\\dic.txt"
    }


}
object ListDictionary: iDictionary
{


        private val dictionary = mutableListOf<String>()

        init {
           File(iDictionary.PATH).forEachLine { add(it) }
        }
        override fun add(word: String): Boolean {
            return dictionary.add(word);
        }

        override fun find(word: String): Boolean {
            return dictionary.find { it == word }!=null
        }

        override fun size()= dictionary.size

}
enum class DictionaryType
{
    ARRAY_LIST,
    TREE_SET,
    HASH_SET,

}
object  TreeSetDictionary : iDictionary
{
    private val dictionary = TreeSet<String>()
    init {
        File(iDictionary.PATH).forEachLine { add(it) }
    }
    override fun add(word: String): Boolean {
        return dictionary.add(word);
    }

    override fun find(word: String): Boolean {
        return dictionary.find { it == word }!=null
    }

    override fun size()= dictionary.size

}

object HashSetDictionary : iDictionary
{

    private val dictionary = HashSet<String>()
    init {
        File(iDictionary.PATH).forEachLine { add(it) }
    }
    override fun add(word: String): Boolean {
        return dictionary.add(word);
    }

    override fun find(word: String): Boolean {
        return dictionary.find { it == word }!=null
    }

    override fun size()= dictionary.size
}
class DictionaryProvider
{
    companion object {
        fun createDictionary(type: DictionaryType): iDictionary {
            return when(type) {
                    DictionaryType.ARRAY_LIST -> ListDictionary
                    DictionaryType.TREE_SET -> TreeSetDictionary
                    DictionaryType.HASH_SET -> HashSetDictionary
            }
        }
    }
}

/**********feladat 2 ********/

fun String.name(): String
{
    return this.split(" ").map { it[0] }.joinToString("") { it.toString() }
}

fun List<String>.joinList(): String
{
    return this.map { it }.joinToString(prefix = "", separator = "#", postfix = "") { it.toString() }
}

fun List<String>.longestString(): String
{
    return this.map { it }.maxByOrNull { it }.toString()
}

data class Date(val year:Int=2022, val month: Int=10,val day:Int=16):Comparable<Date>
{
   /* override fun compareTo(other: Date): Int {
        return COMPARATOR.compare(this, other)
    }

    companion object {
        private val COMPARATOR =
            Comparator.comparingInt<Date> { it.year }
                .thenComparingInt { it.month }
                .thenComparingInt { it.day }
    }*/
   override fun compareTo(other: Date): Int = when {
       this.year != other.year -> this.year compareTo other.year
       this.month != other.month -> this.month compareTo other.month
       this.day != other.day -> this.day compareTo other.day
       else -> 0
   }
}

fun Date.leapYear(year: Int):Boolean
{
    var leap = false
    if (year % 4 == 0) {
        if (year % 100 == 0) {
            // year is divisible by 400, hence the year is a leap year
            leap = year % 400 == 0
        } else
            leap = true
        return true
    } else
        leap = false
        return false
    //println(if (leap) "$year is a leap year." else "$year is not a leap year.")
}
fun Date.validDate():Boolean {
    var valid = true
    if (month>12 || month<1)
    {
        return false;
    }
    if(day<1) return false

    if( leapYear(year))
    {
        if(month==2 && day>29 )
        {
            return false;
        }
        else
        {
            when (month)
            {
                1-> if(month > 31){valid = false}
                3-> if(month > 31){valid = false}
                4-> if(month > 30){valid = false}
                5-> if(month > 31){valid = false}
                6-> if(month > 30){valid = false}
                7-> if(month > 31){valid = false}
                8-> if(month > 31){valid = false}
                9-> if(month > 30){valid = false}
                10-> if(month > 31){valid = false}
                11-> if(month > 30){valid = false}
                12-> if(month > 31){valid = false}
            }
        }
    }
    if(valid==false) return false;

    return true;
}

fun main(args: Array<String>) {
  /*  val dict : iDictionary = DictionaryProvider.createDictionary(DictionaryType.ARRAY_LIST)
    println("Number of words: ${dict.size()}")
    var word: String?
    while(true){
        print("What to find? ")
        word = readLine()
        if( word.equals("quit")){
            break
        }
        println("Result: ${word?.let { dict.find(it) }}")
    }
   */
/*  feladat 2 */
   /* val name = "Jhon Smith"
    println(name.name())

    val fruits = listOf("apple", "pear", "melon", "strawberry")
    println(fruits.joinList())

    println(fruits.longestString())*/

/*  feladat 3 */

    var dates = mutableListOf<Date>()
    var i = 0
    while(dates.size != 10)
    {
        var gYear = Random.nextInt(1986,2022)
        var gMonth = Random.nextInt(0,40)
        var gDay = Random.nextInt(0,50)

        var date=Date(gYear,gMonth,gDay)
        if(date.validDate())
        {
            dates.add(i,date)
            i++
        }
        else
        {
            println(date)
        }
    }
    dates.sort()
    dates.reverse()
        dates.forEach {
        println("The date is  ${it.year} - ${it.month} - ${it.day} ")
    }



}