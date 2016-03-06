package com.example.carmitacg.myplayers.models.persistence.localdb.inserting;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.carmitacg.myplayers.models.entities.Jugador;
import com.example.carmitacg.myplayers.models.persistence.localdb.PlayersSQLiteDatabase;
import com.example.carmitacg.myplayers.models.persistence.localdb.interfaces.IPLAYERSDATABASETRANSACTION;

import java.util.List;

/**
 * Created by carmita c g on 05/03/2016.
 */
public class JugadorInsertDB implements IPLAYERSDATABASETRANSACTION {
    private PlayersSQLiteDatabase datasource;
    private SQLiteDatabase db;
    private Context context;
    public JugadorInsertDB(Context context){
        datasource = new PlayersSQLiteDatabase(context);
        this.context = context;
    }
    @Override
    public Cursor getAllPlayersAsCursor() {
        return null;
    }

    @Override
    public List<Jugador> getAllPlayersAsList(String EquipId, String CategoriaId) {
        return null;
    }

    @Override
    public Jugador getJugadorById(String id) {
        return null;
    }

    @Override
    public void updateJugador(String[] values, String PlayerId) {

    }

    @Override
    public void insertJugador(String[] values) {

    }

    @Override
    public Cursor getPlayersByCategory(String EquipId, String CategoryId) {
        return null;
    }

