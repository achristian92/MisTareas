package apps.construyendo.mistareas.Presenter.View.activity;



import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;


import apps.construyendo.mistareas.Presenter.Model.Tareas;
import apps.construyendo.mistareas.Presenter.View.fragment.Tareas_Detalle_fragment;
import apps.construyendo.mistareas.R;

public class Detalle_TareasActivity extends AppCompatActivity{

    public static final  String EXTRA_NOTICIA="activity.noticiadetalle.EXTRA_NOTICIA";



   // private int mYear, mMonth, mDay, mHour, mMinute;


   /* @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);   ---------------------- PARA QUE NO MUESTRE EN EL HINT EL TEXTO
        setContentView(R.layout.activity_detalle__tareas);
    }*/
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Tareas tareas=getIntent().getParcelableExtra(EXTRA_NOTICIA);

        FragmentTransaction ft=getSupportFragmentManager().beginTransaction();//iniciar una transaccion
        ft.add(android.R.id.content, new Tareas_Detalle_fragment().newInstance(tareas));
        ft.commit();
    }

}
/*
 @Override
    public void onClick(View v) {
        if (v == edit_fecha) {
            // Get Current Date
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {

                            edit_fecha.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);

                        }
                    }, mYear, mMonth, mDay);
            datePickerDialog.show();
        }
        if (v == edit_hora) {

            // Get Current Time
            final Calendar c = Calendar.getInstance();
            mHour = c.get(Calendar.HOUR_OF_DAY);
            mMinute = c.get(Calendar.MINUTE);

            // Launch Time Picker Dialog
            TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                    new TimePickerDialog.OnTimeSetListener() {

                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay,
                                              int minute) {

                            edit_hora.setText(hourOfDay + ":" + minute);
                        }
                    }, mHour, mMinute, false);
            timePickerDialog.show();
        }
        if(aSwitch.isChecked()){
            Toast.makeText(this, "verdadero", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "false", Toast.LENGTH_SHORT).show();
        }
    }
*/