/*-----------------------------------------------------------
----------------
* ÁNGEL DE JESÚS MÉRIDA JIMÉNEZ - 23661
* UNIVERSIDAD DEL VALLE DE GUATEMALA
* FACULTAD DE INGENIERÍA
* DEPARTAMENTO DE CIENCIA DE LA COMPUTACIÓN
* PROGRAMACIÓN DE PLATAFORMAS MÓVILES
*
*
* Actividad:LABORATORIO 2
* Descripción:IMPLEMENTACIÓN DE 6 FUNCIONES DADAS EN LAS INSTRUCCIONES DEL LABORATORIO
-------------------------------------------------------------
-----------------*/
fun main() {
    // Función calcularPromedio
    fun calcularPromedio(numbers: List<Int>): Double {
        val sum = numbers.reduce { acc, num -> acc + num }
        return sum.toDouble() / numbers.size
    }

    // Función para filtrar números impares
    fun filtrarNumerosImpares(numbers: List<Int>): List<Int> {
        return numbers.filter { it % 2 != 0 }
    }

    // Función isPalindrome
    fun isPalindrome(str: String): Boolean {
        val cleanedStr = str.replace(Regex("[^A-Za-z0-9]"), "").toLowerCase()
        return cleanedStr == cleanedStr.reversed()
    }

    // Función para agregar saludo a cada nombre en una lista
    fun agregarSaludo(nombres: List<String>): List<String> {
        return nombres.map { "¡Hola, $it!" }
    }

    // Función performOperation
    fun performOperation(a: Int, b: Int, operation: (Int, Int) -> Int): Int {
        return operation(a, b)
    }

    // Clases Person y Student, y función de mapeo
    data class Person(val name: String, val age: Int, val gender: String)
    data class Student(val name: String, val age: Int, val gender: String, val studentId: String)

    fun mapPersonToStudent(person: Person, studentId: String): Student {
        return Student(person.name, person.age, person.gender, studentId)
    }

    // Menú de opciones
    while (true) {
        println("\nSeleccione una opción:")
        println("1. Calcular promedio")
        println("2. Filtrar números impares")
        println("3. Verificar si una cadena es un palíndromo")
        println("4. Agregar saludo a nombres")
        println("5. Realizar operación matemática")
        println("6. Mapear Person a Student")
        println("0. Salir")
        print("Opción: ")

        when (readLine()?.toIntOrNull()) {
            1 -> {
                val numeros = listOf(1, 2, 3, 4, 5)
                println("El promedio es: ${calcularPromedio(numeros)}")
            }
            2 -> {
                val numeros = listOf(1, 2, 3, 4, 5)
                val numerosImpares = filtrarNumerosImpares(numeros)
                println("Números impares: $numerosImpares")
            }
            3 -> {
                print("Ingrese una cadena: ")
                val palabra = readLine() ?: ""
                println("¿'$palabra' es un palíndromo? ${isPalindrome(palabra)}")
            }
            4 -> {
                val nombres = listOf("Alicia", "Roberto", "Luisa")
                val saludos = agregarSaludo(nombres)
                saludos.forEach { println(it) }
            }
            5 -> {
                print("Ingrese el primer número: ")
                val a = readLine()?.toIntOrNull() ?: 0
                print("Ingrese el segundo número: ")
                val b = readLine()?.toIntOrNull() ?: 0
                println("Seleccione la operación:")
                println("1. Suma")
                println("2. Resta")
                print("Opción: ")
                val operacion = when (readLine()?.toIntOrNull()) {
                    1 -> { x: Int, y: Int -> x + y }
                    2 -> { x: Int, y: Int -> x - y }
                    else -> { x: Int, y: Int -> x + y }
                }
                val resultado = performOperation(a, b, operacion)
                println("El resultado de la operación es: $resultado")
            }
            6 -> {
                val personas = listOf(
                    Person("Samuel", 20, "Masculino"),
                    Person("Luna", 22, "Femenino")
                )
                val estudiantes = personas.mapIndexed { index, person -> mapPersonToStudent(person, "ID${index + 1}") }
                estudiantes.forEach { println("El Estudiante ${it.name} tiene ${it.age}") }
            }
            0 -> {
                println("Abandonando el programa")
                return
            }
            else -> {
                println("Opción inexistente, ingresa una opción válida")
            }
        }
    }
}
