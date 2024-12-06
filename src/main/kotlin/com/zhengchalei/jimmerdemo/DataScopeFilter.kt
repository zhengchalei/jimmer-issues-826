/*
 * 版权所有 © 2024 郑查磊.
 * 保留所有权利.
 *
 * 注意: 本文件受著作权法保护，未经授权不得复制或传播。
 */
package com.zhengchalei.jimmerdemo


import org.babyfish.jimmer.sql.kt.ast.expression.eq
import org.babyfish.jimmer.sql.kt.ast.expression.exists
import org.babyfish.jimmer.sql.kt.filter.KAssociationIntegrityAssuranceFilter
import org.babyfish.jimmer.sql.kt.filter.KFilterArgs
import org.springframework.stereotype.Component

@Component
class DataScopeFilter() : KAssociationIntegrityAssuranceFilter<DataScopeAware> {

    /**
     * 根据当前用户的数据权限过滤查询范围
     *
     * 此函数重写了KFilterArgs<DataScopeAware>接口的filter方法，根据当前用户所属的数据权限类型，
     * 动态修改查询条件，以限制查询结果范围这使得每个用户只能查询自己有权限看到的数据
     *
     * @param args 查询参数对象，包含查询所需的表格信息和条件构建器通过这个参数，我们可以添加额外的查询条件
     */
    override fun filter(args: KFilterArgs<DataScopeAware>) {
        // 获取当前用户的数据权限范围
        val authorId = 1

        //  1. Table join is disabled because it is not allowed by cacheable filter
        //  args.apply { where(table.author.id eq authorId) }


        // 2. Table join is disabled because it is not allowed by cacheable filter
        args.apply {
            exists(
                wildSubQuery(Author::class) {
                    where(table.id eq parentTable.author.id)
                    where(table.id eq authorId)
                }
            )
        }

        // 3. success
//        args.apply { where(table.authorId eq authorId) }
    }
}
