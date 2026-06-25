#include <iostream>
using namespace std;

int main() {
    int monedas[] = {1, 3, 4};
    int n = 3; // cantidad de monedas
    int monto;
    cout << "ingresa el monto: ";
    cin >> monto;
    // dp[i] el minimo de monedas para formar el monto i
    int dp[100];
    // en el caso base para formar 0 se necesitan 0 monedas
    dp[0] = 0;
    // inicializamos todo con un numero muy grande 
    for (int i = 1; i <= monto; i++) {
        dp[i] = 9999;
    }

    // para cada monto i, probamos cada moneda y nos quedamos con el minimo
    for (int i = 1; i <= monto; i++) {
        for (int j = 0; j < n; j++) {
            if (monedas[j] <= i) {
                dp[i] = min(dp[i], dp[i - monedas[j]] + 1);
            }
        }
    }
    // mostramos la tabla
    cout << "tabla DP: [";
    for (int i = 0; i <= monto; i++) {
        cout << dp[i];
        if (i < monto) cout << ", ";
    }
    cout << "]" << endl;
    cout << "minimo de monedas: " << dp[monto] << endl;

    return 0;
}
