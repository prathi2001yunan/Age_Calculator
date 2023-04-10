package com.example.agcy

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.DatePicker
import android.widget.ImageButton
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.google.android.material.button.MaterialButton
import java.text.SimpleDateFormat
import java.time.Year
import java.util.*

class MainActivity2 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        var d1:Int=0
        var d2:Int=0
        var d3:Int=0
        var d4:Int=0
        var d5:Int=0
        var d6:Int=0
        var selecteddate = ""

        var but2 = findViewById<CardView>(R.id.cardView)
        var text = findViewById<TextView>(R.id.textView45)
        var text2 = findViewById<TextView>(R.id.textView4)
        var text3 = findViewById<TextView>(R.id.textView6)
        var text4 = findViewById<TextView>(R.id.textView7)
        var text5 = findViewById<TextView>(R.id.textView8)
        var text6 = findViewById<TextView>(R.id.textView9)
        var text7 = findViewById<TextView>(R.id.textView10)

        var but= findViewById<CardView>(R.id.cardView1)
        var but4 = findViewById<MaterialButton>(R.id.button3)

        val calc1 = Calendar.getInstance()
        val year = calc1.get(Calendar.YEAR)
        val month = calc1.get(Calendar.MONTH)
        val day = calc1.get(Calendar.DAY_OF_MONTH)
        but.setOnClickListener() {
            val dpd = DatePickerDialog(
                this,
                DatePickerDialog.OnDateSetListener { view: DatePicker, year: Int, month: Int, dayofmonth: Int ->

                    text.setText("" +dayofmonth+ "/" + (month+1) + "/" +year)
                    d1=dayofmonth
                    d2=month
                    d3=year
                },
                year,
                month,
                day
            )
            dpd.show()
        }
        but2.setOnClickListener{
            val dpd1 = DatePickerDialog(this,
                DatePickerDialog.OnDateSetListener { view: DatePicker, year: Int, month: Int, dayofmonth: Int ->
                    text2.setText("" + dayofmonth + "/" + (month+1) + "/" + year)
                    d4=dayofmonth
                    d5=month
                    d6=year
                    selecteddate="$dayofmonth/${month+1}/$year"
                },
                year,
                month,
                day
            )
            dpd1.show(

            )

        }

        but4.setOnClickListener{
            var sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
            var date = sdf.parse(selecteddate)
            var datehr = date.getTime()/3600000
            var datemin = date.getTime()/600000
            var datesec = date.getTime()
            var currentdate = sdf.parse(sdf.format(System.currentTimeMillis()))
            var datehr2 = (currentdate.getTime())/3600000
            var datemin2 = (currentdate.getTime())/600000
            var datesec2 = currentdate.getTime()
            var datehr3 = "${datehr2-datehr} HOURS'S"
            text6.text=datehr3
            var datemin3 = "${datemin2-datemin} MINUTE'S"
            text7.text=datemin3
            var datesec3 = "${datesec2-datesec} SECONDS'S"
            var k1=text.text.split("/")
            var k2=text2.text.split("/")
            var v1=0
            var v2=0
            var v3=0
            var y1=k1[0].toInt()
            var y2=k2[0].toInt()
            var m1=k1[1].toInt()
            var m2=k2[1].toInt()
            var d1=k1[2].toInt()
            var d2=k2[2].toInt()

            if(y1<y2){
                y1=y1+30
                m1=m1-1
            }
            if(m1<m2){
                m1=m1+12
                d1=d1-1
            }

            if(d1<d2){
                v3=d2-d1
            }
            else{
                v3=d1-d2
            }

            v1=y1-y2
            v2=m1-m2
            text3.setText("${v3}  YEARS")

            text4.setText("${v2}  MONTHS" )

            text5.setText("${v1} DAYS")

        }










        }


}


