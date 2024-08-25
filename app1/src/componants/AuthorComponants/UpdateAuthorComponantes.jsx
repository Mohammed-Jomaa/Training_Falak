import React, { useState, useEffect } from 'react';
import { useParams, useNavigate } from 'react-router-dom';
import { getAuthorById, updateAuthor } from '../../services/AuthorService';

const UpdateAuthorComponent = () => {
    const [fullName, setFullName] = useState('');
    const [title, setTitle] = useState('');
    const [dob, setDob] = useState('');
    const [bio, setBio] = useState('');

    const [errors, setErrors] = useState({
        fullName: '',
        title: '',
        dob: '',
        bio: ''
    });

    const navigate = useNavigate();
    const { id } = useParams();

    useEffect(() => {
        getAuthorById(id)
            .then(response => {
                const author = response.data;
                setFullName(author.fullName);
                setTitle(author.title);
                setDob(author.dob);
                setBio(author.bio);
            })
            .catch(error => {
                console.error('Error fetching author details:', error);
            });
    }, [id]);

    const handleSubmit = (e) => {
        e.preventDefault();
        if (validateForm()) {
            const authorData = { fullName, title, dob, bio };
            updateAuthor(id, authorData) 
                .then(() => {
                    navigate("/authors");
                })
                .catch(error => {
                    console.error('Error updating author:', error);
                });
        }
    };
    

    const validateForm = () => {
        let valid = true;
        const errorsCopy = { ...errors };

        if (fullName.trim()) {
            errorsCopy.fullName = '';
        } else {
            errorsCopy.fullName = 'Full Name is required';
            valid = false;
        }

        if (title.trim()) {
            errorsCopy.title = '';
        } else {
            errorsCopy.title = 'Title is required';
            valid = false;
        }

        if (dob.trim()) {
            errorsCopy.dob = '';
        } else {
            errorsCopy.dob = 'Date of Birth is required';
            valid = false;
        }

        if (bio.trim()) {
            errorsCopy.bio = '';
        } else {
            errorsCopy.bio = 'Bio is required';
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
                    <h2 className='text-center'>Update Author</h2>
                    <div className='card-body'>
                        <form onSubmit={handleSubmit}>
                            <div className='form-group mb-2'>
                                <label className='form-label'>Full Name :</label>
                                <input
                                    type="text"
                                    placeholder='Enter Author Full Name'
                                    name='fullName'
                                    value={fullName}
                                    className='form-control'
                                    onChange={(e) => setFullName(e.target.value)}
                                />
                                {errors.fullName && <div className='text-danger'>{errors.fullName}</div>}
                            </div>
                            <div className='form-group mb-2'>
                                <label className='form-label'>Title :</label>
                                <input
                                    type="text"
                                    placeholder='Enter Author Title'
                                    name='title'
                                    value={title}
                                    className='form-control'
                                    onChange={(e) => setTitle(e.target.value)}
                                />
                                {errors.title && <div className='text-danger'>{errors.title}</div>}
                            </div>
                            <div className='form-group mb-2'>
                                <label className='form-label'>Date Of Birth :</label>
                                <input
                                    type="date"
                                    placeholder='Enter Author Date of Birth'
                                    name='dob'
                                    value={dob}
                                    className='form-control'
                                    onChange={(e) => setDob(e.target.value)}
                                />
                                {errors.dob && <div className='text-danger'>{errors.dob}</div>}
                            </div>
                            <div className='form-group mb-2'>
                                <label className='form-label'>Bio :</label>
                                <textarea
                                    rows="4" cols="50"
                                    placeholder='Enter Author Bio'
                                    name='bio'
                                    value={bio}
                                    className='form-control'
                                    onChange={(e) => setBio(e.target.value)}
                                />
                                {errors.bio && <div className='text-danger'>{errors.bio}</div>}
                            </div>
                            <button type="submit" className='btn btn-primary'>Update</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    );
};

export default UpdateAuthorComponent;
