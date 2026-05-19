## 2. Explicar el caso base. (en esta parte explico un poco mas detallado el caso base de mis commits el punto 3 y 4 solo me dedico al código final)
# Primer commit: El inicio == arr.length - 1 lo que haces que una vez llegamos al ultimo elemento del arreglo, ya no habrá otro elemento que pueda compararse lo que dará de respuesta un true, pero sin este cao base nunca terminaria y causaria un error de falta de control de pila.

# Segundo commit: if (tam == 1) return true, el que hace el trabajo es tam ==1 mira que ya se reviso todos los pares del arreglo y que todo esta en orden, con un solo elemento no hay nada para comparar ese es el punto donde ya todo esta bien. en lo que se diferencia en el primer commit es que va a ir cortando el arreglo por la derecha como por ejemplo

primer commit:
orden(arr, 0) → orden(arr, 1) → orden(arr, 2) → orden(arr, 3) → orden(arr, 4) → true

segundo commit:
orden(arr, 5) → orden(arr, 4) → orden(arr, 3) → orden(arr, 2) → orden(arr, 1) → true

# Tercer commit: Hay 2 casos el de izquierda == derecha que los 2 índices apuntan al elemento del centro, ya no habrá pares que comparar y que esta ordenado. Y el izquierda > derecha que los indices se van a cruzar lo que causa a que le arreglo tiene un número par de los elementos.

#Cuarto commit: izquierda == derecha los índices llegaron al mismo elemento del centro ya no hay nada más que comparar y izquierda > derecha los índices se cruzaron lo que revisamos todo el arreglo sin encontrar desorden

## 3. Obtener T(n). 
T(n) = T(n-2) + O(1)
T(1) = O(1) caso base (izq == der)
T(0) = O(1)  caso base (izq > der)

T(n) = T(n-2) + 1
     = T(n-4) + 1 + 1
     = T(n-6) + 1 + 1 + 1
     = ...
     = T(1) + n/2
     = n/2

## 4. Analizar la complejidad temporal. 
La complejidad es  O(n/2)  aun que en las llamadas que face el problema se reduce en 2, pero hacen n/2 llamadas recursivas.

