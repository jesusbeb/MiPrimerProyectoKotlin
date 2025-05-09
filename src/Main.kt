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


    //Elvis operator ?: sirve para convertir de nulables a no nulables. Evita errores del
    //tipo NullPointerException al proporcionar un valor por defecto a una variable nula.
    //Simplifica la escritura de codigo al reducir la necesidad de comprobaciones explicitas de nulos
    var nombre3: String? = null
    var caracteresDeNombre3 : Int = nombre3?.length ?: 0
    println(caracteresDeNombre3)


    //Listas
    //Las listas en Kotlin son parte fundamental de las 'collections' y se dividen en
    //dos grandes tipos: listas mutables e inmutables.
    val listaDeNombres = listOf("Juan", "Enrique", "Camila") //Lista inmutable. Ya no podemos agregar ni eliminar
    println(listaDeNombres)

    val listaVacia = mutableListOf<String>() //lista mutable
    println(listaVacia)

    listaVacia.add("Juan") //Agregamos un elemento
    println(listaVacia)

    val valorUsandoGet = listaVacia.get(0) //Forma de obtener un elemento de la lista
    println(valorUsandoGet)

    val valorUsandoOperador = listaVacia[0] //Otra forma de obtener un elemento
    println(valorUsandoOperador)

    val primerValorL = listaDeNombres.firstOrNull() //Obtenemos el primer valor de la lista, y si esta vacia, devuelve un String vacio
    println(primerValorL)

    listaVacia.removeAt(0) //Eliminamos un elemento
    println(listaVacia)

    listaVacia.add("Enrique")
    println(listaVacia)
    listaVacia.removeIf{caracteres -> caracteres.length >3} //Eliminamos un elemento si se cumple cierta condicion
    println(listaVacia)

    //Arreglos
    val myArray = arrayOf(1,2,3,4)
    println("Nuestro array $myArray") //Nos devuelve bytecode. En Kotlin no es aconsejable usar Arrays
    println("Array como lista ${myArray.toList()}") //Convertimos el array a una lista


    //Ordenamiento de listas con las funciones de kotlin
    val numerosDeLoteria = listOf(11,22,43,56,78,66) //Creamos una lista
    println(numerosDeLoteria)

    val numerosSorted = numerosDeLoteria.sorted() //Ordenamos en orden ascendente
    println(numerosSorted)

    val numerosDeLoteriaDescendientes = numerosDeLoteria.sortedDescending()
    println(numerosDeLoteriaDescendientes)

    //Ordenamos segun una condicion. En este caso se ordenan primero los
    //numeros mayores a 50, seguidos de los menores a 50
    val ordenarPorMultiplos = numerosDeLoteria.sortedBy { numero -> numero < 50 }
    println(ordenarPorMultiplos)

    val numerosAleatorios = numerosDeLoteria.shuffled()
    println(numerosAleatorios)

    val numerosEnReversa = numerosDeLoteria.reversed()
    println(numerosEnReversa)

    //Convertimos la lista de int en una lista de String con mensajes de texto
    val mensajesDeNumeros = numerosDeLoteria.map { numero -> "Tu numero de loteria es $numero" }
    println(mensajesDeNumeros)

    //Filtramos numeros segun una condicion
    val numerosFiltrados = numerosDeLoteria.filter { numero -> numero > 50 }
    println(numerosFiltrados)


    //Los maps en Kotlin forman parte de la familia de las colecciones y se utilizan para
    //almacenar pares de elementos, donde cada clave tiene un valor asociado. Esta
    //estructura de datos se conoce como clave-valor y es fundamental para organizar y
    //manipular datos de manera eficiente en una aplicación.
    //No confundir los maps con la función map. Aquí, nos centramos en los maps como colecciones de datos.
    val edadDeSuperHeroes = mapOf( //Creamos un mapa inmutable
        "Ironman" to 35,
        "Spiderman" to 23,
        "Capitan America" to 99
    )
    println(edadDeSuperHeroes)

    val edadSuperHeroesMutable = mutableMapOf(
        "Ironman" to 35,
        "Spiderman" to 23,
        "Capitan America" to 99
    )
    println(edadSuperHeroesMutable)

    //Agregamos un elemento al map
    edadSuperHeroesMutable.put("Wolverine", 45)
    println(edadSuperHeroesMutable)

    //Otra forma de agregar un elemento
    edadSuperHeroesMutable["Storm"] = 30
    println(edadSuperHeroesMutable)

    //Para obtener un valor, se necesita la key. Obtenemos el valor de la key Ironman
    val edadIronman = edadSuperHeroesMutable["Ironman"]
    println(edadIronman)

    //Eliminamos elementos de map. Se hace pasando la clave
    edadSuperHeroesMutable.remove("Wolverine")
    println(edadSuperHeroesMutable)

    //Obtenemos todas las claves
    println(edadSuperHeroesMutable.keys)

    //Obtenemos todos los valores
    println(edadSuperHeroesMutable.values)


    //Los sets en Kotlin son una colección que se caracteriza por no permitir
    //elementos duplicados.
    //Creamos un set inmutable con elementos duplicados, pero este solo almacenara los no repetidos
    val vocablesRepetidas = setOf("a", "e", "i", "o", "u", "a", "e", "i", "o", "u")
    println(vocablesRepetidas)

    val numerosFavoritos = mutableSetOf(1,2,3,4)
    println(numerosFavoritos)
    numerosFavoritos.add(5)
    numerosFavoritos.add(4)
    println(numerosFavoritos)

    //En los sets se eliminan los elementos indicando el valor del elemento
    numerosFavoritos.remove(5)
    println(numerosFavoritos)

    //Obtenemos un elemento segun una condicion. En lugar de solo usar first, usamos
    //firstOrNull en caso de que la condicion no se cumpla y nos devuelva un nulable.
    //firstOrNull solo devuelve el primer elemento que cumpla dicha condicion.
    //Especificamos el posible nulable al declarar la variable por si hay que manejar una excepcion
    val valorDelSet: Int? = numerosFavoritos.firstOrNull { numero -> numero > 2 }
    println(valorDelSet)


    //Funciones
    val fraseAleatoria = "En Platzi nunca paramos de aprender"
    println(randomCase(fraseAleatoria))
    imprimirFrase(randomCase(fraseAleatoria))

    //Llamamos una funcion de extension desde una cadena de texto
    val fraseAleatoria2 = "En Platzi nunca paramos de aprender...".randomCase2()
    imprimirFrase(fraseAleatoria2)


    //Parametros nombrados se usa como buena practica para identificar los parametros que se envian a la funcion
    imprimirNombre(nombre = "Jesus", apellido = "Beltran")


    //Lambdas, tambien conocidas como funciones anonimas
    //val nombreLambda : (tipoParametroEntrada) -> tipoRetorno = { nombreParametroEntrada -> nombreParametroEntrada.funcion}
    //en la variable lambdaEjecutada almacenamos el valor Int que retornara myLambda al
    //enviarle entre parentesis el valor que requiere
    val myLambda : (String) -> Int = { valor -> valor.length }
    val lambdaEjecutada: Int = myLambda("Hola Platzi")
    println(lambdaEjecutada)

    //Podemos pasar las lambdas como parametros a otras funciones.
    //Creamos una lista de saludos
    //Creamos una segunda lista con la longitud de caracteres de los saludos
    val saludos = listOf("hello", "Hola", "Ciao")
    val longitudDeSaludos = saludos.map(myLambda)
    println(longitudDeSaludos)


    //Funcion de alto orden, llamamos a la superfuncion, enviando el argumento del valorInicial
    //y definimos la lambda llamada block
    val largoDelValorInicial = superFuncion(valorInicial = "Hola!", block = { valor ->
        valor.length
    })
    /* //Tambien se puede sacar la lambda fuera de la funcion:
    val largoDelValorInicial = superFuncion(valorInicial = "Hola!") { valor ->
        valor.length
    }*/
    println(largoDelValorInicial)

    //Variable de tipo lambda que devuelve un String, dicho String se obtiene de
    //funcionInception al enviarle tambien un String. Si imprimimos "lambda: () -> String" se
    //devuelve una funcion, por lo que se necesita obtener el valor de la lambda para imprimirlo
    val lambda: () -> String = funcionInception("Jesus")
    val valorLambda: String = lambda()
    println(valorLambda)


    /* La función let es una de las Scope Functions más utilizadas en Kotlin,
    especialmente cuando trabajamos con variables anulables. El poder de let radica
    en su capacidad de ejecutar un bloque de código solo cuando una variable no es nula,
    lo cual nos ahorra posibles errores de ejecución derivados de un
    null pointer exception.
    */
    //Creamos una variable nula
    //Usamos la funcion let con el operador safe call (?)
    //Como la variable es null, el codigo no se ejecutara al menos que tenga un valor
    var nombre4 : String? = null
    nombre4?.let {
        valor -> println("El nombre no es nulo, es $valor")
    }
    //Ahora asignamos un valor a la variable, con lo cual ahora si se ejecutara el codigo
    nombre4 = "Jesus"
    nombre4?.let{
        valor ->
        println("El nombre no es nulo, es $valor")
    }


    /*La función with en Kotlin es una herramienta poderosa que permite mejorar la
    legibilidad y mantener el código más limpio. Al utilizar with, podemos acceder a
    las propiedades de un objeto que le pasamos como parámetro, simplificando el acceso a
    estas sin repetir el nombre de la variable en múltiples líneas.
    */
    //Declaramos una lista de colores
    //Pasamos la lista a la funcion with y dentro de su lambda podemos
    //acceder a las propiedades de la lista
    val colores = listOf("Azul", "Amarillo", "Rojo")
    with(colores) {
        println("Nuestros colores son $this")
        println("Esta listia tiene una cantidad de colores de $size")
    }


    /*La función run es una poderosa herramienta en Kotlin que permite ejecutar una
    serie de operaciones sobre una variable después de ser declarada. Esta función es
    particularmente útil cuando necesitas modificar una lista de elementos antes de
    utilizarla en otras partes de tu código.
    */
    //Declaramos una lista mutable
    //Usamos la funcion run y dentro de su lambda usamos la funcion removeIf para eliminar
    //los elementos que cumplan una condicion, dicha condicion sera para los elementos que
    //contengan el texto "Google"
    //Se devuelve la lista modificada con this
    val moviles = mutableListOf("Google Pixel 2XL", "Google Pixel 4a", "Huawei Redmi 9", "Xiaomi mi a3")
        .run {
            removeIf { movil -> movil.contains("Google") }
            this
        }
    println(moviles)


    /*La función apply es una herramienta muy útil que permite realizar
    operaciones sobre una variable y devolver su valor. Esta función es especialmente
    práctica cuando se trata de manipular variables anulables de forma segura. A
    diferencia de otras funciones, como rom, no es necesario devolver explícitamente el
    resultado desde una lambda, ya que apply lo hace automáticamente. Además, al
    combinarse con un safe cast, la función apply permite trabajar con
    variables anulables previniendo la modificación de propiedades incorrectamente si
    no se les ha asignado un valor.
    */
    //Apply devuelve el resultado sin usar this, a diferencia de Run
    val moviles2 = mutableListOf("Google Pixel 2XL", "Google Pixel 4a",
        "Huawei Redmi 9", "Xiaomi mi a3").apply{
            removeIf{ movil -> movil.contains("Google")}
    }
    println(moviles2)

    //Podemos tener una funcion Apply segura al combinarla con un safe cast en el
    //caso de trabajar con variables nulables y evitar pointer exceptions
    val colores2 : MutableList<String>? = mutableListOf("Amarillo", "Azul", "Rojo")
    colores2?.apply {
        println("Nuestros colores son $this")
        println("La cantidad de colores es $size")
    }


    /*La función also en Kotlin es una herramienta extremadamente útil que puede
    ayudarte a mejorar la claridad y la eficiencia de tu código. Su principal
    propósito es realizar una operación en un objeto y luego devolver este mismo
    objeto para que pueda ser utilizado por otra función más adelante.
    Esta capacidad de "encadenamiento" hace que la función also sea muy poderosa para
    depurar y modificar el estado de las variables de manera ordenada y limpia.
    */
    //Aplicamos "also" a la lista y la imprimimos. Despues fuera del also podemos usar otra
    //funcion como "asReversed" e imprimir el objeto lista para ver el resultado
    val moviles3 = mutableListOf("Google Pixel 2XL", "Google Pixel 4a",
        "Huawei Redmi 9", "Xiaomi mi a3").also {
            lista -> println("El valor original de la lista es $lista")
    }.asReversed()
    println(moviles3)

}



