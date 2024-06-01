package com.example.android_final_app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
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
    private static final String TAG = "LoginActivity"; // 디버깅을 위한 태그 추가
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
        if (v == btnLogin) {
            String id = editTextId.getText().toString();
            String password = editTextPassword.getText().toString();
            Log.d(TAG, "ID: " + id + ", Password: " + password);

            if (isValidLogin(id, password)) {
                Log.d(TAG, "로그인 성공");

                SharedPreferences preferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putBoolean("isLoggedIn", true);
                editor.putString("userName", id); // 예시로 ID를 사용자 이름으로 저장
                editor.apply();

                Log.d(TAG, "로그인 상태 저장 완료");

                Toast.makeText(LoginActivity.this, "로그인 성공", Toast.LENGTH_SHORT).show();

                Intent mainIntent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(mainIntent);
                finish();
            } else {
                Log.d(TAG, "로그인 실패");
                Toast.makeText(LoginActivity.this, "로그인 실패", Toast.LENGTH_SHORT).show();
            }
        } else if (v == btnGoJoin) {
            Intent joinIntent = new Intent(LoginActivity.this, JoinActivity.class);
            startActivity(joinIntent);
        }
    }

    private boolean isValidLogin(String id, String password) {
        Cursor cursor = dbHelper.getMember(id, password);
        if (cursor != null) {
            Log.d(TAG, "Cursor count: " + cursor.getCount());
        } else {
            Log.d(TAG, "Cursor is null");
        }
        return cursor != null && cursor.getCount() > 0;
    }
}
