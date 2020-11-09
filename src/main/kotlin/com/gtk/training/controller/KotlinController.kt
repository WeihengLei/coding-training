package com.hkm.ticket.pos

import com.hkm.ticket.web.KotlinService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono


@RestController
@RequestMapping("/kotlin")
class KotlinController  @Autowired constructor(
        private val kotlinService: KotlinService

){


//    @GetMapping("/coroutine/{personId}")
//    fun getNumberOfMessages(@RequestParam name: String) = Mono<String> {
//
//        val training = kotlinService.create(name).awaitFirstOrDefault(null)
//                ?: throw NoSuchElementException("No person can be found")
//
//        /*val updatetraining =
//                kotlinService.update(training).awaitSingle()
//
//        "Hello, ${training.name}-----${updatetraining.name}"*/
//    }



}