    public void insertAleviJugadors(){

        db = datasource.getReadableDatabase();

        db.execSQL("INSERT INTO JUGADOR(JugadorName," +
                        " JugadorSurname," +
                        " Posicio," +
                        " JugadorGoals" +
                        ", JugadorMatches," +
                        " JugadorMitjanaGols," +
                        " EquipId," +
                        " CategoriaId)" +
                        " values(?,?,?,?,?,?,?,?)",
                new String[]{
                        "Cristian",
                        "Ubeda Collelldevall",
                        "Defensa Central",
                        "16",
                        "13",
                        "0.9",
                        "1",
                        "6"

                });
        db.execSQL("INSERT INTO JUGADOR(JugadorName," +
                        " JugadorSurname," +
                        " Posicio," +
                        " JugadorGoals" +
                        ", JugadorMatches," +
                        " JugadorMitjanaGols," +
                        " EquipId," +
                        " CategoriaId)" +
                        " values(?,?,?,?,?,?,?,?)",
                new String[]{

                        "Pol",
                        "Turon Freixa",
                        "Defensa central",
                        "1",
                        "12",
                        "0.1",
                        "1",
                        "6"
                });
        db.execSQL("INSERT INTO JUGADOR(JugadorName," +
                        " JugadorSurname," +
                        " Posicio," +
                        " JugadorGoals" +
                        ", JugadorMatches," +
                        " JugadorMitjanaGols," +
                        " EquipId," +
                        " CategoriaId)" +
                        " values(?,?,?,?,?,?,?,?)",
                new String[]{

                        "Quim",
                        "Riera Busquets",
                        "Defensa lateral",
                        "0",
                        "7",
                        "0",
                        "1",
                        "6"
                });
        db.execSQL("INSERT INTO JUGADOR(JugadorName," +
                        " JugadorSurname," +
                        " Posicio," +
                        " JugadorGoals" +
                        ", JugadorMatches," +
                        " JugadorMitjanaGols," +
                        " EquipId," +
                        " CategoriaId)" +
                        " values(?,?,?,?,?,?,?,?)",
                new String[]{

                        "Eric",
                        "Juanola Puigvert",
                        "Defensa",
                        "3",
                        "6",
                        "0.2",
                        "1",
                        "6"
                });
        db.execSQL("INSERT INTO JUGADOR(JugadorName," +
                        " JugadorSurname," +
                        " Posicio," +
                        " JugadorGoals" +
                        ", JugadorMatches," +
                        " JugadorMitjanaGols," +
                        " EquipId," +
                        " CategoriaId)" +
                        " values(?,?,?,?,?,?,?,?)",
                new String[]{

                        "Arnau",
                        "Joanmiquel Vilanova",
                        "Defensa lateral",
                        "8",
                        "12",
                        "0.5",
                        "1",
                        "6"
                });
        db.execSQL("INSERT INTO JUGADOR(JugadorName," +
                        " JugadorSurname," +
                        " Posicio," +
                        " JugadorGoals" +
                        ", JugadorMatches," +
                        " JugadorMitjanaGols," +
                        " EquipId," +
                        " CategoriaId)" +
                        " values(?,?,?,?,?,?,?,?)",
                new String[]{

                        "Bilal",
                        "Lamrni Kouss",
                        "Davanter",
                        "21",
                        "12",
                        "1.2",
                        "1",
                        "6"
                });
        db.execSQL("INSERT INTO JUGADOR(JugadorName," +
                        " JugadorSurname," +
                        " Posicio," +
                        " JugadorGoals" +
                        ", JugadorMatches," +
                        " JugadorMitjanaGols," +
                        " EquipId," +
                        " CategoriaId)" +
                        " values(?,?,?,?,?,?,?,?)",
                new String[]{

                        "Amir",
                        "Maanan Kouss",
                        "Migcampista",
                        "13",
                        "16",
                        "0.7",
                        "1",
                        "6"
                });
        db.execSQL("INSERT INTO JUGADOR(JugadorName," +
                        " JugadorSurname," +
                        " Posicio," +
                        " JugadorGoals" +
                        ", JugadorMatches," +
                        " JugadorMitjanaGols," +
                        " EquipId," +
                        " CategoriaId)" +
                        " values(?,?,?,?,?,?,?,?)",
                new String[]{

                        "Marc",
                        "Conca Marti",
                        "Davanter",
                        "76",
                        "16",
                        "4",
                        "1",
                        "6"

                });
        db.execSQL("INSERT INTO JUGADOR(JugadorName," +
                        " JugadorSurname," +
                        " Posicio," +
                        " JugadorGoals" +
                        ", JugadorMatches," +
                        " JugadorMitjanaGols," +
                        " EquipId," +
                        " CategoriaId)" +
                        " values(?,?,?,?,?,?,?,?)",
                new String[]{

                        "Biel",
                        "Surroca Hernandez",
                        "Porter",
                        "0",
                        "13",
                        "0",
                        "1",
                        "6"
                });
        db.execSQL("INSERT INTO JUGADOR(JugadorName," +
                        " JugadorSurname," +
                        " Posicio," +
                        " JugadorGoals" +
                        ", JugadorMatches," +
                        " JugadorMitjanaGols," +
                        " EquipId," +
                        " CategoriaId)" +
                        " values(?,?,?,?,?,?,?,?)",
                new String[]{

                        "Estefan",
                        "Roca Barrio",
                        "Poter/Davanter",
                        "5",
                        "13",
                        "0.4",
                        "1",
                        "6"
                });
        db.execSQL("INSERT INTO JUGADOR(JugadorName," +
                        " JugadorSurname," +
                        " Posicio," +
                        " JugadorGoals" +
                        ", JugadorMatches," +
                        " JugadorMitjanaGols," +
                        " EquipId," +
                        " CategoriaId)" +
                        " values(?,?,?,?,?,?,?,?)",
                new String[]{

                        "Jhosef Matiu",
                        "Camacho Revilla",
                        "Davanter",
                        "5",
                        "9",
                        "0.5",
                        "1",
                        "6"
                });

    }
    public void insertQuartaCatalana(){

        db = datasource.getReadableDatabase();

        db.execSQL("INSERT INTO JUGADOR(JugadorName," +
                " JugadorSurname," +
                " Posicio," +
                " JugadorGoals" +
                ", JugadorMatches," +
                " JugadorMitjanaGols," +
                " EquipId," +
                " CategoriaId)" +
                " values(?,?,?,?,?,?,?,?)",
                new String[]{

                        "Sebastian",
                        "Tercero Garrido",
                        "Porter",
                        "0",
                        "16",
                        "0",
                        "1",
                        "1"
                }
        );
        db.execSQL("INSERT INTO JUGADOR(JugadorName," +
                        " JugadorSurname," +
                        " Posicio," +
                        " JugadorGoals" +
                        ", JugadorMatches," +
                        " JugadorMitjanaGols," +
                        " EquipId," +
                        " CategoriaId)" +
                        " values(?,?,?,?,?,?,?,?)",
                new String[]{

                        "Albert",
                        "Masoliver Pinyol",
                        "Davanter",
                        "1",
                        "13",
                        "0.1",
                        "1",
                        "1"
                }
        );
        db.execSQL("INSERT INTO JUGADOR(JugadorName," +
                        " JugadorSurname," +
                        " Posicio," +
                        " JugadorGoals" +
                        ", JugadorMatches," +
                        " JugadorMitjanaGols," +
                        " EquipId," +
                        " CategoriaId)" +
                        " values(?,?,?,?,?,?,?,?)",
                new String[]{

                        "Marc",
                        "Oliveras Coromina",
                        "Migcampista",
                        "0",
                        "13",
                        "0",
                        "1",
                        "1"
                }
        );
        db.execSQL("INSERT INTO JUGADOR(JugadorName," +
                        " JugadorSurname," +
                        " Posicio," +
                        " JugadorGoals" +
                        ", JugadorMatches," +
                        " JugadorMitjanaGols," +
                        " EquipId," +
                        " CategoriaId)" +
                        " values(?,?,?,?,?,?,?,?)",
                new String[]{

                        "Ferran",
                        "Vardenys Maso",
                        "Davanter",
                        "4",
                        "9",
                        "0.4",
                        "1",
                        "1"
                }
        );
        db.execSQL("INSERT INTO JUGADOR(JugadorName," +
                        " JugadorSurname," +
                        " Posicio," +
                        " JugadorGoals" +
                        ", JugadorMatches," +
                        " JugadorMitjanaGols," +
                        " EquipId," +
                        " CategoriaId)" +
                        " values(?,?,?,?,?,?,?,?)",
                new String[]{

                        "David",
                        "Calm Baldrich",
                        "Davanter",
                        "1",
                        "14",
                        "0.1",
                        "1",
                        "1"
                }
        );
        db.execSQL("INSERT INTO JUGADOR(JugadorName," +
                        " JugadorSurname," +
                        " Posicio," +
                        " JugadorGoals" +
                        ", JugadorMatches," +
                        " JugadorMitjanaGols," +
                        " EquipId," +
                        " CategoriaId)" +
                        " values(?,?,?,?,?,?,?,?)",
                new String[]{

                        "Josep Mª",
                        "Vilanova Masdemont",
                        "Migcampista",
                        "0",
                        "12",
                        "0",
                        "1",
                        "1"
                }
        );
        db.execSQL("INSERT INTO JUGADOR(JugadorName," +
                        " JugadorSurname," +
                        " Posicio," +
                        " JugadorGoals" +
                        ", JugadorMatches," +
                        " JugadorMitjanaGols," +
                        " EquipId," +
                        " CategoriaId)" +
                        " values(?,?,?,?,?,?,?,?)",
                new String[]{

                        "Charlie Agustin",
                        "Proaño Campoverde",
                        "Migcampista",
                        "2",
                        "15",
                        "0.1",
                        "1",
                        "1"
                }
        );
        db.execSQL("INSERT INTO JUGADOR(JugadorName," +
                        " JugadorSurname," +
                        " Posicio," +
                        " JugadorGoals" +
                        ", JugadorMatches," +
                        " JugadorMitjanaGols," +
                        " EquipId," +
                        " CategoriaId)" +
                        " values(?,?,?,?,?,?,?,?)",
                new String[]{

                        "Aniol",
                        "Reixach Farrés",
                        "Defensa",
                        "3",
                        "16",
                        "0.2",
                        "1",
                        "1"
                }
        );
        db.execSQL("INSERT INTO JUGADOR(JugadorName," +
                        " JugadorSurname," +
                        " Posicio," +
                        " JugadorGoals" +
                        ", JugadorMatches," +
                        " JugadorMitjanaGols," +
                        " EquipId," +
                        " CategoriaId)" +
                        " values(?,?,?,?,?,?,?,?)",
                new String[]{

                        "Oriol",
                        "Pujol Castañer",
                        "Defensa",
                        "0",
                        "16",
                        "0",
                        "1",
                        "1"
                }
        );
        db.execSQL("INSERT INTO JUGADOR(JugadorName," +
                        " JugadorSurname," +
                        " Posicio," +
                        " JugadorGoals" +
                        ", JugadorMatches," +
                        " JugadorMitjanaGols," +
                        " EquipId," +
                        " CategoriaId)" +
                        " values(?,?,?,?,?,?,?,?)",
                new String[]{

                        "Èric",
                        "Pagès Canal",
                        "Defensa",
                        "0",
                        "15",
                        "0",
                        "1",
                        "1"
                }
        );
        db.execSQL("INSERT INTO JUGADOR(JugadorName," +
                        " JugadorSurname," +
                        " Posicio," +
                        " JugadorGoals" +
                        ", JugadorMatches," +
                        " JugadorMitjanaGols," +
                        " EquipId," +
                        " CategoriaId)" +
                        " values(?,?,?,?,?,?,?,?)",
                new String[]{

                        "Ivan",
                        "Montenegro Lara",
                        "Davanter",
                        "0",
                        "11",
                        "0",
                        "1",
                        "1"
                }
        );
        db.execSQL("INSERT INTO JUGADOR(JugadorName," +
                        " JugadorSurname," +
                        " Posicio," +
                        " JugadorGoals" +
                        ", JugadorMatches," +
                        " JugadorMitjanaGols," +
                        " EquipId," +
                        " CategoriaId)" +
                        " values(?,?,?,?,?,?,?,?)",
                new String[]{

                        "Tijani",
                        "Samasa Krubally",
                        "Migcampista",
                        "1",
                        "10",
                        "0.1",
                        "1",
                        "1"
                }
        );
        db.execSQL("INSERT INTO JUGADOR(JugadorName," +
                        " JugadorSurname," +
                        " Posicio," +
                        " JugadorGoals" +
                        ", JugadorMatches," +
                        " JugadorMitjanaGols," +
                        " EquipId," +
                        " CategoriaId)" +
                        " values(?,?,?,?,?,?,?,?)",
                new String[]{

                        "Hamza",
                        "Derraz El Mourabiti",
                        "Migcampista",
                        "1",
                        "13",
                        "0.1",
                        "1",
                        "1"
                }
        );
        db.execSQL("INSERT INTO JUGADOR(JugadorName," +
                        " JugadorSurname," +
                        " Posicio," +
                        " JugadorGoals" +
                        ", JugadorMatches," +
                        " JugadorMitjanaGols," +
                        " EquipId," +
                        " CategoriaId)" +
                        " values(?,?,?,?,?,?,?,?)",
                new String[]{

                        "Zenon",
                        "Rosell Lopez",
                        "Micampista",
                        "2",
                        "13",
                        "0.1",
                        "1",
                        "1"
                }
        );
        db.execSQL("INSERT INTO JUGADOR(JugadorName," +
                        " JugadorSurname," +
                        " Posicio," +
                        " JugadorGoals" +
                        ", JugadorMatches," +
                        " JugadorMitjanaGols," +
                        " EquipId," +
                        " CategoriaId)" +
                        " values(?,?,?,?,?,?,?,?)",
                new String[]{

                        "Mahamado",
                        "Tunkara Tunkara",
                        "Porter",
                        "0",
                        "16",
                        "0",
                        "1",
                        "1"
                }
        );
        db.execSQL("INSERT INTO JUGADOR(JugadorName," +
                        " JugadorSurname," +
                        " Posicio," +
                        " JugadorGoals" +
                        ", JugadorMatches," +
                        " JugadorMitjanaGols," +
                        " EquipId," +
                        " CategoriaId)" +
                        " values(?,?,?,?,?,?,?,?)",
                new String[]{

                        "Benjamin",
                        "Fernandez Egea",
                        "Davanter",
                        "0",
                        "13",
                        "0",
                        "1",
                        "1"
                }
        );
        db.execSQL("INSERT INTO JUGADOR(JugadorName," +
                        " JugadorSurname," +
                        " Posicio," +
                        " JugadorGoals" +
                        ", JugadorMatches," +
                        " JugadorMitjanaGols," +
                        " EquipId," +
                        " CategoriaId)" +
                        " values(?,?,?,?,?,?,?,?)",
                new String[]{

                        "Marc",
                        "Reixach Berenguer",
                        "Defensa",
                        "0",
                        "14",
                        "0",
                        "1",
                        "1"
                }
        );
        db.execSQL("INSERT INTO JUGADOR(JugadorName," +
                        " JugadorSurname," +
                        " Posicio," +
                        " JugadorGoals" +
                        ", JugadorMatches," +
                        " JugadorMitjanaGols," +
                        " EquipId," +
                        " CategoriaId)" +
                        " values(?,?,?,?,?,?,?,?)",
                new String[]{

                        "Enric",
                        "Costa Dorca",
                        "Migcampista",
                        "0",
                        "13",
                        "0",
                        "1",
                        "1"
                }
        );
        db.execSQL("INSERT INTO JUGADOR(JugadorName," +
                        " JugadorSurname," +
                        " Posicio," +
                        " JugadorGoals" +
                        ", JugadorMatches," +
                        " JugadorMitjanaGols," +
                        " EquipId," +
                        " CategoriaId)" +
                        " values(?,?,?,?,?,?,?,?)",
                new String[]{

                        "Alhajimaimadou",
                        "Sissoho Sakiliba",
                        "Davanter",
                        "4",
                        "11",
                        "0.4",
                        "1",
                        "1"
                }
        );
        db.execSQL("INSERT INTO JUGADOR(JugadorName," +
                        " JugadorSurname," +
                        " Posicio," +
                        " JugadorGoals" +
                        ", JugadorMatches," +
                        " JugadorMitjanaGols," +
                        " EquipId," +
                        " CategoriaId)" +
                        " values(?,?,?,?,?,?,?,?)",
                new String[]{

                        "Albert",
                        "Fernandez Egea",
                        "Davanter",
                        "0",
                        "3",
                        "0",
                        "1",
                        "1"
                }
        );
        db.execSQL("INSERT INTO JUGADOR(JugadorName," +
                        " JugadorSurname," +
                        " Posicio," +
                        " JugadorGoals" +
                        ", JugadorMatches," +
                        " JugadorMitjanaGols," +
                        " EquipId," +
                        " CategoriaId)" +
                        " values(?,?,?,?,?,?,?,?)",
                new String[]{

                        "Sergio",
                        "Cabrera De Leon",
                        "Defensa",
                        "0",
                        "16",
                        "0",
                        "1",
                        "1"
                }
        );
    }

}
