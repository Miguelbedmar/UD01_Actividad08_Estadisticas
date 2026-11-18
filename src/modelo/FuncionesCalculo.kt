package modelo

interface FuncionesCalculo {
    //Funciones de calculo  de media ,moda  y desviacion tipica.
    fun calcularMedia(numeros: List<Int>): Double
    fun calcularModa(numeros: List<Int>): List<Int>
    fun calcularDesviacionTipica(numeros: List<Int>): Double
    fun mostrarNumeros(numeros: List<Int>)
}