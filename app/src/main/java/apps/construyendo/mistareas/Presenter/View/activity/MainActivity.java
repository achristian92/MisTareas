package apps.construyendo.mistareas.Presenter.View.activity;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import apps.construyendo.mistareas.Presenter.Model.Tareas;
import apps.construyendo.mistareas.Presenter.View.fragment.Tareas_Detalle_fragment;
import apps.construyendo.mistareas.Presenter.View.fragment.Tareas_fragment;
import apps.construyendo.mistareas.R;

public class MainActivity extends AppCompatActivity implements Tareas_fragment.onTareasClickListerner {
    Toolbar toolbar;

    //si es tablet
    private boolean isDualPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar=findViewById(R.id.toolbar_princi);


        showToolbar("Mis Tareas",false);

        Fragment tareadetallefragment=getSupportFragmentManager().findFragmentById(R.id.frag_tareas_detalle);
        isDualPane = tareadetallefragment!=null;

    }
    public void showToolbar(String titulo, boolean upButton){
        //toolbar.setTitle(R.string.crear_usu);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(titulo);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }


    @Override
    public void onTareaClick(Tareas tareas) {
        if(!isDualPane){
            //si es telefono
            Intent intent = new Intent(MainActivity.this, Detalle_TareasActivity.class);
            intent.putExtra(Detalle_TareasActivity.EXTRA_NOTICIA, tareas);
            startActivity(intent);
        }else{
            //si es tablet
            Tareas_Detalle_fragment tareas_detalle_fragment= (Tareas_Detalle_fragment) getSupportFragmentManager().findFragmentById(R.id.frag_tareas_detalle);
            tareas_detalle_fragment.setTareas(tareas);
        }

    }

    @Override
    public void onAgregarTareasCkick() {
        Intent intent=new Intent(MainActivity.this,Detalle_TareasActivity.class);
        startActivity(intent);
    }
}
