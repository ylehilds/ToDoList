package com.lehidev.android;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.os.IBinder;
import android.text.InputType;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class schoolList extends Activity{
	public static final String PREFS_NAME = "MyPrefsFile";
	static ArrayList <String> todoItems = null;
	EditText myEditText = null;
	ListView myListView = null;

	  @Override
	  protected void onPause() {
	    super.onPause();    
	    // Get the activity preferences object.
	    SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
	    // Get the preferences editor.
	    if (todoItems.size()!=0)
	    {
	    	SharedPreferences.Editor editor = settings.edit();	    
	    // Add the UI state preference values.
	    	editor.putString("list", todoItems.toString().replace("[", "").replace("]", ""));
	    	editor.commit();
	    }
	    else 
	    {
	    	SharedPreferences.Editor editor = settings.edit();
		    
		    // Add the UI state preference values.
		    	editor.clear();
		    	editor.commit();
	    }
	  }

	 @Override
	  protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.school);

	    ImageButton backButton = (ImageButton)findViewById(R.id.back);	    
	    ImageButton clearListButton = (ImageButton)findViewById(R.id.clear_all_list);
	    
	    ImageButton emailButton = (ImageButton)findViewById(R.id.email);
	    emailButton.setOnClickListener(new View.OnClickListener() {

		      @Override
		      public void onClick(View view) {
		    	if (todoItems.size() !=0)
		    	  {
		    		  String email="School To Do List: \n\n";
		    	  for(int i=0;i<todoItems.size();i++)
		    	  {
		    		  email+= todoItems.get(i) +"\n";
		    	  }
			        Intent intent = new Intent(Intent.ACTION_SEND);
			        intent.setType("text/plain");
			        intent.putExtra(Intent.EXTRA_EMAIL, new String[] {""});
			        intent.putExtra(Intent.EXTRA_SUBJECT, "School To Do List");
			        intent.putExtra(Intent.EXTRA_TEXT, email);
			       
			        try
			        {
			        	startActivity(Intent.createChooser(intent, "Send Mail..."));
			        } catch (android.content.ActivityNotFoundException ex)
			        {
			        	Toast.makeText(schoolList.this, "There are not email clients installed.", Toast.LENGTH_SHORT).show();
			        }
		    	  }
		    	  else  Toast.makeText(schoolList.this, "List is Empty!", Toast.LENGTH_SHORT).show();
		      }
		    });
	    
	    
	    backButton.setOnClickListener(new View.OnClickListener() {

		      @Override
		      public void onClick(View view) {
		        Intent intent = new Intent(schoolList.this, ToDoList.class);
		        startActivity(intent);
		      }

		    });
	    
myListView = (ListView) findViewById (R.id.myListView);
myEditText = (EditText) findViewById(R.id.myEditText);
//myEditText.setInputType(InputType.TYPE_NULL);
getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
// create the the arrayList of to do items
todoItems = new ArrayList <String> ();
// create the array adapter to bind the array to the listview
final ArrayAdapter <String> aa;
aa = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, todoItems);
// Bind the array adapter to the listview
myListView.setAdapter(aa);

        clearListButton.setOnClickListener(new View.OnClickListener() {
        	 @Override
		      public void onClick(View view) {
        		 AlertDialog.Builder adb=new AlertDialog.Builder(schoolList.this);
              	 //adb.setTitle("Are you Sure!");
              	 adb.setMessage("Are you Sure to Delete All List?");
              	 adb.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                     public void onClick(DialogInterface dialog, int id) {
                         //do stuff like set some variables, maybe display another dialog
                    	 todoItems.clear();
                      	aa.notifyDataSetChanged();  
                     }
             }); 
              	 adb.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                     public void onClick(DialogInterface dialog, int id) {
                         //do stuff like set some variables, maybe display another dialog
                     }
             }); 
              	 adb.show();
              	 }

    	 }); 
	    
        myEditText.setOnKeyListener(new OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
              if (event.getAction() == KeyEvent.ACTION_DOWN)
                if (keyCode == KeyEvent.KEYCODE_ENTER)
                {
                	if (!todoItems.contains(myEditText.getText().toString()) && !myEditText.getText().toString().equals(""))
                	{
		                  todoItems.add(0, myEditText.getText().toString());
		                  aa.notifyDataSetChanged();
                	}
                  myEditText.setText("");
                  return true;
                }
              return false;
            }
          });
        
        myListView.setTextFilterEnabled(true);
        myListView.setOnItemClickListener(new OnItemClickListener() {
        	 public void onItemClick(AdapterView<?> a, View v, final int position, long id) {
               	 AlertDialog.Builder adb=new AlertDialog.Builder(schoolList.this);
              	 //adb.setTitle("Are you Sure!");
              	 adb.setMessage("Are you Sure to Delete?");
              	 adb.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                     public void onClick(DialogInterface dialog, int id) {
                         //do stuff like set some variables, maybe display another dialog
                    	 todoItems.remove(position);
                     	 aa.notifyDataSetChanged();  
                     }
             }); 
              	 adb.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                     public void onClick(DialogInterface dialog, int id) {
                         //do stuff like set some variables, maybe display another dialog
                     }
             }); 
              	 adb.show();
              	 }

    	 }); 
            
	  }
	
	 public static CharSequence gettoDoItems()
	 {
		 if (todoItems != null)
		 {
			 String size = Integer.toString(todoItems.size());
			 return size;
		 }
		 
		 return "0";
	 }
	
	 protected void onResume() {
		 super.onResume();
		    // Get the activity preferences object.
		    SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);

		// Read the UI state values, specifying default values.
		// Clean UP the Preference File
		//  SharedPreferences.Editor editor = settings.edit();
		//  Add the UI state preference values.
		//   editor.clear();
		// 	editor.commit();    
		    String[] newList= settings.getString("list", "nada").split(",");
			if (settings.getAll().size()!=0)
			{
					for (int i=0;i<newList.length;i++)
					{
						if (newList[i].startsWith(" ", 0))
						{
							newList[i] = newList[i].replaceFirst(" ", "");
						}
						if (!todoItems.contains(newList[i]))
							todoItems.add(newList[i]);
					}
			}
		  }
}
