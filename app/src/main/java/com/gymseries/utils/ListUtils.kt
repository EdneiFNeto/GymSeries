package com.gymseries.utils

class ListUtils {

    companion object {
        fun getNumerosRepeticoes(): List<String> {
            return arrayListOf("4-8", "8-10", "8-12", "8-16")
        }

        fun getPesos(): List<String> {
            var lista = ArrayList<String>();
            for (i in 1..100) {
                if (i % 2 == 0)
                    lista.add("$i Kg")
            }
            return lista
        }
    }

}
