package com.example.binettest.base

interface BaseView<ViewState> {
    fun render(viewState: ViewState)
}