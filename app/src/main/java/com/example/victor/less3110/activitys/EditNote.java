package com.example.victor.less3110.activitys;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.example.victor.less3110.R;
import com.example.victor.less3110.db.NotesContract;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.victor.less3110.activitys.MainActivity.REQUEST_CODE;

public class EditNote extends AppCompatActivity {
    @BindView(R.id.editText)
    protected EditText mEditText;
    @BindView(R.id.editTitle)
    protected EditText mEditTitle;
    @BindView(R.id.toolbar)
    protected Toolbar mToolbar;

    public static void start (Context context){
        Intent intent = new Intent(context, EditNote.class);
        context.startActivity(intent);
    }

    public static Intent newInstance (Context context){
        return new Intent(context, EditNote.class);
    }

    public static final String DATA_KEY = "DATA_KEY";

    private static final String SHARE_TYPE = "text/plain";
    public static final String RESULT = "RESULT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_note);

        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);





        String extraString = getIntent().getStringExtra(DATA_KEY);
        Toast.makeText(this, "extra is "+extraString, Toast.LENGTH_SHORT).show();

        mEditText.append(" is ok");
        mEditTitle.append(" is ok too");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.edit_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: {
                Intent intent = new Intent();
                intent.putExtra(RESULT,prepareNoteForSharing());
                setResult(RESULT_OK, intent);
                finish();
//                Intent intent = new Intent(this, MainActivity.class);
//                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                startActivity(intent);
                break;
            }
            case R.id.action_share: {
                share();
                break;
            }
        }
        return super.onOptionsItemSelected(item);
    }


    private void share() {
        Intent shareIntent = new Intent();
        shareIntent.setAction(Intent.ACTION_SEND);
        shareIntent.putExtra(Intent.EXTRA_TEXT, prepareNoteForSharing());
        shareIntent.setType(SHARE_TYPE);
        startActivity(shareIntent);
    }

    private String prepareNoteForSharing() {
        return getString(
                R.string.sharing_template,
                mEditTitle.getText(),
                mEditText.getText());
    }

    @OnClick(R.id.saveBtn)
    public void onSaveBtnClick() {
        insertNote();
        finish();
    }

    private void insertNote() {
        ContentValues values = new ContentValues();
        values.put(NotesContract.TITLE_COLUMN, mEditTitle.getText().toString());
        values.put(NotesContract.TEXT_COLUMN, mEditText.getText().toString());
        values.put(NotesContract.TIME_COLUMN, String.valueOf(System.currentTimeMillis()));
        getContentResolver().insert(NotesContract.CONTENT_URI, values);
    }

}
