package com.example.cameraexample.adapter

import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.cameraexample.R

class GalleryAdapter(private val filePathsList: List<String>) :
    RecyclerView.Adapter<GalleryAdapter.GalleryViewHolder>() {

    class GalleryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val photoIv: ImageView = itemView.findViewById(R.id.gallery_item_iv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryViewHolder {
        return GalleryViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.gallery_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: GalleryViewHolder, position: Int) {
        val photo = BitmapFactory.decodeFile(filePathsList[position])
        holder.photoIv.setImageBitmap(photo)
    }

    override fun getItemCount(): Int = filePathsList.size

}