package com.gymseries.generics

import android.content.Context
import com.gymseries.GenericsUtil
import com.gymseries.adapter.OmbroAdapter
import com.gymseries.generics.async.AsyncGererics
import com.gymseries.model.Ombro

class ListOmbroAsync(
    context: Context,
    ombros: ArrayList<Ombro>,
    ombro: Ombro,
    private val adapter: OmbroAdapter
) :
    AsyncGererics<Ombro>(
        context = context,
        lists = ombros,
        entity = ombro
    ) {

    override fun onPostExecute(result: List<Ombro>?) {
        super.onPostExecute(result)
        if (GenericsUtil<Ombro>().results(result, lists))
            adapter.notifyDataSetChanged()
    }


}
