package com.partners.laboratorio5.Model

class Row {
    private var product: Product? = null
    private var quantity = 0

    init {
        product = Product()
    }

    fun getProduct() : Product {
        return product!!
    }

    fun getQuantity(): Int {
        return quantity
    }

    fun setQuantity(p: Int) {
        this.quantity = p
    }
    fun setProduct(p: Product) {
        this.product = product
    }

}