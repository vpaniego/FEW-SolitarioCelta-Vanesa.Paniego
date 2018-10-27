package es.upm.miw.db;

import android.provider.BaseColumns;

final public class SCResultadoContract {

    private SCResultadoContract() {
    }

    public static abstract class tablaSCResultado implements BaseColumns {

        static final String TABLE_NAME = "resultados";

        static final String COL_NAME_ID = _ID;
        static final String COL_NAME_NOMBRE = "nombre";
        static final String COL_NAME_FECHA = "fecha";
        static final String COL_NAME_FICHAS = "fichas";
    }

}
