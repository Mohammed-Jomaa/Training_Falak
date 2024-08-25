import axios from 'axios';

const REST_API_URL = "http://localhost:8081/authors";

export const listAuthors = () => {
    return axios.get(REST_API_URL);
}

export const createAuthor = (author) => {
    return axios.post(REST_API_URL, author);
}

export const updateAuthor = (id, author) => {
    const url = `${REST_API_URL}/${id}`; 
    return axios.put(url, author);
}
export const getAuthorById = (id) => {
    const url = `${REST_API_URL}/${id}`;
    return axios.get(url);
}
export const deleteAuthor = (id) => {
    const url = `${REST_API_URL}/${id}`; 
    return axios.delete(url);
}
