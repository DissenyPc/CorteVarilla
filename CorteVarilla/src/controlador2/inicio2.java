package controlador2;

import java.util.ArrayList;
import java.util.List;

public class inicio2 {
    // Función para encontrar el valor máximo obtenible cortando la varilla y vendiendo las piezas
    public static int rodCut(int[] prices, int n) {
        int[] dp = new int[n + 1];
        List<Integer>[] cuts = new List[n + 1];
        
        // Inicializar el array dp con 0 y la lista de cortes
        for (int i = 0; i <= n; i++) {
            //dp[i] = 0;
            cuts[i] = new ArrayList<>();
        }

        // Construir la tabla dp de abajo hacia arriba
        for (int i = 1; i <= n; i++) {
            int maxVal = Integer.MIN_VALUE;
            List<Integer> bestCut = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                int currentVal = prices[j] + dp[i - j - 1];
                if (currentVal > maxVal || (currentVal == maxVal && cuts[i - j - 1].size() + 1 < bestCut.size())) {
                    maxVal = currentVal;
                    bestCut = new ArrayList<>(cuts[i - j - 1]);
                    bestCut.add(j + 1);
                }
            }
            dp[i] = maxVal;
            cuts[i] = bestCut;
        }

        // Imprimir las medidas de corte usadas
        System.out.println("Las medidas de corte usadas son: " + cuts[n]);
        return dp[n];
    }

    public static void main(String[] args) {
        int[] prices = {1, 5, 8, 9, 10, 17, 17, 20};
        int n = 4;
        System.out.println("El valor máximo obtenible es " + rodCut(prices, n));
    }
}

