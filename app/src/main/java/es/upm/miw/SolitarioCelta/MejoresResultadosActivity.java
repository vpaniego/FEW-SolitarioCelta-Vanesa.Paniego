package es.upm.miw.SolitarioCelta;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import es.upm.miw.db.RepositorioSCResultado;

public class MejoresResultadosActivity extends AppCompatActivity {

    private ListView resultadosListView;

    RepositorioSCResultado resultadoRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);

        resultadoRepository = new RepositorioSCResultado(getApplicationContext());

        // Mostrar el icono back en la ActionBar
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        // Se recuperan los datos
        Bundle bundle = this.getIntent().getExtras();
        if (bundle != null) {

        }

        resultadosListView = findViewById(R.id.resultadosListView);
        resultadosListView.addHeaderView(getLayoutInflater().inflate(R.layout.cabecera_resultados, null));
        resultadosListView.setAdapter(new SCResultadoAdapter(
                this,
                R.layout.item_resultados,
                resultadoRepository.getAll()));

        setResult(RESULT_OK);
    }

}
