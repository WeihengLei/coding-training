package com.gtk.training.repository

import com.gt.training.entity.Training
import org.springframework.data.domain.Pageable
import org.springframework.data.mongodb.repository.Query
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

/**
 * TrainingRepository
 *
 * @author Weihang
 * @date 10/4/20
 *
 */

interface TrainingRepository : ReactiveMongoRepository<Training, String> {
    /*
		//只输出id和title字段，第一个参数为查询条件，空代表查询所有
		db.news.find( {}, { id: 1, title: 1 } )
		//如果需要输出的字段比较多，不想要某个字段，可以用排除字段的方法
		//不输出内容字段，其它字段都输出
		db.news.find( {}, {content: 0 } )
		https://blog.csdn.net/u012086400/article/details/78652919
	 */


    fun findByBrandIdAndCinemaIdAndId(brandId: String, cinemaId: String, screenId: String): Mono<Training>

}