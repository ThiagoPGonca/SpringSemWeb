package br.com.refspring.test.service;

public interface IConvertData {
    <T> T obterDados(String json, Class<T> classe);
}
