package com.example.victor.less3110.activitys;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.example.victor.less3110.R;
import com.example.victor.less3110.adapters.NotesAdapter;
import com.example.victor.less3110.model.Note;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.victor.less3110.activitys.EditNote.DATA_KEY;

public class MainActivity extends AppCompatActivity {

    @BindView (R.id.list_notes)
    protected RecyclerView mRecyclerView;
    @BindView (R.id.fab)
    protected FloatingActionButton mFab;
    @BindView (R.id.toolbar)
    protected Toolbar mToolbar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        //mRecyclerView = (RecyclerView) findViewById(R.id.list_notes);
        //mToolbar = (Toolbar) findViewById(R.id.mToolbar);
        setSupportActionBar(mToolbar);
        //setTitle(R.string.app_name);
        setTitle("My App Title");

        //как будет отображать список
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false); //вертикальный список
        mRecyclerView.setLayoutManager(layoutManager);

        NotesAdapter adapter = new NotesAdapter();

        List<Note> dataSource = new ArrayList<>();
        for(int i = 0; i < 100; i++){
            Note note = new Note();
            note.setTitle("Title: "+i);
            note.setText("Text: "+i);
            note.setTime(System.currentTimeMillis());
            dataSource.add(note);
        }
        mRecyclerView.setAdapter(adapter);
        adapter.setDataSource(dataSource);


        //mFab = (FloatingActionButton) findViewById(R.id.mFab);
        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = EditNote.newInstance(MainActivity.this);
                intent.putExtra(DATA_KEY, "qwerty");
                startActivity(intent);
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
                Snackbar.make(mRecyclerView,R.string.action_settings,Snackbar.LENGTH_SHORT).show();
                return true;
            case R.id.help:
                Snackbar.make(mRecyclerView,R.string.help,Snackbar.LENGTH_SHORT).show();
                return true;
            default: return super.onOptionsItemSelected(item);

        }

    }
}
