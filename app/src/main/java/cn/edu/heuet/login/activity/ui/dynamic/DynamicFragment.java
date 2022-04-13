package cn.edu.heuet.login.activity.ui.dynamic;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import cn.edu.heuet.login.databinding.FragmentDynamicBinding;

public class DynamicFragment extends Fragment {

    private FragmentDynamicBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DynamicViewModel dynamicViewModel =
                new ViewModelProvider(this).get(DynamicViewModel.class);

        binding = FragmentDynamicBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textDynamic;
        dynamicViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}