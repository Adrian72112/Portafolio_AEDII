package UT6_PD1;

import java.util.Arrays;

public class TClasificador implements IClasificador {

    /**
     * Punto de entrada al clasificador
     *
     * @param datosParaClasificar
     * @param metodoClasificacion
     * @param orden
     * @param tamanioVector
     * @return Un vector del tam. solicitado, ordenado por el algoritmo
     * solicitado
     */
    @Override
    public int[] clasificar(int[] datosParaClasificar, int metodoClasificacion, final boolean cascara) {
        if (cascara) {
            return this.ordenarPorInsercionCascara(datosParaClasificar);
        }
        switch (metodoClasificacion) {
            case METODO_CLASIFICACION_INSERCION:
                return ordenarPorInsercion(datosParaClasificar);
            case METODO_CLASIFICACION_SHELL:
                return ordenarPorShell(datosParaClasificar);
            case METODO_CLASIFICACION_BURBUJA:
                return ordenarPorBurbuja(datosParaClasificar);
            case METODO_CLASIFICACION_QUICKSORT:
                return ordenarPorQuickSort(datosParaClasificar);
            case METODO_CLASIFICACION_SELECCION:
                return ordenarPorSeleccion(datosParaClasificar);
            case METODO_CLASIFICACION_RADIX:
                return ordenarPorRadixSort(datosParaClasificar, datosParaClasificar.length);
            case METODO_CLASIFICACION_CUENTA:
                return ordenarPorCuenta(datosParaClasificar);
            case METODO_CLASIFICACION_BINSORT:
                return ordenarPorBucketSort(datosParaClasificar);
            case METODO_CLASIFICACION_HEAPSORT:
                return ordenarPorHeapSort(datosParaClasificar);
            case METODO_CLASIFICACION_SHAKER:
                return ordenarPorShaker(datosParaClasificar);
            case METODO_CLASIFICACION_BINSORT_TRIVIAL:
                return ordenarPorBinsortTrivial(datosParaClasificar);
            default:
                System.out.println("Este codigo no deberia haberse ejecutado");
                break;
        }
        return datosParaClasificar;
    }

    /**
     * @param datosParaClasificar
     * @return
     */
    @Override
    public int[] ordenarPorShell(final int[] datosParaClasificar) {
        final int[] incrementos = {3223, 358, 51, 10, 3, 1};
        for (int posIncrementoActual = 0; posIncrementoActual < incrementos.length; ++posIncrementoActual) {
            final int inc = incrementos[posIncrementoActual];
            if (inc < datosParaClasificar.length / 2) {
                for (int i = inc; i < datosParaClasificar.length; ++i) {
                    for (int j = i - inc; j >= 0 && datosParaClasificar[j] > datosParaClasificar[j + inc]; j -= inc) {
                        this.intercambiar(datosParaClasificar, j, j + inc);
                    }
                }
            }
        }
        return datosParaClasificar;
    }

    /**
     * @param datosParaClasificar
     * @return
     */
    @Override
    public int[] ordenarPorInsercion(int[] datosParaClasificar) {
        if (datosParaClasificar != null) {
            for (int i = 1; i < datosParaClasificar.length; ++i) {
                int j = i - 1;
                while ((j >= 0)
                        && (datosParaClasificar[j + 1] < datosParaClasificar[j])) {
                    this.intercambiar(datosParaClasificar, j, j + 1);
                    --j;
                }
            }
            return datosParaClasificar;
        }
        return null;
    }

    private int[] ordenarPorBurbuja(int[] datosParaClasificar) {
        Boolean swapped;
        for (int n = datosParaClasificar.length - 1, i = 0; i <= n; ++i) {
            swapped = false;
            for (int j = n; j >= (i + 1); --j) {
                if (datosParaClasificar[j] < datosParaClasificar[j - 1]) {
                    intercambiar(datosParaClasificar, j - 1, j);
                    swapped = true;
                }
            }
            if (!swapped) // Si no hubieron intercambios, entonces salir
            {
                break;
            }
        }
        return datosParaClasificar;
    }

