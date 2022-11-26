package com.lawencon.elearn.dao.impl.hibernate.hql;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.lawencon.elearn.dao.QuizAttachDao;
import com.lawencon.elearn.model.QuizAttach;

@Repository
@Profile("hql")
public class QuizAttachDaoImpl extends BaseDaoImpl implements QuizAttachDao {

	@Override
	public QuizAttach insert(final QuizAttach data) {
		this.em.persist(data);
		return data;
	}

	@Override
	public QuizAttach update(final QuizAttach data) {
		final QuizAttach result = this.em.merge(data);
		this.em.flush();
		return result;
	}

	@Override
	public Optional<QuizAttach> getById(final Long id) {
		final QuizAttach result = this.em.find(QuizAttach.class, id);
		em.detach(result);
		final Optional<QuizAttach> optional = Optional.ofNullable(result);
		return optional;
	}

	@Override
	public List<QuizAttach> getAll() {
		final String sql = " SELECT doc FROM QuizAttach doc ";
		final List<QuizAttach> result = this.em.createQuery(sql, QuizAttach.class).getResultList();
		return result;
	}

	@Override
	public boolean deleteById(final Long id) {
		final String sql = " DELETE FROM QuizAttach WHERE id = :id ";
		final int result = this.em.createQuery(sql).setParameter("id", id).executeUpdate();
		return result > 0;
	}
	
	@Override
	public List<QuizAttach> getAllIdClass(final Long classId) {
		final String sql = "SELECT attach "
				+ "FROM QuizAttach attach "
				+ "INNER JOIN FETCH attach.quizMaterial material "
				+ "INNER JOIN FETCH material.classHdr classHdr "
				+ "INNER JOIN FETCH attach.file file "
				+ "WHERE classHdr.id = :id ";
		final List<QuizAttach> result = this.em.createQuery(sql, QuizAttach.class)
				.setParameter("id", classId).getResultList();
		return result;
	}
	
	@Override
	public List<QuizAttach> getAllIdMaterial(final Long materialId) {
		final String sql = "SELECT attach "
				+ "FROM QuizAttach attach "
				+ "INNER JOIN FETCH attach.quizMaterial material "
				+ "INNER JOIN FETCH attach.file files "
				+ "WHERE material.id = :id ";
		final List<QuizAttach> result = this.em.createQuery(sql, QuizAttach.class)
				.setParameter("id", materialId).getResultList();
		return result;
	}
	
}
