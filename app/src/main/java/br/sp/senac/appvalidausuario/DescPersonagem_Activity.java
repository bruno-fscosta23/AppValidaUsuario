package br.sp.senac.appvalidausuario;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class DescPersonagem_Activity extends AppCompatActivity {

    TextView lstPersona;
    ImageView lstImagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.desc_personagem_layout);

        lstPersona = (TextView) findViewById(R.id.lstDPersona);
        lstImagem = (ImageView) findViewById(R.id.imgPersona);

        Intent intent = getIntent();

        String nomeRetorno = intent.getStringExtra("name");
        int imagemRetorno = intent.getIntExtra("image",0);

        lstPersona.setText(nomeRetorno);
        lstImagem.setImageResource(imagemRetorno);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
