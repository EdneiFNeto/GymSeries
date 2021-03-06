package com.gymseries.fragments

import android.os.Bundle
import android.view.*
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.gymseries.R
import com.gymseries.adapter.ChartAdapter
import com.gymseries.async.InsertMedia
import com.gymseries.async.ListarMedidas
import com.gymseries.model.Charts
import com.gymseries.utils.ActionBarUtils
import com.gymseries.utils.DataUtils
import com.gymseries.utils.ResourcesUtils


class ChartFragment : Fragment() {

    private lateinit var adapter: ChartAdapter
    private lateinit var charts: ArrayList<Charts>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var supportActionBar = (activity as AppCompatActivity).supportActionBar
        ActionBarUtils.title(
            supportActionBar,
            ResourcesUtils.getString(context, R.string.title_chart)
        )
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var myView =
            LayoutInflater.from(context).inflate(R.layout.layout_medidas_fragment, container, false)
        var recyclerView = myView.findViewById<RecyclerView>(R.id.recycle_view_chart)

        charts = arrayListOf()
        adapter = ChartAdapter(context, charts)
        recyclerView.adapter = adapter
        ListarMedidas(context, charts, adapter).execute()

        return myView
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {

        val item = menu.add(ResourcesUtils.getString(context, R.string.title_dialog_chart))
        item.setIcon(R.drawable.ic_edit)
        item.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS)
        item.setOnMenuItemClickListener {
            if (context != null) {

                var builder = AlertDialog.Builder(context!!)
                builder.setIcon(R.drawable.ic_edit_black)
                builder.setTitle(ResourcesUtils.getString(context, R.string.title_add_medidas))

                val myView =
                    LayoutInflater.from(context).inflate(R.layout.layout_dialog_medidas, null)
                builder.setView(myView)

                var braco = myView.findViewById<EditText>(R.id.edt_text_braco_media)
                var peito = myView.findViewById<EditText>(R.id.edt_text_peito_media)
                var cintura = myView.findViewById<EditText>(R.id.edt_text_cintura_media)
                var quadril = myView.findViewById<EditText>(R.id.edt_text_quadril_media)
                var coxa = myView.findViewById<EditText>(R.id.edt_text_coxa_media)
                var panturrilha = myView.findViewById<EditText>(R.id.edt_text_panturrilha_media)

                builder.setPositiveButton(
                    ResourcesUtils.getString(
                        context,
                        R.string.button_confirmar
                    )
                ) { dialog, _ ->

                    if (braco.text.isNotEmpty()
                        && peito.text.isNotEmpty()
                        && cintura.text.isNotEmpty()
                        && coxa.text.isNotEmpty()
                        && quadril.text.isNotEmpty()
                        && panturrilha.text.isNotEmpty()
                    ) {

                        charts.add(
                            Charts(
                                id = 0L,
                                braco = braco.text.toString(),
                                peito = peito.text.toString(),
                                cintura = cintura.text.toString(),
                                coxa = coxa.text.toString(),
                                quadril = quadril.text.toString(),
                                panturrilha = panturrilha.text.toString(),
                                data = DataUtils.getDataAtual()
                            )
                        )
                        InsertMedia(context, charts, adapter).execute()
                        dialog.dismiss()
                    } else
                        Toast.makeText(context, ResourcesUtils.getString(context, R.string.preencha_campos), Toast.LENGTH_SHORT).show()
                }

                var dialog = builder.create()
                dialog.show()
            }
            true
        }

        super.onCreateOptionsMenu(menu, inflater)
    }
}
