/**
*
*
* author : ME
*/

package com.imsoft.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.imsoft.rest.entity.RestApiEntity;

public interface RestApiRepository extends JpaRepository<RestApiEntity, Long>{

}
