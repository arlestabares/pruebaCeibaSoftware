package com.example.data.source.remote.api

import retrofit2.Response


sealed class ApiResponse<T> {
    companion object{
        fun <T> create (error : Throwable): ApiErrorResponse<T>{
            return  ApiErrorResponse(error.message?:"unKnow error")
        }

        fun <T> create(response: Response<T>): ApiResponse<T>{
            return  if (response.isSuccessful){
                val body = response.body()
                if (body == null || response.code() == 204){
                    ApiEmptyResponse()
                }else{
                    ApiSuccessResponse(
                            body= body)
                }
            }else {
                val msg = response.errorBody()?.toString()
                val errorMsg = if (msg.isNullOrEmpty()){
                    response.message()
                }else{
                    msg
                }
                ApiErrorResponse(errorMsg ?: "unknown error")
            }
        }
    }
}
class ApiEmptyResponse<T> : ApiResponse<T>()

data class ApiSuccessResponse<T>(val body:T): ApiResponse<T>(){

  //  constructor(body: T): this (body= body)

}



data class ApiErrorResponse<T> (val errorMessage: String): ApiResponse<T>()
