package com.example.myapplication.ui.Setting;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentSettingBinding;


public class SettingFragment extends Fragment {

    private FragmentSettingBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_setting,container,false);
        return v;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;

    }

}