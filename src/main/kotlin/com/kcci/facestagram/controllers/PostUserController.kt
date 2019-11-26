package com.kcci.facestagram.controllers

import com.kcci.facestagram.entities.PostUsers
import com.kcci.facestagram.repositories.Repository
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/postUser")
class PostUserController {

    @GetMapping
    fun getAll() = Repository.postUser.getAll()

    @PostMapping
    fun insert(@RequestBody postUser: PostUsers){
        Repository.postUser.insert(postUser)
    }


    @RequestMapping(path = ["/{id}"], method = [RequestMethod.DELETE])
    fun deleteByPK(@PathVariable id: String)  {
        var numbersContainer: List<String> = id.split(",")
        Repository.postUser.deleteByPK(Integer.parseInt(numbersContainer[0]),
                Integer.parseInt(numbersContainer[1]))
    }

}