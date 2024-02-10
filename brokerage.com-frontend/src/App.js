import React from 'react';
import { Route, Routes } from 'react-router-dom';
import Header from './components/Header';
import Footer from './components/Footer';
import Home from './pages/Home';
import PropertyDetails from './pages/PropertyDetails';
import SignUp from './pages/SignUp';
import LogIn from './pages/Login';
import SignUpSuccess from './pages/SignUpSuccess';
import SignUpFailure from './pages/SignUpFailure';

const App = () => {
  return (
    <div className='max-w-[1440px] mx-auto bg-white'>
      
      <Header />
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/property/:id" element={<PropertyDetails />} />
        <Route path="/signup" element={<SignUp/>} />
        <Route path="/login" element={<LogIn/>} />
        <Route path="/signup/success" element={<SignUpSuccess/>} />
        <Route path="/signup/failure" element={<SignUpFailure/>} />
      </Routes>
      <Footer />
    </div>
  );
};

export default App;