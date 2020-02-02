package br.com.mrocigno.infrastructure.net

abstract class Mapper<CLASS_IN, CLASS_OUT> {
    abstract fun transform(item: CLASS_IN?): CLASS_OUT
    abstract fun reverse(item: CLASS_OUT?): CLASS_IN
}