//Las constantes se definen fuera de la funcion. O sea se declaran en tiempo de compilacion, a
//diferencia de las variables val que se declaran en tiempo de ejecucion
const val PI = 3.1416

fun main(args: Array<String>) {

    println("Hello, world")

    var dinero = 10
    var dinero2 : Int = 10 //Otra forma de declarar: var nombreVariable : Tipo = valor
    println(dinero)
    dinero = 5
    println(dinero)

    //variable de solo lectura
    val nombre1 = "Maria"
    println(nombre1)
    println(PI)

    val boolean = true
    val numeroLargo : Long = 3000000000000000
    val numeroLargo2 = 3L //otra forma de declarar un Long
    val double = 2.7182
    val float =  1.1f

    val priverValor = 20
    val segundoValor = 10
    val tercerValor = priverValor - segundoValor
    println(tercerValor)

    val apellido = "Beltran"
    val nombre = "Jesus"
    val nombreCompleto = "Mi nombre es $nombre $apellido" //template o interpolacion, es una propiedad de kotlin. Se agrega el simbolo $ y separa la concatenacion
    println(nombreCompleto)


    if (nombre.isNotEmpty()) println("El largo de la variables es ${nombre.length}") else println("Error, la variable esta vacia")

    //Se declara una variable val de solo lectura a la que se le asignara una cadena segun la sentencia de un if
    val mensaje : String = if (nombre.length > 4) {
        "Tu nombre es largo"
    } else if(nombre.isNotEmpty()){
        "Nombre vacio"
    } else {
        "Tienes un nombre corto"
    }
    println(mensaje)



}