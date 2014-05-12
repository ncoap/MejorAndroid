package com.mejorando;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

public class Dialogo extends DialogFragment {

	DialogoListener listener;

	// cuando se relaciona con la actividad que la llama
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		try {
			listener = (DialogoListener) activity;
		} catch (Exception e) {
		}
	}

	// cuando se crea el dialogo
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		builder.setTitle("Titulo Personalizado")
				.setSingleChoiceItems(R.array.dialog_options, 0, null)
				.setPositiveButton(R.string.msg_yes,
						new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								listener.onDialogPositiveClick(Dialogo.this);
							}
						})
				.setNegativeButton(R.string.msg_no,
						new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								listener.onDialogNegativeClick(Dialogo.this);
							}
						});
		return builder.create();
	}
}
