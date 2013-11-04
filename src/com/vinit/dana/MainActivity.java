package com.vinit.dana;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private static final int REQUEST_CODE = 1111;
	private static final int PICK_PHOTO_CODE = 1234;
	
	private String photoUri;
	private ImageView ivGalleryImage;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ivGalleryImage = (ImageView)findViewById(R.id.ivGalleryImage);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	// PICK_PHOTO_CODE is a constant integer
	public void onPickPhoto(View view) {
	    Intent intent = new Intent(Intent.ACTION_PICK,
	        MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
	    startActivityForResult(intent, PICK_PHOTO_CODE);
	}
	
	// Used to retrieve the actual filesystem URI based on the media store result
	private String getFileUri(Uri mediaStoreUri) {
			String[] filePathColumn = { MediaStore.Images.Media.DATA };
	    Cursor cursor = this.getContentResolver().query(mediaStoreUri,
	            filePathColumn, null, null, null);
	    cursor.moveToFirst();
	    int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
	    String fileUri = cursor.getString(columnIndex);
	    cursor.close();
	    
	    return fileUri;
	}
	
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
	   if (requestCode == PICK_PHOTO_CODE) {
	      photoUri = getFileUri(data.getData());
	      // do something to the photo
	      Bitmap selectedImage = BitmapFactory.decodeFile(photoUri);
	      Toast.makeText(getBaseContext(), "It is: "+photoUri, Toast.LENGTH_SHORT).show();
	      ivGalleryImage.setImageBitmap(selectedImage);
	   }
	}
	
	public void onLaunchEvents(View v){
		Intent i = new Intent(this, EventsActivity.class);
   	 	startActivity(i);
	}
}
