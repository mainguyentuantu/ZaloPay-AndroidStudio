package com.example.demozalopay;

import android.content.Intent;
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

public class MainActivity extends AppCompatActivity {

    Button btnConfirm;
    EditText edtSoluong;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnConfirm = findViewById(R.id.buttonConfirm);
        edtSoluong = findViewById(R.id.editTextSoluong);

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtSoluong.getText() == null || edtSoluong.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "NHAP SO LUONG MUON MUA", Toast.LENGTH_SHORT).show();
                    return;
                }
                String soLuongString = edtSoluong.getText().toString();
                double total = Double.parseDouble(soLuongString) * (double)1000000;

                Intent intent = new Intent(MainActivity.this, OrderPayment.class);
                intent.putExtra("soluong", edtSoluong.getText().toString());
                intent.putExtra("total", total);
                startActivity(intent);

            }
        });
    }
}