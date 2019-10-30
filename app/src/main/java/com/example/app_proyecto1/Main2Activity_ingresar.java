package com.example.app_proyecto1;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity_ingresar extends AppCompatActivity
{
    //Iniciar sesión.
    //Objetos
    EditText etUsuario, etClave;
    Button   btnInicio;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2_ingresar);

        //Referencio objetos
        etUsuario = findViewById(R.id.etUsuario);
        etClave   = findViewById(R.id.etClave);
        btnInicio = findViewById(R.id.btnInicio);

        //Flecha atras
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null)
        {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle("Regresar");
        }
    }

    //Botón inicio para pasar de actividad.
    public void inicio(View view)
    {
        String usuario = etUsuario.getText().toString();
        String clave   = etClave.getText().toString();

        //Validaciones para campos de entrada
        if (usuario.isEmpty())
        {
            Toast.makeText(this,"Ingresa usuario", Toast.LENGTH_LONG).show();
        }
        else if (clave.isEmpty())
        {
            Toast.makeText(this,"Ingresa contraseña", Toast.LENGTH_LONG).show();
        }
        else if (usuario.equals("admin") && clave.equals("admin"))
        {
            Toast.makeText(this,"Bienvenido administrador", Toast.LENGTH_SHORT).show();
            // Pasar de actividad
            Intent lo_intent = new Intent(Main2Activity_ingresar.this, Main4Activity_registros.class);
            startActivity(lo_intent);
        }
        else
        {
            Toast.makeText(this, "No tienes autorización para entrar", Toast.LENGTH_LONG).show();
        }
    }

    //Botón regresar.
    public void regresar(View view)
    {
        Intent lo_intent = new Intent(Main2Activity_ingresar.this, MainActivity.class);
        startActivity(lo_intent);
    }
}
