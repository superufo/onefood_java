package com.alamousse.service.dto;

import lombok.Data;
import com.alamousse.annotation.Query;

/**
 * @author mike
 * @date 2019-6-4 09:54:37
 */
@Data
public class QiniuQueryCriteria{

    @Query(type = Query.Type.INNER_LIKE)
    private String key;
}
