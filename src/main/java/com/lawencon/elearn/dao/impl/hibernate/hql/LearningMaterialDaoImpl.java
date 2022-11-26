package com.lawencon.elearn.dao.impl.hibernate.hql;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.lawencon.elearn.dao.LearningMaterialDao;
import com.lawencon.elearn.model.LearningMaterial;

@Repository
@Profile("hql")
public class LearningMaterialDaoImpl extends BaseDaoImpl implements LearningMaterialDao{
	
	@Override
	public LearningMaterial insert(final LearningMaterial data) {
		this.em.persist(data);
		return data;
	}

	@Override
	public LearningMaterial update(final LearningMaterial data) {
		final LearningMaterial result = this.em.merge(data);
		this.em.flush();
		return result;
	}

	@Override
	public Optional<LearningMaterial> getById(final Long id) {
		final LearningMaterial result = this.em.find(LearningMaterial.class, id);
		em.detach(result);
		final Optional<LearningMaterial> optional = Optional.ofNullable(result);
		return optional;
	}

	@Override
	public List<LearningMaterial> getAll() {
		final String sql = " SELECT doc FROM LearningMaterial doc ";
		final List<LearningMaterial> result = this.em.createQuery(sql, LearningMaterial.class).getResultList();
		return result;
	}

	@Override
	public boolean deleteById(final Long id) {
		final String sql = " DELETE FROM LearningMaterial WHERE id = :id ";
		final int result = this.em.createQuery(sql).setParameter("id", id).executeUpdate();
		return result > 0;
	}

}
