package com.lawencon.elearn.service.impl;

import java.util.Random;

import org.springframework.stereotype.Service;

import com.lawencon.elearn.service.GenerateCodeService;

@Service
public class GenerateCodeServiceImpl implements GenerateCodeService{

	@Override
	public String generateDigit(final int codeLength) {
		final int leftLimit = 48; // numeral '0'
	    final int rightLimit = 122; // letter 'z'
	    final int targetStringLength = codeLength;
	    final Random random = new Random();
	    final String generatedString = random.ints(leftLimit, rightLimit + 1)
	      .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
	      .limit(targetStringLength)
	      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
	      .toString()
	      .toUpperCase();
	    return generatedString;
	}

}
