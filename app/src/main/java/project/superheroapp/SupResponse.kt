package project.superheroapp

data class SupResponse(
    val count:Int,
    val results:List<Superhero>
){
    class Superhero(
        val name:String,
        val url:String
    ){
        fun getId():Int{
            val partes=url.split("/")
            return partes[partes.size-2].toInt()
        }
    }
}