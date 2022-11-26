package com.lawencon.elearn.dao.impl.hibernate.hql;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.lawencon.elearn.dao.CommentDao;
import com.lawencon.elearn.model.Comment;

@Repository
@Profile("hql")
public class CommentDaoImpl extends BaseDaoImpl implements CommentDao {
	
	@Override
	public Comment insert(final Comment data) {
		this.em.persist(data);
		return data;
	}

	@Override
	public Comment update(final Comment data) {
		final Comment result = this.em.merge(data);
		this.em.flush();
		return result;
	}

	@Override
	public Optional<Comment> getById(final Long id) {
		final Comment result = this.em.find(Comment.class, id);
		em.detach(result);
		final Optional<Comment> optional = Optional.ofNullable(result);
		return optional;
	}

	@Override
	public List<Comment> getAll() {
		final String sql = " SELECT doc FROM Comment doc ";
		final List<Comment> result = this.em.createQuery(sql, Comment.class).getResultList();
		return result;
	}

	@Override
	public boolean deleteById(final Long id) {
		final String sql = " DELETE FROM Comment WHERE id = :id ";
		final int result = this.em.createQuery(sql).setParameter("id", id).executeUpdate();
		return result > 0;
	}
	
}
