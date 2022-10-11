package com.example.ch5;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import android.view.ActionMode;

public class ContextActionMode extends AppCompatActivity implements ActionMode.Callback{
    private ActionMode mActionMode;
    private ActionMode.Callback myActivity = this;

//    class ActionModeCallBack implements ActionMode.Callback {
//        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
//            MenuInflater inflater = mode.getMenuInflater();
//            inflater.inflate(R.menu.mymenu,menu);
//            return true;
//        }
//        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
//            return false;
//        }
//        public boolean onActionItemClicked(ActionMode mode, MenuItem item){
//            switch(item.getItemId()){
//                case R.id.share:
//                    mode.finish();
//                    return true;
//                default:
//                    return false;
//            }
//        }
//        public void onDestroyActionMode(ActionMode mode){
//            mActionMode = null;
//        }
//    }

//    private View.OnLongClickListener mLongClickListener = new View.OnLongClickListener() {
//        @Override
//        public boolean onLongClick(View view) {
//            if (mActionMode != null) {
//                return false;
//            }
//            mActionMode = startActionMode(myActivity);
//            return false;
//        }
//    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flotingcontextmenu);
        TextView t1 = (TextView) findViewById(R.id.TextView01);
        t1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if (mActionMode != null) {
                    return false;
                }
//                mActionMode = startActionMode(new ActionModeCallBack());
                mActionMode = startActionMode(myActivity);
                return false;
            }

        });
    }

    public boolean onCreateActionMode(ActionMode mode, Menu menu) {
        MenuInflater inflater = mode.getMenuInflater();
        inflater.inflate(R.menu.mymenu,menu);
        return true;
    }
    public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
        return false;
    }
    public boolean onActionItemClicked(ActionMode mode, MenuItem item){
        switch(item.getItemId()){
            case R.id.share:
                mode.finish();
                return true;
            default:
                return false;
        }
    }
    public void onDestroyActionMode(ActionMode mode){
        mActionMode = null;
    }
}
