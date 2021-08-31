package com.cj.formulariopersona;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.MessageFormat;
import java.util.ArrayList;

import es.dmoral.toasty.Toasty;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText txtName;
    private EditText txtLastName;
    private EditText txtDocument;
    private Button btnSubmit;
    private ArrayList<Person> persons = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtName = findViewById(R.id.txtName);
        txtLastName = findViewById(R.id.txtLastName);
        txtDocument = findViewById(R.id.txtDocument);
        btnSubmit = findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSubmit:
                addPerson();
                break;
        }
    }

    private void addPerson() {
        String name = txtName.getText().toString();
        String lastName = txtLastName.getText().toString();
        String document = txtDocument.getText().toString();

        Person person = new Person(name, lastName, document);
        persons.add(person);
        cleanFields();
//        Toasty.success(this, "Se ha agregado a " + name + " " + lastName,
//                Toast.LENGTH_SHORT, true).show();
        Toasty.success(this, MessageFormat.format("Se ha agregado a {0} {1}", name, lastName),
                Toast.LENGTH_SHORT, true).show();
    }

    private void cleanFields() {
        txtName.getText().clear();
        txtLastName.getText().clear();
        txtDocument.getText().clear();
    }
}