package com.cj.formulariopersona;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import es.dmoral.toasty.Toasty;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText txtNombre;
    private EditText txtApellido;
    private EditText txtCedula;
    private Button btnIngresar;
    private ArrayList<Persona> personas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNombre = findViewById(R.id.txtNombre);
        txtApellido = findViewById(R.id.txtApellido);
        txtCedula = findViewById(R.id.txtCedula);
        btnIngresar = findViewById(R.id.btnIngresar);
        btnIngresar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnIngresar:
                agregarPersona();
                break;
        }
    }

    private void agregarPersona() {
        String nombre = txtNombre.getText().toString();
        String apellido = txtApellido.getText().toString();
        String cedula = txtCedula.getText().toString();

        Persona persona = new Persona(nombre, apellido, cedula);
        personas.add(persona);
        limpiarCampos();
        Toasty.success(this, "Se ha agregado a " + nombre + " " + apellido,
                Toast.LENGTH_SHORT, true).show();
    }

    private void limpiarCampos() {
        txtNombre.getText().clear();
        txtApellido.getText().clear();
        txtCedula.getText().clear();
    }
}