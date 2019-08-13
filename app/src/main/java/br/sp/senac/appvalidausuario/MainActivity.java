package br.sp.senac.appvalidausuario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txtUsuario, txtSenha;
    Button btnEntrar, btnSair;

    public static final String EXTRA_MESSAGE = "br.sp.senac.appvalidausuario.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtUsuario = (EditText) findViewById(R.id.txtUsuario);
        txtSenha = (EditText) findViewById(R.id.txtSenha);
        btnEntrar = (Button) findViewById(R.id.btnEntrar);
        btnSair = (Button) findViewById(R.id.btnSair);
        txtUsuario.requestFocus();
        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String usuario, senha;
                usuario = txtUsuario.getText().toString();
                senha = txtSenha.getText().toString();

                if (usuario.equals("senac") && (senha.equals("senac"))) {
                    //startActivity(new Intent(getApplicationContext(),RespondeUsuario_Activity.class));
                    Intent intent = new Intent(getApplicationContext(), RespondeUsuario_Activity.class);

                    String message = txtUsuario.getText().toString();
                    intent.putExtra(EXTRA_MESSAGE,message);

                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(), "Usuário ou Senha incorretos!", Toast.LENGTH_SHORT).show();
                    txtUsuario.setText("");
                    txtSenha.setText("");
                    txtUsuario.requestFocus();
                }

            }
        });

        btnSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
