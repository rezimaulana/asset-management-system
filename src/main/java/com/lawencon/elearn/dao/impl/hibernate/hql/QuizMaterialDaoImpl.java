package com.lawencon.elearn.dao.impl.hibernate.hql;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.lawencon.elearn.dao.QuizMaterialDao;
import com.lawencon.elearn.model.QuizMaterial;

@Repository
@Profile("hql")
public class QuizMaterialDaoImpl extends BaseDaoImpl implements QuizMaterialDao{
	
	@Override
	public QuizMaterial insert(final QuizMaterial data) {
		this.em.persist(data);
		return data;
	}

	@Override
	public QuizMaterial update(final QuizMaterial data) {
		final QuizMaterial result = this.em.merge(data);
		this.em.flush();
		return result;
	}

	@Override
	public Optional<QuizMaterial> getById(final Long id) {
		final QuizMaterial result = this.em.find(QuizMaterial.class, id);
		em.detach(result);
		final Optional<QuizMaterial> optional = Optional.ofNullable(result);
		return optional;
	}

	@Override
	public List<QuizMaterial> getAll() {
		final String sql = " SELECT doc FROM QuizMaterial doc ";
		final List<QuizMaterial> result = this.em.createQuery(sql, QuizMaterial.class).getResultList();
		return result;
	}

	@Override
	public boolean deleteById(final Long id) {
		final String sql = " DELETE FROM QuizMaterial WHERE id = :id ";
		final int result = this.em.createQuery(sql).setParameter("id", id).executeUpdate();
		return result > 0;
	}
	
}
