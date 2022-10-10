import java.io.File
import java.util.TreeSet

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


fun main(args: Array<String>) {
    val dict : iDictionary = DictionaryProvider.createDictionary(DictionaryType.ARRAY_LIST)
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

}