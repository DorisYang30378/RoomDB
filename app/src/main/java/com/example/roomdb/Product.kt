package com.example.roomdb

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products" )
class Product {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="pid")
    var id: Int=0
    @ColumnInfo(name = "proName")
    var pname: String=""
    @ColumnInfo(name="qty")
    var qty: Int=0
    constructor(id:Int,name:String,value :Int){
        this.id=id
        this.pname=name
        this.qty=value

    }

    constructor(name: String,value:Int){
        this.pname=name
        this.qty=value
    }

}