package com.example.model_viewpract;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class MenuviewModel extends AndroidViewModel{

    Executor executor;

    Simulador simulador;

    MutableLiveData<Integer> dias = new MutableLiveData<>();
    MutableLiveData<Integer>errorcapitulos = new MutableLiveData<>();
    MutableLiveData<Integer>errorcapDias = new MutableLiveData<>();

    public MenuviewModel(@NonNull Application application) {
        super(application);

        executor = Executors.newSingleThreadExecutor();
        simulador = new Simulador();
    }

    public void calcular(final int capitulos, int capDia){
        final Simulador.Solicitud solicitud = new Simulador.Solicitud(capitulos,capDia);

        executor.execute(new Runnable() {
            @Override
            public void run() {
                simulador.calcular(solicitud, new Simulador.Callback() {
                    @Override
                    public void cuandoEsteCalculado(int diasResult) {
                        errorcapitulos.postValue(null);
                        errorcapDias.postValue(null);
                        dias.postValue(diasResult);
                    }

                    @Override
                    public void cuandoHayaErrorCapitulos(int capitulosMin) {
                        errorcapitulos.postValue(capitulosMin);
                    }

                    @Override
                    public void cuandoHayaErrorCapDias(int capDiasMin) {
                        errorcapDias.postValue(capDiasMin);
                    }
                });

            }
        });

    }

}
