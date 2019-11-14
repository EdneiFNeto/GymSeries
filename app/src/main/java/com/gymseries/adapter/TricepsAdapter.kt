package com.gymseries.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gymseries.R
import com.gymseries.model.Triceps
import com.gymseries.utils.AlertDialogUtis

class  TricepsAdapter(context: Context, list: List<Triceps>) : BaseAdapter<Triceps>(context, list)

