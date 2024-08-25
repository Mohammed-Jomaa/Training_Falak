import React, { useEffect, useState } from "react";
import { deleteAuthor, getAuthorById, listAuthors } from "../../services/AuthorService";
import { useNavigate } from "react-router-dom";

const ListAuthorsComponent = () => {
  const [authors, setAuthors] = useState([]);
  const [authorDetails, setAuthorDetails] = useState(null);
  const [searchId, setSearchId] = useState('');
  const navigator = useNavigate();

  useEffect(() => {
    getAllAuthor();
  }, []);

  function getAllAuthor() {
    listAuthors()
      .then((response) => {
        setAuthors(response.data);
      })
      .catch((err) => {
        console.log(err);
      });
  }

  function addNewAuthor() {
    navigator("/authors/add-Author");
  }

  function updateAuthor(authorId) {
    navigator(`/authors/update-Author/${authorId}`);
  }

  function removeAuthor(authorId) {
    deleteAuthor(authorId)
      .then((response) => {
        getAllAuthor();
      })
      .catch((err) => {
        console.log(err);
        if (err.response && err.response.status === 500) {
          alert("This author has a book and cannot be deleted.");
        }
      });
  }

  function searchAuthorById() {
    if (!searchId) {
      alert('Please enter an author ID.');
      setAuthorDetails(null); 
      return;
    }
    getAuthorById(searchId)
      .then((response) => {
        setAuthorDetails(response.data);
      })
      .catch((err) => {
        console.log(err);
        alert('Author not found.');
        setAuthorDetails(null); 
        getAllAuthor(); 
      });
  }
  

  const formatDate = (dateString) => {
    const options = { year: "numeric", month: "long", day: "numeric" };
    return new Intl.DateTimeFormat("en-US", options).format(
      new Date(dateString)
    );
  };

  return (
    <div className="container">
      <h2 className="text-center my-4">List of Authors</h2>
      <button
        type="button"
        className="btn btn-outline-primary mb-3"
        onClick={addNewAuthor}
      >
        Add Author
      </button>
      <div className="col-md-8 d-flex align-items-center mb-3">
        <input
          type="text"
          className="form-control me-3"
          placeholder="Find author by ID"
          value={searchId}
          onChange={(e) => setSearchId(e.target.value)}
        />
        <button className="btn btn-primary" onClick={searchAuthorById}>
          Search
        </button>
      </div>
      {authorDetails && (
        <div className="card">
          <div className="card-body">
            <h5 className="card-title">Author Details</h5>
            <p><strong>Author ID:</strong> {authorDetails.author_id}</p>
            <p><strong>Full Name:</strong> {authorDetails.fullName}</p>
            <p><strong>Title:</strong> {authorDetails.title}</p>
            <p><strong>Date of Birth:</strong> {formatDate(authorDetails.dob)}</p>
            <p><strong>Bio:</strong> {authorDetails.bio}</p>
          </div>
        </div>
      )}
      <div className="table-responsive">
        <table className="table table-striped table-bordered">
          <thead className="thead-dark">
            <tr>
              <th className="text-center">Author Id</th>
              <th className="text-center">Full Name</th>
              <th className="text-center">Title</th>
              <th className="text-center">Date of Birth</th>
              <th className="text-center">Bio</th>
              <th className="text-center">Actions</th>
            </tr>
          </thead>
          <tbody>
            {authors.map((item, index) => (
              <tr key={index}>
                <td className="text-center">{item.author_id}</td>
                <td className="text-center">{item.fullName}</td>
                <td className="text-center">{item.title}</td>
                <td className="text-center">{formatDate(item.dob)}</td>
                <td
                  style={{
                    maxWidth: "400px",
                    whiteSpace: "wrap",
                  }}
                >
                  {item.bio}
                </td>
                <td>
                  <button
                    className="btn btn-info me-2"
                    onClick={() => updateAuthor(item.author_id)}
                  >
                    Update
                  </button>
                  <button
                    className="btn btn-danger"
                    onClick={() => removeAuthor(item.author_id)}
                  >
                    Delete
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
};

export default ListAuthorsComponent;
