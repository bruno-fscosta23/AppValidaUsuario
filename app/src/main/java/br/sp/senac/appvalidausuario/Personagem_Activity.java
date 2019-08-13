package br.sp.senac.appvalidausuario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class Personagem_Activity extends AppCompatActivity {

    ListView listView;

    String[] nomePersonagem = {"Homer","Maggie", "Margi", "Lisa","Bart","Apu","Nelson","Vovô"};
    int[] imagemPersonagem = {R.drawable.homer,R.drawable.maggie,R.drawable.margi,R.drawable.lisa,R.drawable.bart,R.drawable.apu,R.drawable.nelson,R.drawable.vovo};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personagem_layout);

        listView = findViewById(R.id.lstPersona);

        CustomAdapter customAdapter = new CustomAdapter();
        listView.setAdapter(customAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(),DescPersonagem_Activity.class);
                intent.putExtra("nome",nomePersonagem[position]);
                intent.putExtra("imagem",imagemPersonagem[position]);
                startActivity(intent);
            }
        });
    }
    private class CustomAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return imagemPersonagem.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View view, ViewGroup parent) {
            View view1= getLayoutInflater().inflate(R.layout.rec_personagem,null);

            TextView name = (TextView) view1.findViewById(R.id.nPersonagem);
            ImageView image = (ImageView) view1.findViewById(R.id.imgPersona);

            name.setText(nomePersonagem[position]);
            image.setImageResource(imagemPersonagem[position]);

            return view1;
        }
    }
}
