package com.udacity.shoestore.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoeViewModel : ViewModel() {

    private val _shoeList = MutableLiveData<MutableList<Shoe>>()
    val getLivedataList:LiveData<MutableList<Shoe>> get() = _shoeList


    init {
        dummyData()
    }

    fun dummyData(){
        addShoe("asdasd", "22.12", "safsdafsdf", "asfsdfsadfsdaf")
    }

    fun addShoe(name: String, size: String, company: String, description: String) {
        var shoe= Shoe(name, size, company, description)
        _shoeList.value?.add(shoe)

    }
}