package ru.gb.hw07.service;

import org.springframework.stereotype.Service;

@Service
public class PublicService {

	public String getText() {
		return "Public data - for everybody authenticated";
	}
}
