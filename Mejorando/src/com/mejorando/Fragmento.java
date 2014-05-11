package com.mejorando;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Fragmento extends Fragment {

	TextView tv_fragment_nombre;

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		View view = inflater.inflate(R.layout.fragmento, null);
		tv_fragment_nombre = (TextView)view.findViewById(R.id.tv_fragment_nombre);
		return view;
	}
	
	public void setNombre(String nombre){
		if(nombre!=null){	
			tv_fragment_nombre.setText(nombre);
		}
	}
	
}