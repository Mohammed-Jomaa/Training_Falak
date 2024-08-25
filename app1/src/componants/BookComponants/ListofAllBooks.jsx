// ListofAllBooks.js
import React, { useEffect, useState } from "react";
import { listBooks, deleteBook } from "../../services/BookService";
import { useNavigate } from "react-router-dom";

const ListofAllBooks = () => {
  const [books, setBooks] = useState([]);
  const [searchId, setSearchId] = useState("");
  const [bookDetails, setBookDetails] = useState(null);
  const navigator = useNavigate();

  useEffect(() => {
    getAllBooks();
  }, []);

  function getAllBooks() {
    listBooks()
      .then((response) => {
        setBooks(response.data);
      })
      .catch((err) => {
        console.log(err);
      });
  }

  function addNewBook() {
    navigator("/books/add-book");
  }

  function updateBook(book_id) {
    navigator(`/books/update-book/${book_id}`);
  }

  function removeBook(book_id) {
    deleteBook(book_id)
      .then((response) => {
        getAllBooks();
      })
      .catch((err) => {
        console.log(err);
        if (err.response && err.response.status === 500) {
          alert("This book has an author and cannot be deleted.");
        }
      });
  }

  function searchBookById() {
    if (!searchId) {
      alert("Please enter a book ID.");
      setBookDetails(null);
      return;
    }
    getBookById(searchId)
      .then((response) => {
        setBookDetails(response.data);
      })
      .catch((err) => {
        console.log(err);
        alert("Book not found.");
        setBookDetails(null);
        getAllBooks();
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
      <h2 className="text-center my-4">List of Books</h2>
      <button
        type="button"
        className="btn btn-outline-primary mb-3"
        onClick={addNewBook}
      >
        Add Book
      </button>
      <div className="col-md-8 d-flex align-items-center mb-3">
        <input
          type="text"
          className="form-control me-3"
          placeholder="Find book by ID"
          value={searchId}
          onChange={(e) => setSearchId(e.target.value)}
        />
        <button className="btn btn-primary" onClick={searchBookById}>
          Search
        </button>
      </div>
      {bookDetails && (
        <div className="card">
          <div className="card-body">
            <h5 className="card-title">Book Details</h5>
            <p>
              <strong>Book Id:</strong> {bookDetails.book_id}
            </p>
            <p>
              <strong>Title:</strong> {bookDetails.title}
            </p>
            <p>
              <strong>Subtitle:</strong> {bookDetails.subtitle}
            </p>
            <p>
              <strong>Description:</strong> {bookDetails.description}
            </p>
            <p>
              <strong>Image URL:</strong> {bookDetails.imageURL}
            </p>
            <p>
              <strong>Edition:</strong> {bookDetails.edition}
            </p>
            <p>
              <strong>Publishing Date:</strong>{" "}
              {formatDate(bookDetails.publishing_date)}
            </p>
            <p>
              <strong>Categories:</strong> {bookDetails.categories}
            </p>
            {/* Render other book details similarly */}
          </div>
        </div>
      )}
      <br />
      <div className="table-responsive">
        <table className="table table-striped table-bordered">
          <thead className="thead-dark">
            <tr>
              <th className="text-center">Book Id</th>
              <th className="text-center">Title</th>
              <th className="text-center">Subtitle</th>
              <th className="text-center">Description</th>
              <th className="text-center">Image URL</th>
              <th className="text-center">Edition</th>
              <th className="text-center">Publishing Date</th>
              <th className="text-center">Categories</th>
              <th className="text-center">Book Authors</th>
              <th className="text-center">Actions</th>
            </tr>
          </thead>
          <tbody>
            {books.map((book, index) => (
              <tr key={index}>
                <td className="text-center">{book.book_id}</td>
                <td className="text-center">{book.title}</td>
                <td className="text-center">{book.subtitle}</td>
                <td className="text-center">{book.description}</td>
                <td className="text-center">
                  <img
                    src={book.imageURL}
                    alt=""
                    style={{ maxWidth: "100px", maxHeight: "100px" }}
                  />
                </td>
                <td className="text-center">{book.edition}</td>
                <td className="text-center">
                  {formatDate(book.publishing_date)}
                </td>
                <td className="text-center">{book.categories}</td>
                <td className="text-center">
                  <ul>
                    {book.bookAuthors && book.bookAuthors.length > 0 && (
                      <div>
                        {book.bookAuthors.map((author, authorIndex) => (
                          <li key={authorIndex}>
                            <p>{author.authorName}</p>
                          </li>
                        ))}
                      </div>
                    )}
                  </ul>
                </td>

                <td>
                  <button
                    className="btn btn-info me-2"
                    onClick={() => updateBook(book.book_id)}
                  >
                    Update
                  </button>
                  <button
                    className="btn btn-danger"
                    onClick={() => removeBook(book.book_id)}
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

export default ListofAllBooks;
