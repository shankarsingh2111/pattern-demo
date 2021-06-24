package com.example.sample

import java.util.*


class MyClass {

    fun main(args: Array<String>) {
        //code
        val scanner = Scanner(System.`in`)
        val testCount = scanner.nextInt()
        for (i in 0 until testCount) {
            val ns = scanner.nextLine()
            val arr = ns.split("\\ ").toTypedArray()
            val n = arr[0].toInt()
            val s = arr[1].toInt()
            val arrayS = scanner.nextLine()
            val array = arrayS.split("\\ ").toTypedArray()
            var start = 1
            var end = -1
            var sumlocal = 0
            for (j in 1..n) {
                sumlocal += array[j].toInt()
                if (sumlocal > s) {
                    sumlocal -= array[start].toInt()
                    start += 1
                }
                if (sumlocal == s) {
                    end = j
                    break
                }
            }
            if (sumlocal == s && end != -1) {
                println("$start $end")
            } else {
                println("-1 -1")
            }
        }
    }
}