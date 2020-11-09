package com.hkm.ticket.web

import com.gt.training.dao.TrainingDao
import com.gt.training.entity.Training
import com.gtk.training.repository.TrainingRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import reactor.core.publisher.Mono

@Service
@Transactional
open class KotlinService @Autowired constructor(
        private val trainingDao: TrainingDao,
        private val trainingRepository: TrainingRepository
) {

    fun create(name: String): Mono<Training> {
        val tr  = Training()
        //tr.name = "testname"
        //val default = Training(name = "Normal")
        //trainingRepository.save(tr)
        //trainingDao.save(tr)

        return trainingRepository.save(tr)
    }


}