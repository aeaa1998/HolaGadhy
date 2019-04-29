package com.partners.laboratorio5.Model
class Product{
    private var name = ""
    private var code = ""

    fun getName(): String {
        return name
    }

    fun getCode(): String {
        return code
    }

    fun setName(name: String) {
        this.name = name
    }

    fun setCode( code: String) {
        this.code = code
    }
}