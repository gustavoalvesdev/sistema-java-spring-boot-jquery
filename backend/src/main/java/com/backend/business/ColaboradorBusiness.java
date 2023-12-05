package com.backend.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.entity.ColaboradorEntity;
import com.backend.repository.ColaboradorRepository;

@Service
public class ColaboradorBusiness {

	@Autowired
	ColaboradorRepository colaboradorRepository;

	public ColaboradorEntity findById(Integer id) {
		return colaboradorRepository.findById(id).get();
	}
	
	public List<ColaboradorEntity> findAll() {
		return colaboradorRepository.findAll();
	}
	
	public ColaboradorEntity save(ColaboradorEntity colaboradorEntity) {
		colaboradorEntity.setScore(calcularComplexidade(colaboradorEntity.getSenha()));
		
		return colaboradorRepository.save(colaboradorEntity);
	}
	
	public String calcularComplexidade(String password) {
		if (password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\\$%\\^&\\*])(?=.{8,})")){
		    return "Forte";
		} else if (password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.{8,})")){
		    return "Aceitável";
		} else if (password.matches("^(?=.*[a-z])(?=.*[0-9])(?=.{8,})")){
		    return "Fraca";
		} else {
		    return "Muito Fraca";
		}
	}

}
