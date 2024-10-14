import com.Api.CurrencyConverter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CurrencyConverter converter = new CurrencyConverter();
        boolean continuar = true;

        String[][] currencies = {
                {"ARS", "Peso Argentino"},
                {"BOB", "Boliviano"},
                {"BRL", "Real Brasileño"},
                {"CLP", "Peso Chileno"},
                {"COP", "Peso Colombiano"},
                {"USD", "Dólar Estadounidense"}
        };

        while (continuar) {
            System.out.println("\n=== Menú de Conversión de Monedas ===");
            System.out.println("Seleccione la moneda base:");
            for (int i = 0; i < currencies.length; i++) {
                System.out.printf("%d. %s - %s\n", i + 1, currencies[i][0], currencies[i][1]);
            }

            int fromOption = getUserSelection(scanner, currencies.length);

            System.out.println("\nSeleccione la moneda a convertir:");
            for (int i = 0; i < currencies.length; i++) {
                System.out.printf("%d. %s - %s\n", i + 1, currencies[i][0], currencies[i][1]);
            }

            int toOption = getUserSelection(scanner, currencies.length);

            double amount = 0;
            while (true) {
                System.out.print("Ingrese la cantidad a convertir: ");
                try {
                    amount = Double.parseDouble(scanner.nextLine());
                    if (amount > 0) {
                        break;
                    } else {
                        System.out.println("La cantidad debe ser mayor que cero.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Entrada inválida. Por favor, ingrese un número.");
                }
            }

            String fromCurrency = currencies[fromOption - 1][0];
            String toCurrency = currencies[toOption - 1][0];

            try {
                double convertedAmount = converter.convert(amount, fromCurrency, toCurrency);
                System.out.printf("\n%.2f %s son %.2f %s\n", amount, fromCurrency, convertedAmount, toCurrency);
            } catch (Exception e) {
                System.out.println("Error al realizar la conversión: " + e.getMessage());
            }

            System.out.print("\n¿Desea realizar otra conversión? (s/n): ");
            String respuesta = scanner.nextLine().toLowerCase();
            if (!respuesta.equals("s")) {
                continuar = false;
            }
        }

        System.out.println("Gracias por usar el convertidor de monedas. ¡Hasta luego!");
    }

    private static int getUserSelection(Scanner scanner, int maxOptions) {
        int selection = 0;
        while (true) {
            System.out.print("Ingrese el número de su selección: ");
            try {
                selection = Integer.parseInt(scanner.nextLine());
                if (selection > 0 && selection <= maxOptions) {
                    break;
                } else {
                    System.out.println("Selección inválida. Intente de nuevo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número.");
            }
        }
        return selection;
    }
}
