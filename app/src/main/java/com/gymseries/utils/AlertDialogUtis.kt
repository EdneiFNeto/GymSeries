package com.gymseries.utils

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.appcompat.app.AlertDialog
import com.gymseries.R
import com.gymseries.adapter.BycipesAdapter
import com.gymseries.adapter.TricepsAdapter
import com.gymseries.model.Biceps
import com.gymseries.model.Triceps

class AlertDialogUtis {

    companion object{

        private val TAG: String?="AlertDialogUtisLog"

        fun alertDailogAddPesoNumRepeticao(context: Context, holder: BycipesAdapter.MyHolder, biceps: Biceps) {

            //exeibe dialog para opcao de treinos
            var builder = AlertDialog.Builder(context)
            builder.setIcon(R.mipmap.ic_descri_treino)
            val title = biceps.descr
            builder.setTitle(title.toUpperCase())

            val view: View = LayoutInflater.from(context).inflate(R.layout.layout_select_peso_repeticao_treino, null)
            var spinner_kg = view.findViewById<Spinner>(R.id.spinner_kg)
            var spinner_num_repeticao = view.findViewById<Spinner>(R.id.spinner_numero_repeticao)
            var button_salvar = view.findViewById<Button>(R.id.button_salvar_dialog_treino)

            var kg: String? = null
            var numRepeticao: String? = null

            spinner_num_repeticao.adapter = ArrayAdapter<String>( context, R.layout.layout_spinner_text_view, ListUtils.getPesos())
            spinner_kg.adapter = ArrayAdapter<String>(context, R.layout.layout_spinner_text_view,ListUtils.getNumerosRepeticoes())

            spinner_kg.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

                override fun onNothingSelected(parent: AdapterView<*>?) {

                }

                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                    if (parent != null) {
                        kg = parent.getItemAtPosition(position) as String
                    }
                }
            }

            spinner_num_repeticao.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

                override fun onNothingSelected(parent: AdapterView<*>?) {
                }

                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                    if (parent != null) {
                        numRepeticao = parent.getItemAtPosition(position) as String
                    }
                }
            }

            builder.setView(view)
            var dialog = builder.create()
            dialog.show()

            button_salvar.setOnClickListener{

                holder.text_kg.text = "Peso: $kg"

                holder.text_num_repeticao.text = "Nº Prepetição: $numRepeticao"

                //salva os itens no banco de triceps
                var title_item = holder.text_title_treino.text.toString()

                //salva no banco

                Log.e(TAG, "Kg: ${holder.text_kg.text}\nNº repeticao: ${holder.text_num_repeticao.text}\nTitle: ${holder.text_title_treino.text}")

                dialog.dismiss()
            }
        }

        fun alertDailogAddPesoNumRepeticao(context: Context, holder: TricepsAdapter.MyHolder, tricep: Triceps) {

            //exeibe dialog para opcao de treinos
            var builder = AlertDialog.Builder(context)
            builder.setIcon(R.mipmap.ic_descri_treino)
            val title = tricep.descr
            builder.setTitle(title.toUpperCase())

            val view: View = LayoutInflater.from(context).inflate(R.layout.layout_select_peso_repeticao_treino, null)
            var spinner_kg = view.findViewById<Spinner>(R.id.spinner_kg)
            var spinner_num_repeticao = view.findViewById<Spinner>(R.id.spinner_numero_repeticao)
            var button_salvar = view.findViewById<Button>(R.id.button_salvar_dialog_treino)

            var kg: String? = null
            var numRepeticao: String? = null

            spinner_num_repeticao.adapter = ArrayAdapter<String>( context, R.layout.layout_spinner_text_view, ListUtils.getNumerosRepeticoes())
            spinner_kg.adapter = ArrayAdapter<String>(context, R.layout.layout_spinner_text_view,ListUtils.getPesos())

            spinner_kg.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

                override fun onNothingSelected(parent: AdapterView<*>?) {

                }

                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                    if (parent != null) {
                        kg = parent.getItemAtPosition(position) as String
                    }
                }
            }

            spinner_num_repeticao.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

                override fun onNothingSelected(parent: AdapterView<*>?) {
                }

                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                    if (parent != null) {
                        numRepeticao = parent.getItemAtPosition(position) as String
                    }
                }
            }

            builder.setView(view)
            var dialog = builder.create()
            dialog.show()

            button_salvar.setOnClickListener{

                holder.text_kg.text = "Peso: $kg"

                holder.text_num_repeticao.text = "Nº Prepetição: $numRepeticao"

                //salva os itens no banco de triceps
                var title_item = holder.title_item_treino.text.toString()

                //salva no banco

                Log.e(TAG, "Kg: ${holder.text_kg.text}\nNº repeticao: ${holder.text_num_repeticao.text}\nTitle: ${holder.title_item_treino.text}")

                dialog.dismiss()


            }
        }
    }
}
