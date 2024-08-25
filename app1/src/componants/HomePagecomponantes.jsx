import React from 'react';
import { Link } from 'react-router-dom';

const HomePageComponents = () => {
  return (
    <div className="homepage-container">
      <header className="homepage-header">
        <h1>Welcome to the Book Management System</h1>
        <p>Your one-stop solution for managing books and authors efficiently.</p>
      </header>
      <main className="homepage-main">
        <section className="homepage-section">
          <h2>Explore</h2>
          <div className="homepage-links">
            <Link to="/authors" className="homepage-link">Explore Authors</Link>
            <Link to="/books" className="homepage-link">Explore Books</Link>
          </div>
        </section>
      </main>
      <footer className="homepage-footer">
        <p>&copy; 2024 Book Management System. All rights reserved.</p>
      </footer>
    </div>
  );
}

export default HomePageComponents;
