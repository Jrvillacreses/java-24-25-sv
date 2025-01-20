import pojo.Lavadora;

public class Main {
    public static void main(String[] args) {
        // Crear lavadoras
        Lavadora lavadora1 = new Lavadora(10, "Rápido");
        Lavadora lavadora2 = new Lavadora(8, "Ecológico");
        Lavadora lavadora3 = new Lavadora(10, "Rápido");

        // Abrir puertas de las tres lavadoras
        lavadora1.abrirPuerta();
        lavadora2.abrirPuerta();
        lavadora3.abrirPuerta();

        // Cargar lavadoras
        lavadora1.cargar(8); // Menos que la capacidad
        lavadora3.cargar(12); // Más que la capacidad

        // Cerrar puertas
        lavadora1.cerrarPuerta();
        lavadora2.cerrarPuerta();
        lavadora3.cerrarPuerta();

        // Programar lavadora 1 y 2
        lavadora1.programarLavado("Rápido");
        lavadora2.programarLavado("Ecológico");

        // Iniciar lavado de la lavadora 1 y 3
        lavadora1.iniciarLavado();
        lavadora3.iniciarLavado();

        // Intentar abrir la puerta de la lavadora 1 mientras está funcionando
        lavadora1.abrirPuerta();
    }
}
