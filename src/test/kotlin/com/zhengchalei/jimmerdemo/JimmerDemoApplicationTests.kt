package com.zhengchalei.jimmerdemo

import org.babyfish.jimmer.sql.kt.KSqlClient
import org.babyfish.jimmer.sql.kt.ast.expression.eq
import org.babyfish.jimmer.sql.kt.ast.expression.valueIn
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class JimmerDemoApplicationTests {

    @Autowired
    lateinit var sqlClient: KSqlClient

    @Test
    fun contextLoads() {
            val list = this.sqlClient.createQuery(Book::class) {
//                where(
//                    table.author.id valueIn subQuery(Author::class) {
//                        where(table.id eq 1)
//                        select(table.id)
//                    }
//                )
                select(table.fetchBy {
                    allScalarFields()
                })
            }.execute()
            list.forEach { println(it) }
    }

}