    @Override
    public int[] ordenarPorSeleccion(int[] datosParaClasificar) {
        for (int i = 0; i < datosParaClasificar.length - 1; i++) {
            int indiceMenor = i;
            int claveMenor = datosParaClasificar[i];
            for (int j = i + 1; j < datosParaClasificar.length; j++) {
                if (datosParaClasificar[j] < claveMenor) {
                    indiceMenor = j;
                    claveMenor = datosParaClasificar[j];
                }
            }
            intercambiar(datosParaClasificar, i, indiceMenor);
        }
        return datosParaClasificar;
    }

    @Override
    public int[] ordenarPorHeapSort(int[] datosParaClasificar) {
        for (int i = (datosParaClasificar.length - 1) / 2; i >= 0; i--) { //Armo el heap inicial de n-1 div 2 hasta 0
            armaHeap(datosParaClasificar, i, datosParaClasificar.length - 1);
        }
        for (int i = (datosParaClasificar.length - 1); i >= 1; i--) {
            intercambiar(datosParaClasificar, 0, i);
            armaHeap(datosParaClasificar, 0, i - 1);
        }
        return datosParaClasificar;
    }

    private void armaHeap(int[] datosParaClasificar, int primero, int ultimo) {
        if (primero < ultimo) {
            int actual = primero;
            while (actual <= ultimo / 2) {
                if (ultimo == 2 * actual) { //r tiene un hijo solo
                    if (datosParaClasificar[actual] < datosParaClasificar[actual * 2]) { // Cambiar aqui para asc o desc
                        intercambiar(datosParaClasificar, actual, 2 * actual);
                    }
                    actual = ultimo;
                } else { //r tiene 2 hijos
                    int posicionIntercambio = 0;
                    if (datosParaClasificar[2 * actual] > datosParaClasificar[2 * actual + 1]) {
                        posicionIntercambio = 2 * actual;
                    } else {
                        posicionIntercambio = 2 * actual + 1;
                    }
                    if (datosParaClasificar[actual] < datosParaClasificar[posicionIntercambio]) { // Cambiar aqui para ord en asc o desc
                        intercambiar(datosParaClasificar, actual, posicionIntercambio);
                        actual = posicionIntercambio;
                    } else {
                        actual = ultimo;
                    }
                }
            }
        }
    }

    @Override
    public int[] ordenarPorQuickSort(int[] datosParaClasificar) {
        this.quicksort(datosParaClasificar, 0, datosParaClasificar.length - 1);
        return datosParaClasificar;
    }

    protected int encuentraPivote(int izq, int der, int[] ent) {
        return 34;
    }

    private void quicksort(int[] entrada, int i, int j) {
        int izquierda = i;
        int derecha = j;

        int posicionPivote = this.encuentraPivote(izquierda, derecha, entrada);
        if (posicionPivote >= 0) {
            int pivote = posicionPivote;
            while (izquierda <= derecha) {
                while ((entrada[izquierda] < pivote) && (izquierda < j)) {
                    izquierda++;
                }

                while ((pivote < entrada[derecha]) && (derecha > i)) {
                    derecha--;
                }

                if (izquierda <= derecha) {
                    intercambiar(entrada, izquierda, derecha);
                    izquierda++;
                    derecha--;
                }
            }

            if (i < derecha) {
                quicksort(entrada, i, derecha);
            }
            if (izquierda < j) {
                quicksort(entrada, izquierda, j);
            }
        }
    }

    protected int[] maxMin(int[] datos) {
        int[] array = new int[2];
        array[0] = Integer.MIN_VALUE;
        array[1] = Integer.MAX_VALUE;
        for (int n : datos) {
            if (n > array[0]) {
                array[0] = n;
            }
            if (n < array[1]) {
                array[1] = n;
            }
        }
        return array;
    }

