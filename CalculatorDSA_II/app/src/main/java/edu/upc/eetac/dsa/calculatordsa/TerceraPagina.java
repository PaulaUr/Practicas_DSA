package edu.upc.eetac.dsa.calculatordsa;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;


public class TerceraPagina extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.historial2);
    }

    public void noBorrar(){
        Intent intent = getIntent();
        setResult(RESULT_CANCELED,intent);
        finish();
    //retorna a SegundaPagina;

    }
    public void siBorrar(){
        Intent intent = new Intent(this, SegundaPagina.class);
        startActivity(intent);
       // setResult(RESULT_OK,intent);
        //finish();
        //retorna a MainActivity
    }
}
