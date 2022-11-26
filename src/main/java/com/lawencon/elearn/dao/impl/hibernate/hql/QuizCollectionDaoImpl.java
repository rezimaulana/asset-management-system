package com.lawencon.elearn.dao.impl.hibernate.hql;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.lawencon.elearn.dao.QuizCollectionDao;
import com.lawencon.elearn.model.QuizCollection;

@Repository
@Profile("hql")
public class QuizCollectionDaoImpl extends BaseDaoImpl implements QuizCollectionDao{
	
	@Override
	public QuizCollection insert(final QuizCollection data) {
		this.em.persist(data);
		return data;
	}

	@Override
	public QuizCollection update(final QuizCollection data) {
		final QuizCollection result = this.em.merge(data);
		this.em.flush();
		return result;
	}

	@Override
	public Optional<QuizCollection> getById(final Long id) {
		final QuizCollection result = this.em.find(QuizCollection.class, id);
		em.detach(result);
		final Optional<QuizCollection> optional = Optional.ofNullable(result);
		return optional;
	}

	@Override
	public List<QuizCollection> getAll() {
		final String sql = " SELECT doc FROM QuizCollection doc ";
		final List<QuizCollection> result = this.em.createQuery(sql, QuizCollection.class).getResultList();
		return result;
	}

	@Override
	public boolean deleteById(final Long id) {
		final String sql = " DELETE FROM QuizCollection WHERE id = :id ";
		final int result = this.em.createQuery(sql).setParameter("id", id).executeUpdate();
		return result > 0;
	}

	@Override
	public List<QuizCollection> getAllClsDtlIdScheduleId(final long classDtlId, final long scheduleId) {
		final String sql = "SELECT col "
				+ "FROM QuizCollection col "
				+ "INNER JOIN FETCH col.classDtl cd "
				+ "INNER JOIN FETCH cd.student s "
				+ "INNER JOIN FETCH col.file f "
				+ "INNER JOIN FETCH col.quizSchedule es "
				+ "WHERE cd.id = :classDtlId "
				+ "AND es.id = :scheduleId ";
		final List<QuizCollection> result = this.em.createQuery(sql, QuizCollection.class)
				.setParameter("classDtlId", classDtlId).setParameter("scheduleId", scheduleId).getResultList();
		return result;
	}
	
}
