package com.example.taisacco

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
//import com.example.taisacco.in
import com.example.taisacco.databinding.FragmentMyAccountBinding
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import java.util.*


/**
 * A simple [Fragment] subclass.
 */
class MyAccount : Fragment() {
    private lateinit var binding: FragmentMyAccountBinding
    private val REQUEST_IMAGE_GET = 1

    //Uri to Store Selected Image
    private lateinit var selectedImageUri: Uri

    //Storage and Firestore

    private lateinit var mStorage: FirebaseStorage
    private lateinit var mdb : FirebaseFirestore

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_my_account, container, false)

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_my_account,
            container,
            false
        )
        mStorage = FirebaseStorage.getInstance()
        mdb = FirebaseFirestore.getInstance()

        binding.edit.setOnClickListener {
            selectImage()
        }

        binding.save.setOnClickListener {
            uploadProductImage()

        }
        return binding.root
    }

    //function to select image
    private fun selectImage() {
        val intent = Intent(Intent.ACTION_GET_CONTENT).apply {
            type = "image/*"
        }
        if (intent.resolveActivity(requireActivity().packageManager) != null) {
            startActivityForResult(intent, REQUEST_IMAGE_GET)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_IMAGE_GET && resultCode == Activity.RESULT_OK) {

            val fullPhotoUri: Uri = data!!.data!!
            selectedImageUri = fullPhotoUri

            //displaying the selected image
            Glide.with(requireContext().applicationContext)
                .load(selectedImageUri)
                .into(binding.image)

        }
    }

    //Function to Upload Image
    private fun uploadProductImage() {
        //getting the image name that will be used to store it. eg farm_1.jpeg
//        val imageName = selectedImageUri
        val imageName = "uploads/" + binding.editText.text + "@" + UUID.randomUUID().toString()
        Log.i("george", "This is the selected Image URL. $selectedImageUri")
        //storage location of image with the image name

        val productImageRef = mStorage.reference
            .child("$imageName")
//            .child("uplands/" +binding.editText.text+"@"+ UUID.randomUUID().toString())
        //task to upload the selected image url to the specific location
        val uploadTask = productImageRef.putFile(selectedImageUri)

        //task to get the imageUrl of the uploaded image
        val urlTask = uploadTask.continueWithTask { task ->
            if (!task.isSuccessful) {
                Log.i("chei", "failed")
                task.exception?.let {
                    throw it

                }
            }
            productImageRef.downloadUrl
        }.addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val downloadUri = task.result

                saveImageToFirestore(downloadUri)

                Log.i("chei", "works")
                Log.i("chei", downloadUri.toString())
            }
        }
    }

    private fun saveImageToFirestore(downloadUri: Uri?) {
        val imageName = selectedImageUri.lastPathSegment

        val uploadedImage = info(
            imageName!!,
            downloadUri.toString()
        )

        //reference to store the image to firestore
        //val imageRef = mdb.getReference("uplands").child("images")
        val imageRef = mdb.collection("uplands")
        imageRef.add(uploadedImage).addOnSuccessListener { documentReference ->
            Log.i("chei","added success")
        }
            .addOnFailureListener { e ->
                Log.i("chei","added error")
            }
        //val key=imageRef.push().key
//        imageRef.child(key!!).setValue(uploadedImage).addOnSuccessListener {
//            Toast.makeText(requireContext().applicationContext, "$imageName Added Successfully", Toast.LENGTH_SHORT).show()
//        }.addOnFailureListener {
//            Toast.makeText(requireContext().applicationContext, "$imageName Storage to database Failed: ${it.localizedMessage}", Toast.LENGTH_SHORT).show()
//        }

    }

}
//    private fun saveImageToFirestore(downloadUri: Uri?) {
//        val imageName = selectedImageUri.lastPathSegment
//
//        val uploadedImage = info(
//            imageName!!,
//            downloadUri.toString()
//        )
//
//        //reference to store the image to firestore
//        val imageRef = mdb.getReference("uplands").child("images")
//        val key = imageRef.push().key
//        imageRef.child(key!!).setValue(uploadedImage).addOnSuccessListener {
//            Toast.makeText(
//                requireContext().applicationContext,
//                "$imageName Added Successfully",
//                Toast.LENGTH_SHORT
//            ).show()
//        }.addOnFailureListener {
//            Toast.makeText(
//                requireContext().applicationContext,
//                "$imageName Storage to database Failed: ${it.localizedMessage}",
//                Toast.LENGTH_SHORT
//            ).show()
//        }
//
//    }
//}

