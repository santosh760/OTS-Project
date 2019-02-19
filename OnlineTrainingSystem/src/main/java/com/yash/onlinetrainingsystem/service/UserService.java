package com.yash.onlinetrainingsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yash.onlinetrainingsystem.domain.User;
import com.yash.onlinetrainingsystem.repository.UserRepository;

@Service
@Transactional
public class UserService implements UserRepository {
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public List<User> findAll() {
	
		return userRepository.findAll();
	}

	@Override
	public List<User> findAll(Sort sort) {
		
		return userRepository.findAll(sort);
	}

	@Override
	public List<User> findAllById(Iterable<Integer> ids) {
		
		return userRepository.findAllById(ids);
	}

	@Override
	public <S extends User> List<S> saveAll(Iterable<S> entities) {
		
		return userRepository.saveAll(entities);
	}

	@Override
	public void flush() {
		userRepository.flush();

	}

	@Override
	public <S extends User> S saveAndFlush(S entity) {
		
		return userRepository.saveAndFlush(entity);
	}

	@Override
	public void deleteInBatch(Iterable<User> entities) {
		userRepository.deleteInBatch(entities);

	}

	@Override
	public void deleteAllInBatch() {
		userRepository.deleteAllInBatch();

	}

	@Override
	public User getOne(Integer id) {
		
		return userRepository.getOne(id);
	}

	@Override
	public <S extends User> List<S> findAll(Example<S> example) {
		
		return userRepository.findAll(example);
	}

	@Override
	public <S extends User> List<S> findAll(Example<S> example, Sort sort) {
		
		return userRepository.findAll(example, sort);
	}

	@Override
	public Page<User> findAll(Pageable pageable) {
		
		return userRepository.findAll(pageable);
	}

	@Override
	public <S extends User> S save(S entity) {
		
		return userRepository.save(entity);
	}

	@Override
	public Optional<User> findById(Integer id) {
		
		return userRepository.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		
		return userRepository.existsById(id);
	}

	@Override
	public long count() {
		
		return userRepository.count();
	}

	@Override
	public void deleteById(Integer id) {
		userRepository.deleteById(id);

	}

	@Override
	public void delete(User entity) {
		userRepository.delete(entity);

	}

	@Override
	public void deleteAll(Iterable<? extends User> entities) {
		userRepository.deleteAll(entities);

	}

	@Override
	public void deleteAll() {
		userRepository.deleteAll();

	}

	@Override
	public <S extends User> Optional<S> findOne(Example<S> example) {
		
		return userRepository.findOne(example);
	}

	@Override
	public <S extends User> Page<S> findAll(Example<S> example, Pageable pageable) {
	
		return userRepository.findAll(example, pageable);
	}

	@Override
	public <S extends User> long count(Example<S> example) {
		
		return userRepository.count(example);
	}

	@Override
	public <S extends User> boolean exists(Example<S> example) {
		
		return userRepository.exists(example);
	}

	@SuppressWarnings("unused")
	public User checkUser(String username, String password) throws NullPointerException {
		try {
		User user= findUserByUsername(username);
		if(user.getPassword().equals(password)) {
			return user;
		}
		else {
			return null;
		}
		}
		catch (Exception e) {
			return null;
		}	
		
		
	}

	@Override
	public User findUserByUsername(String username) {
		
		return userRepository.findUserByUsername(username);
	}

}
