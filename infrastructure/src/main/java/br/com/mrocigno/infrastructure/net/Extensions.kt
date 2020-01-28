package br.com.mrocigno.infrastructure.net

import retrofit2.Response

fun <I, O> Response<I>.converter(mapper: Mapper<I, O>) : ApiResult<O> {
    return if(this.isSuccessful){
        val body = body()
        if (body == null || code() == 204 || (body is List<*> && body.size == 0)) {
            ApiResultError(RequestError(
                code = 0,
                message = "The request is empty"
            ))
        } else {
            ApiResultSuccess(mapper.transform(this.body()))
        }
    } else {
        ApiResultError(RequestError(
            code = code(),
            message = message()
        ))
    }
}