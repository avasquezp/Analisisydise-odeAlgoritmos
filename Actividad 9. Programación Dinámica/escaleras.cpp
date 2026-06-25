#include <iostream>
using namespace std;

int main() {
    int n;
    cout << "entrada: ";
    cin >> n;
    // dp: dp[i] es igual al numero de formas distintas de llegar al escalon i
    int dp[100];

    // dp[0] = 1 hay una forma de estar en el inicio y no moverse
    // dp[1] = 1 solo existe un camino posible
    dp[0] = 1;
    dp[1] = 1;

    // Para llegar al escalon i puedo venir de i-1 que seria 1 paso o de i-2 que son 2 pasos, sumamos ambas posibilidades porque queremos contar formas
    for (int i = 2; i <= n; i++) {
        dp[i] = dp[i-1] + dp[i-2];
    }

    // Mostramos cada dp[i] para ver como se construyo la solucion de abajo hacia arriba
    cout << "tabla DP: [";
    for (int i = 0; i <= n; i++) {
        cout << dp[i];
        if (i < n) cout << ", ";
    }
    cout << "]" << endl;

    cout << "formas posibles: " << dp[n] << endl;

    return 0;
}
