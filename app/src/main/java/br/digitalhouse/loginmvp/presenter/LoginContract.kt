package br.digitalhouse.loginmvp.presenter

interface LoginContract {

    interface View : BaseView<LoginPresenter>{
        fun showError()
        fun startHomeActivity()
    }

    interface Presenter : BasePresenterInterface {
        fun isLoginValid(user : String, password : String)
    }

}