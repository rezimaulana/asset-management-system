package com.lawencon.elearn.dao.impl.hibernate.hql;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.lawencon.elearn.dao.QuizScheduleDao;
import com.lawencon.elearn.model.QuizSchedule;

@Repository
@Profile("hql")
public class QuizScheduleDaoImpl extends BaseDaoImpl implements QuizScheduleDao {
	
	@Override
	public QuizSchedule insert(final QuizSchedule data) {
		this.em.persist(data);
		return data;
	}

	@Override
	public QuizSchedule update(final QuizSchedule data) {
		final QuizSchedule result = this.em.merge(data);
		this.em.flush();
		return result;
	}

	@Override
	public Optional<QuizSchedule> getById(final Long id) {
		final QuizSchedule result = this.em.find(QuizSchedule.class, id);
		em.detach(result);
		final Optional<QuizSchedule> optional = Optional.ofNullable(result);
		return optional;
	}

	@Override
	public List<QuizSchedule> getAll() {
		final String sql = " SELECT doc FROM QuizSchedule doc ";
		final List<QuizSchedule> result = this.em.createQuery(sql, QuizSchedule.class).getResultList();
		return result;
	}

	@Override
	public boolean deleteById(final Long id) {
		final String sql = " DELETE FROM QuizSchedule WHERE id = :id ";
		final int result = this.em.createQuery(sql).setParameter("id", id).executeUpdate();
		return result > 0;
	}
	
	@Override
	public List<QuizSchedule> getAllIdMaterial(final Long idMaterial) {
		final String sql = "SELECT schedule "
				+ "FROM QuizSchedule schedule "
				+ "INNER JOIN FETCH schedule.quizMaterial material "
				+ "WHERE material.id = :id ";
		final List<QuizSchedule> result = this.em.createQuery(sql, QuizSchedule.class)
				.setParameter("id", idMaterial).getResultList();
		return result;
	}

	@Override
	public List<QuizSchedule> getAllIdClassHdr(Long classHdrId) {
		final String sql = "SELECT schedule "
				+ "FROM QuizSchedule schedule "
				+ "INNER JOIN FETCH schedule.quizMaterial material "
				+ "INNER JOIN FETCH material.classHdr ch "
				+ "WHERE ch.id = :id ";
		final List<QuizSchedule> result = this.em.createQuery(sql, QuizSchedule.class)
				.setParameter("id", classHdrId).getResultList();
		return result;
	}

}
