package pojo;

public class Lavadora {
    private int capacidad;
    private String planDeLavado;
    private boolean puertaAbierta;
    private boolean enFuncionamiento;
    private int cargaActual;

    public Lavadora(int capacidad, String planDeLavado) {
        this.capacidad = capacidad;
        this.planDeLavado = planDeLavado;
        this.puertaAbierta = true; // Por defecto la puerta comienza abierta
        this.enFuncionamiento = false;
        this.cargaActual = 0;
    }

    public void abrirPuerta() {
        if (enFuncionamiento) {
            System.out.println("No se puede abrir la puerta mientras la lavadora está funcionando.");
        } else {
            puertaAbierta = true;
            System.out.println("Puerta abierta.");
        }
    }

    public void cerrarPuerta() {
        puertaAbierta = false;
        System.out.println("Puerta cerrada.");
    }

    public void cargar(int peso) {
        if (puertaAbierta) {
            cargaActual = peso;
            System.out.println("Lavadora cargada con " + peso + " kgs.");
        } else {
            System.out.println("No se puede cargar la lavadora con la puerta cerrada.");
        }
    }

    public void programarLavado(String plan) {
        if (!puertaAbierta) {
            this.planDeLavado = plan;
            System.out.println("Lavadora programada con el plan: " + plan);
        } else {
            System.out.println("Cierre la puerta antes de programar el lavado.");
        }
    }

    public void iniciarLavado() {
        if (puertaAbierta) {
            System.out.println("Cierre la puerta para iniciar el lavado.");
        } else if (cargaActual > capacidad) {
            System.out.println("La carga excede la capacidad de la lavadora. Reduzca la carga para iniciar.");
        } else {
            enFuncionamiento = true;
            System.out.println("Iniciando lavado con el plan " + planDeLavado + ". Por favor espere...");

            // Simular duración del lavado con un hilo
            new Thread(() -> {
                try {
                    Thread.sleep(5000); // Simula 5 segundos de lavado
                    enFuncionamiento = false;
                    System.out.println("Lavado terminado. Puede abrir la puerta ahora.");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}