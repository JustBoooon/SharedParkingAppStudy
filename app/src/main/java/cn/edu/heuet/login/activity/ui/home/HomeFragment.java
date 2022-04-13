package cn.edu.heuet.login.activity.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import cn.edu.heuet.login.R;
import cn.edu.heuet.login.activity.LoginActivity;
import cn.edu.heuet.login.activity.ui.dynamic.DynamicFragment;
import cn.edu.heuet.login.activity.ui.home.HomeViewModel;
import cn.edu.heuet.login.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment implements View.OnClickListener {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        //创建view model对象
        HomeViewModel homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);

//        final TextView textView = binding.textHome;
//        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        binding.buttonFind.setOnClickListener(this);
        binding.buttonShare.setOnClickListener(this);

        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onClick(View v) {
        NavController navController = Navigation.findNavController(v);
        switch (v.getId()) {
            case R.id.button_find:
                navController.navigate(R.id.navigation_find);
                break;
            case R.id.button_share:
                navController.navigate(R.id.navigation_share);
                break;
        }
    }
}