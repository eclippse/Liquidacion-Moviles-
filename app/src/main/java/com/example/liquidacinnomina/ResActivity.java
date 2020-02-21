package com.example.liquidacinnomina;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResActivity extends AppCompatActivity {

    TextView nombre, dias, pago, bruto, porcentaje, retencion, neto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resultado);



        RecibirDastos();
    }

    public void Volver(View view){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    public void RecibirDastos(){
        Bundle extras = getIntent().getExtras();
        String datoNombre = extras.getString("stNombre");
        String datoDias = extras.getString("stDias");
        String datoPago = extras.getString("stPago");
        String datoBruto = extras.getString("stBruto");
        String datoPorcentaje = extras.getString("stPorcentaje");
        String datoRetencion = extras.getString("stRetencion");
        String datoNeto = extras.getString("stNeto");

        nombre = (TextView)findViewById(R.id.tvNombre);
        dias = (TextView)findViewById(R.id.tvDias);
        pago = (TextView)findViewById(R.id.tvPago);
        bruto = (TextView)findViewById(R.id.tvBruto);
        porcentaje = (TextView)findViewById(R.id.tvPorcentaje);
        retencion = (TextView)findViewById((R.id.tvRetencion));
        neto = (TextView)findViewById(R.id.tvNeto);

        nombre.setText(datoNombre);
        dias.setText(datoDias);
        pago.setText(datoPago);
        bruto.setText(datoBruto);
        porcentaje.setText(datoPorcentaje);
        retencion.setText(datoRetencion);
        neto.setText(datoNeto);
    }
}
