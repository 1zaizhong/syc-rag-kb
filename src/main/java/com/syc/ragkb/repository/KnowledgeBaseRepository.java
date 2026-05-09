package com.syc.ragkb.repository;

import com.syc.ragkb.entity.KnowledgeBase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KnowledgeBaseRepository extends JpaRepository<KnowledgeBase, Long> {

    List<KnowledgeBase> findByIsDeletedFalse();

    List<KnowledgeBase> findByDepartmentIdAndIsDeletedFalse(String departmentId);

    List<KnowledgeBase> findByIsPublicTrueAndIsDeletedFalse();
}