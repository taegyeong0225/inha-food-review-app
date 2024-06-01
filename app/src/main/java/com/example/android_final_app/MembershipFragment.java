package com.example.android_final_app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MembershipFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MembershipFragment extends Fragment {

    public MembershipFragment() {
        // Required empty public constructor
    }

    public static MembershipFragment newInstance() {
        return new MembershipFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_membership, container, false);

        // 회원 이름과 로그아웃 버튼 설정
        TextView textViewUserName = view.findViewById(R.id.textViewUserName);
        Button btnLogout = view.findViewById(R.id.btnLogout);

        // SharedPreferences에서 사용자 이름 가져오기
        SharedPreferences preferences = getActivity().getSharedPreferences("MyPrefs", getActivity().MODE_PRIVATE);
        String userName = preferences.getString("userName", "User");
        textViewUserName.setText("반갑습니다! " + userName + "회원님");

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 로그아웃 처리
                SharedPreferences.Editor editor = preferences.edit();
                editor.putBoolean("isLoggedIn", false);
                editor.apply();

                // LoginActivity 호출
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });

        return view;
    }
}