package com.lawencon.elearn.dao.impl.hibernate.hql;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.lawencon.elearn.dao.ExamMaterialDao;
import com.lawencon.elearn.model.ExamMaterial;

@Repository
@Profile("hql")
public class ExamMaterialDaoImpl extends BaseDaoImpl implements ExamMaterialDao{
	
	@Override
	public ExamMaterial insert(final ExamMaterial data) {
		this.em.persist(data);
		return data;
	}

	@Override
	public ExamMaterial update(final ExamMaterial data) {
		final ExamMaterial result = this.em.merge(data);
		this.em.flush();
		return result;
	}

	@Override
	public Optional<ExamMaterial> getById(final Long id) {
		final ExamMaterial result = this.em.find(ExamMaterial.class, id);
		em.detach(result);
		final Optional<ExamMaterial> optional = Optional.ofNullable(result);
		return optional;
	}

	@Override
	public List<ExamMaterial> getAll() {
		final String sql = " SELECT doc FROM ExamMaterial doc ";
		final List<ExamMaterial> result = this.em.createQuery(sql, ExamMaterial.class).getResultList();
		return result;
	}

	@Override
	public boolean deleteById(final Long id) {
		final String sql = " DELETE FROM ExamMaterial WHERE id = :id ";
		final int result = this.em.createQuery(sql).setParameter("id", id).executeUpdate();
		return result > 0;
	}
	
}
