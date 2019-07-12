package com.example.mynotes;

import android.app.Activity;
import android.util.Log;
import android.widget.ArrayAdapter;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class MyFirebase extends Activity {

    static DatabaseReference myRef;
    static ArrayList<NotesModel> arrayListNews;
    private static MyFirebaseListener mListener;

    public static void init(MyFirebaseListener listener){

        mListener = listener;

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        myRef = database.getReference("notas");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                ArrayList<NotesModel> arrayListNotes = new ArrayList<>();

                for (DataSnapshot notasSnapshot : dataSnapshot.getChildren()){

                        NotesModel nota = notasSnapshot.getValue(NotesModel.class);
                        arrayListNotes.add(nota);

                }

                mListener.onRefreshList(arrayListNotes);

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }

    public static void write(){
        myRef.setValue("Hello, World!");
    }

    public static void publicarNuevaNoticia(String title, String body) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss ddMMyyyy");
        String currentDateandTime = sdf.format(new Date());

        NotesModel mNew = new NotesModel(title, body);
        myRef.child(currentDateandTime).setValue(mNew);
    }


    public interface MyFirebaseListener{
        void onRefreshList(ArrayList<NotesModel> notesModels);
    }


}


