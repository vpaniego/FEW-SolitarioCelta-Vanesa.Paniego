package es.upm.miw.SolitarioCelta;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

public class SCeltaEliminarDialogFragment extends DialogFragment {

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
                                String messageEliminados = "Eliminados " + String.valueOf(activity.resultadoRepository.removeAll()) + " resultados";
                                Toast.makeText(activity.getBaseContext(), messageEliminados,
                                        Toast.LENGTH_SHORT).show();
                                activity.adapter.removeAllFromView();
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