    @Override
    public int[] ordenarPorCuenta(int[] datosParaClasificar) {
        int[] maxmin = this.maxMin(datosParaClasificar);
        int max = maxmin[0];

        int[] cuenta = new int[max + 1]; // Digitos del 0 al 99
        int[] salida = new int[datosParaClasificar.length];

        for (int j = 0; j < datosParaClasificar.length; j++) {
            cuenta[datosParaClasificar[j]]++;
        }
        for (int i = 1; i < cuenta.length; i++) {
            cuenta[i] += cuenta[i - 1];
        }
        int i;
        for (int j = datosParaClasificar.length - 1; j >= 0; j--) {
            i = cuenta[datosParaClasificar[j]];
            salida[i - 1] = datosParaClasificar[j];
            cuenta[datosParaClasificar[j]]--;
        }
        return salida;

    }

    private void intercambiar(int[] vector, int pos1, int pos2) {
        int temp = vector[pos2];
        vector[pos2] = vector[pos1];
        vector[pos1] = temp;
    }

    protected int[] ordenarPorInsercionCascara(final int[] datosParaClasificar) {
        if (datosParaClasificar != null) {
            return datosParaClasificar;
        }
        return null;
    }

    protected int getMax(int[] nums) {
        int max_value = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max_value) {
                max_value = nums[i];
            }
        }
        return max_value;
    }

    // A function to do counting sort of arr[] according to 
    // the digit represented by exp. 
    protected void countSort(int arr[], int n, int exp) {
        int output[] = new int[n]; // output array 
        int i;
        int count[] = new int[10];
        Arrays.fill(count, 0);
        // Store count of occurrences in count[] 
        for (i = 0; i < n; i++) {
            count[(arr[i] / exp) % 10]++;
        }
        // Change count[i] so that count[i] now contains 
        // actual position of this digit in output[] 
        for (i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }
        // Build the output array 
        for (i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }
        // Copy the output array to arr[], so that arr[] now 
        // contains sorted numbers according to current digit 
        for (i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }

    // The main function to that sorts arr[] of size n using 
    // Radix Sort 
    public int[] ordenarPorRadixSort(int[] datosParaClasificar, int n) {
        // Find the maximum number to know number of digits 
        int m = getMax(datosParaClasificar);

        // Do counting sort for every digit. Note that instead 
        // of passing digit number, exp is passed. exp is 10^i 
        // where i is current digit number 
        for (int exp = 1; m / exp > 0; exp *= 10) {
            countSort(datosParaClasificar, n, exp);
        }

        return datosParaClasificar;
    }

    public int[] ordenarPorBucketSort(int[] nums) {
        // Bucket Sort
        int max_value = getMax(nums);
        int[] Bucket = new int[max_value + 1];
        int[] sorted_nums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            Bucket[nums[i]]++;
        }
        int outPos = 0;
        for (int i = 0; i < Bucket.length; i++) {
            for (int j = 0; j < Bucket[i]; j++) {
                sorted_nums[outPos++] = i;
            }
        }
        return sorted_nums;
    }

    public int[] ordenarPorShaker(int[] datosParaClasificar) {
        int Izq = 0;
        int Der = datosParaClasificar.length - 1;

        boolean intercambio;
        do {
            // Derecha a izquierda
            intercambio = false;
            for (int j = Der; j >= (Izq + 1); j--) {
                if (datosParaClasificar[j] < datosParaClasificar[j - 1]) {
                    intercambiar(datosParaClasificar, j - 1, j);
                    intercambio = true;
                }
            }
            Izq++;
            if (!intercambio) {
                break;
            }

            // Izquierda a derecha
            intercambio = false;
            for (int j = Izq; j <= Der - 1; j++) {
                if (datosParaClasificar[j] > datosParaClasificar[j + 1]) {
                    intercambiar(datosParaClasificar, j + 1, j);
                    intercambio = true;
                }
            }
            Der--;
        } while (intercambio);
        return datosParaClasificar;
    }

    public int[] ordenarPorBinsortTrivial(int[] datosParaClasificar) {
        for (int i = 0; i < datosParaClasificar.length; i++) {
            while (datosParaClasificar[i] != i) {
                intercambiar(datosParaClasificar, i, datosParaClasificar[i]);
            }
        }
        return datosParaClasificar;
    }
}
