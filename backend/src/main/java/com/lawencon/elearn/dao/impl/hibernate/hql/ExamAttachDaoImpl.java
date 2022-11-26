package com.lawencon.elearn.dao.impl.hibernate.hql;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.lawencon.elearn.dao.ExamAttachDao;
import com.lawencon.elearn.model.ExamAttach;

@Repository
@Profile("hql")
public class ExamAttachDaoImpl extends BaseDaoImpl implements ExamAttachDao{
	
	@Override
	public ExamAttach insert(final ExamAttach data) {
		this.em.persist(data);
		return data;
	}

	@Override
	public ExamAttach update(final ExamAttach data) {
		final ExamAttach result = this.em.merge(data);
		this.em.flush();
		return result;
	}

	@Override
	public Optional<ExamAttach> getById(Long id) {
		final ExamAttach result = this.em.find(ExamAttach.class, id);
		em.detach(result);
		final Optional<ExamAttach> optional = Optional.ofNullable(result);
		return optional;
	}

	@Override
	public List<ExamAttach> getAll() {
		final String sql = " SELECT doc FROM ExamAttach doc ";
		final List<ExamAttach> result = this.em.createQuery(sql, ExamAttach.class).getResultList();
		return result;
	}

	@Override
	public boolean deleteById(final Long id) {
		final String sql = " DELETE FROM ExamAttach WHERE id = :id ";
		final int result = this.em.createQuery(sql).setParameter("id", id).executeUpdate();
		return result > 0;
	}

	@Override
	public List<ExamAttach> getAllIdClass(final Long classId) {
		final String sql = "SELECT attach "
				+ "FROM ExamAttach attach "
				+ "INNER JOIN FETCH attach.examMaterial material "
				+ "INNER JOIN FETCH material.classHdr classHdr "
				+ "INNER JOIN FETCH attach.file file "
				+ "WHERE classHdr.id = :id ";
		final List<ExamAttach> result = this.em.createQuery(sql, ExamAttach.class)
				.setParameter("id", classId).getResultList();
		return result;
	}

	@Override
	public List<ExamAttach> getAllIdMaterial(final Long materialId) {
		final String sql = "SELECT attach "
				+ "FROM ExamAttach attach "
				+ "INNER JOIN FETCH attach.examMaterial material "
				+ "INNER JOIN FETCH attach.file files "
				+ "WHERE material.id = :id ";
		final List<ExamAttach> result = this.em.createQuery(sql, ExamAttach.class)
				.setParameter("id", materialId).getResultList();
		return result;
	}
	
}
