package com.example.didact.u2_controles_ej20_actividadceckboxyradiogroup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox cb_sopa, cb_ensalada, cb_nachos, cb_carne, cb_pescado;
    RadioGroup rg_sino;
    Spinner sp_provincias, sp_bebidas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cb_sopa= (CheckBox)findViewById(R.id.cb_sopa);
        cb_ensalada= (CheckBox)findViewById(R.id.cb_ensalada);
        cb_nachos= (CheckBox)findViewById(R.id.cb_nachos);
        cb_carne= (CheckBox)findViewById(R.id.cb_carne);
        cb_pescado= (CheckBox)findViewById(R.id.cb_pescado);
        rg_sino= (RadioGroup)findViewById(R.id.rg_sino);
        sp_provincias= (Spinner)findViewById(R.id.sp_provincias);
        sp_bebidas= (Spinner)findViewById(R.id.sp_bebidas);

        //Spinner bebidas
        String [] bebidas = {"Cocacola","Fanta","Sprite","Neztea","Zumo","Agua","Vino"};

        ArrayAdapter<String> adaptador1 = new ArrayAdapter<String>(this,
                android.R.layout.simple_expandable_list_item_1,bebidas);

        sp_bebidas.setAdapter(adaptador1);

        //Spinner provincias
        String [] provincias = {"Cádiz", "Mñaga","Almeria","Cordoba"};

        ArrayAdapter<String> adaptador2 = new ArrayAdapter<String>(this,
                android.R.layout.simple_expandable_list_item_1,provincias);

        sp_provincias.setAdapter(adaptador2);

    } //FIN onCreate

    //Metodo onClick VerPedido, tanto los ChackBox como el RadioGroup van dentro del onClick.
    public void VerPedido (View view){

        //Elementos checkeados
        String preferencias="";
        if (cb_sopa.isChecked()){
            preferencias+="Sopa ";
        }
        if (cb_ensalada.isChecked()){
            preferencias+="Ensalada ";
        }
        if (cb_nachos.isChecked()){
            preferencias+="Nachos ";
        }
        if (cb_carne.isChecked()){
            preferencias+="Carne ";
        }
        if (cb_pescado.isChecked()){
            preferencias+="Pescado ";
        }

        //Elemento RadioGroup
        int id=rg_sino.getCheckedRadioButtonId();

        RadioButton rbSeleccionado = (RadioButton)findViewById(id);
        String textoRbSeleccionado = rbSeleccionado.getText().toString();

        //String de spinner de bebidas
        String bebidaSeleccionada = sp_bebidas.getSelectedItem().toString();

        Toast.makeText(getApplicationContext(), "Tu Pedido es: "+preferencias+textoRbSeleccionado+" bebida seleccionada:"+bebidaSeleccionada,
                Toast.LENGTH_SHORT).show();





    }
    //metodo onClick del boton Seleccionar provincia
    public void provincias(View view){
        //Como obtener el valor seleccionado de un Spinner

        String provinciaSeleccionada = sp_provincias.getSelectedItem().toString();
        Toast.makeText(getApplicationContext(), "Proicnia "+provinciaSeleccionada,
                Toast.LENGTH_LONG).show();
    }


}//FIN MainActivity
