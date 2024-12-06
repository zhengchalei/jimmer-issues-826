package com.zhengchalei.jimmerdemo

import org.babyfish.jimmer.sql.*

@Entity
@Table(name = "book")
interface Book: DataScopeAware {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Int

    val name: String

}
