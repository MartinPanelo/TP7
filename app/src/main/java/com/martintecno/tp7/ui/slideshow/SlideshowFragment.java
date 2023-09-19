package com.martintecno.tp7.ui.slideshow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.martintecno.tp7.Carteles;
import com.martintecno.tp7.databinding.FragmentSlideshowBinding;

public class SlideshowFragment extends Fragment {

    private FragmentSlideshowBinding binding;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SlideshowViewModel slideshowViewModel =
                new ViewModelProvider(this).get(SlideshowViewModel.class);

        binding = FragmentSlideshowBinding.inflate(inflater, container, false);
        View root = binding.getRoot();




        binding.BTNSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Carteles.CartelSalir( aca va la activity );
                // Carteles.CartelSalir( getActivity());// esto cierra la activity actual
                //  System.exit(0);esto cierra la activity actual
                Carteles.CartelSalir( getActivity());
            }
        });



        return root;



    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}