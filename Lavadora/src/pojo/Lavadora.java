package pojo;

public class Lavadora {
    private int capacidad;
    private String planDeLavado;
    private boolean puertaAbierta;
    private boolean enFuncionamiento;
    private int cargaActual;
    private String nombre;

    public Lavadora(String nombre, int capacidad, String planDeLavado) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.planDeLavado = planDeLavado;
        this.puertaAbierta = true; // Por defecto la puerta comienza abierta
        this.enFuncionamiento = false;
        this.cargaActual = 0;
    }

    public void abrirPuerta() {
        if (enFuncionamiento) {
            System.out.println(nombre + ": No se puede abrir la puerta mientras la lavadora está funcionando.");
        } else {
            puertaAbierta = true;
            System.out.println(nombre + ": Puerta abierta.");
        }
    }

    public void cerrarPuerta() {
        puertaAbierta = false;
        System.out.println(nombre + ": Puerta cerrada.");
    }

    public void cargar(int peso) {
        if (puertaAbierta) {
            cargaActual = peso;
            System.out.println(nombre + ": Lavadora cargada con " + peso + " kgs.");
        } else {
            System.out.println(nombre + ": No se puede cargar la lavadora con la puerta cerrada.");
        }
    }

    public void programarLavado(String plan) {
        if (!puertaAbierta) {
            this.planDeLavado = plan;
            System.out.println(nombre + ": Lavadora programada con el plan: " + plan);
        } else {
            System.out.println(nombre + ": Cierre la puerta antes de programar el lavado.");
        }
    }

    public void iniciarLavado() {
        if (puertaAbierta) {
            System.out.println(nombre + ": Cierre la puerta para iniciar el lavado.");
        } else if (cargaActual > capacidad) {
            System.out.println(nombre + ": La carga excede la capacidad de la lavadora. Reduzca la carga para iniciar.");
        } else {
            enFuncionamiento = true;
            System.out.println(nombre + ": Iniciando lavado con el plan " + planDeLavado + ". Por favor espere...");
            simularLavado();
        }
    }

    private void simularLavado() {
        System.out.println(nombre + ": Lavando...");
        abrirPuerta();
        for (int i = 1; i <= 5; i++) {
            try {
                Thread.sleep(1000); // Simula 1 segundo de lavado
                System.out.println(nombre + ": Lavado en progreso: " + i + " segundos.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        enFuncionamiento = false;
        System.out.println(nombre + ": Lavado terminado. Puede abrir la puerta ahora.");
    }

    public boolean isEnFuncionamiento() {
        return enFuncionamiento;
    }
}
