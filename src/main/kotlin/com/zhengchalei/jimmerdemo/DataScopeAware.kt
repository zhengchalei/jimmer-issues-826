package com.zhengchalei.jimmerdemo

import org.babyfish.jimmer.sql.IdView
import org.babyfish.jimmer.sql.JoinColumn
import org.babyfish.jimmer.sql.ManyToOne
import org.babyfish.jimmer.sql.MappedSuperclass

@MappedSuperclass
interface DataScopeAware {

    @ManyToOne
    @JoinColumn(name = "author_id") val author: Author?

    @IdView("author") val authorId: Int?

}
