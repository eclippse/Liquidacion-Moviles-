package com.example.liquidacinnomina;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    EditText nombre, dias, pago;
    double nuPorcentaje=0, nuDias=0, nuPago=0, nuBruto=0, nuRetencion=0, nuNeto=0;
    String stNombre="", stDias="", stPago="";
    String stPorcentaje="0%", stBruto="", stRetencion="", stNeto="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre = (EditText)findViewById(R.id.etNombre);
        dias = (EditText)findViewById(R.id.etDias);
        pago = (EditText)findViewById(R.id.etPago);
    }

    public void CalcularNomina(View view){

        stNombre = nombre.getText().toString();
        stDias = dias.getText().toString();
        stPago = pago.getText().toString();

        CalcularValorBruto();
        CalcularRetencion();
        CalcularValorNeto();

        Intent i = new Intent(this, ResActivity.class);
        i.putExtra("stNombre", stNombre);
        i.putExtra("stDias", stDias);
        i.putExtra("stPago", stPago);
        i.putExtra("stBruto", stBruto);
        i.putExtra("stPorcentaje", stPorcentaje);
        i.putExtra("stRetencion", stRetencion);
        i.putExtra("stNeto", stNeto);
        startActivity(i);
    }

    public void CalcularValorBruto(){
        nuDias = Double.parseDouble(stDias);
        nuPago = Double.parseDouble(stPago);

        nuBruto = (nuDias*nuPago);
        stBruto = String.valueOf(nuBruto);
    }

    public void CalcularRetencion(){
        if ((nuBruto>1500001)&&(nuBruto<2500000)){
            nuPorcentaje = 0.1;
            stPorcentaje ="10%";
        }
        if ((nuBruto>=2500001)&&(nuBruto<3500000)){
            nuPorcentaje = 0.2;
            stPorcentaje ="20%";
        }
        if ((nuBruto>=3500001)&&(nuBruto<4500000)){
            nuPorcentaje = 0.3;
            stPorcentaje ="30%";
        }
        if (nuBruto>=4500001){
            nuPorcentaje = 0.35;
            stPorcentaje ="35%";
        }

        nuRetencion = (nuBruto*nuPorcentaje);
        stRetencion = String.valueOf(nuRetencion);
    }

    public void CalcularValorNeto(){
        nuNeto = (nuBruto - nuRetencion);
        stNeto = String.valueOf(nuNeto);
    }



}
