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
        int capMin = 1;
        int capDiaMin = 1;
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {}

        boolean error = false;
        int dias = 0;

        if (solicitud.capitulos < capMin){
            callback.cuandoHayaErrorCapitulos(capMin);
            error = true;
        }
        if (solicitud.capDias < capDiaMin){
            callback.cuandoHayaErrorCapDias(capDiaMin);
            error = true;
        }

        if (!error){
            if (solicitud.capitulos>7){
                dias = solicitud.capitulos / solicitud.capDias + ((solicitud.capitulos / solicitud.capDias) / 7);
            }
            else{
                dias = solicitud.capitulos / solicitud.capDias;
            }
            callback.cuandoEsteCalculado(dias);
        }
    }
}



