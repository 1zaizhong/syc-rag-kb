package com.syc.rag.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Array;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
/**
 * @author 粟英朝
 * @version 0.0.3
 * @date 2026/4/29 下午2:18
 * @description  RAG 系统最核心的表。（Chunks），每段文字连同其对应的向量（Embedding）都存储在这里
 **/
@Entity
@Table(name = "kb_doc_chunk")
@Data
public class DocChunk {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //文档id
    @Column(name = "doc_id", nullable = false)
    private Long docId;

    //知识库id
    @Column(name = "kb_id", nullable = false)
    private Long kbId;

    //分块索引
    @Column(name = "chunk_index", nullable = false)
    private Integer chunkIndex;

    //分块内容
    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    /**
     * 向量字段，使用 PGVector 的 vector 类型。
     * Hibernate 6.4+ 原生支持 pgvector，通过 hibernate-vector 模块实现。
     * @JdbcTypeCode(SqlTypes.VECTOR) 告诉 Hibernate 这是向量类型。
     * @Array(length = 1024) 指定维度，对应 text-embedding-v3 的输出维度。
     */
    @JdbcTypeCode(SqlTypes.VECTOR)
    @Array(length = 1024)
    @Column(name = "embedding", columnDefinition = "vector(1024)")
    private float[] embedding;

    @Column(name = "page_num")
    private Integer pageNum;

    @Column(name = "section_title", length = 500)
    private String sectionTitle;

    @Column(name = "token_count", nullable = false)
    private Integer tokenCount = 0;

    @Column(name = "doc_version", nullable = false)
    private Integer docVersion;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
}