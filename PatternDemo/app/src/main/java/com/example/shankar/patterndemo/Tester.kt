package com.example.shankar.patterndemo

import android.util.Log

fun <T> Array<T>.reverse(): Array<T>{
    for(i in 0..size/2){
        val temp = get(i)
        set(i, get(size-1 - i))
        set(size-1 - i, temp)
    }
    return this;
}

fun start(){
    val arr : Array<Int> = Array(5) { i -> i };
    var arr2 : Array<Int> = arr.reverse()
    for(i in 0 until arr2.size){
        Log.w("arr2", "="+ arr2[i]);
    }

    val arr3 : Array<String> = Array(5) { i -> (i*2).toString() };
    var arr4 : Array<String> = arr3.reverse()
    for(i in 0 until arr4.size){
        Log.w("arr4", "="+ arr4[i]);
    }

}