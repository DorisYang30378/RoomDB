package com.example.roomdb

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query




    @Dao
    interface ProductDao {

        @Insert
        fun insertProd( pro: Product){}

        @Query("select * from products where proName= :pro")
        fun findProd(pro: String): List<Product>

        @Query("delete from products where proName =:pro")
        fun delProd( pro: String)

        @Query("select * from products")
        fun getALL(): List<Product>

    }
