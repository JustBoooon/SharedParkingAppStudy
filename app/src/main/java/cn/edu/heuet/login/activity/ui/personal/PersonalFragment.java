package cn.edu.heuet.login.activity.ui.personal;

import static android.content.Context.MODE_PRIVATE;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import cn.edu.heuet.login.R;
import cn.edu.heuet.login.activity.LoginActivity;
import cn.edu.heuet.login.activity.MainActivityPast;
import cn.edu.heuet.login.activity.NavigationActivity;
import cn.edu.heuet.login.constant.ModelConstant;
import cn.edu.heuet.login.databinding.FragmentPersonalBinding;

public class PersonalFragment extends Fragment {

    private FragmentPersonalBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        PersonalViewModel personalViewModel = new ViewModelProvider(this).get(PersonalViewModel.class);

        binding = FragmentPersonalBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

//        final Button button = binding.btLogout;

        // 退出登录
        binding.btLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /* 清空 SharedPreferences 中的登录信息
                这里getSharedPreferences()无法直接被fragment调用，需要由Activity来调用*/
                SharedPreferences sp = getActivity().getSharedPreferences(ModelConstant.LOGIN_INFO, MODE_PRIVATE);
                sp.edit().clear().apply();
                /* 跳转到登录页
                intent第一个参数要改成getActivity()来获取跳转起点(就是fragment被哪个activity所调用)*/
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
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