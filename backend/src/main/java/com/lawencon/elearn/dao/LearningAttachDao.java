package com.lawencon.elearn.dao;

import java.util.List;

import com.lawencon.elearn.model.LearningAttach;

public interface LearningAttachDao extends BaseDao<LearningAttach> {
	List<LearningAttach> getAllIdClass(Long classId);
	List<LearningAttach> getAllIdMaterial(Long materialId);
}
