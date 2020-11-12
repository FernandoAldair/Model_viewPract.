package com.example.model_viewpract;

public class Simulador {

    public static class Solicitud {
        public int capitulos;
        public int capDias;

        public Solicitud(int capitulos, int capDias) {
            this.capitulos = capitulos;
            this.capDias = capDias;
        }
    }

    interface Callback {
        void cuandoEsteCalculado(int dias);
        void cuandoHayaErrorCapitulos (int capitulosMin);
        void cuandoHayaErrorCapDias (int capDiasMin);
    }

    public void calcular(Solicitud solicitud, Callback callback) {
        int capMin = 0;
        int capDiaMin = 0;
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {}

        int dias;
        if (solicitud.capitulos>7){
            dias = solicitud.capitulos / solicitud.capDias + ((solicitud.capitulos / solicitud.capDias) / 7);
        }
        else{
            dias = solicitud.capitulos / solicitud.capDias;
        }

        callback.cuandoEsteCalculado(dias);

    }
}



