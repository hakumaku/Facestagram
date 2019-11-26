package com.kcci.facestagram.repositories

import com.kcci.facestagram.entities.Post
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.time.LocalDateTime

class PostRepository : SingleKeyEntityRepository<Post, Int>() {
    override val entityName get() = "Post"
    override val keyNames get() = "PostId"

    override fun readEntity(result: ResultSet): Post {
        val entity = Post()
        entity.postId = result.getInt(1)
        entity.usersId = result.getInt(2)
        entity.content = result.getString(3)
        entity.planStartDate = LocalDateTime.parse(result.getString(4))
        entity.planEndDate = LocalDateTime.parse(result.getString(5))
        entity.placeId = result.getInt(6)
        entity.accessibleLevelId = result.getInt(7)

        return entity
    }

    override fun insertCore(entity: Post): PreparedStatement {
        val statement = createStatement("insert into $entityName values(?, ?, ?, ?, ?, ?)")

        statement.setInt(1, entity.usersId)
        statement.setString(2, entity.content)
        statement.setString(3, entity.planStartDate.toString().replace("T", " ").dropLast(6))
        statement.setString(4, entity.planEndDate.toString().replace("T", " ").dropLast(6))
        statement.setInt(5, entity.placeId)
        statement.setInt(6, entity.accessibleLevelId)

        return statement
    }

    override fun updateCore(entity: Post): PreparedStatement {
        val statement = createStatement("update Post set UsersId = ?, Content = ?, PlanStartDate = ?, PlanEndDate = ?, PlaceId = ?, AccessibleLevelId = ? where PostId = ?")
        statement.setInt(1, entity.usersId)
        statement.setString(2, entity.content)
        statement.setString(3, entity.planStartDate.toString().replace("T", " ").dropLast(6))
        statement.setString(4, entity.planEndDate.toString().replace("T", " ").dropLast(6))
        statement.setInt(5, entity.placeId)
        statement.setInt(6, entity.accessibleLevelId)
        statement.setInt(7, entity.postId)

        return statement
    }
}