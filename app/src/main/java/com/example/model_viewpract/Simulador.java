package com.example.model_viewpract;

public class Simulador {
    public static class Solicitud {
        public  int capitulos;
        public int capDias;

        public Solicitud(int capitulos, int capDias){
            this.capitulos = capitulos;
            this.capDias = capDias;
        }
    }

    public int cacular(Solicitud solicitud){
        int semana = 7;
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {}

        return solicitud.capitulos / solicitud.capDias+((solicitud.capitulos / solicitud.capDias)/7);
    }
}
