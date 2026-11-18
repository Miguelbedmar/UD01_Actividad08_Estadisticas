package controlador

import java.util.Locale
import java.util.Random
import java.util.Scanner

class GeneradorNumero {
    val ROJO = "\u001B[31m" // Creamos una variable con el nombre del color  para perzonalizar los mensajes de errores
    val RESET = "\u001B[0m"
    private var  contador =0
    private var numero = mutableListOf<Int>()
    val sc = Scanner(System.`in`).useLocale(Locale.US)


    fun numeroGenerado(): MutableList<Int> {
        numero = MutableList(100){(1..100).random()}

        print("Contenido de la lista generada es :${numero}\n ")
         return numero
    }

    fun numeroIngresado():MutableList<Int> { //Funcion que recoge  el ingreso de cien numeros

        while (numero.size <= 100) {
            try {
                println("Ingrese cien numeros ")
               val numeroIngresado = sc.nextLine().toIntOrNull()
                if(numeroIngresado !=null) {
                    print("Numeros ingresados${contador}/100 \n ")
                    numero.add(numeroIngresado)
                    contador++
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
        return numero

    }


    fun mostrarListaNumero (numeros: List<Int>){

        return  println("El contenido de la lista actual: ${numeros}")
    }

}