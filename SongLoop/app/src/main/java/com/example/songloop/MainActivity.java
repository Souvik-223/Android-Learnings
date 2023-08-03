package com.example.songloop;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import java.io.File;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    ListView listview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listview = findViewById(R.id.listview);
        setContentView(R.layout.activity_main);
        Dexter.withContext(this)
                .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                .withListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                        ArrayList<File> mysongs = fetchsongs(Environment.getExternalStorageDirectory());
                        String[] items = new String[mysongs.size()];
                                for(int i=0; i< mysongs.size(); i++){
                                    items[i] = mysongs.get(i).getName().replace(".mp3","");
                                }

                        ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, items);
                                listview.setAdapter(adapter);
                                listview.setOnItemClickListener(new AdapterView.OnItemClickListener(){
                                    @Override
                                    public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                                        Intent intent = new Intent(MainActivity.this, playSong.class);
                                        String currentSong = listview.getItemAtPosition(position).toString();
                                        intent.putExtra("songList" , mysongs);
                                        intent.putExtra("currentSong" , currentSong);
                                        intent.putExtra("Position" , position);
                                        startActivity(intent);
                                    }
                                });
                    }

                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {

                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                        permissionToken.continuePermissionRequest();
                    }
                })
                .check();
    }
    public ArrayList<File> fetchsongs(File file){
        ArrayList<File> arrayList = new ArrayList<>();
            File[] songs = file.listFiles();
            if (songs != null){
                for(File myFile: songs){
                    if(!myFile.isHidden() && myFile.isDirectory()){
                        arrayList.addAll(fetchsongs(myFile));
                    }
                    else{
                        if(myFile.getName().endsWith(".mp3") && !myFile.getName().startsWith(".")){
                            arrayList.add(myFile);
                        }
                    }
                }
            }
            return arrayList;
    }

}