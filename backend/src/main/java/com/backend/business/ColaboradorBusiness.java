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
	
	public int calcularComplexidade(String password) {
		int lengthScore = Math.min(password.length() / 2, 5);
        int uppercaseScore = password.matches(".*[A-Z].*") ? 5 : 0;
        int lowercaseScore = password.matches(".*[a-z].*") ? 5 : 0;
        int digitScore = password.matches(".*\\d.*") ? 5 : 0;

        // You can customize the special characters based on your requirements
        String specialChars = "!@#$%^&*()-_=+[]{}|;:'\",.<>?/";
        int specialCharScore = password.matches(".*[" + specialChars + "].*") ? 5 : 0;

        // You can adjust weights for different criteria based on your requirements
        int totalScore = lengthScore + uppercaseScore + lowercaseScore + digitScore + specialCharScore;

        return totalScore;
	}
}
