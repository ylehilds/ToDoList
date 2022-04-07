package com.lehidev.android;

import android.app.Activity;
import com.lehidev.android.schoolList;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class ToDoList extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ImageButton schoolButton = (ImageButton)findViewById(R.id.school);
	    schoolButton.setOnClickListener(new View.OnClickListener() {

	      @Override
	      public void onClick(View view) {
	        Intent intent = new Intent(ToDoList.this, schoolList.class);
	        startActivity(intent);
	      }
	    });
	    
	    ImageButton workButton = (ImageButton)findViewById(R.id.work);
        workButton.setOnClickListener(new View.OnClickListener() {

	      @Override
	      public void onClick(View view) {
	        Intent intent = new Intent(ToDoList.this, workList.class);
	        startActivity(intent);
	      }
	    });
	    
        ImageButton groceriesButton = (ImageButton)findViewById(R.id.groceries);     
        groceriesButton.setOnClickListener(new View.OnClickListener() {

	      @Override
	      public void onClick(View view) {
	        Intent intent = new Intent(ToDoList.this, groceriesList.class);
	        startActivity(intent);
	      }
	    });
               
        ImageButton wantsButton = (ImageButton)findViewById(R.id.wants);
        wantsButton.setOnClickListener(new View.OnClickListener() {

	      @Override
	      public void onClick(View view) {
	        Intent intent = new Intent(ToDoList.this, wantsList.class);
	        startActivity(intent);
	      }
	    });  
    }
    
    protected void onStart() {
		 super.onResume();
		    SharedPreferences settingsForSchool = getSharedPreferences(schoolList.PREFS_NAME, 0);
		    String[] newList= settingsForSchool.getString("list", "nada").split(",");
		    if (newList[0] == "nada")
		    {
		    	 TextView schoolTextView = (TextView)findViewById(R.id.schoollistsize);
		    	 schoolTextView.setText("");
				 schoolTextView.append("("+0+")");
		    }
		    else
		    {
		    	TextView schoolTextView = (TextView)findViewById(R.id.schoollistsize);
		    	 schoolTextView.setText("");
		    	schoolTextView.append("("+newList.length+")");
		    }
		    
		    SharedPreferences settings2 = getSharedPreferences(workList.PREFS_NAME, 0);
		    String[] newList2= settings2.getString("list", "nada").split(",");
		    if (newList2[0] == "nada")
		    {
		    	 TextView workTextView = (TextView)findViewById(R.id.worklistsize);
		    	 workTextView.setText("");
			     workTextView.append("("+0+")");
		    }
		    else
		    {
		    	TextView workTextView = (TextView)findViewById(R.id.worklistsize);
		    	 workTextView.setText("");
		    	workTextView.append("("+newList2.length+")");
		    }
	 		    
	        SharedPreferences settings3 = getSharedPreferences(groceriesList.PREFS_NAME, 0);
		    String[] newList3= settings3.getString("list", "nada").split(",");
	        if (newList3[0] == "nada")
	        {
	        	TextView groceriesTextView = (TextView)findViewById(R.id.grocerieslistsize);
	        	groceriesTextView.setText("");
	 	        groceriesTextView.append("("+0+")");
	        }
	        else
	        {
	        	TextView groceriesTextView = (TextView)findViewById(R.id.grocerieslistsize);
	        	groceriesTextView.setText("");
	        	groceriesTextView.append("("+newList3.length+")");
	        }
	        	        	        
	        SharedPreferences settings4 = getSharedPreferences(wantsList.PREFS_NAME, 0);
		    String[] newList4= settings4.getString("list", "nada").split(",");
		    if (newList4[0] == "nada")
		    {
		    	TextView wantsTextView = (TextView)findViewById(R.id.wantslistsize);
		    	wantsTextView.setText("");
		        wantsTextView.append("("+0+")");
		    }
		    else
		    {
		    	 TextView wantsTextView = (TextView)findViewById(R.id.wantslistsize);
		    	 wantsTextView.setText("");
			     wantsTextView.append("("+newList4.length+")");
		    }
		  }
}