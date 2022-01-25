package com.han.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etOrigin;
    Button btnDecrypt;
    Button btnEncode;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etOrigin = findViewById(R.id.et_origin_content);
        btnDecrypt = findViewById(R.id.btn_decrypt);
        btnEncode = findViewById(R.id.btn_encode);
        tvResult = findViewById(R.id.tv_result);

        btnDecrypt.setOnClickListener(v -> {
            String inputContent = etOrigin.getText().toString();
            String result = new AES().decrypt(inputContent);
            tvResult.setText(result);
        });

        btnEncode.setOnClickListener(v -> {
            String inputContent = etOrigin.getText().toString();
            String result = new AES().encrypt(inputContent.getBytes());
            tvResult.setText(result);
        });

        findViewById(R.id.btn_clear).setOnClickListener(v ->{
            etOrigin.setText("");
            tvResult.setText("");
        });

        tvResult.setOnClickListener(v -> {
            ClipboardManager cm = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
            cm.setText(tvResult.getText().toString());
        });
    }
}