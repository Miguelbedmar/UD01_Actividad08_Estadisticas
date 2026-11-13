package controlador

import java.util.Locale
import java.util.Random
import java.util.Scanner

class GeneradorNumero {
    val ROJO = "\u001B[31m" // Creamos una variable con el nombre del color  para perzonalizar los mensajes de errores
    val RESET = "\u001B[0m"

    private val generadorNumero = (1..100).random()
    val sc = Scanner(System.`in`).useLocale(Locale.US)

    fun numeroGenerado() {


        println(generadorNumero)
    }

    fun numeroIngresado() { //Funcion que recoge  el ingreso de cien numeros
        var numero = 0

        while (numero < 100) {
            try {
             println("Ingrese cien numeros ")
             if(!sc.hasNextInt()) {
                 sc.next()
                 continue
             }
              numero=sc.nextInt()
              sc.nextLine()

            } catch (NumberFormatException: NumberFormatException) {
                println("${ROJO} ERROR! el numero no es válido!$RESET")
                continue
            } catch (IllegalArgumentException: IllegalArgumentException) {
                println("${ROJO} ERROR! Valor  no válido!")
                continue
            }

        }

    }


}