package com.syc.ragkb.dto;

import lombok.Data;

/**
 * @author 粟英朝
 * @version 0.0.3
 * @date 2026/5/10 上午1:26
 * @description
 **/
@Data
public class KnowledgeBaseCreateRequest {
    private String name;
    private String description;
    private String departmentId;
    private Boolean isPublic = false;
}