package com.example.demobatchjob

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import kotlin.system.exitProcess

@SpringBootApplication
open class BatchProcessingApplication {
	@Throws(Exception::class)
	@JvmStatic
	fun main(args: Array<String>) {
		exitProcess(SpringApplication.exit(SpringApplication.run(BatchProcessingApplication::class.java, *args)))
	}
}