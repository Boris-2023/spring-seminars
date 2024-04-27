package ru.gb.hw07.service;

import org.springframework.stereotype.Service;

// функционал страницы для любого аутентифицированного пользователя - тут заглушка
@Service
public class PublicService {

	public String getText() {
		return "Public data - for everybody authenticated";
	}
}
