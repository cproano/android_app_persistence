package com.example.carmitacg.myplayers.models.persistence.localdb;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.carmitacg.myplayers.models.persistence.localdb.inserting.JugadorInsertDB;

/**
 * Created by carmita c g on 29/02/2016.
 */
public class PlayersSQLiteDatabase extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "MyPlayers.db";
    private static final int DATABASE_VERSION = 1;
    public PlayersSQLiteDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(PlayersSQLiteDataSource.CREATE_ESTADI_TABLE);
        db.execSQL(PlayersSQLiteDataSource.CREATE_EQUIP_TABLE);
        db.execSQL(PlayersSQLiteDataSource.CREATE_GOL_TABLE);
        db.execSQL(PlayersSQLiteDataSource.CREATE_ENTRENADOR_TABLE);
        db.execSQL(PlayersSQLiteDataSource.CREATE_PLAYER_TABLE);
        db.execSQL(PlayersSQLiteDataSource.CREATE_PARTIT_TABLE);
        db.execSQL(PlayersSQLiteDataSource.CREATE_CATEGORIA_TABLE);

        //Inserim estadis i equips
        db.execSQL("insert into ESTADI(EstadiName, EstadiCapacity, EstadiLocation) values(?,?,?)", new String[]{"Municipal La Canya", "2000", "La Canya"});
        db.execSQL("insert into EQUIP(EquipName, EquipPresident, EstadiId) values(?,?,?)", new String[]{"La Canya, A.E.", "Mateo", "1"});

        db.execSQL("insert into ESTADI(EstadiName, EstadiCapacity, EstadiLocation) values(?,?,?)", new String[]{"Municipal Sant Joan les Abadesses", "2000", "Sant Joan de les Abadesses"});
        db.execSQL("insert into EQUIP(EquipName, EquipPresident, EstadiId) values(?,?,?)", new String[]{"Abadessenc, C.E.", "", "1"});

        db.execSQL("insert into ESTADI(EstadiName, EstadiCapacity, EstadiLocation) values(?,?,?)", new String[]{"Municipal La Cellera de Ter", "2000", "La Cellera"});
        db.execSQL("insert into EQUIP(EquipName, EquipPresident, EstadiId) values(?,?,?)", new String[]{"Cellera, C.F.", "", "1"});

        db.execSQL("insert into ESTADI(EstadiName, EstadiCapacity, EstadiLocation) values(?,?,?)", new String[]{"Municipal Osor", "2000", "Osor"});
        db.execSQL("insert into EQUIP(EquipName, EquipPresident, EstadiId) values(?,?,?)", new String[]{"Osor, U.E.", "", "1"});

        db.execSQL("insert into ESTADI(EstadiName, EstadiCapacity, EstadiLocation) values(?,?,?)", new String[]{"Municipal Verntallat", "2000", "El Mallol"});
        db.execSQL("insert into EQUIP(EquipName, EquipPresident, EstadiId) values(?,?,?)", new String[]{"Joanetes, C.F.", "", "1"});

        db.execSQL("insert into ESTADI(EstadiName, EstadiCapacity, EstadiLocation) values(?,?,?)", new String[]{"Municipal Bescano", "2000", "Bescano"});
        db.execSQL("insert into EQUIP(EquipName, EquipPresident, EstadiId) values(?,?,?)", new String[]{"Bescano, C.D.", "", "1"});

        db.execSQL("insert into ESTADI(EstadiName, EstadiCapacity, EstadiLocation) values(?,?,?)", new String[]{"Municipal Castellfollit de la Roca", "2000", "Castellfollit de la Roca"});
        db.execSQL("insert into EQUIP(EquipName, EquipPresident, EstadiId) values(?,?,?)", new String[]{"Castellfollit, U.E.", "", "1"});

        db.execSQL("insert into ESTADI(EstadiName, EstadiCapacity, EstadiLocation) values(?,?,?)", new String[]{"Municipal Montagut", "2000", "Montagut"});
        db.execSQL("insert into EQUIP(EquipName, EquipPresident, EstadiId) values(?,?,?)", new String[]{"Penya Esportiva Montagut", "", "1"});

        db.execSQL("insert into ESTADI(EstadiName, EstadiCapacity, EstadiLocation) values(?,?,?)", new String[]{"Municipal Sant Jaume de Llierca", "2000", "Sant Jaume de Llierca"});
        db.execSQL("insert into EQUIP(EquipName, EquipPresident, EstadiId) values(?,?,?)", new String[]{"Atlètic Llierca", "", "1"});

        db.execSQL("insert into ESTADI(EstadiName, EstadiCapacity, EstadiLocation) values(?,?,?)", new String[]{"Municipal Serinyà", "2000", "Serinyà"});
        db.execSQL("insert into EQUIP(EquipName, EquipPresident, EstadiId) values(?,?,?)", new String[]{"Serinyà, C.F.", "", "1"});

        db.execSQL("insert into ESTADI(EstadiName, EstadiCapacity, EstadiLocation) values(?,?,?)", new String[]{"Municipal Sant Privat d'en Bas", "2000", "Sant Privat d'en Bas"});
        db.execSQL("insert into EQUIP(EquipName, EquipPresident, EstadiId) values(?,?,?)", new String[]{"Sant Privat D'en Bas, F.C.", "", "1"});

        db.execSQL("insert into ESTADI(EstadiName, EstadiCapacity, EstadiLocation) values(?,?,?)", new String[]{"Municipal Bonmati", "2000", "Bonmati"});
        db.execSQL("insert into EQUIP(EquipName, EquipPresident, EstadiId) values(?,?,?)", new String[]{"Bonmati, C.F.", "", "1"});

        db.execSQL("insert into ESTADI(EstadiName, EstadiCapacity, EstadiLocation) values(?,?,?)", new String[]{"Manel Alemany", "2000", "Fontcoberta"});
        db.execSQL("insert into EQUIP(EquipName, EquipPresident, EstadiId) values(?,?,?)", new String[]{"Fontcoberta, U.E.", "", "1"});

        db.execSQL("insert into ESTADI(EstadiName, EstadiCapacity, EstadiLocation) values(?,?,?)", new String[]{"Camp Escola Pia Olot", "2000", "Olot"});
        db.execSQL("insert into EQUIP(EquipName, EquipPresident, EstadiId) values(?,?,?)", new String[]{"Olot, At.", "", "1"});

        db.execSQL("insert into ESTADI(EstadiName, EstadiCapacity, EstadiLocation) values(?,?,?)", new String[]{"Municipal Camós", "2000", "Camós"});
        db.execSQL("insert into EQUIP(EquipName, EquipPresident, EstadiId) values(?,?,?)", new String[]{"Camós, C.F.", "", "1"});

        db.execSQL("insert into ESTADI(EstadiName, EstadiCapacity, EstadiLocation) values(?,?,?)", new String[]{"Municipal Sant Miquel Campmajor", "2000", "Sant Miquel de Campmajor"});
        db.execSQL("insert into EQUIP(EquipName, EquipPresident, EstadiId) values(?,?,?)", new String[]{"Sant Miquel de Campmajor, U.E.", "", "1"});




        db.execSQL("insert into CATEGORIA(Descripcio, EquipId) values (?,?)", new String[]{
                "Quarta Catalana","1"

        });
        db.execSQL("insert into CATEGORIA(Descripcio, EquipId) values (?,?)", new String[]{

                "Juvenil Segona Divisió", "1"
        });
        db.execSQL("insert into CATEGORIA(Descripcio, EquipId) values (?,?)", new String[]{

                "Cadet Segona Divisió", "1"
        });
        db.execSQL("insert into CATEGORIA(Descripcio, EquipId) values (?,?)", new String[]{

                "Infantil Segona Divisió", "1"
        });
        db.execSQL("insert into CATEGORIA(Descripcio, EquipId) values (?,?)", new String[]{
                "Aleví Segona Divisió 'A'", "1"

        });
        db.execSQL("insert into CATEGORIA(Descripcio, EquipId) values (?,?)", new String[]{

                "Aleví Segona Divisió 'B'", "1"
        });db.execSQL("insert into CATEGORIA(Descripcio, EquipId) values (?,?)", new String[]{

                "Benjamí 7 Primera Divisió", "1"
        });


    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
