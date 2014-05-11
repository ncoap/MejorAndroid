package com.mejorando;


import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class DetalleActivity extends FragmentActivity {
	private boolean favorite = false;
	
	public void toggleClicked(View v) {
		Log.e("TAG", "toggle");
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detalle);
		Intent i =  getIntent();
		String nombre = i.getStringExtra("nombre");
		Fragmento frag= (Fragmento)getSupportFragmentManager().findFragmentById(R.id.fragment_1);
		frag.setNombre(nombre);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.action_fav:
			Drawable icon = null;
			if (favorite) {
				icon = getResources().getDrawable(
						R.drawable.rating_not_important);
			} else {
				icon = getResources().getDrawable(R.drawable.rating_important);
			}
			favorite = !favorite;
			item.setIcon(icon);
			return true;
		case R.id.action_share:
			Intent share = new Intent();
			share.setAction(Intent.ACTION_SEND);
			String msg = getResources().getString(R.string.msg_share);
			share.putExtra(Intent.EXTRA_TEXT, msg);
			Uri img_res = Uri.parse("android.resource://" + getPackageName()
					+ "/drawable/" + R.drawable.hotel1);
			share.putExtra(Intent.EXTRA_STREAM, img_res);
			share.setType("image/jpeg");
			startActivity(Intent.createChooser(share, "Compartir"));
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

}
