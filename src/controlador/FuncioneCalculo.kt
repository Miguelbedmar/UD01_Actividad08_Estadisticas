package controlador
import modelo.FuncionesCalculo
import kotlin.math.pow
import kotlin.math.sqrt


 class FuncioneCalculo(): FuncionesCalculo {


        //Calculo de la media con el metodo average()
     override fun calcularMedia(numeros: List<Int>): Double {
        if(numeros.isEmpty()){ // Comprobamos  si la lista esta vacia
            return 0.0
        }
         return numeros.average() //Calculamos la media

     }

     //Calculo  de la moda con groupingBy ,eachCount.
     override fun calcularModa(numeros: List<Int>): List<Int> {
        if(numeros.isEmpty()){
            return emptyList()
        }
         val numeroAgrupado = numeros.groupingBy { it }.eachCount() // Agrupamos  los numeros de la lista  y  contamos   por repetividad
         val limiteAgrupados= numeroAgrupado.values.maxOrNull()?:0

         if(limiteAgrupados   <= 1) return emptyList()

         return numeroAgrupado.filterValues { it== limiteAgrupados }.keys.toList() // Obtenemos los valires del map
     }

     //Calculo de la desviaciónTipica.
     override fun calcularDesviacionTipica(numeros: List<Int>): Double {
        if(numeros.isEmpty()){
            return 0.0
        }

         val media = calcularMedia(numeros)
         val varianza = numeros.map{(it-media).pow(2) }.average() // Calculamos la desviacion tipica

         return sqrt(varianza) // realizamos la raiz cuadrada
     }

     override fun mostrarNumeros(numeros: List<Int>) {
        
       println(" <=======Todas las estadisticas=====>")
       println("MEDIA: %.2f ".format(calcularMedia( numeros)))
       println("MODA:   "+calcularModa(numeros))
       println("DESVIACIÓN TIPICA %.2f : ".format(calcularDesviacionTipica(numeros)))
       println("<===================================>")
     }


 }







