package br.com.mrocigno.infrastructure.net


data class RequestError(val code : Int, val message : String)
sealed class ApiResult<T>
data class ApiResultError<T>(val error: RequestError?) : ApiResult<T>()
data class ApiResultSuccess<T>(val body: T) : ApiResult<T>()