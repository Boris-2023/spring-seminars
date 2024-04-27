package ru.gb.hw07.service;

import org.springframework.stereotype.Service;

@Service
public class PrivateService {

	public String getText() {
		return "Private data - for administration only!";
	}
}
