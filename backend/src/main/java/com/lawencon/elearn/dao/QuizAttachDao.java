package com.lawencon.elearn.dao;

import java.util.List;

import com.lawencon.elearn.model.QuizAttach;

public interface QuizAttachDao extends BaseDao<QuizAttach>{
	List<QuizAttach> getAllIdClass(Long classId);
	List<QuizAttach> getAllIdMaterial(Long materialId);
}
