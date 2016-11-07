package com.example.victor.less3110;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.example.victor.less3110.adapters.NotesAdapter;
import com.example.victor.less3110.model.Note;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView (R.id.list_notes)
    protected RecyclerView recyclerView;
    @BindView (R.id.fab)
    protected FloatingActionButton fab;
    @BindView (R.id.toolbar)
    protected Toolbar toolbar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        //recyclerView = (RecyclerView) findViewById(R.id.list_notes);
        //toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //setTitle(R.string.app_name);
        setTitle("My App Title");

        //как будет отображать список
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false); //вертикальный список
        recyclerView.setLayoutManager(layoutManager);

        NotesAdapter adapter = new NotesAdapter();

        List<Note> dataSource = new ArrayList<>();
        for(int i = 0; i < 100; i++){
            Note note = new Note();
            note.setTitle("Title: "+i);
            note.setText("Text: "+i);
            note.setTime(System.currentTimeMillis());
            dataSource.add(note);
        }
        recyclerView.setAdapter(adapter);
        adapter.setDataSource(dataSource);


        //fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Clicked on FAB", Snackbar.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.action_settings:
                Snackbar.make(recyclerView,R.string.action_settings,Snackbar.LENGTH_SHORT).show();
                return true;
            case R.id.help:
                Snackbar.make(recyclerView,R.string.help,Snackbar.LENGTH_SHORT).show();
                return true;
            default: return super.onOptionsItemSelected(item);

        }

    }
}
