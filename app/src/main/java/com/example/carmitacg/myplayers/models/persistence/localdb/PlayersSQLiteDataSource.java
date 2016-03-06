package com.example.carmitacg.myplayers.models.persistence.localdb;

/**
 * Created by carmita c g on 29/02/2016.
 */
public class PlayersSQLiteDataSource {

    public static String CREATE_PLAYER_TABLE =
            "create table JUGADOR(" +
                    "JugadorId INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "JugadorName TEXT," +
                    "JugadorSurname TEXT," +
                    "Posicio TEXT," +
                    "JugadorGoals INTEGER," +
                    "JugadorMatches INTEGER," +
                    "JugadorMitjanaGols FLOAT," +
                    "EquipId INTEGER," +
                    "CategoriaId INTEGER," +
                    "FOREIGN KEY(EquipId) REFERENCES EQUIP(EquipId)," +
                    "FOREIGN KEY(CategoriaId) REFERENCES CATEGORIA(CategoriaId)" +
            ");";
    public static String CREATE_ENTRENADOR_TABLE =
            "create table ENTRENADOR(" +
                    "EntrenadorId INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "EntrenadorName TEXT," +
                    "EntrenadorSurname TEXT," +
                    "EquipId INTEGER," +
                    "FOREIGN KEY(EquipId) REFERENCES EQUIP(EquipId)" +
            ");";
    public static String CREATE_EQUIP_TABLE =
            "create table EQUIP(" +
                    "EquipId INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "EquipName TEXT," +
                    "EquipPresident TEXT," +
                    "EstadiId INTEGER," +
                    "FOREIGN KEY(EstadiId) REFERENCES ESTADI(EstadiId)" +
            ");";
    public static String CREATE_ESTADI_TABLE =
            "create table ESTADI(" +
                    "EstadiId INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "EstadiName TEXT," +
                    "EstadiCapacity INTEGER," +
                    "EstadiLocation TEXT," +
                    "EstadiDataConstruction DATE " +
            ");";
    public static String CREATE_PARTIT_TABLE =
            "create table PARTIT(" +
                    "EstadiId INTEGER," +
                    "Equip1Id INTEGER," +
                    "Equip2Id INTEGER," +
                    "GolId INTEGER," +
                    "FOREIGN KEY(EstadiId) REFERENCES ESTADI(EstadiId)," +
                    "FOREIGN KEY(Equip1Id) REFERENCES EQUIP(EquipId)," +
                    "FOREIGN KEY(Equip2Id) REFERENCES EQUIP(EquipId)," +
                    "FOREIGN KEY(GolId) REFERENCES GOL(GolId)" +
            ");";

    public static String CREATE_CATEGORIA_TABLE =
            "create table CATEGORIA(" +
                    "CategoriaId INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "Descripcio TEXT," +
                    "EquipId INTEGER," +
                    "FOREIGN KEY(EquipId) REFERENCES EQUIP(EquipId)" +
            ");";

    public static String CREATE_GOL_TABLE =
            "create table GOL(" +
                    "GolId INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "JugadorId INTEGER," +
                    "FOREIGN KEY(JugadorId) REFERENCES PLAYER(JugadorId)" +
            ");";

}
