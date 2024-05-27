package com.example.android_final_app;

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

import com.example.android_final_app.DB.memberDB;
import com.example.android_final_app.DB.memberDBHelper;

public class JoinActivity extends AppCompatActivity {

    private EditText editName, editEmail, editID, editPW, editCheckPW;
    private Button joinButton;
    private memberDBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_join);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        dbHelper = new memberDBHelper(this);

        editName = findViewById(R.id.editName);
        editEmail = findViewById(R.id.editEmail);
        editID = findViewById(R.id.editID);
        editPW = findViewById(R.id.editPW);
        editCheckPW = findViewById(R.id.editCheckPW);
        joinButton = findViewById(R.id.btnJoin);

        joinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editName.getText().toString();
                String email = editEmail.getText().toString();
                String id = editID.getText().toString();
                String password = editPW.getText().toString();

                long newRowId = dbHelper.addMember(name, email, id, password);

                if (newRowId != -1) {
                    Toast.makeText(JoinActivity.this, "가입이 완료되었습니다!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(JoinActivity.this, "가입을 실패하였습니다.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
