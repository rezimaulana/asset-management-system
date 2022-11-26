package com.lawencon.elearn.dao.impl.hibernate.hql;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.lawencon.elearn.dao.ForumDao;
import com.lawencon.elearn.model.Forum;

@Repository
@Profile("hql")
public class ForumDaoImpl extends BaseDaoImpl implements ForumDao{
	
	@Override
	public Forum insert(final Forum data) {
		this.em.persist(data);
		return data;
	}

	@Override
	public Forum update(final Forum data) {
		final Forum result = this.em.merge(data);
		this.em.flush();
		return result;
	}

	@Override
	public Optional<Forum> getById(final Long id) {
		final Forum result = this.em.find(Forum.class, id);
		em.detach(result);
		final Optional<Forum> optional = Optional.ofNullable(result);
		return optional;
	}

	@Override
	public List<Forum> getAll() {
		final String sql = " SELECT doc FROM Forum doc ";
		final List<Forum> result = this.em.createQuery(sql, Forum.class).getResultList();
		return result;
	}

	@Override
	public boolean deleteById(final Long id) {
		final String sql = " DELETE FROM Forum WHERE id = :id ";
		final int result = this.em.createQuery(sql).setParameter("id", id).executeUpdate();
		return result > 0;
	}
	
}
