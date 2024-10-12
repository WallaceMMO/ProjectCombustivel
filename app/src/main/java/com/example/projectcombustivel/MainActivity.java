/*
 *@author:<Wallace Moura Machado de Oliveira;1110482413004>
 */
package com.example.projectcombustivel;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText txtGasolina;
    private EditText txtEtanol;
    private Button btnCalcular;
    private TextView lblResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtGasolina = findViewById(R.id.txtGasolina);
        txtEtanol = findViewById(R.id.txtEtanol);
        btnCalcular = findViewById(R.id.btnCalcular);
        lblResultado = findViewById(R.id.lblResultado);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularMelhorCombustivel();
            }
        });
    }

    private void calcularMelhorCombustivel() {
        String precoGasolinaStr = txtGasolina.getText().toString();
        String precoEtanolStr = txtEtanol.getText().toString();

        if (precoGasolinaStr.isEmpty() || precoEtanolStr.isEmpty()) {
            lblResultado.setText("Por favor, insira ambos os valores.");
            return;
        }

        try {
            double precoGasolina = Double.parseDouble(precoGasolinaStr);
            double precoEtanol = Double.parseDouble(precoEtanolStr);

            if (precoGasolina <= 0 || precoEtanol <= 0) {
                lblResultado.setText("Os preços devem ser maiores que zero.");
                return;
            }

            double porcentagem = (precoEtanol / precoGasolina) * 100;

            if (porcentagem <= 70) {
                lblResultado.setText("Compensa abastecer com Etanol.");
            } else {
                lblResultado.setText("Compensa abastecer com Gasolina.");
            }
        } catch (NumberFormatException e) {
            lblResultado.setText("Valores inválidos.");
        }
    }
}