package es.adrianmmudarra.widgetstring

class POJO (var nombre:String, var apellido:String){
    override fun toString(): String {
        return "$nombre $apellido"
    }
}

class B{
    var obj = POJO("Adrian", "Muñoz")

    fun something(){
        obj.toString();
    }
}