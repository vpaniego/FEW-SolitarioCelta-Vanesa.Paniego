package es.upm.miw.SolitarioCelta;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import es.upm.miw.db.SCResultado;

public class SCResultadoAdapter extends ArrayAdapter<SCResultado> {

    private Context context;
    private List<SCResultado> resultados;
    private int resourceId;

    public SCResultadoAdapter(@NonNull Context context, int resource, @NonNull List<SCResultado> resultados) {
        super(context, resource, resultados);
        this.context = context;
        this.resourceId = resource;
        this.resultados = resultados;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LinearLayout view;
        if (null != convertView) {
            view = (LinearLayout) convertView;
        } else {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = (LinearLayout) inflater.inflate(resourceId, parent, false);
        }

        SCResultado resultado = resultados.get(position);

        if(resultado != null) {

            TextView tvNombreJugador = view.findViewById(R.id.tvNombreJugador);
            tvNombreJugador.setText(resultado.getNombre());

            TextView tvNumeroFichas = view.findViewById(R.id.tvFichas);
            tvNumeroFichas.setText("" + resultado.getFichas());

            TextView tvFecha = view.findViewById(R.id.tvFecha);
            tvFecha.setText(String.format("%tF", resultado.getFecha()));
        }

        return view;
    }
}
