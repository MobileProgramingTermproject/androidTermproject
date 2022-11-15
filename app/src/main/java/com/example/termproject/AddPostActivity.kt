//package com.example.termproject
//
//import android.content.ContentUris
//import android.graphics.BitmapFactory
//import android.os.Bundle
//import android.provider.MediaStore
//import android.widget.ImageView
//import androidx.appcompat.app.AlertDialog
//import androidx.appcompat.app.AppCompatActivity
//import com.google.android.material.snackbar.Snackbar
//import com.google.firebase.auth.ktx.auth
//import com.google.firebase.ktx.Firebase
//import com.google.firebase.storage.FirebaseStorage
//import com.google.firebase.storage.StorageReference
//import com.google.firebase.storage.ktx.storage
//import kotlin.collections.EmptyList.size
//import kotlin.collections.EmptyMap.size
//
//class AddPostActivity : AppCompatActivity() {
//    lateinit var storage: FirebaseStorage
//    lateinit var binding: ActivityStorageBinding
//
//    companion object {
//        const val REQUEST_CODE = 1
//        const val UPLOAD_FOLDER = "upload_images/"
//    }
//
//    override fun onCreate(savedInstanceState: Bundle?){
//        super.onCreate(savedInstanceState)
//        binding = ActivityStorageBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        Firebase.auth.currentUser ?: finish()
//
//        storage = Firebase.storage
//
//        val storageRef = storage.reference
//        val imageRef1 = storageRef.child("images/computer_sangsangbugi.jpg")
//    }
//
//    private fun displayImageRef(imageRef: StorageReference?, view: ImageView){
//        imageRef?.getBytes(Long.MAX_VALUE)?.addOnSuccessListener {
//            val bmp = BitmapFactory.decodeByteArray(it,0,size)
//            view.setImageBitmap(bmp)
//        }?.addOnFailureListener{
//            //Failed to download the image
//        }
//    }
//
//    private fun uploadFile(file_id: Long, fileName: String){
//        val imageRef = storage.reference.child("${UPLOAD_FOLDER}${fileName}")
//        val contentUri = ContentUris.withAppendedId(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,file_id)
//        imageRef.putFile(contentUri).addOnCompleteListener{
//            if(it.isSuccessful){
//                Snackbar.make(binding.root,"Upload completed.",Snackbar.LENGTH_SHORT).show()
//            }
//        }
//    }
//
//    private fun listPhotosDialog(){
//        storage.reference.child(UPLOAD_FOLDER).listAll().addOnSuccessListener {
//            val itemsString = mutableListOf<String>()
//            for(i in it.items){
//                itemsString.add(i.name)
//            }
//            AlertDialog.Builder(this).setTitle("Uploaded Photos").setItems(itemsString.toTypedArray(),{_,i->}).show()
//        }
//    }
//}