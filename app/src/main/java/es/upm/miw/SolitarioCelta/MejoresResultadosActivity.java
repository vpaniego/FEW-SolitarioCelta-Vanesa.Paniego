package es.upm.miw.SolitarioCelta;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
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
        SCResultadoAdapter scResultadoAdapter = new SCResultadoAdapter(
                this,
                R.layout.item_resultados,
                resultadoRepository.getAllOrderByNumFichas());
        resultadosListView.setAdapter(scResultadoAdapter);
        //para que cada vez que haya un cambio el resultadosListView se actualice
        scResultadoAdapter.refreshEvents(resultadoRepository.getAllOrderByNumFichas());

        setResult(RESULT_OK);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.opciones_resultados_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.eliminar:
                mostrarEliminar();
                return true;

        }
        return super.onOptionsItemSelected(item);
    }

    private void mostrarEliminar() {
        DialogFragment eliminarDialogFragment = new SCeltaEliminarDialogFragment();
        eliminarDialogFragment.show(getFragmentManager(), String.valueOf(R.string.eliminarText));
    }
}
