package com.kcci.facestagram.repositories

import com.kcci.facestagram.entities.PostUsers
import com.kcci.facestagram.exceptions.UnupdatableException
import java.sql.PreparedStatement
import java.sql.ResultSet

class PostUsersRepository : DoubleKeyEntityRepository<PostUsers, Int, Int>() {
    override val entityName get() = "PostUser"
    override val keyNames get() = "postId,userid"

    override fun readEntity(result: ResultSet): PostUsers {
        val entity = PostUsers()
        entity.postId = result.getInt(1)
        entity.usersId = result.getInt(2)

        return entity
    }

    override fun insertCore(entity: PostUsers): PreparedStatement {
        val statement = createStatement("insert into PostUser values(?, ?)")

        statement.setInt(1, entity.postId)
        statement.setInt(2, entity.usersId)

        return statement
    }

    override fun updateCore(entity: PostUsers): PreparedStatement {
        throw UnupdatableException(2, "기본키만 있는 엔터티는 업데이트 할 수 없음")
    }
}