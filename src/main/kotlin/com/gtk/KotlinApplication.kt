package com.gtk.training

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.ComponentScan



@SpringBootApplication
@ComponentScan(basePackages =["com.gt.training", "com.gtk.training"])

open class KotlinApplication {

    fun main(args: Array<String>) {
        SpringApplication.run(KotlinApplication::class.java, *args)
    }

}