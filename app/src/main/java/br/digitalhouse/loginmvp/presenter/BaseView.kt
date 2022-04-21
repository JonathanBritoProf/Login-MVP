package br.digitalhouse.loginmvp.presenter

interface BaseView <T> {

    var presenter : T
    fun bindView()

}