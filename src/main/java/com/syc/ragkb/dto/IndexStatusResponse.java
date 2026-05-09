package com.syc.ragkb.dto;

import lombok.Data;

/**
 * @author 粟英朝
 * @version 0.0.3
 * @date 2026/5/10 上午1:27
 * @description
 **/
@Data
public class IndexStatusResponse {
    private Long docId;
    private String fileName;
    private String status;         // PENDING / PROCESSING / DONE / FAILED
    private String errorMsg;
    private Integer chunkCount;
    private Integer tokenCount;
    private String indexedAt;
    private Integer retryCount;
}
