package com.example.demobatchjob

import org.slf4j.LoggerFactory
import org.springframework.batch.core.BatchStatus
import org.springframework.batch.core.JobExecution
import org.springframework.batch.core.JobExecutionListener
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Component
import java.sql.ResultSet
import java.util.function.Consumer

@Component
class JobCompletionNotificationListener @Autowired constructor(private val jdbcTemplate: JdbcTemplate) :
    JobExecutionListener {
    override fun afterJob(jobExecution: JobExecution) {
        if (jobExecution.status == BatchStatus.COMPLETED) {
            log.info("!!! JOB FINISHED! Time to verify the results")
            jdbcTemplate.query(
                "SELECT first_name, last_name FROM people"
            ) { rs: ResultSet, _: Int ->
                Person(
                    rs.getString(1),
                    rs.getString(2)
                )
            }.forEach(Consumer { person: Person? ->
                log.info(
                    "Found <{{}}> in the database.",
                    person
                )
            })
        }
    }

    companion object {
        private val log = LoggerFactory.getLogger(JobCompletionNotificationListener::class.java)
    }
}