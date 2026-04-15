package com.example.prova;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Produto.class}, version = 1)
public abstract class ProdutoDataBase extends RoomDatabase {

    private static ProdutoDataBase instance;

    public abstract ProdutoDao produtoDao();

    public static synchronized ProdutoDataBase getInstance(Context context) {
        if(instance == null){
            instance = Room.databaseBuilder(
                            context.getApplicationContext(),
                            ProdutoDataBase.class,
                            "produto-database"
                    ).fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }
}


