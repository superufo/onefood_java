package com.alamousse.service.dto;

import lombok.Data;
import com.alamousse.annotation.Query;

/**
 * sm.ms图床
 *
 * @author mike
 * @date 2019-6-4 09:52:09
 */
@Data
public class PictureQueryCriteria{

    @Query(type = Query.Type.INNER_LIKE)
    private String filename;
    
    @Query(type = Query.Type.INNER_LIKE)
    private String username;
}
