
void main() {
    //Primer ejercicio de invertir cadenas
    System.out.println("Cadena invertida ejercicio 1");
    System.out.println(invertir("Hola soy una cadena"));

    //ejercicio 2 numeros pares, use dos ejemplos
    Integer[] entrada = {2,7,9,12,33,15,22,12,4};
    Integer[] entrada2 = {1,2,3,4,5,6,7,2,4,6,8,6};
    System.out.println("Pares unicos ejercicio 2");
    System.out.println(paresUnicos(entrada2));

    //Ejercicio 3 Validar gemelos envia dos parametros para numero inicial y final
    System.out.println("Numeros primos gemelos Ejercicio 3");
    System.out.println(validarGemelos(0,10));

    //Ejercicio 4 Arreglo de enteros y numero objetivo
    Integer[] entrada3 = {2,5,8,44,1,7};
    Integer[] entrada4 = {55,3,8,11,45,1};
    Integer[] entrada5 = {2,5,88,44,1,7};
    Integer objetivo = 88;
    System.out.println("Numero objetivo Ejercicio 4");
    System.out.println(numeroObjetivo(Arrays.stream(entrada3).toList(),objetivo));
}
/*
* Funcion para invertir la cadena Ejercicio 1
* */
public static String invertir(String texto){
    String[] palabras = texto.split(" ");
    StringBuilder resultado = new StringBuilder();

    for (String s : palabras) {
        String palabra = new StringBuilder(s).reverse().toString();

        resultado.append(" ").append(palabra);
    }
    return resultado.toString();
}

/*Funcion para obtener pares Ejercicio 2*/
public static List<Integer> paresUnicos(Integer[] numeros){
    List<Integer> resultado = new ArrayList<>();
    for(Integer numero: numeros){
        if(numero % 2 == 0 && !resultado.contains(numero))
            resultado.add(numero);
    }
    return resultado;
}

/*
* Funcion para obtener numeros primos parte del Ejercicio 3
* */
public static boolean esPrimo(Integer numero){

    if(numero<=1) return false;

    for(int i=2; i<=Math.sqrt(numero); i++){
        if(numero % i == 0)
            return false;
    }
    return true;
}

/**
 * Funcion para validar gemelos parte del ejercicio 3
 * */
public static String validarGemelos(int inicio, int fin){
    List<String> par = new ArrayList<>();

    for(int i=inicio; i<= fin-2; i++){
        if(esPrimo(i) && esPrimo(i+2)){
            par.add("("+i+","+ (i+2)+")");
        }
    }
    String resultado = String.join(",", par);
    return resultado.isEmpty()?"0":resultado;
}

/**
 * Funcion de ejercicio 4 que valida si 2 numeros de la lista suman el objetivo sin que el numero se repita
 * */
public static Boolean numeroObjetivo(List<Integer> numeros, Integer objetivo){
    int resta;
    for(Integer numero: numeros){
        if(objetivo>numero){
            resta = objetivo - numero;
            if(numeros.contains(resta) && (objetivo / 2 != resta)){
                return Boolean.TRUE;
            }
        }
    }
    return Boolean.FALSE;
}