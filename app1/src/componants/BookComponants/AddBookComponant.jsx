import React, { useState } from 'react';
import { createBook } from '../../services/BookService';
import { useNavigate } from 'react-router-dom';

const AddBookComponent = () => {
    const [title, setTitle] = useState('');
    const [subtitle, setSubtitle] = useState('');
    const [description, setDescription] = useState('');
    const [imageURL, setImageURL] = useState('');
    const [edition, setEdition] = useState('');
    const [publishingDate, setPublishingDate] = useState('');
    const [categories, setCategories] = useState('');

    const [errors, setErrors] = useState({
        title: '',
        subtitle: '',
        description: '',
        imageURL: '',
        edition: '',
        publishingDate: '',
        categories: ''
    });

    const navigate = useNavigate(); 

    const handleSubmit = (e) => {
        e.preventDefault();
        if (validateForm()) {
            const book = { title, subtitle, description, imageURL, edition, publishing_date: publishingDate, categories };
            createBook(book).then((response) => {
                console.log(response.data);
                navigate("/books");
            });
        }
    };

    const validateForm = () => {
        let valid = true;
        const errorsCopy = { ...errors };

        if (title.trim()) {
            errorsCopy.title = '';
        } else {
            errorsCopy.title = 'Title is required';
            valid = false;
        }

        if (subtitle.trim()) {
            errorsCopy.subtitle = '';
        } else {
            errorsCopy.subtitle = 'Subtitle is required';
            valid = false;
        }

        if (description.trim()) {
            errorsCopy.description = '';
        } else {
            errorsCopy.description = 'Description is required';
            valid = false;
        }

        if (imageURL.trim()) {
            errorsCopy.imageURL = '';
        } else {
            errorsCopy.imageURL = 'Image URL is required';
            valid = false;
        }

        if (edition.trim()) {
            errorsCopy.edition = '';
        } else {
            errorsCopy.edition = 'Edition is required';
            valid = false;
        }

        if (publishingDate.trim()) {
            errorsCopy.publishingDate = '';
        } else {
            errorsCopy.publishingDate = 'Publishing Date is required';
            valid = false;
        }

        if (categories.trim()) {
            errorsCopy.categories = '';
        } else {
            errorsCopy.categories = 'Categories are required';
            valid = false;
        }

        setErrors(errorsCopy);
        return valid;
    };

    return (
        <div className='container'>
            <br />
            <br />
            <div className='row'>
                <div className='card col-md-6 offset-md-3'>
                    <h2 className='text-center'>Add Book</h2>
                    <div className='card-body'>
                        <form onSubmit={handleSubmit}>
                            <div className='form-group mb-2'>
                                <label className='form-label'>Title :</label>
                                <input
                                    type="text"
                                    placeholder='Enter Book Title'
                                    name='title'
                                    value={title}
                                    className='form-control'
                                    onChange={(e) => setTitle(e.target.value)}
                                />
                                {errors.title && <div className='text-danger'>{errors.title}</div>}
                            </div>
                            <div className='form-group mb-2'>
                                <label className='form-label'>Subtitle :</label>
                                <input
                                    type="text"
                                    placeholder='Enter Book Subtitle'
                                    name='subtitle'
                                    value={subtitle}
                                    className='form-control'
                                    onChange={(e) => setSubtitle(e.target.value)}
                                />
                                {errors.subtitle && <div className='text-danger'>{errors.subtitle}</div>}
                            </div>
                            <div className='form-group mb-2'>
                                <label className='form-label'>Description :</label>
                                <textarea
                                    rows="4" cols="50"
                                    placeholder='Enter Book Description'
                                    name='description'
                                    value={description}
                                    className='form-control'
                                    onChange={(e) => setDescription(e.target.value)}
                                />
                                {errors.description && <div className='text-danger'>{errors.description}</div>}
                            </div>
                            <div className='form-group mb-2'>
                                <label className='form-label'>Image URL :</label>
                                <input
                                
                                    type="text"
                                    placeholder='Enter Book Image URL'
                                    name='imageURL'
                                    value={imageURL}
                                    className='form-control'
                                    onChange={(e) => setImageURL(e.target.value)}
                                />
                                {errors.imageURL && <div className='text-danger'>{errors.imageURL}</div>}
                            </div>
                            <div className='form-group mb-2'>
                                <label className='form-label'>Edition :</label>
                                <input
                                    type="text"
                                    placeholder='Enter Book Edition'
                                    name='edition'
                                    value={edition}
                                    className='form-control'
                                    onChange={(e) => setEdition(e.target.value)}
                                />
                                {errors.edition && <div className='text-danger'>{errors.edition}</div>}
                            </div>
                            <div className='form-group mb-2'>
                                <label className='form-label'>Publishing Date :</label>
                                <input
                                    type="date"
                                    name='publishingDate'
                                    value={publishingDate}
                                    className='form-control'
                                    onChange={(e) => setPublishingDate(e.target.value)}
                                />
                                {errors.publishingDate && <div className='text-danger'>{errors.publishingDate}</div>}
                            </div>
                            <div className='form-group mb-2'>
                                <label className='form-label'>Categories :</label>
                                <input
                                    type="text"
                                    placeholder='Enter Book Categories (comma-separated)'
                                    name='categories'
                                    value={categories}
                                    className='form-control'
                                    onChange={(e) => setCategories(e.target.value)}
                                />
                                {errors.categories && <div className='text-danger'>{errors.categories}</div>}
                            </div>
                            <button type="submit" className='btn btn-primary'>Submit</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default AddBookComponent;
