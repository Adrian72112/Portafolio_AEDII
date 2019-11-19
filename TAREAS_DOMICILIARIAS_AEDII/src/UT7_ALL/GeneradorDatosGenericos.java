package UT7_ALL;

import java.util.Random;

public class GeneradorDatosGenericos implements IGeneradorDatos {

    private static int TAMANIO_MAX = 5000;

    public Integer[] generarDatosAleatorios() {
        Random rnd = new Random();
        Integer[] datosGenerados = new Integer[TAMANIO_MAX];
        boolean[] datosUtilizados = new boolean[TAMANIO_MAX];
        for (int i = 0; i < datosGenerados.length; i++) {
            int j = rnd.nextInt(TAMANIO_MAX);
            while (datosUtilizados[j]) {
                j = (j + 1) % TAMANIO_MAX;
            }
            datosGenerados[j] = i;
            datosUtilizados[j] = true;
        }
        return datosGenerados;
    }

    public Integer[] generarDatosAscendentes() {
        Integer[] copiaAscendente = new Integer[TAMANIO_MAX];
        for (int i = 0; i < TAMANIO_MAX; i++) {
            copiaAscendente[i] = i;
        }
        return copiaAscendente;
    }

    public Integer[] generarDatosDescendentes() {
        Integer[] copiaDescendente = new Integer[TAMANIO_MAX];
        for (int i = 0; i < TAMANIO_MAX; i++) {
            copiaDescendente[i] = TAMANIO_MAX - i;
        }
        return copiaDescendente;
    }

}
