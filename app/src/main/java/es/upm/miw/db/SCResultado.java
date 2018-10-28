package es.upm.miw.db;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.RequiresApi;

import java.util.Date;

public class SCResultado implements Parcelable {

    private int id;
    private String nombre;
    private Date fecha;
    private Integer fichas;

    public SCResultado(int id, String nombre, Date fecha, Integer fichas) {
        this.id = id;
        this.nombre = nombre;
        this.fecha = fecha;
        this.fichas = fichas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getFichas() {
        return fichas;
    }

    public void setFichas(Integer fichas) {
        this.fichas = fichas;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    protected SCResultado(Parcel in) {
        id = in.readInt();
        nombre = in.readString();
        fecha = (Date) in.readValue(Date.class.getClassLoader());
        fichas = in.readByte() == 0x00 ? null : in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(nombre);
        dest.writeValue(fecha);
        if (fichas == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(fichas);
        }
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<SCResultado> CREATOR = new Parcelable.Creator<SCResultado>() {
        @RequiresApi(api = Build.VERSION_CODES.O)
        @Override
        public SCResultado createFromParcel(Parcel in) {
            return new SCResultado(in);
        }

        @Override
        public SCResultado[] newArray(int size) {
            return new SCResultado[size];
        }
    };
}