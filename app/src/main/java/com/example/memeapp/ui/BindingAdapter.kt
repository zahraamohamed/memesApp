package com.example.memeapp.ui

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.memeapp.networking.Status


@BindingAdapter(value = ["app:showWhenLoading"])
fun <T> showWhenLoading(view:View , status: Status<T>?){
    if (status is Status.Loading){
        view.visibility = View.VISIBLE
    }else{
        view.visibility = View.GONE
    }
}

@BindingAdapter(value = ["app:showWhenError"])
fun <T> showWhenError(view:View , status: Status<T>?){
    if (status is Status.Error){
        view.visibility = View.VISIBLE
    }else{
        view.visibility = View.GONE
    }
}

@BindingAdapter(value = ["app:showWhenSuccess"])
fun <T> showWhenSuccess(view:View , status: Status<T>?){
    if (status is Status.Success){
        view.visibility = View.VISIBLE
    }else{
        view.visibility = View.GONE
    }
}

@BindingAdapter(value = ["app:imgUrl"])
fun setImageFromUrl(
    view: ImageView , url: String?){
    Glide.with(view)
        .load(url).centerCrop().into(view)
}

//@BindingAdapter(value = ["app:items"])
//fun <T> setRecyclerItems(view: RecyclerView, items:List<T>?){
//    if(items != null)
//        (view.adapter as BaseAdapter<T>?)?.setItem(items)
//    else
//        (view.adapter as BaseAdapter<T>?)?.setItem(emptyList())
//
//}

