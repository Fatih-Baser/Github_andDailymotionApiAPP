package com.edushare.lsizadanie.other

class ClickListener<in T> (val clickListener: (t: T) -> Unit) {
    fun onClick(t: T) = clickListener(t)
}