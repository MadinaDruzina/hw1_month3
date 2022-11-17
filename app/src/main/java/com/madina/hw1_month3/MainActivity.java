package com.madina.hw1_month3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText etMail, etText, etTheme;
    private Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etMail = findViewById(R.id.et_mail);
        etText = findViewById(R.id.et_text);
        etTheme = findViewById(R.id.et_theme);
        btnSend = findViewById(R.id.btn_send);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);

                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{etMail.getText().toString()});   //
                intent.putExtra(Intent.EXTRA_SUBJECT, etTheme.getText().toString());
                intent.putExtra(Intent.EXTRA_TEXT, etText.getText().toString());

                intent.setType("message/rfc882");
                startActivity(Intent.createChooser(intent, "choose as email client"));
            }
        });
    }
}