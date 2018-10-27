package es.upm.miw.SolitarioCelta;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;

public class SCeltaEliminarDialogFragment extends DialogFragment {

    static final String LOG_TAG = "MiW";


	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		final MejoresResultadosActivity activity = (MejoresResultadosActivity) getActivity();

        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder
                .setTitle(R.string.txtDialogoEliminarTitulo)
                .setMessage(R.string.txtDialogoEliminarPregunta)
                .setPositiveButton(
                        R.string.txtDialogoEliminarAfirmativo,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                int eliminados = activity.resultadoRepository.removeAll();
                                Log.i(LOG_TAG, "Número de resultados eliminados = " + String.valueOf(eliminados));
                            }
                        }
                )
                .setNegativeButton(
                        R.string.txtDialogoEliminarNegativo,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // Opcion NO: no hacer nada;
                            }
                        }
                );

		return builder.create();
	}
}
