package com.example.dialog;
 
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class Dialog extends Activity {

	private static final int DIALOG_ALERT =3;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	}
	
	@SuppressWarnings("deprecation")
	public void onClick(View view){
		showDialog(DIALOG_ALERT);
	}
	
	@Override 
	protected android.app.Dialog onCreateDialog(int id){
		switch(id){
		case DIALOG_ALERT:
			Builder builder = new AlertDialog.Builder(this);
			builder.setMessage("Do you want to end the activity?");
			builder.setCancelable(true);
			builder.setPositiveButton("This will end the activity", new OkOnClickListener());
			builder.setNegativeButton("This will resume the activity", new CancelOnClickListener());
			AlertDialog dialog = builder.create();
			dialog.show();
		}
		return super.onCreateDialog(id);
	}


	private final class CancelOnClickListener implements
	DialogInterface.OnClickListener {
public void onClick(DialogInterface dialog, int which) {
	Toast.makeText(getApplicationContext(), "What we say to the Death God? Not Today(Activity Lives)",
			Toast.LENGTH_LONG).show();
}
}

private final class OkOnClickListener implements
	DialogInterface.OnClickListener {
public void onClick(DialogInterface dialog, int which) {
	Dialog.this.finish();
}
}
}
