package controlador
import modelo.FuncionesCalculo
import kotlin.math.pow
import kotlin.math.sqrt


 class FuncioneCalculo(): FuncionesCalculo {



     override fun calcularMedia(numeros: List<Int>): Double {
        if(numeros.isEmpty()){
            return 0.0
        }
         return numeros.average()
     }

     override fun calcularModa(numeros: List<Int>): List<Int> {
        if(numeros.isEmpty()){
            return emptyList()
        }
         val numeroAgrupado = numeros.groupingBy { it }.eachCount()
         val limiteAgrupados= numeroAgrupado.values.maxOrNull()?:0

         if(limiteAgrupados   <= 1) return emptyList()

         return numeroAgrupado.filterValues { it== limiteAgrupados }.keys.toList()
     }

     override fun calcularDesviacionTipica(numeros: List<Int>): Double {
        if(numeros.isEmpty()){
            return 0.0
        }

         val media = calcularMedia(numeros)
         val varianza = numeros.map{(it-media).pow(2) }.average()

         return sqrt(varianza)
     }

     override fun mostrarNumeros(numeros: List<Int>) {
       println(" <=======Todas las estadisticas=====>")
       println("MEDIA: ${calcularMedia(numeros)} ")
       println("MODA: ${calcularModa(numeros)}")
       println("DESVIACIÓN TIPICA : ${calcularDesviacionTipica(numeros)}")
       println("<===================================>")
     }


 }







