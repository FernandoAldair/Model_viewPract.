package com.example.model_viewpract;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.model_viewpract.databinding.FragmentMenuBinding;

public class MenuFragment extends Fragment {
    private FragmentMenuBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentMenuBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final MenuviewModel menuviewModel = new ViewModelProvider(this).get(MenuviewModel.class);

        binding.calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int capitulos = Integer.parseInt(binding.capitulos.getText().toString());
                int capDia = Integer.parseInt(binding.capdia.getText().toString());

                menuviewModel.calcular(capitulos, capDia);
            }
        });

        menuviewModel.dias.observe(getViewLifecycleOwner(), new Observer<Integer>() {
            @Override
            public void onChanged(Integer dias) {
                binding.dias.setText(""+dias);
            }
        });

        menuviewModel.errorcapitulos.observe(getViewLifecycleOwner(), new Observer<Integer>() {
            @Override
            public void onChanged(Integer capitulos) {
                if (capitulos != null){
                    binding.capitulos.setError("Los capitulos no pueden ser inferior a uno");
                }
                else {
                    binding.capitulos.setError(null);
                }
            }
        });

        menuviewModel.errorcapDias.observe(getViewLifecycleOwner(), new Observer<Integer>() {
            @Override
            public void onChanged(Integer capDiasMin) {
                if (capDiasMin != null){
                    binding.capdia.setError("Los capitulos diarios no pueden ser inferior a uno");
                }
                else {
                    binding.capdia.setError(null);
                }
            }
        });


    }
}