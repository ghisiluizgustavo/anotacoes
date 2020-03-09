package com.o.minhasanotacoes;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private AnotacaoPreferencias preferencias;
    private EditText edtAnotacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtAnotacao = findViewById(R.id.edtAnotacao);

        preferencias = new AnotacaoPreferencias( getApplicationContext() );

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String anotacao = edtAnotacao.getText().toString();

                if ( anotacao.equals("") ){

                    Toast.makeText(getApplicationContext(), "Você não digitou nada", Toast.LENGTH_SHORT).show();

                } else {

                    preferencias.salvar( anotacao );
                    Toast.makeText(getApplicationContext(), "Anotação Salva", Toast.LENGTH_SHORT).show();

                }

            }
        });

        String anotacao = preferencias.recuperar();
        if ( !anotacao.equals("") ){
            edtAnotacao.setText( anotacao );
        }
    }

}
