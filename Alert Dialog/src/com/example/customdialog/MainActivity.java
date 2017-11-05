package com.example.customdialog;



import android.os.Bundle;
import android.renderscript.Sampler.Value;
import android.app.Activity;
import android.app.ActivityOptions;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_main);
        dialogbar();

    }
    
void dialogbar(){   
    LayoutInflater factory = LayoutInflater.from(this);
    final View deleteDialogView = factory.inflate(R.layout.custom, null);
    final AlertDialog deleteDialog = new AlertDialog.Builder(this).create();
    deleteDialog.setView(deleteDialogView);
    TextView text = (TextView) (deleteDialogView.findViewById(R.id.txt_dia));
    text.setText("Do you realy want to exit ?\n অ্যাপটি ব্যাবহারের জন্য ধন্যবাদ।");
    
    //support custom font
    Typeface p = Typeface.createFromAsset(getAssets(), "fonts/purnova.ttf");
    text.setTypeface(p);
    
    deleteDialogView.findViewById(R.id.btn_yes).setOnClickListener(new OnClickListener() {    
        @Override
        public void onClick(View v) {
            //My business logic, Close all the activity and close app 
        	Intent intent = new Intent(Intent.ACTION_MAIN);
	        intent.addCategory(Intent.CATEGORY_HOME);
	        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	        startActivity(intent);
            deleteDialog.dismiss();
        }
    });
    deleteDialogView.findViewById(R.id.btn_no).setOnClickListener(new OnClickListener() {    
        @Override
        public void onClick(View v) {
            deleteDialog.dismiss();    
        }
    });

    deleteDialog.show();
}



	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
