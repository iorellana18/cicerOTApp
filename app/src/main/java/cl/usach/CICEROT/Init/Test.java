package cl.usach.CICEROT.Init;

/**
 * Created by Ian on 01-12-2016.
 */
        import android.app.ProgressDialog;
        import android.content.Intent;
        import android.database.Cursor;
        import android.graphics.Bitmap;
        import android.graphics.BitmapFactory;
        import android.net.Uri;
        import android.os.Bundle;
        import android.os.Environment;
        import android.provider.MediaStore;
        import android.support.annotation.NonNull;
        import android.support.design.widget.CoordinatorLayout;
        import android.support.design.widget.FloatingActionButton;
        import android.support.v7.app.AppCompatActivity;
        import android.support.v7.widget.AppCompatImageView;
        import android.support.v7.widget.Toolbar;
        import android.util.Log;
        import android.view.View;
        import android.widget.ImageView;

        import com.google.android.gms.tasks.OnFailureListener;
        import com.google.android.gms.tasks.OnSuccessListener;
        import com.google.firebase.storage.FileDownloadTask;
        import com.google.firebase.storage.FirebaseStorage;
        import com.google.firebase.storage.StorageReference;
        import com.google.firebase.storage.UploadTask;

        import java.io.File;
        import java.io.FileOutputStream;
        import java.io.IOException;

        import cl.usach.CICEROT.Main.Adapter;
        import cl.usach.CICEROT.R;

public class Test extends AppCompatActivity implements View.OnClickListener {

    private static final int SELECT_PICTURE = 100;

    CoordinatorLayout coordinatorLayout;
    FloatingActionButton btnSelectImage;
    ImageView imgView;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pruebas);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinatorLayout);
        btnSelectImage = (FloatingActionButton) findViewById(R.id.btnSelectImage);
        imgView = (ImageView) findViewById(R.id.imgView);


        String link = getIntent().getStringExtra("imagen");
        Bitmap bitmap = BitmapFactory.decodeFile(link);
        imgView.setImageBitmap(bitmap);
        btnSelectImage.setOnClickListener(this);

    }


    void openImageChooser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), SELECT_PICTURE);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if (requestCode == SELECT_PICTURE) {
                // Obtener dato
                Uri selectedImageUri = data.getData();
                if (null != selectedImageUri) {
                    // Obtener el path de la uri
                    String path = ImageFilePath.getPath(getApplicationContext(), selectedImageUri);
                    Log.i("Wats", "Image Path : " + path);
                    System.out.println(selectedImageUri);

                    final String nombre = getIntent().getStringExtra("nombre");
                    FirebaseStorage storage = FirebaseStorage.getInstance();

                    StorageReference storageRef = storage.getReferenceFromUrl("gs://chatito-eff08.appspot.com/perfil");
                    final StorageReference riversRef = storageRef.child(nombre.toLowerCase()+".jpg");
                    UploadTask uploadTask = riversRef.putFile(selectedImageUri);


                    imgView.setImageURI(Uri.fromFile(new File(path)));
                    ProgressDialog.show(Test.this, "Cargando foto", "Por favor, espere un momento...");
                    uploadTask.addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception exception) {
                        }
                    }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            FirebaseStorage storage = FirebaseStorage.getInstance();
                            StorageReference storageRef = storage.getReferenceFromUrl("gs://chatito-eff08.appspot.com/perfil").child(nombre.toLowerCase()+".jpg");

                            try {
                                final File localFile = File.createTempFile("images", "jpg");
                                storageRef.getFile(localFile).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                                    @Override
                                    public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                                        System.out.println(localFile.getAbsolutePath());
                                        Intent intent = new Intent(Test.this, Adapter.class);
                                        intent.putExtra("link",localFile.getAbsolutePath());
                                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);//elimina anteriores activities
                                        startActivity(intent);
                                        finish();
                                    }
                                }).addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception exception) {
                                    }
                                });
                            } catch (IOException e ) {
                                System.out.println(e);
                            }
                        }
                    });
                }
            }
        }
    }


    public String getPathFromURI(Uri contentUri) {
        String res = null;
        String[] proj = {MediaStore.Images.Media.DATA};
        Cursor cursor = getContentResolver().query(contentUri, proj, null, null, null);
        if (cursor.moveToFirst()) {
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            res = cursor.getString(column_index);
        }
        cursor.close();
        return res;
    }

    @Override
    public void onClick(View v) {
        openImageChooser();
    }
}