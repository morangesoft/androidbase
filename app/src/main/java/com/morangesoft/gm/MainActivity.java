package com.morangesoft.gm;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;
import com.morangesoft.gm.general.TheApp;
import com.morangesoft.gm.models.Cliente;
import com.morangesoft.gm.ui.clientes.ClienteEditDialog;
import com.morangesoft.gm.ui.clientes.ClientesFragment;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private TheApp theapp = TheApp.getInstance();

    private AppBarConfiguration mAppBarConfiguration;
    private int moduleIndex=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (moduleIndex){
                    case 0:
                        Toast.makeText(getApplicationContext(),"Usuarios",Toast.LENGTH_SHORT).show();
                        break;
                    case 1://Clientes
                        //Toast.makeText(getApplicationContext(),"Clientes",Toast.LENGTH_SHORT).show();
                        ClienteEditDialog dlg = new ClienteEditDialog();
                        dlg.onGuardarClick = new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Cliente clie = (Cliente)v.getTag();
                                System.out.println(clie.toString());
                            }
                        };
                        dlg.show(getSupportFragmentManager(),"clieadd");
                        break;
                    case 2:
                        Toast.makeText(getApplicationContext(),"Productos",Toast.LENGTH_SHORT).show();
                        break;
                }
//                Snackbar.make(view, theapp.currentMdl, Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_usuario, R.id.nav_cliente, R.id.nav_productos)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        MenuItem mnuusuario = navigationView.getMenu().findItem(R.id.nav_usuario);
        mnuusuario.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                theapp.currentMdl = item.getTitle().toString();
                moduleIndex = 0;
                return false;
            }
        });
        MenuItem mnucliente = navigationView.getMenu().findItem(R.id.nav_cliente);
        mnucliente.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                theapp.currentMdl = item.getTitle().toString();
                moduleIndex = 1;
                return false;
            }
        });
        MenuItem mnuproductos = navigationView.getMenu().findItem(R.id.nav_productos);
        mnuproductos.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                moduleIndex = 2;
                theapp.currentMdl = item.getTitle().toString();
                return false;
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
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    private void startAppVars(){

    }
}