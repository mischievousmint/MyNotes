package com.example.mynotes.Activities;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.mynotes.MyFirebase;
import com.example.mynotes.NotesAdapter;
import com.example.mynotes.NotesModel;
import com.example.mynotes.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MyFirebase.MyFirebaseListener {

    EditText etTitle;
    EditText etSubtitle;
    Button btnSave;
    RecyclerView rvNotes;
    ArrayList<NotesModel> arrayListEmpty;
    NotesAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyFirebase.init(this);

        rvNotes = findViewById(R.id.rvNotes);
        etTitle = findViewById(R.id.etTitle);
        etSubtitle = findViewById(R.id.etSubTitle);
        btnSave = findViewById(R.id.btnSave);

        rvNotes.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        arrayListEmpty = new ArrayList<>();
        mAdapter = new NotesAdapter(arrayListEmpty);
        rvNotes.setAdapter(mAdapter);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyFirebase.publicarNuevaNoticia(etTitle.getText().toString(),etSubtitle.getText().toString());
            }
        });

    }

 /*   private List<NotesModel> getNotesList(){

        NotesModel nota1 = new NotesModel();
        nota1.setTitle(etTitle.getText().toString());
        nota1.setTitle(etSubtitle.getText().toString());

        List<NotesModel> notesList = new ArrayList<>();
        //nota1.

       *//* NotesModel film1 = new NotesModel();
        film1.setTitle("Fantasía");

        NotesModel film2 = new NotesModel();
        film2.setTitle("Anastasia");

        NotesModel film3 = new NotesModel();
        film3.setTitle("Matrix");

        List<NotesModel> listadepeliculas = new ArrayList<>();
        listadepeliculas.add(film1);
        listadepeliculas.add(film2);
        listadepeliculas.add(film3);*//*

        return notesList;
    }*/





    @Override
    public void onRefreshList(ArrayList<NotesModel> notesModels) {
        mAdapter.loadData(notesModels);
    }
}
