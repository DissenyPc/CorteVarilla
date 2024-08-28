package controlador;

public class inicio {
    // Función para encontrar el valor máximo obtenible cortando la varilla y vendiendo las piezas
    public static int rodCut(int[] prices, int n) {
        int[] dp = new int[n + 1];
        
        // Inicializar el array dp con 0
        for (int i = 0; i <= n; i++) {
            dp[i] = 0;
        }

        // Construir la tabla dp de abajo hacia arriba
        for (int i = 1; i <= n; i++) {
            int maxVal = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++) {
                maxVal = Math.max(maxVal, prices[j] + dp[i - j - 1]);
            }
            dp[i] = maxVal;
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int[] prices = {10,20, 8, 9, 10, 17, 17, 20};
        int n = 4;
        System.out.println("El valor máximo obtenible es " + rodCut(prices, n));
    }
}
