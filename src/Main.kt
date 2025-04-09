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


    //when
    val nombreColor = "Amarillo"
    when (nombreColor){
        "Amarillo" -> println("$nombreColor: El amarillo es el color de la alegria")
        "Rojo", "Carmesi" -> println("$nombreColor: Este color simboliza el calor") //Se ejecuta esta linea para cualquiera de los colores
        else -> println("No hay informacion para el color")
    }

    val code = 401
    when(code){
        in 200..299 -> println("Todo ha ido bien") //Si el valor esta entre 200 y 299
        in 400..500 -> println("Algo ha fallado") //entre 400 y 500
        else -> println("Codigo desconocido, algo ha fallado")
    }

    val tallaDeZapatos = 42
    val mensajeZ = when(tallaDeZapatos){
        41,43 -> "Tenemos disponibles" //41 o 43
        42,44 -> "Casi no nos quedan" //42 o 44
        45 -> "Lo siento no tenemos disponible" //45
        else -> "Estos zapatos solo vienen en tallas 41, 42, 43, 44 y 45"
    }
    println(mensajeZ)


    //while
    var contador = 10
    while(contador > 0){
        println("El valor de contador es $contador")
        contador--
    }


    //do while
    do {
        println("Generando numero aleatorio...")
        val numeroAleatorio = (0..100).random() //rango de 0 a 100 0..100
        println("El numero generado es: $numeroAleatorio")
    } while(numeroAleatorio > 50)


    //for
    val listaDeFrutas = listOf("Manzana", "Pera", "Frambuesa", "Durazno") //declaramos una lista
    for (elemento in listaDeFrutas){
        println("Hoy voy a comerme una fruta llamada $elemento")
    }

    //forEach es una funcion anonima
    listaDeFrutas.forEach {
        elemento -> println("Hoy voy a comerme una nueva fruta llamada $elemento")
    }

    //Convertimos listaDeFrutas en una lista de tipo entero, cuyos numeros enteros seran
    //la longitud de cada elemento de listaDeFrutas
    val caracteresDeFruta: List<Int> = listaDeFrutas.map { elemento -> elemento.length}
    println(caracteresDeFruta)

    //Filtramos caracteresDeFruta en una nueva lista con elementos que cumplan la condicion indicada
    val listaFiltrada = caracteresDeFruta.filter { largoDeFruta -> largoDeFruta > 5 }
    println(listaFiltrada)


    //Se usa el operador ? junto al tipo de dato para declarar una variable nula.
    //Al ser variable nula, no se pueda usar la propiedad length, pero obligamos al
    //compilador a ejecutar el codigo usando !! lo cual generara error (!! se recomienda no usarlo al crear codigo)
    //Si usamos el operador ? hacemos una llamada segura, ya que no ejecutara esa linea
    //de codigo en caso de que pudiera generar error
    var nombre2 : String? = null
    //nombre2!!.length
    nombre2?.length
    println(nombre2?.length)

    //Try Catch
    try { //Intentamos el siguiente codigo y si genera error...
        nombre2!!.length
    } catch (excepcion : NullPointerException){ //Capturamos el error, creando una excepcion del tipo NullPointerException
        println("Ha ocurrido un error") //Imprimimos un mensaje si se ejecuta el catch
    } finally{ //Se ejecuta al final de try y catch para mostrar lo que quieramos
        println("Finalmente ha ocurrido un error... Cerrando aplicacion")
    }

    //Podemos ejecutar nuestra propia excepcion
    try {
        throw NullPointerException("Referencia nula")
    } catch (excepcion : NullPointerException){
        println("Ha ocurrido un error. Referencia nula")
    } finally{
        println("Finalmente ha ocurrido un error... Cerrando aplicacion")
    }

    //Podemos usar try-catch para capturar un error y devolver un valor por defecto
    val primerValor = 10
    val segundValor = 0
    val resultado : Int = try { primerValor/segundValor } catch (excepcion2 : Exception) { 0 }
    println(resultado)

}