package com.smartpms.ui.home;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.google.gson.Gson;
import com.smartpms.databinding.FragmentHomeBinding;
import com.smartpms.retrofit.Results;
import com.smartpms.retrofit.RetrofitClient;
import com.smartpms.retrofit.resultdto.PatientDTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.textView2.setText("init");
        getPatient(getContext());
        final TextView textView = binding.textHome;
        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void getUserid(Context context) {
        Call<Integer> call = RetrofitClient.getInstance().getMyApi().getUserid();
        call.enqueue(new Callback<Integer>() {
            @Override
            public void onResponse(Call<Integer> call, Response<Integer> response) {
                Log.i("bindu", String.valueOf(response.body()));
                binding.textView2.setText(String.valueOf(response.body()));
            }

            @Override
            public void onFailure(Call<Integer> call, Throwable t) {
                Log.e("bindu", String.valueOf(t.getMessage()));
                Toast.makeText(context, "An error has occured", Toast.LENGTH_LONG).show();
            }

        });
    }


    private void getPatient(Context context) {
        Call<PatientDTO> call = RetrofitClient.getInstance().getMyApi().getPatient();
        call.enqueue(new Callback<PatientDTO>() {
            @Override
            public void onResponse(Call<PatientDTO> call, Response<PatientDTO> response) {
                Log.i("bindu", String.valueOf(response.body()));

                Gson g = new Gson();
                PatientDTO p = g.fromJson(String.valueOf(response.body()), PatientDTO.class);
                binding.textView2.setText(String.valueOf(p.getBpm()));
            }

            @Override
            public void onFailure(Call<PatientDTO> call, Throwable t) {
                Log.e("bindu", String.valueOf(t.getMessage()));
                Toast.makeText(context, "An error has occured", Toast.LENGTH_LONG).show();
            }

        });
    }
}