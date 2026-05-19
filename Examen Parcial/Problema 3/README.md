# Explicar cómo se detectan las inversiones. 

## Primer commit: 
Durante la fusión, cuando arr[i] > arr[j], significa que arr[j] es menor que todos los elementos que faltan de la mitad izquierda. Como la mitad izquierda está ordenada, se cuentan mid - i + 1 inversiones de una sola vez. 
merge([3],[1]): 3 > 1  inversiones += 1
merge([1,3],[2]): 3 > 2  inversiones += 1
Total = 2 que serian  (3,1) y (3,2)
## segundo commit: 
El algoritmo toma el último elemento del arreglo actual y lo compara con todos los elementos anteriores en el cos¡digo esta:
for (int i = 0; i < n - 1; i++) {
    if (arr[i] > arr[n - 1]) {
        contador++;
    }
}
Si algún elemento anterior es mayor al último se cuenta como inversión porque aparece antes pero es mayor, con el mismo ejemplo de {3, 1, 2} 
n=3: compara 2 con [3,1]
  3 > 2 inversion (3,2)  contador=1
  1 > 2 no es inversion
  
n=2: compara 1 con [3]
  3 > 1 inversion (3,1) contador=1

n=1: caso base return 0

Total = 1 + 1 + 0 = 2  con  (3,2) y (3,1)

# Obtener la recurrencia T(n). 
T(n) = T(n-1) + O(n)
T(1) = O(1)  caso base

T(n) = T(n-1) + n
     = T(n-2) + (n-1) + n
     = ...
     = 1 + 2 + 3 + ... + n
     = n(n+1)/2

# Analizar la complejidad temporal. 
Es un O(n²)  porque en cada llamada se recorren todos los elementos anteriores generando una suma de n + (n-1) + (n-2) + ... + 1 operaciones en total. 
Explicar por qué el algoritmo es más eficiente que revisar todos los pares posibles.
Compara cada par uno por uno O(n²), el algoritmo con Merge Sort aprovecha que las mitades están ordenadas y cuenta mid - i + 1 inversiones de una sola vez en vez de una por una como O(n log n). 

