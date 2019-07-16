package com.example.football_exp


interface BaseContract {

    interface BaseView{

        fun showErrorMessage()
    }

    interface BasePresenter{

        fun onUnbind()
    }
}