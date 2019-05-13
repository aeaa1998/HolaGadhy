package com.partners.laboratorio5.Model

class Inventary{
    public val rows: ArrayList<Row> = arrayListOf()

    override fun toString(): String {
        var totalString = ""
        for (item in rows) {
            totalString += "CODIGO: ${item.getProduct().getCode()}, CANTIDAD: ${item.getQuantity()}\n"
        }
        return totalString
    }
}