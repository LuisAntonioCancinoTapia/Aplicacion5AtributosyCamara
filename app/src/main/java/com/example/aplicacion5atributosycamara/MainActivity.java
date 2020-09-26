package com.example.aplicacion5atributosycamara;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText nombres,apellidos,emails,celulars,direccions;

    public static final int CAMERA_PIC_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombres=(EditText)findViewById(R.id.txt_nombres);
        apellidos=(EditText)findViewById(R.id.txt_apellidos);
        emails=(EditText)findViewById(R.id.txt_email);
        celulars=(EditText)findViewById(R.id.txt_celular);
        direccions=(EditText)findViewById(R.id.txt_direccion);

        ((Button)findViewById(R.id.btn_camara)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent,CAMERA_PIC_REQUEST);
            }
        });
    }

    public boolean validarNombre(){
        String user = nombres.getText().toString();
        if(user.isEmpty())return false;
        return true;
    }
    public boolean validarApellido(){
        String user = apellidos.getText().toString();
        if(user.isEmpty())return false;
        return true;
    }
    public boolean validarEmail(){
        String user = emails.getText().toString();
        if(user.isEmpty())return false;
        return true;
    }
    public boolean validarCelular(){
        String user = celulars.getText().toString();
        if(user.isEmpty())return false;
        return true;
    }
    public boolean validarDireccion(){
        String user = direccions.getText().toString();
        if(user.isEmpty())return false;
        return true;
    }

    public void validar(View v){
        if (!validarNombre()) nombres.setError("Nombre en blanco");
        if (!validarApellido()) apellidos.setError("Apellido en blanco");
        if (!validarEmail()) emails.setError("Email en blanco");
        if (!validarCelular()) celulars.setError("Celular en blanco");
        if (!validarDireccion()) direccions.setError("Direccion en blanco");
    }

    @Override
    protected void onActivityResult(int requesCode, int resultCode, Intent data){
        super.onActivityResult(requesCode,resultCode,data);
        if(requesCode == CAMERA_PIC_REQUEST){
            if(resultCode == RESULT_OK){
                Bitmap bitmap = (Bitmap)data.getExtras().get("data");
                ImageView iv_foto = (ImageView)findViewById(R.id.iv_picture);
                iv_foto.setImageBitmap(bitmap);
                Toast.makeText(this,"Foto capturada",Toast.LENGTH_LONG).show();
            }
        }

    }
}


