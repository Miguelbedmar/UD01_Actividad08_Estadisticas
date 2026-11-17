package controlador

import java.util.Locale
import java.util.Random
import java.util.Scanner

class GeneradorNumero {
    val ROJO = "\u001B[31m" // Creamos una variable con el nombre del color  para perzonalizar los mensajes de errores
    val RESET = "\u001B[0m"

    private var Numero = mutableListOf<Int>()
    val sc = Scanner(System.`in`).useLocale(Locale.US)


    fun numeroGenerado() {
       Numero = MutableList(100){(1..100).random()}

        for (num in Numero){
            print("Contenido de la lista generada es :${Numero} ")
        }

    }

    fun numeroIngresado() { //Funcion que recoge  el ingreso de cien numeros

        while (Numero.size < 100) {
            try {
             println("Ingrese cien numeros ")
               val numeroIngresado = sc.nextLine().toIntOrNull()
                if(numeroIngresado !=null) {
                    Numero.add(numeroIngresado)
                }else{
                    println("${ROJO} ERROR! el numero no es valido$RESET ")
                }
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