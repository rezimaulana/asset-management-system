package com.lawencon.elearn.dao.impl.hibernate.hql;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.lawencon.elearn.dao.LearningAttachDao;
import com.lawencon.elearn.model.LearningAttach;

@Repository
@Profile("hql")
public class LearningAttachDaoImpl extends BaseDaoImpl implements LearningAttachDao{
	
	@Override
	public LearningAttach insert(final LearningAttach data) {
		this.em.persist(data);
		return data;
	}

	@Override
	public LearningAttach update(final LearningAttach data) {
		final LearningAttach result = this.em.merge(data);
		this.em.flush();
		return result;
	}

	@Override
	public Optional<LearningAttach> getById(final Long id) {
		final LearningAttach result = this.em.find(LearningAttach.class, id);
		em.detach(result);
		final Optional<LearningAttach> optional = Optional.ofNullable(result);
		return optional;
	}

	@Override
	public List<LearningAttach> getAll() {
		final String sql = " SELECT doc FROM LearningAttach doc ";
		final List<LearningAttach> result = this.em.createQuery(sql, LearningAttach.class).getResultList();
		return result;
	}

	@Override
	public boolean deleteById(final Long id) {
		final String sql = " DELETE FROM LearningAttach WHERE id = :id ";
		final int result = this.em.createQuery(sql).setParameter("id", id).executeUpdate();
		return result > 0;
	}
	
	@Override
	public List<LearningAttach> getAllIdClass(final Long classId) {
		final String sql = "SELECT attach "
				+ "FROM LearningAttach attach "
				+ "INNER JOIN FETCH attach.learningMaterial material "
				+ "INNER JOIN FETCH material.classHdr classHdr "
				+ "INNER JOIN FETCH attach.file file "
				+ "WHERE classHdr.id = :id ";
		final List<LearningAttach> result = this.em.createQuery(sql, LearningAttach.class)
				.setParameter("id", classId).getResultList();
		return result;
	}

	@Override
	public List<LearningAttach> getAllIdMaterial(final Long materialId) {
		final String sql = "SELECT attach "
				+ "FROM LearningAttach attach "
				+ "INNER JOIN FETCH attach.learningMaterial material "
				+ "INNER JOIN FETCH attach.file files "
				+ "WHERE material.id = :id ";
		final List<LearningAttach> result = this.em.createQuery(sql, LearningAttach.class)
				.setParameter("id", materialId).getResultList();
		return result;
	}
	
}