//Al declarar una funcion se tiene que hacer fuera de la funcion main
//Entre parentesis se declara el nombre del parametro y tipo.
//Fuera del parentesis van dos puntos y tipo de dato que retornara la funcion
//Esta funcion convierte todo un String a mayusculas o minusculas, esto segun el
//residuo de la division de un numero aleatorio entre 2
fun randomCase(frase : String) : String {
    val numeroAleatorio = 0..99 //variable que especifica un rango de 0 a 99
    val resultadoAleatorio = numeroAleatorio.random() //se genera un numero aleatorio segun el rango
    //.rem() se usa para obtener el residuo de una division entre algun numero que se le especifique
    return if (resultadoAleatorio.rem(2) == 0){
        frase.toUpperCase()
    } else {
        frase.toLowerCase()
    }
}


//Funcion que no devuelve algun valor especifico, devuelve Unit (similar a void en
//otros lenguajes). Solo imprime un String. Se puede omitir Unit en la declaracion de la funcion
fun imprimirFrase(frase : String) : Unit {
    println("Tu frase es: $frase")
}


//Funcion de extension
//Las funciones de extensión en Kotlin te permiten añadir funcionalidad a un
//tipo existente sin tener que heredar de él o modificar su código original.
//Para crear una función de extensión, se usa la misma sintaxis de una función normal,
//pero precedida por el tipo al que deseas añadir la extensión.
//Usamos this para utilizar la cadena de texto que llame a esta funcion
fun String.randomCase2() : String {
    val numeroAleatorio = 0..99
    val resultadoAleatorio = numeroAleatorio.random()
    return if (resultadoAleatorio.rem(2) == 0){
        this.toUpperCase()
    } else {
        this.toLowerCase()
    }
}


//Parametros por defecto, se usan cuando dicho parametro no es enviado cuando se llama a la funcion
fun imprimirNombre(nombre: String, segundoNombre: String = "", apellido: String){
    println("Mi nombre es $nombre $segundoNombre $apellido")
}


//Funcion de Alto Orden
//Como parametro recibe un String, block es una sintaxis recomendada para nombrar las lambdas,
//en este caso es una lambda que recibe un String y devuelve un entero. La funcion igual devuelve un entero
//Esta funcion retorna el valor del block al pasarle el valorInicial
fun superFuncion(valorInicial : String, block : (String) -> Int) : Int {
    return block(valorInicial)
}

//Funcion que recibe como parametro un String y devuelve una lambda que no
//recibe parametro y devuelve tambien un String   () -> String
//Retornamos las lambda entre {} y ahi podemos colocar el String que devuelve
fun funcionInception(nombre : String) : () -> String {
    return {
        "Hola desde la lambda $nombre"
    }
}
