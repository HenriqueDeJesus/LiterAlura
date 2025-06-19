package br.com.challenge.books.service;

public interface IConverteDados {
    <T> T  obterDados(String json, Class<T> classe);
}
