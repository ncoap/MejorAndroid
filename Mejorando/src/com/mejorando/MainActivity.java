package com.mejorando;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {
	private boolean favorite = false;
	private String msj_estado = "";
	private static final ArrayList<String> lista_usuarios = new ArrayList<String>();
	private TextView tv_mensaje;

	public void toggleClicked(View v) {
		Log.e("TAG", "toggle");
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final EditText et_usuario = (EditText) findViewById(R.id.et_usuario);
		ListView lv_usuario = (ListView) findViewById(R.id.lv_usuario);
		Button bt_enviar = (Button) findViewById(R.id.bt_enviar);

		final ArrayAdapter<String> adapter = new ArrayAdapter<String>(
				getApplicationContext(), android.R.layout.simple_list_item_1,
				lista_usuarios);

		lv_usuario.setAdapter(adapter);
		bt_enviar.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				String usuario = et_usuario.getText().toString();
				lista_usuarios.add(usuario);
				adapter.notifyDataSetChanged();
			}
		});

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
