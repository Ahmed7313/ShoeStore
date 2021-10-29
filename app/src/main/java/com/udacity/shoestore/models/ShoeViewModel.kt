package com.udacity.shoestore.models

import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoeViewModel : ViewModel() {

    private val _shoeList = MutableLiveData<MutableList<Shoe>>()
    val shoeList:LiveData<MutableList<Shoe>>
    get() = _shoeList

    private val _eventSaveShoeDetailPress = MutableLiveData(false)
    val eventSaveShoeDetailPress: LiveData<Boolean>
        get() = _eventSaveShoeDetailPress

    var shoe = Shoe(
        "a",
        "0",
        "b",
        "c"
    )

    fun addShoe(name: String, size: String, company: String, description: String) {
         shoe= Shoe(name, size, company, description)
        _shoeList.addNewItem(shoe)

    }

    fun addShoeTest (){
        _shoeList.addNewItem(shoe)
        _eventSaveShoeDetailPress.value = true
    }

    fun bindShoetoView(name: TextView, size: TextView, company: TextView, description: TextView, shoe: Shoe) {
        name.text = shoe.name
        size.text = shoe.size
        company.text = shoe.company
        description.text = shoe.description
    }

    fun <T> MutableLiveData<MutableList<T>>.addNewItem(item: T) {
        val oldValue = this.value ?: mutableListOf()
        oldValue.add(item)
        this.value = oldValue
    }

    fun saveShoeDetailComplete() {
        _eventSaveShoeDetailPress.value = false
    }
}