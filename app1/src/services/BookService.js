// BookService.js
import axios from 'axios';

const REST_API_URL = "http://localhost:8081/books";

export const listBooks = () => {
    return axios.get(REST_API_URL);
}

export const createBook = (book) => {
    return axios.post(REST_API_URL, book);
}

export const getBookById = (id) => {
    const url = `${REST_API_URL}/${id}`;
    return axios.get(url);
}

export const deleteBook = (id) => {
    const url = `${REST_API_URL}/${id}`;
    return axios.delete(url);
}

export const updateBook = (id, book) => {
    const url = `${REST_API_URL}/${id}`;
    return axios.put(url, book);
}
