package com.syc.ragkb.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author 粟英朝
 * @version 0.0.3
 * @date 2026/5/10 上午1:26
 * @description
 **/
@Data
@Builder
public class KnowledgeBaseVO {
    private Long id;
    private String name;
    private String description;
    private String departmentId;
    private Boolean isPublic;
    private Long createdBy;
    private LocalDateTime createdAt;
    /** 当前用户对该知识库的权限：ADMIN / WRITE / READ */
    private String permission;
}