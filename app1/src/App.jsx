import './App.css'
import { useState } from 'react';
import ListAuthorsComponent from './componants/AuthorComponants/ListAuthorsComponent';
import HeaderComponantes from './componants/HeaderComponantes';
import FooterComponants from './componants/FooterComponants';
import HomePageComponents from './componants/HomePagecomponantes'
import { BrowserRouter, Route, Router, Routes } from 'react-router-dom';
import AddAuthorComponantes from './componants/AuthorComponants/AddAuthorComponantes';
import UpdateAuthorComponent from './componants/AuthorComponants/UpdateAuthorComponantes';
import ListofAllBooks from './componants/BookComponants/ListofAllBooks';
import AddBookComponant from './componants/BookComponants/AddBookComponant';
import UpdateBookComponent from './componants/BookComponants/UpdateBookComponantes';

function App() {

 

  return (
    <>
    <BrowserRouter>
      <HeaderComponantes/>
      <Routes>
      <Route path='/' element={<HomePageComponents/>}></Route>
        <Route path='/authors' element={<ListAuthorsComponent/>}></Route>
        <Route path='/books' element={<ListofAllBooks/>}></Route>
        <Route path='books/add-book' element={<AddBookComponant/>}></Route>
        <Route path='books/update-book/:id' element={<UpdateBookComponent/>}></Route>
        <Route path='authors/add-Author' element={<AddAuthorComponantes/>}></Route>
        <Route path='authors/update-Author/:id' element={<UpdateAuthorComponent/>}></Route>
      </Routes>
    </BrowserRouter>
    </>
  )
}
export default App
