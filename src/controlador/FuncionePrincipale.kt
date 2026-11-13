package controlador

import java.util.Scanner
import java.util.Locale

val sc = Scanner(System.`in`).useLocale(Locale.US)
val ROJO = "\u001B[31m" // Creamos una variable con el nombre del color  para perzonalizar los mensajes de errores
val RESET = "\u001B[0m"

class FuncionePrincipale {


    fun String.formateoMenuPrincipalContacto(anchoTotal: Int): String { // Creamos una función extension
        val ancho = anchoTotal - 2 // restamos dos al ancho total para centrarlo
        if (this.length >= ancho) return "<$this>" // comprobamos si la longitud es superior  a la cadena de caracteres

        val textoEspacio = if (this.isEmpty()) "" else "$this" // Comprobamos si el texto está vacio

        val relleno = ancho - textoEspacio.length //Calculamos la cantidad de relleno

        val izq = relleno / 2
        val de = relleno - izq
        return "<" + "=".repeat(izq) + textoEspacio + "=".repeat(de) + ">"
    }

    fun menuPrincipal() {
        var salir = false
        val ancho = 48 // Ancho predeterminado para rellenar con <==>
        do {
            try {
                println("ESTADÍSTICAS CON KOTLIN".formateoMenuPrincipalContacto(ancho))
                println("0. Salir".formateoMenuPrincipalContacto(ancho))
                println("1. Generar 100 números aleatorios".formateoMenuPrincipalContacto(ancho))
                println("2. Introducir 100 números manualmente".formateoMenuPrincipalContacto(ancho))
                println("3. Mostrar números".formateoMenuPrincipalContacto(ancho))
                println("4. Calcular media".formateoMenuPrincipalContacto(ancho))
                println("5. Calcular moda".formateoMenuPrincipalContacto(ancho))
                println("6. Calcular desviación típica".formateoMenuPrincipalContacto(ancho))
                println("7.Calcular todas las estadísticas".formateoMenuPrincipalContacto(ancho))
                println("Seleccione una opción".formateoMenuPrincipalContacto(ancho))
                if (!sc.hasNextInt()) {
                    sc.next()
                    println("${ROJO}Error: La opción seleccionada no está disponible$RESET")
                    continue
                }
                val opcion = sc.nextInt()
                when (opcion) {
                    1 -> GeneradorNumero().numeroGenerado()
                    2 -> GeneradorNumero().numeroIngresado()
                    3 -> println("")
                    4 -> println("")

                    5 -> println("")
                    6 -> println("")

                    0 -> {
                        salir = true
                        println("Hasta luego")
                        println("Has salido del programa....")
                    }

                    else -> println("Opción introducida no disponible.")


                }


            } catch (ex: Exception) {
                println("${ROJO} ERROR! Valor inválido detectado $RESET" + ex.message)
            } catch (e: NoSuchElementException) {
                println("${ROJO} ERROR! ERROR!: Has salido fuera del fichero $RESET " + e.message)
                salir = true
            }

        } while (!salir)


    }
}