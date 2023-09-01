package com.laapp.learnsql;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MainActivity extends AppCompatActivity {

    TextView submit;
    EditText tv1,tv2,tv3;



    Connection con=null;
    String ip="192.168.0.105";
    String port="56761";
    String Classes = "net.sourceforge.jtds.jdbc.Driver";
    String database = "student";
    String username="root";
    String password="root";
    String url = "jdbc:jtds:sqlserver://"+ip+":"+port+"/"+database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tv1=findViewById(R.id.name);
        tv2=findViewById(R.id.address);
        tv3=findViewById(R.id.phone);
        submit=findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Connection con= ConnectionClass1();
                try {
                    if(con!=null)
                    {
                        String n=tv1.getText().toString();
                        String a=tv2.getText().toString();
                        String p=tv3.getText().toString();
                        String query="DECLARE @STAT VARCHAR(500)\n" +
                                "EXEC dbo.TestProc @COUNTRY_CODE = 'afg',\n" +
                                "\t\t@STATUS = @STAT OUTPUT\n" +
                                "SELECT @STAT";
                        Statement st=con.createStatement();
                        ResultSet rs=st.executeQuery(query);

                        while (rs.next()) {

                            String s1=rs.getString(1);
                            Toast.makeText(MainActivity.this, s1, Toast.LENGTH_SHORT).show();
                        }
                        con.close();
                  //      Toast.makeText(MainActivity.this, "Sucessfully Inserted into the  database", Toast.LENGTH_SHORT).show();
                    }
                }
                catch (Exception e) {
                    Log.e("Error1",e.getMessage());
                }
            }
        });


    }

@SuppressLint("NewApi")
    public Connection ConnectionClass()
    {
        Connection con=null;
        String ip="192.168.0.105";
        String port="56761";
        String Classes = "net.sourceforge.jtds.jdbc.Driver";
        String database = "student";
        String username="root";
        String password="root";
        String url = "jdbc:jtds:sqlserver://"+ip+":"+port+"/"+database;


        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        try {

            Class.forName("net.sourceforge.jtds.jdbc.Driver");
        //    String connectionUrl = "jdbc:jtds:sqlserver://" + ip + ":" + port + ";databasename=" + databasename + ";User=" + username + ";password=" + password + ";";
            con = DriverManager.getConnection(url,username,password);
            Toast.makeText(this, "T4", Toast.LENGTH_SHORT).show();
            Log.e("Connection","open");
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
            Toast.makeText(this, "Class fail", Toast.LENGTH_SHORT).show();
        } catch (SQLException e) {
            e.printStackTrace();
            Toast.makeText(this, "Connected no", Toast.LENGTH_SHORT).show();
        }
        return con;
    }


    @SuppressLint("NewApi")
    public Connection ConnectionClass1()
    {
        Connection con=null;
        String ip="162.222.225.88";
        String port="1433";
        String Classes = "net.sourceforge.jtds.jdbc.Driver";
        String database = "LAAPP";
        String username="LAAPP";
        String password="laapp@2023";
        String url = "jdbc:jtds:sqlserver://"+ip+":"+port+"/"+database;


        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        try {

            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            //    String connectionUrl = "jdbc:jtds:sqlserver://" + ip + ":" + port + ";databasename=" + databasename + ";User=" + username + ";password=" + password + ";";
            con = DriverManager.getConnection(url,username,password);
            Toast.makeText(this, "T4", Toast.LENGTH_SHORT).show();
            Log.e("Connection Success","open");
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
            Toast.makeText(this, "Class fail", Toast.LENGTH_SHORT).show();
        } catch (SQLException e) {
            e.printStackTrace();
            Toast.makeText(this, "Connected no", Toast.LENGTH_SHORT).show();
        }






        return con;
    }




    public Connection start() {

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        try {
            Class.forName(Classes);
            con = DriverManager.getConnection(url, username,password);
            Toast.makeText(this, "Connected", Toast.LENGTH_SHORT).show();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            Toast.makeText(this, "Class fail", Toast.LENGTH_SHORT).show();
        } catch (SQLException e) {
            e.printStackTrace();
            Toast.makeText(this, "Connected no", Toast.LENGTH_SHORT).show();
        }
        return con;
    }

}