package com.ykp.islamwissenscheck.repository

interface DatastoreRepo {
        suspend fun putScore(key:String, score:Int = 0)
        suspend fun putBoolean(key:String,value:Boolean)
        suspend fun getScore(key: String):Int?
        suspend fun clearPReferences(key: String)

}