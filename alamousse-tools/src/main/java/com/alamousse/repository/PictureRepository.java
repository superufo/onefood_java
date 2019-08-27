package com.alamousse.repository;

import com.alamousse.domain.Picture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author mike
 * @date 2018-12-27
 */
public interface PictureRepository extends JpaRepository<Picture,Long>, JpaSpecificationExecutor {
}
