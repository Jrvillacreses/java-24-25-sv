import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String linea = sc.nextLine();
            if (linea.isEmpty()) continue;

            // Obtener el primer carácter y calcular el desplazamiento
            char primerCaracter = linea.charAt(0);
            int desplazamiento = primerCaracter - 'p';

            // Decodificar el mensaje a partir del segundo carácter
            StringBuilder mensajeDecodificado = new StringBuilder();
            for (int i = 1; i < linea.length(); i++) {
                char c = linea.charAt(i);
                if (Character.isLetter(c)) {
                    char base = Character.isUpperCase(c) ? 'A' : 'a';
                    int nuevaPosicion = (c - base - desplazamiento + 26) % 26 + base;
                    mensajeDecodificado.append((char) nuevaPosicion);
                } else {
                    mensajeDecodificado.append(c); // Caracteres no alfabéticos se mantienen iguales
                }
            }

            // Verificar si el mensaje decodificado es "FIN"
            String resultado = mensajeDecodificado.toString();
            if (resultado.equals("FIN")) {
                break;
            }

            // Contar las vocales no acentuadas
            int contadorVocales = 0;
            for (char c : resultado.toLowerCase().toCharArray()) {
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    contadorVocales++;
                }
            }

            // Imprimir el número de vocales
            System.out.println(contadorVocales);
        }

        sc.close();
    }
}
