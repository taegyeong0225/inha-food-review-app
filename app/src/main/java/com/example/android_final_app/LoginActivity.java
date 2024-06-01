package com.example.android_final_app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.android_final_app.DB.memberDBHelper;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnLogin;
    private Button btnGoJoin;
    private Toast objToast;
    private EditText editTextId;
    private EditText editTextPassword;
    private memberDBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        dbHelper = new memberDBHelper(this);

        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(this);

        btnGoJoin = findViewById(R.id.btnGoJoin);
        btnGoJoin.setOnClickListener(this);

        editTextId = findViewById(R.id.editTextId);
        editTextPassword = findViewById(R.id.editTextPassword);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public void onClick(View v) {
        // 로그인 버튼을 눌렀을 때
        if (v == btnLogin) {
            String id = editTextId.getText().toString();
            String password = editTextPassword.getText().toString();

            if (isValidLogin(id, password)) {
                // 로그인 성공 시 SharedPreferences에 상태와 사용자 이름 저장
                SharedPreferences preferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putBoolean("isLoggedIn", true);
                editor.putString("userName", id); // 예시로 ID를 사용자 이름으로 저장
                editor.apply();

                Toast.makeText(LoginActivity.this, "로그인 성공", Toast.LENGTH_SHORT).show();

                // MainActivity로 이동하여 적절한 프래그먼트 표시
                Intent mainIntent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(mainIntent);
                finish();
            } else {
                Toast.makeText(LoginActivity.this, "로그인 실패", Toast.LENGTH_SHORT).show();
            }
            // 회원가입으로 이동 버튼을 누른 경우
        } else if (v == btnGoJoin) {
            Intent joinIntent = new Intent(LoginActivity.this, JoinActivity.class);
            startActivity(joinIntent);
        }
    }

    // 데이터베이스를 통해 로그인 유효성 검사
    private boolean isValidLogin(String id, String password) {
        Cursor cursor = dbHelper.getMember(id, password);
        return cursor != null && cursor.getCount() > 0;
    }
}
