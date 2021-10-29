package com.example.myshoestore

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    var currentShoe: Shoe? = null

    private val _shoes = MutableLiveData<List<Shoe>>()
    val shoes: LiveData<List<Shoe>>
        get() = _shoes

    private val _eventCloseScreen = MutableLiveData<Boolean>()
    val eventCloseScreen: LiveData<Boolean>
        get() = _eventCloseScreen


    //welcome
    private val _gotoWelcomeScreen= MutableLiveData<Boolean>()
    val gotoWelcomeScreen: LiveData<Boolean>
    get() = _gotoWelcomeScreen

    //instruction
    private val _gotoInstructionScreen= MutableLiveData<Boolean>()
    val gotoInstractionScreen: LiveData<Boolean>
        get() = _gotoInstructionScreen

    //shoelist
    private val _gotoShoeListScreen= MutableLiveData<Boolean>()
    val gotoshoeListScreen: LiveData<Boolean>
        get() = _gotoShoeListScreen

    fun createNewShoe() {
        currentShoe = Shoe("", 0.0, "", "")
    }

    fun close() {
        _eventCloseScreen.value = true
    }

    @SuppressLint("NullSafeMutableLiveData")
    fun onEventCloseComplete() {
        _eventCloseScreen.value = null
    }

    fun showWelcomeSreen(){
        _gotoWelcomeScreen.value=true
    }

    @SuppressLint("NullSafeMutableLiveData")
    fun onEventWelcomeScreenComplete() {
        _gotoWelcomeScreen.value = null
    }



    fun showInstractionSreen(){
        _gotoInstructionScreen.value=true
    }

    @SuppressLint("NullSafeMutableLiveData")
    fun onEventShowInstructionScreencomplete() {
        _gotoInstructionScreen.value = null
    }


    fun showShoeListSreen(){
        _gotoShoeListScreen.value=true
    }

    @SuppressLint("NullSafeMutableLiveData")
    fun onEventShowShoeListScreencomplete() {
        _gotoShoeListScreen.value = null
    }

    init {
        _shoes.value = createSampleShoes()
    }

    private fun createSampleShoes(): List<Shoe> {
        val tempShoes = mutableListOf<Shoe>()

        tempShoes.add(Shoe("Nike Runner", 39.0, "Nike", "A synthetic leather and mesh combination upper"))
        tempShoes.add(Shoe("Adidas Runner", 38.0, "Adidas", "Variable lacing systems which help customize shoe fit"))

        return tempShoes
    }

    fun save() {
        val tempShoes = mutableListOf<Shoe>()
        _shoes.value?.let {
            tempShoes.addAll(it)
        }

        currentShoe?.let {
            tempShoes.add(it)
        }

        _shoes.value = tempShoes
        _eventCloseScreen.value = true
    }
}