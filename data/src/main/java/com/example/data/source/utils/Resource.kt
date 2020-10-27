package com.example.data.source.utils

class Resource<out T>(val status: Status, val data: T?, val error: Throwable?) {


    companion object {
        fun <T> success(data: T?): Resource<T> {
            return Resource(
                    Status.SUCCES, data, null
            )
        }
        fun <T> error(error: Throwable, data: T?): Resource<T> {
            return Resource(
                    Status.ERROR, data, error
            )
        }
        fun <T> loading(data: T?): Resource<T> {

            return Resource(
                    Status.LOADING, data, null
            )
        }
    }
    enum class Status {
        SUCCES, ERROR, LOADING
    }
}